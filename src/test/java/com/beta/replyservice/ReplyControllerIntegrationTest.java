package com.beta.replyservice;

import com.beta.replyservice.services.ReplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReplyControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testReplyMessage_WithNoOperation() {
        ResponseEntity<ReplyMessage> responseEntity = testRestTemplate.getForEntity("/reply/test", ReplyMessage.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertEquals("test", responseEntity.getBody().getMessage())
        );
    }

    @Test
    public void testReplyMessage_WithTwoReverseOperation() {
        ResponseEntity<ReplyMessage> responseEntity = testRestTemplate.getForEntity("/v2/reply/11-test", ReplyMessage.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertEquals("test", responseEntity.getBody().getMessage())
        );
    }

    @Test
    public void testReplyMessage_WithBothOperation() {
        ResponseEntity<ReplyMessage> responseEntity = testRestTemplate.getForEntity("/v2/reply/12-test", ReplyMessage.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertEquals("751ec45015a704a39dc403001c963e97", responseEntity.getBody().getMessage())
        );
    }

    @Test
    public void testReplyMessage_WithInvalidOperation() {
        ResponseEntity<ReplyMessage> responseEntity = testRestTemplate.getForEntity("/v2/reply/1-test", ReplyMessage.class);
        assertAll(
                () -> assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode())
        );
    }

}
