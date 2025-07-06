package com.chat.chat_ai.dataprovider.gateway;

import com.chat.chat_ai.core.domain.input.CallAiInput;
import com.chat.chat_ai.core.domain.out.CallApiModelOutput;
import com.chat.chat_ai.core.gateway.CallAiModelGateway;
import com.chat.chat_ai.dataprovider.factories.CallModelFactory;
import org.springframework.stereotype.Component;

@Component
public class CallApiModelGatewayImpl implements CallAiModelGateway {

    private final CallModelFactory factory;

    public CallApiModelGatewayImpl(CallModelFactory factory) {
        this.factory = factory;
    }

    @Override
    public CallApiModelOutput execute(CallAiInput input) {
        return factory.get(input.model()).execute(input);
    }
}
