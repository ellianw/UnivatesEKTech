/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Controllers.ClientController;
import Controllers.ProductController;
import java.sql.Connection;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Ellian
 */
public class ApplicationContext {
    private static ApplicationContext instance;
    
    private Connection connection;
    
    private JPanel activePanel;
    private JDialog activeEditor;
    private ClientController clientController;
    private ProductController productController;

    private ApplicationContext(){
    
    };
    
    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    };
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection conn) {
        this.connection = conn;
    }

    public JPanel getActivePanel() {
        return activePanel;
    }

    public void setActivePanel(JPanel activePanel) {
        this.activePanel = activePanel;
    }

    public JDialog getActiveEditor() {
        return activeEditor;
    }

    public void setActiveEditor(JDialog activeEditor) {
        this.activeEditor = activeEditor;
    }

    public ClientController getClientController() {
        return clientController;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public ProductController getProductController() {
        if (productController == null) {
            productController = new ProductController();
        }
        return productController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }
    
    
}
