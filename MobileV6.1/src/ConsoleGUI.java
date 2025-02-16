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
import Products.Product;
import Products.ProductFactory;
import Subscribtions.Service.SubscribtionService;
import User.IdGenerator;
import User.Repository.UserRepositoryImplementation;
import User.Roles.RegisteredUser;
import User.Service.UserServiceImplementation;
import Listings.Service.ListingServiceImplementation;
import Listings.Repository.ListingRepositoryImplementation;
import Listings.Listing;
import Regions.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ConsoleGUI {

    private CommandInvoker invoker = new CommandInvoker();
    private UserServiceImplementation userService;
    private ListingServiceImplementation listingService;
    private LanguageContext languageContext;
    private String loggedInUser = null;

    private JTextArea messageArea;
    private JTextField usernameField, passwordField, areaField, cityField, descriptionField;
    private JButton loginButton, addUserButton, viewUsersButton, addListingButton, deleteListingButton, logoutButton, showListingsButton;

    public ConsoleGUI()
    {
        UserRepositoryImplementation userRepository = new UserRepositoryImplementation();
        userService = new UserServiceImplementation(userRepository);
        SubscribtionService subscribtionService = new SubscribtionService();
        ListingRepositoryImplementation listingRepository = new ListingRepositoryImplementation();
        listingService = new ListingServiceImplementation(listingRepository, userService, subscribtionService);

        languageContext = new LanguageContext(new EnglishStrategy());
    }

    public void createAndShowGUI()
    {
        JFrame frame = new JFrame("TARATAIKA.COM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(12, 2, 5, 5));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        areaField = new JTextField();
        cityField = new JTextField();
        descriptionField = new JTextField();

        messageArea = new JTextArea(5, 20);
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        loginButton = new JButton("Login");
        addUserButton = new JButton("Add User");
        viewUsersButton = new JButton("View Users");
        addListingButton = new JButton("Add Listing");
        deleteListingButton = new JButton("Delete Listing");
        logoutButton = new JButton("Logout");
        showListingsButton = new JButton("Show Listings");

        container.add(new JLabel("Username:"));
        container.add(usernameField);
        container.add(new JLabel("Password:"));
        container.add(passwordField);
        container.add(loginButton);
        container.add(addUserButton);
        container.add(viewUsersButton);
        container.add(addListingButton);
        container.add(deleteListingButton);
        container.add(showListingsButton);
        container.add(new JLabel("Area:"));
        container.add(areaField);
        container.add(new JLabel("City:"));
        container.add(cityField);
        container.add(new JLabel("Description:"));
        container.add(descriptionField);
        container.add(scrollPane);
        container.add(logoutButton);

        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String username = usernameField.getText();
                String password = passwordField.getText();
                invoker.setCommand(new LoginCommand(userService, username, password));
                invoker.executeCommand();
                String loginMessage = ((LoginCommand) invoker.getCommand()).getMessage();
                messageArea.setText(loginMessage);
                if (loginMessage.isEmpty()) {
                    loggedInUser = username;
                }
            }
        });

        addUserButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String area = areaField.getText();
                String city = cityField.getText();
                RegisteredUser user = new RegisteredUser(username, username, "", password, new Region(area, city), "");
                invoker.setCommand(new AddUserCommand(userService, user));
                invoker.executeCommand();
                messageArea.setText(languageContext.getUserAdded());
            }
        });

        viewUsersButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                invoker.setCommand(new ShowAllUsersCommand(userService));
                invoker.executeCommand();
                messageArea.setText("Users List: \n" + userService.getUserRepository().getStorage());
            }
        });

        addListingButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                String area = areaField.getText();
                String city = cityField.getText();
                String description = descriptionField.getText();
                Product product = ProductFactory.createProduct();
                Listing listing = new Listing(IdGenerator.increment() + "", product, new Region(area, city), loggedInUser, LocalDate.now().plusYears(1).toString(), false, description);
                invoker.setCommand(new AddListingCommand(listingService, listing, loggedInUser));
                invoker.executeCommand();
                messageArea.setText(languageContext.getListingAdded());
            }
        });

        deleteListingButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                String listingId = descriptionField.getText();
                invoker.setCommand(new DeleteListingCommand(listingService, listingId, loggedInUser));
                invoker.executeCommand();
                messageArea.setText(languageContext.getListingDeleted());
            }
        });

        showListingsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                invoker.setCommand(new ShowAllListingsCommand(listingService, loggedInUser));
                invoker.executeCommand();
                messageArea.setText("Listings: \n" + listingService.getListingById(loggedInUser));
            }
        });

        logoutButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                invoker.setCommand(new LogoutCommand(loggedInUser));
                invoker.executeCommand();
                loggedInUser = null;
                messageArea.setText(languageContext.getUserLoggedOut());
            }
        });

        frame.setVisible(true);
    }

    public void test()
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ConsoleGUI().createAndShowGUI();
            }
        });
    }
}
