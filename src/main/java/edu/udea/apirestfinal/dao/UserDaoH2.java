package edu.udea.apirestfinal.dao;

import edu.udea.apirestfinal.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


public class UserDaoH2 implements IDao<User> {

    String queryCreate = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY AUTO_INCREMENT, userName VARCHAR(255),  password VARCHAR(255), email VARCHAR(255), enabled BOOLEAN)";

    //Configurar H2
    private JdbcTemplate template;


    @Override
    public int guardar(User user) {
        String query = "INSERT INTO users (userName, password, email, enabled) VALUES (?, ?, ?, ?)";
        int res=template.update(query, user.getUserName(), user.getPassword(), user.getEmail(), user.isEnabled());
        return res;
    }

    @Override
    public void eliminar(Long id) {
        String query = "DELETE FROM users WHERE id = ?";
        template.update(query, id);
    }

    @Override
    public User buscar(Long id) {
        String query = "SELECT * FROM users WHERE id = ?";
        return template.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<User> buscarTodos() {
        String querySelectAll = "SELECT * FROM users";
        List<User> users = template.query(querySelectAll, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public int editar(User user) {
        String query = "UPDATE users SET userName = ?, password = ?, email = ?, enabled = ? WHERE id = ?";
        int res=template.update(query, user.getUserName(), user.getPassword(), user.getEmail(), user.isEnabled(), user.getId());
        return res;
    }
}



