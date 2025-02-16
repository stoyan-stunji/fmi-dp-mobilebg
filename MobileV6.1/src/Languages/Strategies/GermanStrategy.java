package Languages.Strategies;

import Languages.LanguageStrategy;

public class GermanStrategy implements LanguageStrategy
{
    public String getWelcomeMessage() {
        return "Willkommen bei der Tarataika.de!";
    }

    public String getChooseActionMessage() {
        return "Wählen Sie eine Aktion: \n1. Registrieren \n2. Anmelden \n3. Alle Benutzer anzeigen \n4. Beenden";
    }

    public String getRegisterMessage() {
        return "Benutzerregistrierung";
    }

    public String getLoginMessage() {
        return "Anmelden";
    }

    public String getUserAddedMessage() {
        return "Benutzer hinzugefügt!";
    }

    public String getChooseActionMessageLoggedIn()
    {
        return "Wählen Sie eine Aktion: \n1. Alle Einträge anzeigen \n2. Eintrag hinzufügen \n3. Eintrag löschen \n4. Abmelden";
    }

    public String getAreYouDealershipMessage()
    {
        return "Sind Sie eine Organisation (Händler)? Y/N";
    }

    public String getEnterUsername()
    {
        return "Eingeben Sie Benutzernamen: ";
    }

    public String getEnterEmail()
    {
        return "Eingeben Sie E-Mail: ";
    }

    public String getEnterPassword()
    {
        return "Eingeben Sie Passwort: ";
    }

    public String getDealershipName()
    {
        return "Händlername: ";
    }

    public String getPhoneNumber()
    {
        return "Eingeben Sie Telefonnummer: ";
    }

    public String getArea()
    {
        return "Eingeben Sie Bereich: ";
    }

    public String getCity()
    {
        return "Eingeben Sie Stadt: ";
    }

    public String getUserAdded()
    {
        return "Benutzer hinzugefügt!";
    }

    public String getUserLoggedIn()
    {
        return "Benutzer angemeldet!";
    }

    public String getUsersList()
    {
        return "Benutzer: ";
    }

    public String getExiting()
    {
        return "Beenden...";
    }

    public String getListingsList()
    {
        return "Einträge: ";
    }

    public String getEnterDescription()
    {
        return "Eingeben Sie Beschreibung: ";
    }

    public String getWantToPromote()
    {
        return "Möchten Sie Ihr Eintrag bewerben? Y/N";
    }

    public String getPayment()
    {
        return "Geben Sie Ihre Kreditkarteninformationen ein [€9,60]: ";
    }

    public String getListingAdded()
    {
        return "Eintrag hinzugefügt!";
    }

    public String getListingId()
    {
        return "Eingeben Eintrag ID: ";
    }

    public String getListingDeleted()
    {
        return "Eintrag gelöscht!";
    }

    public String getUserLoggedOut()
    {
        return "Benutzer abgemeldet!";
    }
}
