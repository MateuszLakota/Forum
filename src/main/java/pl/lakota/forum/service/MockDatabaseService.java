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
        return Arrays.asList(new PostDTO("Mock message 1.", "Mock nickname 1.", "1970-01-01"),
                new PostDTO("Mock message 2.", "Mock nickname 2.", "2000-01-01"),
                new PostDTO("Mock message 3.", "Mock nickname 3.", "2020-01-01"));
    }
}
