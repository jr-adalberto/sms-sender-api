package dev.dadal.smssender.controller;

import dev.dadal.smssender.dto.SmsRequest;
import dev.dadal.smssender.service.ISmsSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsSenderController {

    private final ISmsSender smsSender;

    public SmsSenderController(ISmsSender smsSender) {
        this.smsSender = smsSender;
    }

    @PostMapping("/send-sms")
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}
