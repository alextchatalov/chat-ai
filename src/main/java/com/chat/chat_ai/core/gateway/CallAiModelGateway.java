package com.chat.chat_ai.core.gateway;

import com.chat.chat_ai.core.domain.input.CallAiInput;
import com.chat.chat_ai.core.domain.out.CallApiModelOutput;

import java.util.Map;

public interface CallAiModelGateway extends Gateway<CallAiInput, CallApiModelOutput> {
}
