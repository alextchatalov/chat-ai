package com.chat.chat_ai.core.facede;

import com.chat.chat_ai.core.domain.out.CallApiModelOutput;
import com.chat.chat_ai.entrypoint.domain.AiModel;


public interface CallAiFacade extends Facede {

    CallApiModelOutput execute(AiModel model, String message);
}
