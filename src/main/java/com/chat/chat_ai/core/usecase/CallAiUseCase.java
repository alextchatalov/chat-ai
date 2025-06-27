package com.chat.chat_ai.core.usecase;

import com.chat.chat_ai.core.domain.input.CallAiInput;
import com.chat.chat_ai.core.domain.out.CallApiModelOutput;

public interface CallAiUseCase extends UseCase<CallAiInput, CallApiModelOutput> {

    CallApiModelOutput execute(CallAiInput command);
}
