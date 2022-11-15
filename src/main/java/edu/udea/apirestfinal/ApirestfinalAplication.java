package edu.udea.apirestfinal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ApirestfinalAplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate template;


    public static void main(String[] args) {
        SpringApplication.run(ApirestfinalAplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        template.execute("CREATE TABLE IF NOT EXISTS users (id SERIAL, userName VARCHAR(255), password VARCHAR(255), email VARCHAR(255),  enabled BOOLEAN, roles VARCHAR(255), PRIMARY KEY (id))");
        template.execute("CREATE TABLE IF NOT EXISTS roles (id SERIAL, name VARCHAR(255), enabled BOOLEAN, PRIMARY KEY (id))");
        template.execute("CREATE TABLE IF NOT EXISTS users_roles (user_id INTEGER, role_id INTEGER, PRIMARY KEY (user_id, role_id))");

        for (int i = 0; i < 3; i++) {
            template.execute("INSERT INTO users (userName, password, email, enabled) VALUES ('user" + i + "', 'password" + i + "', 'email" + i + "', true)");
        }

        template.execute("INSERT INTO roles (name, enabled) VALUES ('Developer', true)");
        template.execute("INSERT INTO roles (name, enabled) VALUES ('FrontEnd', true)");
        template.execute("INSERT INTO roles (name, enabled) VALUES ('FullStack', true)");


    }
}
