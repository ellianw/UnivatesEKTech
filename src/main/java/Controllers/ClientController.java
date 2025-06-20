/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.ClientDAO;
import Entities.ApplicationContext;
import Entities.Client;
import Entities.Product;
import Views.Editors.ClientEditor;
import Views.Editors.ProductEditor;
import Views.Panes.JpnClients;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ellian
 */
public class ClientController {
    private ClientDAO dao = null;
    private JpnClients panel = null;

    public ClientController() {
        dao = new ClientDAO();
        if (ApplicationContext.getInstance().getActivePanel() instanceof JpnClients jpnClients) {
            panel = jpnClients;
        }        
    }
    
    public void setPanel(JpnClients panel) {
        this.panel = panel;
    }
    
    public DefaultTableModel getFilledTableModel() {
        return getFilledTableModel(false);
    }
    
    public DefaultTableModel getFilledTableModel(boolean conditioned) {
        String[] colunas = { "ID", "Nome", "Email", "Telefone","CPF" };
        DefaultTableModel tableModel = new DefaultTableModel(colunas,0);
        List<Client> clientList = null;
        
        String whereClause = "";
        
        try {
            if (conditioned) {
                whereClause = getWhereClause();
            }
            clientList = dao.findAllActive(whereClause);
        } catch (Exception e) {
            System.out.println("Erro ao buscar clientes: "+e);
        }

        if (clientList == null ) return tableModel;
        
        for (Client s : clientList) {
            Object[] linha = {
                s.getId(),
                s.getName(),
                s.getEmail(),
                s.getPhone(),
                s.getCPF()
            };
            tableModel.addRow(linha);
        }
        
        return tableModel;
    }
    
    public boolean saveClient(Client client) {
        try {
            if (client.getId() == null) {
                dao.insert(client);
            } else {
                dao.update(client);
            }
        } catch (Exception e) {
            System.out.println("SQL error while inserting or updating clients: "+e);
            return false;
        }
        
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
            Client client = dao.findById(id);
            ClientEditor editor = new ClientEditor(null,true);
            editor.setLocationRelativeTo(null);
            editor.fillFields(client);
            editor.setVisible(true);
        } catch (Exception e) {
            System.out.println("SQL error while editing client: "+e);
            return false;
        }
        return true;
    }
    
    private String getWhereClause() {
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
