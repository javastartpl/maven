package pl.javastart.jchat.message;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @InjectMocks
    MessageService messageService;
    @Mock
    MessageRepository messageRepository;
    @Captor
    ArgumentCaptor<Message> messageCaptor;

    @Test
    void shouldCreateMessage() {
        CreateMessageRequest messageRequest = new CreateMessageRequest("someAuthor", "some message");
        messageService.createMessage(messageRequest);
        verify(messageRepository).save(messageCaptor.capture());
        Message savedMessage = messageCaptor.getValue();
        assertAll(
                () -> assertEquals(messageRequest.author(), savedMessage.getAuthor()),
                () -> assertEquals(messageRequest.message(), savedMessage.getMessage()),
                () -> assertNotNull(savedMessage.getId()),
                () -> assertNotNull(savedMessage.getTime())
        );
    }

}
