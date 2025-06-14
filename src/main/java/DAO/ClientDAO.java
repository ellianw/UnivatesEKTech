/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ellian
 */
public class ClientDAO {
    private Connection conn;

    public ClientDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Client client) throws SQLException {
        String sql = "INSERT INTO client (name, cpf, phone, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getCPF());
            stmt.setString(3, client.getPhone());
            stmt.setString(4, client.getEmail());
            stmt.executeUpdate();
        }
    }

    public Client findById(int id) throws SQLException {
        String sql = "SELECT * FROM client WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Client(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("cpf"),
                    rs.getString("phone"),
                    rs.getString("email")
                );
            }
        }
        return null;
    }

    public List<Client> findAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                clients.add(new Client(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("cpf"),
                    rs.getString("phone"),
                    rs.getString("email")
                ));
            }
        }
        return clients;
    }

    public void update(Client client) throws SQLException {
        String sql = "UPDATE client SET name = ?, cpf = ?, phone = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getCPF());
            stmt.setString(3, client.getPhone());
            stmt.setString(4, client.getEmail());
            stmt.setInt(5, client.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}