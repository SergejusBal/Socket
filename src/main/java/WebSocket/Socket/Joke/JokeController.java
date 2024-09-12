package WebSocket.Socket.Joke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JokeController {
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    private JokeService jokeService;

    @Autowired
    public JokeController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    @Scheduled(fixedRate = 5000)
    public void sendGreeting() {
        messagingTemplate.convertAndSend("/topic/joke", jokeService.getJoke());
    }


}
