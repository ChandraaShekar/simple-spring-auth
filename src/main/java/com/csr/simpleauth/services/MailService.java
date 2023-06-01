package com.csr.simpleauth.services;
import org.apache.kafka.common.utils.Java;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;
    
    public String sendEmail(){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("cxd2860@mavs.uta.edu");
            message.setSubject("Test Mail");
            message.setText("Hello World");
            message.setFrom("Chandu");
            javaMailSender.send(message);
            return "Email Sent";
        }catch(Exception e){
            return "Mail Failed to send";
        }
    }
}
