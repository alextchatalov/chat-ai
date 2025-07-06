package com.chat.chat_ai.core.gateway;

public interface Gateway<I, O> {
    O execute(I input);
}
