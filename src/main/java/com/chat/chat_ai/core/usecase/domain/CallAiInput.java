package com.chat.chat_ai.core.usecase.domain;

import com.chat.chat_ai.entrypoint.domain.AiModel;

public record CallAiInput(AiModel model, String message){}

