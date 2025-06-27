package com.chat.chat_ai.core.factories;

import com.chat.chat_ai.core.domain.input.CallAiInput;
import com.chat.chat_ai.core.domain.out.CallApiModelOutput;
import com.chat.chat_ai.core.exception.StrategyNotFoundException;
import com.chat.chat_ai.core.strategies.AiModelStrategy;
import com.chat.chat_ai.entrypoint.domain.AiModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CallModelFactory {
    private final List<AiModelStrategy<AiModel, CallAiInput, CallApiModelOutput>> strategies;

    public CallModelFactory(List<AiModelStrategy<AiModel, CallAiInput, CallApiModelOutput>> strategies) {
        this.strategies = strategies;
    }

    public AiModelStrategy<AiModel, CallAiInput, CallApiModelOutput> get(AiModel model) {
        return strategies.stream()
                .filter(param -> param.identify().equals(model))
                .findFirst()
                .orElseThrow(() -> new StrategyNotFoundException(model));
    }
}

