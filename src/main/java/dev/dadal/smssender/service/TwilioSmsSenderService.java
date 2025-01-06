package dev.dadal.smssender.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import dev.dadal.smssender.config.TwilioConfiguration;
import dev.dadal.smssender.dto.SmsRequest;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("twilio")
public class TwilioSmsSenderService implements ISmsSender {

    public final TwilioConfiguration twilioConfiguration;

    public TwilioSmsSenderService(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        String to = "+55" + smsRequest.ddd() + smsRequest.phoneNumber();
        String from = "De " + smsRequest.sender() + "\n";


        if (isValidPhoneNumber(to)) {
            Message message = Message.creator(
                    new PhoneNumber(to),
                    new PhoneNumber(twilioConfiguration.getTrialNumber()),
                    from + smsRequest.message()
            ).create();
        } else {
            throw new IllegalArgumentException("Número de telefone inválido: " + to);
        }
    }

    private boolean isValidPhoneNumber(String fullPhoneNumber) {
        String regex = "^\\+55\\d{10,11}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fullPhoneNumber);
        return matcher.matches();
    }
}
