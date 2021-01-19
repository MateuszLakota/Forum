package pl.lakota.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class PostsContainer {

    @Getter
    private List<PostDTO> posts;
}
