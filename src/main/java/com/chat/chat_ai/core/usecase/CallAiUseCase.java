package com.chat.chat_ai.core.usecase;

import com.chat.chat_ai.core.usecase.domain.CallAiInput;

import java.util.Map;

public interface CallAiUseCase extends UseCase<CallAiInput, Map<String, String>> {

    Map<String, String> execute(CallAiInput command);
}
