package com.chat.chat_ai.core.strategies.impl;

import com.chat.chat_ai.core.domain.input.CallAiInput;
import com.chat.chat_ai.core.domain.out.CallApiModelOutput;
import com.chat.chat_ai.core.strategies.AiModelStrategy;
import com.chat.chat_ai.entrypoint.domain.AiModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class OllamaStrategyImpl implements AiModelStrategy<AiModel, CallAiInput, CallApiModelOutput> {

    private final ChatClient ollamaClient;

    public OllamaStrategyImpl(@Qualifier("ollamaAiChatClient") ChatClient ollamaClient) {
        this.ollamaClient = ollamaClient;
    }

    @Override
    public AiModel identify() {
        return AiModel.OLLAMA;
    }

    @Override
    public CallApiModelOutput execute(CallAiInput command) {
        try {
            var response =  Map.of("generation",
                    Objects.requireNonNull(ollamaClient
                            .prompt()
                            .user(command.message())
                            .call()
                            .content())
            );
            return new CallApiModelOutput(response);
        } catch (Exception e) {
            e.printStackTrace();
            return new CallApiModelOutput(Map.of("error", e.getMessage()));
        }
    }


}
