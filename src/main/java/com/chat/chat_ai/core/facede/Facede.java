package com.chat.chat_ai.core.facede;

public interface Facede<I, O> {
    O execute(I input);
}
