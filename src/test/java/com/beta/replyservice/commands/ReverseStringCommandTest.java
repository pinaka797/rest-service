package com.beta.replyservice.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringCommandTest {
    private Command command = new ReverseStringCommand();

    @Test
    public void testGetReverse_WithEmptyString() {
        String testStr = "";
        assertEquals(testStr, command.execute(testStr));
    }

    @Test
    public void testGetReverse_WithNonEmptyString() {
        String testStr = "Test";
        assertEquals("tseT", command.execute(testStr));
    }

    @Test
    public void testGetReverse_WithNonEmptyStringWithNumbers() {
        String testStr = "Test9";
        assertEquals("9tseT", command.execute(testStr));
    }

    @Test
    public void testGetReverse_WithPalindrome() {
        String testStr = "teet";
        assertEquals("teet", command.execute(testStr));
    }
}
