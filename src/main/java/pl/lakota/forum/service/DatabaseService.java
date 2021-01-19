package pl.lakota.forum.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.lakota.forum.entity.PostDTO;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public interface DatabaseService {

    List<PostDTO> retrievePosts(JdbcTemplate jdbcTemplate);

    static DatabaseService getImplementation() {
        try {
            Resource resource = new ClassPathResource("/application.properties");
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            Object typeOfEnvironment = props.get("typeOfEnvironment");
            return typeOfEnvironment.equals("MOCK") ? new MockDatabaseService() : new RealDatabaseService();
        } catch (IOException e) {
            return null;
        }
    }
}
