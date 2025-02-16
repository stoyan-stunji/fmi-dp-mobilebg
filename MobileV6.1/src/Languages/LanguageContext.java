package Languages;

public class LanguageContext
{
    private LanguageStrategy languageStrategy;

    public LanguageContext(LanguageStrategy languageStrategy) {
        this.languageStrategy = languageStrategy;
    }

    public void setLanguage(LanguageStrategy languageStrategy) {
        this.languageStrategy = languageStrategy;
    }

    public String getWelcomeMessage() {
        return languageStrategy.getWelcomeMessage();
    }

    public String getChooseActionMessage() {
        return languageStrategy.getChooseActionMessage();
    }

    public String getRegisterMessage() {
        return languageStrategy.getRegisterMessage();
    }

    public String getLoginMessage() {
        return languageStrategy.getLoginMessage();
    }

    public String getUserAddedMessage() {
        return languageStrategy.getUserAddedMessage();
    }

    public String getChooseActionMessageLoggedIn() { return languageStrategy.getChooseActionMessageLoggedIn(); }

    public String getAreYouDealershipMessage() { return languageStrategy.getAreYouDealershipMessage(); }

    public String getEnterUsername() { return languageStrategy.getEnterUsername(); }

    public String getEnterEmail() { return languageStrategy.getEnterEmail(); }

    public String getEnterPassword() { return languageStrategy.getEnterPassword(); }

    public String getDealershipName() { return languageStrategy.getDealershipName(); }

    public String getPhoneNumber() { return languageStrategy.getPhoneNumber(); }

    public String getArea() { return languageStrategy.getArea(); }

    public String getCity() { return languageStrategy.getCity(); }

    public String getUserAdded() { return languageStrategy.getUserAdded(); }

    public String getUsersList() { return languageStrategy.getUsersList(); }

    public String getUserLoggedIn() { return languageStrategy.getUserLoggedIn(); }

    public String getExiting() { return languageStrategy.getExiting(); }

    public String getListingsList() { return languageStrategy.getListingsList(); }

    public String getEnterDescription() { return languageStrategy.getEnterDescription(); }

    public String getWantToPromote() { return languageStrategy.getWantToPromote(); }

    public String getPayment() { return languageStrategy.getPayment(); }

    public String getListingAdded() { return languageStrategy.getListingAdded(); }

    public String getListingId() { return languageStrategy.getListingId(); }

    public String getListingDeleted() { return languageStrategy.getListingDeleted(); }

    public String getUserLoggedOut() { return languageStrategy.getUserLoggedOut(); }
}
