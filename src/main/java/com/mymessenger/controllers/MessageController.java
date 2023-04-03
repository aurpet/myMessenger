package com.mymessenger.controllers;

import com.mymessenger.model.Message;
import com.mymessenger.repo.MessageRepository;
import com.mymessenger.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aurimas
 * @created 2023-04-03
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageController(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        if (message.getUser() != null) {
            messageRepository.save(message);
            return new ResponseEntity("Message successfully send", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/show-all")
    public ResponseEntity<Message> showAllMessages(@RequestParam("userName") String userName){
        //TODO takes a time for complete
        return new ResponseEntity(messageRepository.findAll(), HttpStatus.OK);
    }
}
