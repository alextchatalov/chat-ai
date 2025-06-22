package com.chat.chat_ai.core.usecase.impl;

import com.chat.chat_ai.core.usecase.CallAiUseCase;
import com.chat.chat_ai.core.usecase.domain.CallAiInput;
import com.chat.chat_ai.entrypoint.domain.AiModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class CallAiUseCaseImpl implements CallAiUseCase {

    private final ChatClient ollamaClient;
    private final ChatClient openAiClient;

    public CallAiUseCaseImpl(@Qualifier("ollamaAiChatClient") ChatClient ollamaClient, @Qualifier("openAiChatClient") ChatClient openAiClient) {
        this.openAiClient = openAiClient;
        this.ollamaClient = ollamaClient;
    }


    @Override
    public Map<String, String> execute(CallAiInput command) {
        try {
            return Map.of("generation",
                    Objects.requireNonNull(defineModel(command.model())
                            .prompt()
                            .user(command.message())
                            .call()
                            .content())
            );
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("error", e.getMessage());
        }
    }

    private ChatClient defineModel(AiModel model) {
        return switch (model) {
            case OPEN_AI -> openAiClient;
            case OLLAMA -> ollamaClient;
        };
    }
}
