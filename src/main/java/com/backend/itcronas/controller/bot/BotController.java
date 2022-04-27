package com.backend.itcronas.controller.bot;


import com.backend.itcronas.model.BotMessage;
import com.backend.itcronas.web.payload.MessageResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "http://192.168.1.2:8081", maxAge = 3600)
@RestController
@RequestMapping("/api/bot")
public class BotController {
    @PostMapping("/phone")
    public ResponseEntity<MessageResponse> sendRequestPhone(@RequestBody BotMessage bot) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String formatted = String.format("Новая заявка %s ", bot.getText());
        BotMessage botMessage = new BotMessage();
        botMessage.setText(formatted);
        botMessage.setChat_id("-idchat");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(botMessage);
        System.out.println(json);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.telegram.org/bot5396770758:/sendMessage");
        HttpEntity<?> entity = new HttpEntity<>(json, headers);
        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);
        return  ResponseEntity.ok(new MessageResponse("Request send success"));
    }

}