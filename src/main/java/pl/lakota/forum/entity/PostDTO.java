package pl.lakota.forum.entity;

import lombok.Getter;
import lombok.Setter;

public class PostDTO {

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private String nickname;

    @Getter
    @Setter
    private String postDate;

    public PostDTO(String nickname) {
        this.nickname = nickname;
    }
}
