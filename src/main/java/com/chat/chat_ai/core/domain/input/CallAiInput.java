package com.chat.chat_ai.core.domain.input;

import com.chat.chat_ai.entrypoint.domain.AiModel;

public record CallAiInput(AiModel model, String message){}

