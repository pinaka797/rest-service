package com.beta.replyservice.services;

import com.beta.replyservice.ReplyMessage;
import com.beta.replyservice.commands.CommandBuilder;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Override
    public ReplyMessage getReply(String operationStr, String msg) {
        if(!validateMessage(msg) || !validateOperationStr(operationStr) )
           throw new InvalidInputArgumentException();

        String currentStr=msg;
        for(char ch :operationStr.toCharArray()){
            currentStr= CommandBuilder.build(ch).execute(currentStr);
        }
        return new ReplyMessage(currentStr);
    }

    @Override
    public ReplyMessage getReply(String input) {
        return new ReplyMessage(input);
    }
    private boolean validateOperationStr(String opStr) {
        return opStr.length()==2;
    }

    private boolean validateMessage(String msg) {
        return msg!=null;
    }

}
