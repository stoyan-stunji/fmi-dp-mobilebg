import Commands.CommandInvoker;
import Commands.ForListings.AddListingCommand;
import Commands.ForListings.DeleteListingCommand;
import Commands.ForListings.ShowAllListingsCommand;
import Commands.ForUsers.AddUserCommand;
import Commands.ForUsers.LoginCommand;
import Commands.ForUsers.LogoutCommand;
import Commands.ForUsers.ShowAllUsersCommand;
import Languages.LanguageContext;
import Languages.Strategies.EnglishStrategy;
import Languages.Strategies.GermanStrategy;
import Products.Product;
import Products.ProductFactory;
import Subscribtions.Service.SubscribtionService;
import User.IdGenerator;
import User.Repository.UserRepositoryImplementation;
import User.Roles.Dealership;
import User.Roles.RegisteredUser;
import User.Service.UserServiceImplementation;
import Listings.Service.ListingServiceImplementation;
import Listings.Repository.ListingRepositoryImplementation;
import Listings.Listing;
import Regions.Region;

import java.time.LocalDate;
import java.util.Scanner;

public class Console
{
    public void run()
    {
        UserRepositoryImplementation userRepository = new UserRepositoryImplementation();
        UserServiceImplementation userService = new UserServiceImplementation(userRepository);

        SubscribtionService subscribtionService = new SubscribtionService();

        ListingRepositoryImplementation listingRepository = new ListingRepositoryImplementation();
        ListingServiceImplementation listingService = new ListingServiceImplementation(listingRepository, userService, subscribtionService);

        CommandInvoker invoker = new CommandInvoker();
        Scanner scanner = new Scanner(System.in);
        String loggedInUser = null;

        LanguageContext languageContext = new LanguageContext(new EnglishStrategy());

        System.out.println(languageContext.getWelcomeMessage());
        System.out.println("Language: \n1. English \n2. German");
        int languageChoice = scanner.nextInt();
        scanner.nextLine();

        if (languageChoice == 1) {
            languageContext.setLanguage(new EnglishStrategy());
        } else if (languageChoice == 2) {
            languageContext.setLanguage(new GermanStrategy());
        }

        while (true)
        {
            if (loggedInUser == null) {
                System.out.println(languageContext.getChooseActionMessage());
            } else {
                System.out.println(languageContext.getChooseActionMessageLoggedIn());
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (loggedInUser == null) {
                switch (choice) {
                    case 1:
                        System.out.println(languageContext.getAreYouDealershipMessage());
                        String answer = scanner.nextLine();

                        if(answer.equals("Y"))
                        {
                            System.out.println(languageContext.getEnterUsername());
                            String userName = scanner.nextLine();
                            System.out.println(languageContext.getEnterEmail());
                            String email = scanner.nextLine();
                            System.out.println(languageContext.getEnterPassword());
                            String password = scanner.nextLine();
                            System.out.println(languageContext.getDealershipName());
                            String name = scanner.nextLine();
                            System.out.println(languageContext.getPhoneNumber());
                            String phoneNumber = scanner.nextLine();
                            System.out.println(languageContext.getArea());
                            String area = scanner.nextLine();
                            System.out.println(languageContext.getCity());
                            String city = scanner.nextLine();
                            IdGenerator.increment();

                            Dealership user = new Dealership(userName, userName, email, password, name, phoneNumber, new Region(area, city));
                            invoker.setCommand(new AddUserCommand(userService, user));
                            invoker.executeCommand();
                        }
                        else
                        {
                            System.out.println(languageContext.getEnterUsername());
                            String userName = scanner.nextLine();
                            System.out.println(languageContext.getEnterEmail());
                            String email = scanner.nextLine();
                            System.out.println(languageContext.getEnterPassword());
                            String password = scanner.nextLine();
                            System.out.println(languageContext.getPhoneNumber());
                            String phoneNumber = scanner.nextLine();
                            System.out.println(languageContext.getArea());
                            String area = scanner.nextLine();
                            System.out.println(languageContext.getCity());
                            String city = scanner.nextLine();
                            IdGenerator.increment();

                            RegisteredUser user = new RegisteredUser(userName, userName, email, password, new Region(area, city), phoneNumber);
                            invoker.setCommand(new AddUserCommand(userService, user));
                            invoker.executeCommand();
                        }
                        System.out.println(languageContext.getUserAdded());
                        break;
                    case 2:
                        System.out.println(languageContext.getEnterUsername());
                        String loginId = scanner.nextLine();
                        System.out.println(languageContext.getEnterPassword());
                        String enteredPassword = scanner.nextLine();

                        invoker.setCommand(new LoginCommand(userService, loginId, enteredPassword));
                        invoker.executeCommand();

                        String loginMessage = ((LoginCommand) invoker.getCommand()).getMessage();
                        System.out.println(loginMessage);

                        if (loginMessage.equals(""))
                        {
                            loggedInUser = loginId;
                        }
                        System.out.println(languageContext.getUserLoggedIn());
                        break;
                    case 3:
                        System.out.println(languageContext.getUsersList());
                        invoker.setCommand(new ShowAllUsersCommand(userService));
                        invoker.executeCommand();
                        break;
                    case 4:
                        System.out.println(languageContext.getExiting());
                        scanner.close();
                        return;
                }
            }
            else
            {
                switch (choice) {
                    case 1:
                        System.out.println(languageContext.getListingsList());
                        invoker.setCommand(new ShowAllListingsCommand(listingService, loggedInUser));
                        invoker.executeCommand();
                        break;
                    case 2:
                        System.out.println(languageContext.getArea());
                        String area = scanner.nextLine();
                        System.out.println(languageContext.getCity());
                        String city = scanner.nextLine();
                        System.out.println(languageContext.getEnterDescription());
                        String description = scanner.nextLine();
                        System.out.println(languageContext.getWantToPromote());
                        String answer = scanner.nextLine();
                        boolean flag = false;

                        if(answer.equals("Y"))
                        {
                            flag = true;
                            System.out.println(languageContext.getPayment());
                        }

                        // TO:DO - Decouple from Standard Input & Output
                        Product product = ProductFactory.createProduct();

                        Listing listing = new Listing(IdGenerator.increment() + "", product, new Region(area, city), loggedInUser, LocalDate.now().plusYears(1).toString(), flag, description);
                        invoker.setCommand(new AddListingCommand(listingService, listing, loggedInUser));
                        invoker.executeCommand();

                        System.out.println(languageContext.getListingAdded());
                        break;
                    case 3:
                        System.out.println(languageContext.getListingId());
                        String deleteListingId = scanner.nextLine();
                        invoker.setCommand(new DeleteListingCommand(listingService, deleteListingId, loggedInUser));
                        invoker.executeCommand();

                        System.out.println(languageContext.getListingDeleted());
                        break;
                    case 4:
                        invoker.setCommand(new LogoutCommand(loggedInUser));
                        invoker.executeCommand();
                        loggedInUser = null;
                        System.out.println(languageContext.getUserLoggedOut());
                        break;
                }
            }
        }
    }
}
