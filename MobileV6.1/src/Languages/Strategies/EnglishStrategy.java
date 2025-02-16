package Languages.Strategies;

import Languages.LanguageStrategy;

public class EnglishStrategy implements LanguageStrategy
{
    public String getWelcomeMessage() {
        return "Welcome to Tarataika.com!";
    }

    public String getChooseActionMessage() {
        return "Choose an action: \n1. Register \n2. Login \n3. Show All Users \n4. Exit";
    }

    public String getRegisterMessage() {
        return "User Registration";
    }

    public String getLoginMessage() {
        return "Login";
    }

    public String getUserAddedMessage() {
        return "User Added!";
    }

    public String getChooseActionMessageLoggedIn()
    {
        return "Choose an action: \n1. Show All Listings \n2. Add Listing \n3. Delete Listing \n4. Logout";
    }

    public String getAreYouDealershipMessage()
    {
        return "Are you an organisation (dealership)? Y/N";
    }

    public String getEnterUsername()
    {
        return "Enter Username: ";
    }

    public String getEnterEmail()
    {
        return "Enter Email: ";
    }

    public String getEnterPassword()
    {
        return "Enter Password: ";
    }

    public String getDealershipName()
    {
        return "Dealership Name: ";
    }

    public String getPhoneNumber()
    {
        return "Enter Phone Number: ";
    }

    public String getArea()
    {
        return "Enter Area: ";
    }

    public String getCity()
    {
        return "Enter City: ";
    }

    public String getUserAdded()
    {
        return "User Added!";
    }

    public String getUserLoggedIn()
    {
        return "User Logged In!";
    }

    public String getUsersList()
    {
        return "Users: ";
    }

    public String getExiting()
    {
        return "Exiting...";
    }

    public String getListingsList()
    {
        return "Listings: ";
    }

    public String getEnterDescription()
    {
        return "Enter Description: ";
    }

    public String getWantToPromote()
    {
        return "Want to promote your listing? Y/N";
    }

    public String getPayment()
    {
        return "Enter credit card information [$10.00]: ";
    }

    public String getListingAdded()
    {
        return "Listing Added!";
    }

    public String getListingId()
    {
        return "Enter Listing ID: ";
    }

    public String getListingDeleted()
    {
        return "Listing Deleted!";
    }

    public String getUserLoggedOut()
    {
        return "User Logged Out!";
    }
}

