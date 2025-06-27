package com.chat.chat_ai.core.strategies;

public interface AiModelStrategy<T, I, CallApiModelOutput> extends Strategy<T> {

    CallApiModelOutput execute(I command);

}
