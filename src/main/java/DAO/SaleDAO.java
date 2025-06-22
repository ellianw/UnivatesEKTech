/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.ApplicationContext;
import Entities.Product;
import Entities.Sale;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 *
 * @author Ellian
 */

public class SaleDAO {
    private Connection conn;
    private ProductDAO productDAO;

    public SaleDAO() {
        conn = ApplicationContext.getInstance().getConnection();
        productDAO = new ProductDAO();
    }

    public boolean insert(Sale sale) {
        String insertSaleSQL = "INSERT INTO sale (ref_client, ref_user, date) VALUES (?, ?, ?) RETURNING id";
        String insertSaleProductSQL = "INSERT INTO sale_product (ref_sale, ref_product, quantity, product_value) VALUES (?, ?, ?, ?)";

        try {
            conn.setAutoCommit(false);

            // 1. Inserir a venda
            int saleId;
            try (PreparedStatement stmt = conn.prepareStatement(insertSaleSQL)) {
                stmt.setInt(1, sale.getClientId());
                stmt.setInt(2, sale.getSellerId());
                stmt.setDate(3, parseDate(sale.getDate()));

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    saleId = rs.getInt(1);
                } else {
                    conn.rollback();
                    return false;
                }
            }

            // 2. Inserir os produtos da venda
            try (PreparedStatement stmt = conn.prepareStatement(insertSaleProductSQL)) {
                Map<Integer, double[]> map = sale.getProductsMap();
                

                for (Integer productId : map.keySet()) {
                    double[] extraMap = map.get(productId);
                    stmt.setInt(1, saleId);
                    stmt.setInt(2, productId);
                    stmt.setInt(3, (int) extraMap[0]);
                    stmt.setDouble(4, extraMap[1]);
                    stmt.addBatch();
                }

                stmt.executeBatch();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static java.sql.Date parseDate(String textDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = format.parse(textDate);
            return new java.sql.Date(utilDate.getTime()); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
}
