/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.SaleDAO;
import Entities.Sale;
import Views.Panes.JpnSales;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ellian
 */
public class SaleController {
    private SaleDAO dao = null;
    private JpnSales panel = null;

    public SaleController() {
        dao = new SaleDAO();
    }
    
    public void setPanel(JpnSales panel) {
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
    
    public boolean saveSale(Integer clientId, Integer sellerId, Map productMap, String date) {
        Sale sale = new Sale(null, clientId, sellerId, productMap, date, calculateSaleValue(productMap));
        try {
            if (sale.getId() == null) {
                dao.insert(sale);
            } else {
//                dao.update(sale);
            }
        } catch (Exception e) {
            System.out.println("SQL error while inserting or updating sale: "+e);
            return false;
        }
        
        return true;
    }
//    NEED REFACTOR
    public boolean deleteSale(Integer id) {
//        try {
//            dao.delete(id);
//        } catch (Exception e) {
//            System.out.println("SQL error while deleting client: "+e);
//            return false;
//        }
        return true;
    }
    
    public boolean editSale(Integer id) {
//        try {
//            Product product = dao.findById(id);
//            panel.setEditingProduct(product);
//        } catch (Exception e) {
//            System.out.println("SQL error while editing client: "+e);
//            return false;
//        }
        return true;
    }
    
    private double calculateSaleValue(Map sale) {
        double output = 0;
        for (Object v : sale.values()) {
            double[] arr = (double[]) v;
            output += arr[1];
        }
        return output;
    }
}
