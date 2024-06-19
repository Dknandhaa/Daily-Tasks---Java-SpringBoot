//package com.web.service.service;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.web.service.entites.dataset;
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Autowired
//    private PdfService urlService;
//
//    @Autowired
//    private UserService userService;
//
//    public void sendDataAsJsonToCurrentUser() throws MessagingException, IOException {
//        String email = urlService.getCurrentUserEmail();
//        if (email == null) {
//            throw new RuntimeException("No authenticated user found.");
//        }
//
//        List<dataset> urls = urlService.getAllDatasets();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonData = objectMapper.writeValueAsString(urls);
//        System.out.println(jsonData);
//        sendEmailWithAttachment(email, "Your Data", "Please find the attached data.", jsonData);
//
//    }
//
//    private void sendEmailWithAttachment(String to, String subject, String text, String jsonData) throws MessagingException {
//        MimeMessage message;
//        message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(text);
//        helper.addAttachment("data.json", new ByteArrayResource(jsonData.getBytes()));
//        javaMailSender.send(message);
//    }
//}
//
package com.web.service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.service.entites.dataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PdfService urlService;

    @Autowired
    private UserService userService;

    public void sendDataAsJsonToCurrentUser() throws MessagingException, IOException {
        String email = urlService.getCurrentUserEmail();
        if (email == null) {
            throw new RuntimeException("No authenticated user found.");
        }

        List<dataset> urls = urlService.getAllDatasets();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(urls);

        sendEmailWithAttachment(email, "Your Data", "The data you requested is attached with this mail \n thanks for visiting our site \n reg,\n bookworm.inc.", jsonData);
    }

    private void sendEmailWithAttachment(String to, String subject, String text, String jsonData) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        helper.addAttachment("data.json", new ByteArrayResource(jsonData.getBytes()));
        javaMailSender.send(message);
    }
}
