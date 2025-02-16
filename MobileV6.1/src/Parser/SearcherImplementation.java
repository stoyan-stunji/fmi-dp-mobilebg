package Parser;

import Filters.CompositeFilters.AndFilter;
import Filters.CompositeFilters.OrFilter;
import Filters.Filter;
import Listings.Listing;
import Products.Product;
import Products.Enums.Brand;
import Products.Enums.Model;
import Products.Enums.Engine;
import Products.Enums.Gearbox;
import Products.StreetLegalVehicles.Vehicles.Car;

import java.util.*;
import java.util.stream.Collectors;

public class SearcherImplementation implements Searcher
{
    private final QueryParser queryParser = new QueryParser();

    public List<Listing> search(List<Listing> listings, String query)
    {
        List<String> polishNotation = queryParser.toPolishNotation(query);
        return evaluate(listings, polishNotation);
    }

    private List<Listing> evaluate(List<Listing> listings, List<String> polishNotation) {
        Stack<Filter<Listing>> stack = new Stack<>();
        System.out.println("Polish Notation: " + polishNotation);

        for (String token : polishNotation) {
            System.out.println("Processing token: " + token);
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalStateException("Not enough operands for operator: " + token);
                }

                Filter<Listing> right = stack.pop();
                Filter<Listing> left = stack.pop();

                System.out.println("Combining filters with operator: " + token);
                if (token.equals("|")) {
                    stack.push(new OrFilter<>(List.of(left, right)));
                } else if (token.equals("&")) {
                    stack.push(new AndFilter<>(List.of(left, right)));
                }
            } else if (isCondition(token)) {
                stack.push(createFilterFromCondition(token));
            } else {
                throw new IllegalArgumentException("Unrecognized token: " + token);
            }
        }

        if (stack.isEmpty()) {
            return Collections.emptyList();
        }

        if (stack.size() > 1) {
            throw new IllegalStateException("Mismatched operators and operands. Stack size: " + stack.size());
        }

        Filter<Listing> finalFilter = stack.pop();
        System.out.println("Filter: " + finalFilter);
        System.out.println("Final filter applied.");
        return listings.stream().filter(finalFilter::visit).collect(Collectors.toList());
    }



    private boolean isOperator(String token)
    {
        return token.equals("|") || token.equals("&");
    }

    private boolean isCondition(String token) {
        return token.matches("[a-zA-Z]+\\s*[<>=]\\s*'[^']*'") || token.matches("[a-zA-Z]+\\s*[<>=]\\s*\\d+");
    }

    private Filter<Listing> createFilterFromCondition(String condition) {
        // Split the condition into parts: field, operator, and value
        String[] parts = condition.split("(?<=[<>=])|(?=[<>=])");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid condition: " + condition);
        }

        String field = parts[0].trim();
        String operator = parts[1].trim();
        String value = parts[2].trim().replace("'", ""); // Remove quotes around the value if present

        // Return a filter based on the field, operator, and value
        return listing -> {
            Product product = listing.getProduct();
            switch (field.toLowerCase()) {
                case "brand":
                    if (product instanceof Car car) {
                        return operator.equals("=") && car.getBrand().name().equalsIgnoreCase(value);
                    }
                    break;
                case "model":
                    if (product instanceof Car car) {
                        return operator.equals("=") && car.getModel().name().equalsIgnoreCase(value);
                    }
                    break;
                case "year":
                    int year = Integer.parseInt(value);
                    if (product instanceof Car car) {
                        return switch (operator) {
                            case "=" -> car.getYear() == year;
                            case "<" -> car.getYear() < year;
                            case ">" -> car.getYear() > year;
                            default -> false;
                        };
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown field: " + field);
            }
            return false;
        };
    }

}
