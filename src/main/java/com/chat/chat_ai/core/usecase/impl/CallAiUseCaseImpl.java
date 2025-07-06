package com.chat.chat_ai.core.usecase.impl;

import com.chat.chat_ai.core.domain.input.CallAiInput;
import com.chat.chat_ai.core.domain.out.CallApiModelOutput;
import com.chat.chat_ai.core.gateway.CallAiModelGateway;
import com.chat.chat_ai.dataprovider.factories.CallModelFactory;
import com.chat.chat_ai.core.usecase.CallAiUseCase;
import org.springframework.stereotype.Service;

@Service
public class CallAiUseCaseImpl implements CallAiUseCase {

    private CallAiModelGateway gateway;

    @Override
    public CallApiModelOutput execute(CallAiInput command) {
        return gateway.execute(command);
    }

}
