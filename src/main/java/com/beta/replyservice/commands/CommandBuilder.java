package com.beta.replyservice.commands;

public class CommandBuilder {
    public static class NoSuchCommandException extends RuntimeException {
    }

    public static Command build(char opType) {
        switch (opType) {
            case '1':
                return new ReverseStringCommand();
            case '2':
                return new EncodeMd5Command();
            default:
                throw new NoSuchCommandException();
        }
    }
}
