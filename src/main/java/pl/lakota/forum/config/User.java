package pl.lakota.forum.config;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class User {

    public static Map<String, Integer> RIDDLES;

    static {
        RIDDLES = new HashMap<>();
        RIDDLES.put("3^3 = ?", 27);
        RIDDLES.put("2 * 3 = ?", 6);
        RIDDLES.put("10 - 15 = ?", -5);
        RIDDLES.put("20 + 20 = ?", 40);
        RIDDLES.put("0 - 0 = ?", 0);
    }

    @Getter
    @Setter
    private String nickname;

    @Getter
    @Setter
    private String dateOfBirth;

    @Getter
    @Setter
    private int verificationResult;

    @Getter
    @Setter
    private String riddle;

    public void shuffleRiddle() {
        int index = new Random().nextInt(5);
        riddle = new ArrayList<>(RIDDLES.entrySet()).get(index).getKey();
    }

    public String getRiddle() {
        return riddle;
    }
}