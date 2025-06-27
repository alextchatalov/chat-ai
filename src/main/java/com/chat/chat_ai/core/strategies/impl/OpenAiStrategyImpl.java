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
public class OpenAiStrategyImpl implements AiModelStrategy<AiModel, CallAiInput, CallApiModelOutput> {

    private final ChatClient openAiClient;

    public OpenAiStrategyImpl(@Qualifier("openAiChatClient") ChatClient openAiClient) {
        this.openAiClient = openAiClient;
    }

    @Override
    public AiModel identify() {
        return AiModel.OPEN_AI;
    }

    @Override
    public CallApiModelOutput execute(CallAiInput command) {
        try {
            return new CallApiModelOutput(Map.of("generation",
                    Objects.requireNonNull(openAiClient
                            .prompt()
                            .user(command.message())
                            .call()
                            .content())
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return new CallApiModelOutput(Map.of("error", e.getMessage()));
        }
    }


}
