/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.ProductDAO;
import Entities.ApplicationContext;
import Entities.Product;
import Views.Editors.ProductEditor;
import Views.Panes.JpnProducts;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ellian
 */
public class ProductController {
    public final static int ALL = 0;
    public final static int INCLUSIVE = 1;
    public final static int EXCLUSIVE = 2;    
            
    private ProductDAO dao = null;
    private JpnProducts panel = null;

    public ProductController(Connection conn) {
//        dao = new ProductDAO(ApplicationContext.getInstance().getConnection());
    }

    public ProductController() {
        dao = new ProductDAO();
        if (ApplicationContext.getInstance().getActivePanel() instanceof JpnProducts jpnProducts) {
            panel = jpnProducts;
        }
    }    
    
    public void setPanel(JpnProducts panel) {
        this.panel = panel;
    }
    
    public DefaultTableModel getFilledTableModel() {
        return getFilledTableModel(false,null);
    }
    
    public DefaultTableModel getFilledTableModel(boolean modified, String expression) {
        String[] colunas = { "ID", "Nome", "Descrição", "Valor","Estoque" };
        DefaultTableModel tableModel = new DefaultTableModel(colunas,0);
        List<Product> productList = null;
        
        try {
            if (modified) {
                productList = dao.findAllActive(expression);
            } else {
                productList = dao.findAllActive();
            }            
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
    
    public boolean editProduct(Integer id) {
        try {
            Product product = dao.findById(id);
            ProductEditor editor = new ProductEditor(null,true);
            editor.setLocationRelativeTo(null);
            editor.fillFields(product);
            editor.setVisible(true);
        } catch (Exception e) {
            System.out.println("SQL error while editing client: "+e);
            return false;
        }
        return true;
    }
}
