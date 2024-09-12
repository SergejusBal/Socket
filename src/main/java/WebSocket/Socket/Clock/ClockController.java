package WebSocket.Socket.Clock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
public class ClockController {
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ClockService clockService;

    @Autowired
    public ClockController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    private int timeZone = 0;

    @GetMapping("/API/time/{time}")
    public  ResponseEntity<Boolean> rateEvent(@PathVariable int time) {
        try {
            timeZone = time;
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @MessageMapping("/clock")
    @SendTo("/topic/clock")
    public Integer greeting(Integer timeZone) throws Exception {
        return this.timeZone = timeZone;
    }

    @Scheduled(fixedRate = 100)
    public void sendGreeting() {
        messagingTemplate.convertAndSend("/topic/clock", clockService.getTime(timeZone));
    }


}
