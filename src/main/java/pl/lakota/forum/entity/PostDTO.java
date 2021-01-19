package pl.lakota.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private String nickname;
    private String postDate;

    public PostDTO(String nickname) {
        this.nickname = nickname;
    }

    public String getLabel() {
        return this.nickname + ", " + this.postDate + ":";
    }
}
