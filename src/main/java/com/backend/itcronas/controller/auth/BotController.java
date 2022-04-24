package com.backend.itcronas.controller.auth;


import com.backend.itcronas.model.BotMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@RestController
@RequestMapping("/api/bot")
public class BotController {
    @PostMapping("/phone")
    public SendMessage authenticateUser(@RequestBody BotMessage bot) {
          SendMessage message =  new SendMessage();
          message.setChatId("-1001673252630");
        message.setText(bot.getMessage());
        return message;
    }
}