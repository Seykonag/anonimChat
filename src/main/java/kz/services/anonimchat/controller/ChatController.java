package kz.services.anonimchat.controller;

import kz.services.anonimchat.dto.MessageDto;
import kz.services.anonimchat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/create")
    public String createMessage(@RequestBody MessageDto request) {
        return "You link: " + chatService.createMessage(request);
    }

    @PostMapping("/open/{linkMessage}")
    public String openMessage(@PathVariable String linkMessage,
                              @RequestBody String password) {
        return "Hidden text: " + chatService.openMessage(password, linkMessage);
    }
}
