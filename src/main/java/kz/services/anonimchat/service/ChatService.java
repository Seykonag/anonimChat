package kz.services.anonimchat.service;

import kz.services.anonimchat.database.Message;
import kz.services.anonimchat.dto.MessageDto;
import kz.services.anonimchat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final CodeService codeService;
    private final MessageRepository messageRepository;

    public String createMessage(MessageDto dto) {
        Message message = Message.builder()
                .password(dto.getPassword())
                .text(dto.getText())
                .link(codeService.generateCode())
                .build();

        return messageRepository.save(message).getLink();
    }

    public String openMessage(String password, String link) {
        Message message = messageRepository.getReferenceByLink(link);

        if (password.equals(message.getPassword())) {
            return message.getText();
        } else {
            return "Failed password";
        }
    }
}
