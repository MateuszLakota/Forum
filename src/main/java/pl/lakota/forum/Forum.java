package pl.lakota.forum;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class Forum implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    @Bean
    DataSource dataSource() throws SQLException {
        com.microsoft.sqlserver.jdbc.SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setURL(environment.getProperty("spring.datasource.url"));
        return dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(Forum.class, args);
    }

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                ((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
            }
        };
    }
}