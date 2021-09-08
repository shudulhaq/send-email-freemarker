package com.example.sendemailfreemarker.controller;

import com.example.sendemailfreemarker.dto.MailRequest;
import com.example.sendemailfreemarker.dto.MailResponse;
import com.example.sendemailfreemarker.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SendingEmailController {

    @Autowired
    private EmailService service;

    @PostMapping("/sendingEmail")
    public MailResponse sendEmail(@RequestBody MailRequest request){
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());
        model.put("location","Lombok, Indonesia");

        return service.sendEmail(request, model);
    }
}
