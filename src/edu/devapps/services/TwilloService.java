package edu.devapps.services;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class TwilloService {
    private static final String ACCOUNT_SID = "ACa77f30f369ed17f37db2f73eddb5784d";
    private static final String AUTH_TOKEN = "fb19f06c5c1078a57023c72f1397c022";
    private static final String FROM_NUMBER = "+15077095931";

    public static void sendSms(String toNumber, String messageText) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                        new PhoneNumber(toNumber),
                        new PhoneNumber(FROM_NUMBER),
                        messageText)
                .create();

        System.out.println("Message SID: " + message.getSid());
    }
}