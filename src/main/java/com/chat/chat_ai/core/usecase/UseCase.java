package com.chat.chat_ai.core.usecase;

public interface UseCase<I, O> {
    O execute(I input);
}
