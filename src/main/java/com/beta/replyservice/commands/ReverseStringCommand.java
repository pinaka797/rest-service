package com.beta.replyservice.commands;

public class ReverseStringCommand implements Command {

    @Override
    public String execute(String inputStr) {
        return getReverse(inputStr);
    }

    private String getReverse(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return reversed;
    }
}
