package pl.lakota.forum.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.lakota.forum.entity.PostDTO;

import java.util.List;

@Service
public class RealDatabaseService implements DatabaseService {

    @Override
    public List<PostDTO> retrievePosts(JdbcTemplate jdbcTemplate) {
        String query = "SELECT * FROM Posts";
        List<PostDTO> listOfPosts = jdbcTemplate.query(query, (rs, rowNum) -> new PostDTO(
                rs.getString("Message"), rs.getString("Nickname"),
                rs.getString("PostDate")));
        return listOfPosts;
    }
}
