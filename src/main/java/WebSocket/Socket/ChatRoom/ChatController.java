package WebSocket.Socket.ChatRoom;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {


    private List<String> namelist = new ArrayList<>();

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Message repeatMessage(Message message) throws Exception {
        return message;
    }
    @MessageMapping("/name")
    @SendTo("/topic/name")
    public List<String> setName(Name name) throws Exception {
        if(name.getName().isEmpty()) namelist.add("Anonymous");
        else if(namelist.contains(name.getName())) return namelist;
        else namelist.add(name.getName());
        return namelist;
    }

}

