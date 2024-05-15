package pl.javastart.jchat.message;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    String home(Model model) {
        List<Message> latestMessages = messageService.findLatestMessages();
        model.addAttribute("messages", latestMessages);
        return "index";
    }

    @PostMapping
    String addMessage(CreateMessageRequest createMessageRequest) {
        messageService.createMessage(createMessageRequest);
        return "redirect:/";
    }

    @GetMapping("/history")
    String getMessageHistory(Model model) {
        List<Message> allMessages = messageService.findAllMessages();
        model.addAttribute("messages", allMessages);
        return "history";
    }
}
