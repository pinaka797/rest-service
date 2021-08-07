package com.beta.replyservice.services;

import static com.beta.replyservice.commands.CommandBuilder.NoSuchCommandException;
import static com.beta.replyservice.services.ReplyService.InvalidInputArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ReplyServiceTest {

    private ReplyService replyService = new ReplyServiceImpl();

    @Test
    public void testGetReplyNoOperation_withEmptyString() {
        String testStr = "";
        String expectedStr = "";
        assertEquals(expectedStr, replyService.getReply(testStr).getMessage());
    }

    @Test
    public void testGetReplyNoOperation_withNonEmptyString() {
        String testStr = "Test";
        String expectedStr = "Test";
        assertEquals(expectedStr, replyService.getReply(testStr).getMessage());
    }

    @Test
    public void testGetReply_withTwoReverseOperation() {
        String testStr = "Test";
        String opStr = "11";
        String expectedStr = "Test";
        assertEquals(expectedStr, replyService.getReply(opStr, testStr).getMessage());
    }

    @Test
    public void testGetReply_withTwoMD5Operation() {
        String testStr = "Test";
        String opStr = "22";
        String expectedStr = "5ec20daa6b4e614f2cf221347cf1fe41";
        assertEquals(expectedStr, replyService.getReply(opStr, testStr).getMessage());
    }

    @Test
    public void testGetReply_withMutlpleOperationFirstReverse() {
        String testStr = "Test";
        String opStr = "12";
        String expectedStr = "13f2769f098a636c08e133f77860e2fa";
        assertEquals(expectedStr, replyService.getReply(opStr, testStr).getMessage());
    }

    @Test
    public void testGetReply_withMultipleOperationFirstMd5() {
        String testStr = "Test";
        String opStr = "21";
        String expectedStr = "b516a59cd883a9080db0455f1166cbc0";
        assertEquals(expectedStr, replyService.getReply(opStr, testStr).getMessage());
    }

    @Test
    public void testGetReply_InvalidOperation() {
        String testStr = "Test";
        String opStr = "13";
        String expectedStr = "b516a59cd883a9080db0455f1166cbc0";
        assertThrows(NoSuchCommandException.class,
                () -> assertEquals(expectedStr, replyService.getReply(opStr, testStr).getMessage()));
    }

    @Test
    public void testGetReply_validOperationNullString() {
        String testStr = null;
        String opStr = "21";
        String expectedStr = "b516a59cd883a9080db0455f1166cbc0";
        assertThrows(InvalidInputArgumentException.class,
                () -> assertEquals(expectedStr, replyService.getReply(opStr, testStr).getMessage()));
    }
}
