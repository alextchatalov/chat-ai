package com.chat.chat_ai.core.facede;

import com.chat.chat_ai.entrypoint.domain.AiModel;

import java.util.Map;

public interface CallAiFacade {

    Map<String, String> execute(AiModel model, String message);
}
