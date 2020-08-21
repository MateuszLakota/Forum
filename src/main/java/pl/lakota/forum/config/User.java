package pl.lakota.forum.config;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class User {

    public static Map<String, Integer> CAPTCHAS;

    static {
        CAPTCHAS = new HashMap<>();
        CAPTCHAS.put("3 ^ 3 = ?", 27);
        CAPTCHAS.put("2 * 3 = ?", 6);
        CAPTCHAS.put("10 - 15 = ?", -5);
        CAPTCHAS.put("20 + 20 = ?", 40);
        CAPTCHAS.put("0 - 0 = ?", 0);
    }

    @Getter
    @Setter
    private String captcha;

    @Getter
    @Setter
    private String nickname;

    @Getter
    @Setter
    private int resultOfCaptcha;

    public void setCaptcha() {
        int index = new Random().nextInt(5);
        this.captcha = new ArrayList<>(CAPTCHAS.entrySet()).get(index).getKey();
    }
}