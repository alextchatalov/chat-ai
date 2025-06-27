package com.chat.chat_ai.core.usecase.impl;

import com.chat.chat_ai.core.domain.input.CallAiInput;
import com.chat.chat_ai.core.domain.out.CallApiModelOutput;
import com.chat.chat_ai.core.factories.CallModelFactory;
import com.chat.chat_ai.core.usecase.CallAiUseCase;
import org.springframework.stereotype.Service;

@Service
public class CallAiUseCaseImpl implements CallAiUseCase {

    private final CallModelFactory factory;

    public CallAiUseCaseImpl(CallModelFactory factory) {
        this.factory = factory;
    }

    @Override
    public CallApiModelOutput execute(CallAiInput command) {
       return factory.get(command.model()).execute(command);
    }

}
