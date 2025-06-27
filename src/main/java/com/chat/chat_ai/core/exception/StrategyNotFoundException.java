package com.chat.chat_ai.core.exception;

import com.chat.chat_ai.entrypoint.domain.AiModel;

public class StrategyNotFoundException extends RuntimeException {
    public StrategyNotFoundException(AiModel model) {
        super("Strategy not found for model: " + model);
    }
}

