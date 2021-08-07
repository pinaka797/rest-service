package com.beta.replyservice;

import com.beta.replyservice.services.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @GetMapping("/reply")
    public ReplyMessage replying() {
        return new ReplyMessage("Message is empty");
    }

    @GetMapping("/reply/{message}")
    public ReplyMessage replying(@PathVariable String message) {
        return replyService.getReply(message);
    }

    @GetMapping("/v2/reply/{message}")
    public ResponseEntity<ReplyMessage> replyingv2(@PathVariable String message) {
        String operationStr = message.split("-")[0];
        String messageStr = message.split("-")[1];
        try {
            ReplyMessage replyMessage = replyService.getReply(operationStr, messageStr);
            return ResponseEntity.ok().body(replyMessage);
        } catch (ReplyService.InvalidInputArgumentException exception) {
            return ResponseEntity.badRequest().body(new ReplyMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}