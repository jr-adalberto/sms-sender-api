package dev.dadal.smssender.config;

import com.twilio.Twilio;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class SenderInitializer {
    public static Logger logger = Logger.getLogger(SenderInitializer.class.getName());
    public SenderInitializer(TwilioConfiguration senderConfiguration){
        Twilio.init(senderConfiguration.getAccountSid(), senderConfiguration.getAuthToken());

        logger.info("Twilio initialized with Account sid: " + senderConfiguration.getAccountSid() +
                "Auth Token: " + senderConfiguration.getAuthToken() +
                "and Trial Number: " + senderConfiguration.getTrialNumber());
    }
}
