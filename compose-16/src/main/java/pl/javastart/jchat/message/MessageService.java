package pl.javastart.jchat.message;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
class MessageService {
    private static final Pageable DEFAULT_PAGE = PageRequest.of(0, 10, Sort.by("time").descending());
    private final MessageRepository messageRepository;

    MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    void createMessage(CreateMessageRequest messageRequest) {
        Message message = new Message(
                LocalDateTime.now(),
                messageRequest.author(),
                messageRequest.message()
        );
        messageRepository.save(message);
    }

    List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    List<Message> findLatestMessages() {
        return messageRepository.findAll(DEFAULT_PAGE).stream().toList();
    }
}
