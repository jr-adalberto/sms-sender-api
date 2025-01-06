package dev.dadal.smssender.service;

import dev.dadal.smssender.dto.SmsRequest;

public interface ISmsSender {
    void sendSms(SmsRequest smsRequest);
}

