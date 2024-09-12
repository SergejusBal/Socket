package WebSocket.Socket.Clock;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class ClockService {


    public String getTime(int timeZone){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneOffset zoneOffset = ZoneOffset.ofHours(timeZone);
        LocalDateTime localDateTime = LocalDateTime.now(zoneOffset);
        return localDateTime.format(dateTimeFormatter);
    }






}
