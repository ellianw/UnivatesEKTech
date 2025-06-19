/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.ProductDAO;
import Entities.Product;
import Views.Editors.ProductEditor;
import Views.Panes.JpnProducts;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ellian
 */
public class ProductController {
    private ProductDAO dao = null;
    private JpnProducts panel = null;

    public ProductController(Connection conn) {
        dao = new ProductDAO(conn);
    }

    public ProductController() {
    }    
    
    public void setPanel(JpnProducts panel) {
        this.panel = panel;
    }
    
    public DefaultTableModel getFilledTableModel(JpnProducts panel) {
        return getFilledTableModel(panel, false);
    }
    
    public DefaultTableModel getFilledTableModel(JpnProducts panel, boolean conditioned) {
        String[] colunas = { "ID", "Nome", "Descrição", "Valor","Estoque" };
        DefaultTableModel tableModel = new DefaultTableModel(colunas,0);
        List<Product> productList = null;
        
        String whereClause = "";
        
        try {
            if (conditioned) {
                whereClause = getWhereClause(panel);
            }
            productList = dao.findAllActive(whereClause);
        } catch (Exception e) {
            System.out.println("Erro ao buscar clientes: "+e);
            e.printStackTrace();
        }

        if (productList == null ) return tableModel;
        
        for (Product p : productList) {
            Object[] linha = {
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getValue(),
                p.getStock()
            };
            tableModel.addRow(linha);
        }
        
        return tableModel;
    }
    
    public boolean saveProduct(Product product) {
        try {
            if (product.getId() == null) {
                dao.insert(product);
            } else {
                dao.update(product);
            }
        } catch (Exception e) {
            System.out.println("SQL error while inserting or updating clients: "+e);
            return false;
        }
        
        return true;
    }
    
    public boolean deleteProduct(Integer id) {
        try {
            dao.delete(id);
        } catch (Exception e) {
            System.out.println("SQL error while deleting client: "+e);
            return false;
        }
        return true;
    }
    
    public boolean editProduct(Integer id,JpnProducts panel) {
        try {
            Product product = dao.findById(id);
            ProductEditor editor = new ProductEditor(this,panel);
            editor.setLocationRelativeTo(null);
            editor.fillFields(product);
            editor.setVisible(true);
        } catch (Exception e) {
            System.out.println("SQL error while editing client: "+e);
            return false;
        }
        return true;
    }
    
    private String getWhereClause(JpnProducts panel) {
        String clause = null;
        String[] parameters = panel.getSearchParameters();
        String column = parameters[0].toLowerCase();
        String value = parameters[1].toLowerCase();
        if ("id".equals(column) && !value.isBlank()) {
            clause = "id = "+value;
        } else if (!value.isBlank()){
            clause = "name like '%"+value+"%'";
        }
        return clause;
    }
}
