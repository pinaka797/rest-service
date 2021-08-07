package com.beta.replyservice.services;

import com.beta.replyservice.ReplyMessage;

public interface ReplyService {
    public static class InvalidInputArgumentException extends RuntimeException {
    }

    ReplyMessage getReply(String operationStr, String input);

    ReplyMessage getReply(String input);
}
