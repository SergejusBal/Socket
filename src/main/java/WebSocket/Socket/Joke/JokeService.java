package WebSocket.Socket.Joke;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class JokeService {


    private String[] jokes = {
            "Why don't scientists trust atoms? Because they make up everything!",
            "I told my wife she was drawing her eyebrows too high. She looked surprised.",
            "Why don’t skeletons fight each other? They don’t have the guts.",
            "What do you call fake spaghetti? An impasta.",
            "Why did the scarecrow win an award? Because he was outstanding in his field!",
            "Why don’t eggs tell jokes? They’d crack each other up.",
            "What do you call cheese that isn't yours? Nacho cheese.",
            "I would tell you a construction joke, but I’m still working on it.",
            "Why did the bicycle fall over? Because it was two-tired!",
            "I’m reading a book about anti-gravity. It’s impossible to put down!",
            "What do you call a pile of cats? A meowtain.",
            "Why can't your nose be 12 inches long? Because then it would be a foot.",
            "Why did the math book look sad? Because it had too many problems.",
            "I used to play piano by ear, but now I use my hands.",
            "Why are skeletons so calm? Because nothing gets under their skin.",
            "What kind of shoes do ninjas wear? Sneakers.",
            "How does a penguin build its house? Igloos it together.",
            "Why don’t some couples go to the gym? Because some relationships don’t work out.",
            "I told my computer I needed a break, and now it won’t stop sending me cookies.",
            "What’s orange and sounds like a parrot? A carrot.",
            "Why don’t elevators like telling jokes? They bring people down."
    };

    public String getJoke(){
        int randomRumber = getRandomNumber(0,jokes.length);
        return jokes[randomRumber];
    }


    private int getRandomNumber(int min, int max){
        Random random = new Random();
        return random.nextInt(min, max);

    }


}
