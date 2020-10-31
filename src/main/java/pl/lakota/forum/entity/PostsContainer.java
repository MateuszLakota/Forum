package pl.lakota.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// TODO Remove obsolete @Getter and @Setter annotations.
@AllArgsConstructor
public class PostsContainer {

    @Getter
    @Setter
    private List<PostDTO> posts;
}
