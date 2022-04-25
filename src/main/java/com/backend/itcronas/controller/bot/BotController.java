package com.backend.itcronas.controller.bot;


import com.backend.itcronas.component.Bot;
import com.backend.itcronas.model.BotMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

@RestController
@RequestMapping("/api/bot")
public class BotController {
    @PostMapping("/phone")
    public HttpEntity<String> sendRequestPhone(@RequestBody BotMessage bot) throws UnsupportedEncodingException, JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String formatted = String.format("Новая заявка %s", bot.getText());
        BotMessage botMessage = new BotMessage();
        botMessage.setText(formatted);
        botMessage.setChat_id("-1001673252630");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(botMessage);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.telegram.org/bot5396770758:AAF_rmfXHbw8yn2R7FpiFyb-rkQNHHsWCmg/sendMessage");
        HttpEntity<?> entity = new HttpEntity<>(botMessage, headers);
        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);
        return response;
    }
}