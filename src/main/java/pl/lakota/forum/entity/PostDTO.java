package pl.lakota.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// TODO Remove obsolete @Getter and @Setter annotations.
@AllArgsConstructor
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

    public PostDTO() {
    }

    public PostDTO(String nickname) {
        this.nickname = nickname;
    }

    public String getLabel() {
        return this.nickname + ", " + this.postDate + ":";
    }
}
