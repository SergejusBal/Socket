package WebSocket.Socket.ChatRoom;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    private HashMap<String, String> namelist = new HashMap<>();

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Message repeatMessage(Message message) throws Exception {
        return message;
    }
    @MessageMapping("/name")
    @SendTo("/topic/name")
    public List<String> setName(Name name, @Header("simpSessionId") String sessionId) throws Exception {

        if(namelist.isEmpty()) namelist.put("","Anonymous");

        if(namelist.containsValue(name.getName())) new ArrayList<>(namelist.values());
        else namelist.put(sessionId, name.getName());

        return new ArrayList<>(namelist.values());
    }

    public void removeUser(String sessionId)  {
        if(namelist.remove(sessionId) != null) messagingTemplate.convertAndSend("/topic/name", new ArrayList<>(namelist.values()));
    }


}

