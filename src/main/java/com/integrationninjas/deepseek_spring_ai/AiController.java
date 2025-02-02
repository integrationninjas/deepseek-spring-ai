package com.integrationninjas.deepseek_spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/chat")
    public Flux<String> chat(@RequestParam("prompt") String prompt) {
        return chatClient.prompt().user(prompt).stream().content();
    }
}
