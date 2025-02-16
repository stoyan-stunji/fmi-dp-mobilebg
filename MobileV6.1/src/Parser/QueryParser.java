package Parser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryParser
{
    public List<String> toPolishNotation(String query)
    {
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("|", 1);
        precedence.put("&", 2);
        precedence.put("=", 3);
        precedence.put("<", 3);
        precedence.put(">", 3);

        Stack<String> operators = new Stack<>();
        List<String> output = new ArrayList<>();

        String conditionRegex = "[a-zA-Z]+\\s*[<>=]\\s*'[^']*'|[a-zA-Z]+\\s*[<>=]\\s*\\d+";
        String operatorRegex = "[|&()]";
        String tokenRegex = conditionRegex + "|" + operatorRegex;

        Pattern pattern = Pattern.compile(tokenRegex);
        Matcher matcher = pattern.matcher(query);

        while (matcher.find())
        {
            String token = matcher.group().trim();
            if (token.matches(conditionRegex))
            {
                output.add(token);
            }
            else if (token.equals("("))
            {
                operators.push(token);
            }
            else if (token.equals(")"))
            {
                while (!operators.isEmpty() && !operators.peek().equals("("))
                {
                    output.add(operators.pop());
                }

                if (!operators.isEmpty())
                {
                    operators.pop();
                }
                else
                {
                    throw new IllegalArgumentException("Mismatched parentheses in query: " + query);
                }
            }
            else
            {
                while (!operators.isEmpty() && precedence.getOrDefault(operators.peek(), 0) >= precedence.get(token))
                {
                    output.add(operators.pop());
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty())
        {
            String operator = operators.pop();

            if (operator.equals("(") || operator.equals(")"))
            {
                throw new IllegalArgumentException("Mismatched parentheses in query: " + query);
            }
            output.add(operator);
        }

        return output;
    }
}
