# User-Id-Telegram
How to take UserName, UserId, etc.. from a telegram chat bot in Java.


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class idbot extends TelegramLongPollingBot {
    
    public void onUpdateReceived(Update update) {
        // COLLECT ALL INFORMATION
        long id_group = update.getMessage().getChatId();
        long id_Utente = update.getMessage().getFrom().getId();
        String userName = update.getMessage().getFrom().getUserName();
        String firstName = update.getMessage().getFrom().getFirstName();
        String lastName = update.getMessage().getFrom().getLastName();
        // SEND MESSAGE WITH BOT TO USER 
        SendMessage message = new SendMessage().setChatId(id_Utente).setText("" +
                "Id group: " + id_group +"\n" +
                "Id utente: " + id_Utente +"\n" +
                "UserName : " + userName +"\n" +
                "FirstName : " + firstName +"\n" +
                "LastName : " + lastName + "\n");
        try {
            execute(message);
        } catch (TelegramApiException e ) {
            System.err.println(e);
            }
        }
        
    public String getBotUsername() {
        return "the_id";
    }
    public String getBotToken() {
        return "abcddefcgasdwr3432423423";
    }

}

