package com.chat.chat_ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaAiConfiguration {

    @Bean
    public ChatClient ollamaAiChatClient(OllamaChatModel chatModel) {

        return ChatClient.create(chatModel);
    }
}
