package com.learning.simplecsvprocessor.DAO;

import com.learning.simplecsvprocessor.model.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAO {

    private final JdbcTemplate jdbcTemplate;

    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> getClientsWithClientId(String clientId) {
        String sql = """
                SELECT c.clientId, c.name, c.lastName, c.phoneNumber, c.email, a.street, a.city, a.state, a.zipCode
                FROM clients c
                JOIN addresses a ON c.clientId = a.clientId
                where c.clientId = ?
                """;
        return jdbcTemplate.query(sql, new Object[]{clientId}, (rs, rowNum) -> new Client(
                rs.getLong("clientId"),
                rs.getString("name"),
                rs.getString("lastName"),
                rs.getString("phoneNumber"),
                rs.getString("email"),
                rs.getLong("addressId")
        ));

    }

}
