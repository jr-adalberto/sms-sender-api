package dev.dadal.smssender.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfiguration {
    private final String accountSid;
    private final String authToken;
    private final String trialNumber;

    public TwilioConfiguration(@Value("${twilio.account_sid}") String accountSid,
                               @Value("${twilio.auth_token}") String authToken,
                               @Value("${twilio.trial_number}") String trialNumber) {
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.trialNumber = trialNumber;
    }

    @PostConstruct
    public void init() {
        System.out.println("Twilio Configuration Loaded:");
        System.out.println("Account SID: " + accountSid);
        System.out.println("Auth Token: " + authToken);
        System.out.println("Trial Number: " + trialNumber);
    }


    public String getAccountSid() {
        return accountSid;
    }

    public String getTrialNumber() {
        return trialNumber;
    }

    public String getAuthToken() {
        return authToken;
    }
}
