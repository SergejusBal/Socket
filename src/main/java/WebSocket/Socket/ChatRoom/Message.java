package WebSocket.Socket.ChatRoom;

import java.time.LocalDateTime;
import java.util.List;

public class Message {

    private String name;
    private String message;
    private LocalDateTime localDateTime;
    private List<String> nameList;

    public Message() {
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
