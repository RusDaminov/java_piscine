package edu.school21.sockets.repositories;

import edu.school21.sockets.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

import static java.sql.Types.BIGINT;

public class MessageRepositoryImpl implements MessageRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public MessageRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Message findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM messages WHERE id = ?",
                new Object[]{id},
                new int[]{BIGINT},
                new BeanPropertyRowMapper<>(Message.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public List<Message> findAll() {
        return jdbcTemplate.query("SELECT * FROM messages",
                new BeanPropertyRowMapper<>(Message.class));
    }

    @Override
    public void save(Message entity) {
        jdbcTemplate.update("INSERT INTO messages (name, password) VALUES (?, ?)", entity.getName(), entity.getPassword());
    }

    @Override
    public void update(Message entity) {

    }

    @Override
    public void delete(Long id) {

    }
}

