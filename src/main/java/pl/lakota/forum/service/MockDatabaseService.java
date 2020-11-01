package pl.lakota.forum.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.lakota.forum.entity.PostDTO;

import java.util.Arrays;
import java.util.List;

@Service
public class MockDatabaseService implements DatabaseService {
    @Override
    public List<PostDTO> retrievePosts(JdbcTemplate jdbcTemplate) { // argument will be ignored
        return Arrays.asList(new PostDTO("osas", "werbasdbr", "2020-10-30"),
                new PostDTO("łotIsJorNejm", "człowiek w błocie", "2020-10-29"),
                new PostDTO("Kamegen", "jejmołtrab", "2020-10-28"));
    }
}
