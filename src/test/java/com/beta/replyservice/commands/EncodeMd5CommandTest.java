package com.beta.replyservice.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EncodeMd5CommandTest {

    private Command command = new EncodeMd5Command();

    @Test
    public void testGetMd5_WithNull() {
        String testStr = null;
        assertEquals(testStr, command.execute(testStr));
    }

    @Test
    public void testGetMd5_WithEmptyString() {
        String testStr = "";
        String expectedStr = "d41d8cd98f00b204e9800998ecf8427e";
        assertEquals(expectedStr, command.execute(testStr));
    }

    @Test
    public void testGetMd5_WithNonEmptyString() {
        String testStr = "test";
        String expectedStr = "098f6bcd4621d373cade4e832627b4f6";
        assertEquals(expectedStr, command.execute(testStr));
    }

}
