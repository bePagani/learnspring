package com.backend.itcronas.controller.auth;


import com.backend.itcronas.model.BotMessage;
import com.backend.itcronas.web.payload.LoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

@RestController
@RequestMapping("/api/bot")
public class BotController {
    @PostMapping("/phone")
    public ResponseEntity<String> authenticateUser(@RequestBody BotMessage bot) {
          SendMessage message =  new SendMessage();
        message.setText(bot.getMessage());
        return new ResponseEntity<>("$phone", HttpStatus.OK);
    }
}