/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.ClientDAO;
import DAO.ProductDAO;
import Entities.Product;
import Views.JpnProducts;
import java.sql.Connection;
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
    
    public DefaultTableModel getFilledTableModel() {
        String[] colunas = { "ID", "Nome", "Descrição", "Valor","Estoque" };
        DefaultTableModel tableModel = new DefaultTableModel(colunas,0);
//        List<Client> clientList = null;
//        
//        try {
//            clientList = dao.findAll();
//        } catch (Exception e) {
//            System.out.println("Erro ao buscar clientes: "+e);
//        }
//
//        if (clientList == null ) return tableModel;
//        
//        for (Client s : clientList) {
//            Object[] linha = {
//                s.getId(),
//                s.getName(),
//                s.getEmail(),
//                s.getPhone(),
//                s.getCPF()
//            };
//            tableModel.addRow(linha);
//        }
        
        return tableModel;
    }
    
    public boolean saveClient() {
       
//        Client editingClient = new Client(panel.getClientId(),
//                panel.getClientName().getText().trim(),
//                panel.getClientEmail().getText().trim(),
//                panel.getClientPhone().getText().trim(),
//                panel.getClientCPF().getText().trim());
//        try {
//            if (editingClient.getId() == null) {
//                dao.insert(editingClient);
//            } else {
//                dao.update(editingClient);
//            }
//        } catch (Exception e) {
//            System.out.println("SQL error while inserting or updating clients: "+e);
//            return false;
//        }
        
        return true;
    }
    
    public boolean deleteClient(Integer id) {
        try {
            dao.delete(id);
        } catch (Exception e) {
            System.out.println("SQL error while deleting client: "+e);
            return false;
        }
        return true;
    }
    
    public boolean editClient(Integer id) {
        try {
            Product product = dao.findById(id);
            panel.setEditingProduct(product);
        } catch (Exception e) {
            System.out.println("SQL error while editing client: "+e);
            return false;
        }
        return true;
    }
}
