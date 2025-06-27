package com.chat.chat_ai.core.facede.impl;

import com.chat.chat_ai.core.domain.out.CallApiModelOutput;
import com.chat.chat_ai.core.facede.CallAiFacade;
import com.chat.chat_ai.core.usecase.CallAiUseCase;
import com.chat.chat_ai.core.domain.input.CallAiInput;
import com.chat.chat_ai.entrypoint.domain.AiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CallAiFacadeImpl implements CallAiFacade {

    private final CallAiUseCase callAiUseCase;

    @Override
    public CallApiModelOutput execute(AiModel model, String message) {
        return callAiUseCase.execute(new CallAiInput(model, message));
    }
}
