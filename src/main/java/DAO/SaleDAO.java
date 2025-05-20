/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Sale;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Ellian
 */

public class SaleDAO {
    private Connection conn;

    public SaleDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Sale sale, Date date, List<Integer> productIds, List<Integer> quantities, List<Double> productValues) throws SQLException {
        String saleSql = "INSERT INTO sale (client_id, date) VALUES (?, ?) RETURNING id";
        String saleProductSql = "INSERT INTO sale_product (sale_id, product_id, quantity, product_value) VALUES (?, ?, ?, ?)";

        try (
            PreparedStatement saleStmt = conn.prepareStatement(saleSql);
            PreparedStatement spStmt = conn.prepareStatement(saleProductSql)
        ) {
            conn.setAutoCommit(false);

            // Insert sale
            saleStmt.setInt(1, sale.getClientId());
            saleStmt.setDate(2, date);
            ResultSet rs = saleStmt.executeQuery();
            int saleId = 0;
            if (rs.next()) {
                saleId = rs.getInt(1);
            }

            // Insert related products
            for (int i = 0; i < productIds.size(); i++) {
                spStmt.setInt(1, saleId);
                spStmt.setInt(2, productIds.get(i));
                spStmt.setInt(3, quantities.get(i));
                spStmt.setDouble(4, productValues.get(i));
                spStmt.addBatch();
            }
            spStmt.executeBatch();
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.setAutoCommit(true);
        }
    }
}
