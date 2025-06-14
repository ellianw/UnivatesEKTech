/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controllers.ClientController;
import Entities.Client;
import Utils.ViewUtils;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Ellian
 */
public class JpnClients extends javax.swing.JPanel {
    private ClientController controller = null;
    private Client editingClient = null;
    
    /**
     * Creates new form JpnSuppliers
     */
    public JpnClients() {
        controller = new ClientController();
        controller.setPanel(this);
        initComponents();
        setMappings();
    }
    
    public JpnClients(ClientController controller) {
        this.controller = controller;
        controller.setPanel(this);
        initComponents();
        setMappings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        listPane = new javax.swing.JPanel();
        jspListTable = new javax.swing.JScrollPane();
        jtbList = new javax.swing.JTable();
        btnPanel = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        hintPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Clientes:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "CPF", "Nome", "Telefone" }));

        btnSearch.setText("🔎");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)))
        );

        add(searchPanel, java.awt.BorderLayout.NORTH);

        jtbList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Cliente 1", "51 9999-9999", "000.000.000-00"}
            },
            new String [] {
                "ID", "Nome", "Telefone", "CPF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbList.setRowSelectionAllowed(true);
        jtbList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbList.setShowHorizontalLines(true);
        jspListTable.setViewportView(jtbList);
        jtbList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbList.setAutoCreateRowSorter(true);

        javax.swing.GroupLayout listPaneLayout = new javax.swing.GroupLayout(listPane);
        listPane.setLayout(listPaneLayout);
        listPaneLayout.setHorizontalGroup(
            listPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspListTable, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
        );
        listPaneLayout.setVerticalGroup(
            listPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspListTable, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(listPane, java.awt.BorderLayout.CENTER);

        btnPanel.setPreferredSize(new java.awt.Dimension(100, 100));

        btnNew.setText("Novo");
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        btnNew.putClientProperty( "FlatLaf.style","borderColor:#357EC7;borderWidth:2");

        btnEdit.setText("Editar");
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setText("Deletar");
        btnDel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        btnDel.putClientProperty( "FlatLaf.style","borderColor:#cf142b;borderWidth:2");

        btnExit.setText("Sair");
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDel, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(btnPanel, java.awt.BorderLayout.EAST);

        jLabel2.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        jLabel2.setText("Dica: Utilize F5 como atalho para o botão de busca.");

        javax.swing.GroupLayout hintPaneLayout = new javax.swing.GroupLayout(hintPane);
        hintPane.setLayout(hintPaneLayout);
        hintPaneLayout.setHorizontalGroup(
            hintPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hintPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(422, Short.MAX_VALUE))
        );
        hintPaneLayout.setVerticalGroup(
            hintPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hintPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(hintPane, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        ClientEditor editor = new ClientEditor();
        editor.setVisible(true);
        editor.setLocationRelativeTo(null);        
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Integer id = ViewUtils.getSelectedListItemId(jtbList);
        if (id == null) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //boolean status = controller.editSupplier(id);
//        if (!status) {
//            JOptionPane.showMessageDialog(null, "Erro desconhecido ao excluir fornecedor!", "Erro", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        Integer id = ViewUtils.getSelectedListItemId(jtbList);
        if (id == null) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (ViewUtils.excludePane()) {
//          boolean status = controller.deleteClient(id);
//          if (!status) {
//              JOptionPane.showMessageDialog(null, "Erro desconhecido ao excluir fornecedor!", "Erro", JOptionPane.ERROR_MESSAGE);
//                return;
//          }
//          jtbList.setModel(controller.getFilledTableModel());
            JOptionPane.showMessageDialog(null, "Cliente deletado!", "Sucesso", JOptionPane.PLAIN_MESSAGE);        
        }

    }//GEN-LAST:event_btnDelActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        exitPanel();
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel hintPane;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane jspListTable;
    private javax.swing.JTable jtbList;
    private javax.swing.JPanel listPane;
    private javax.swing.JPanel searchPanel;
    // End of variables declaration//GEN-END:variables
 
    private void exitPanel(){
        FrmMain parent = (FrmMain)SwingUtilities.getWindowAncestor(this);
        parent.clearFrame(true);
    }
    
    public Integer getClientId() {
        return editingClient == null ? null : editingClient.getId();
    }
    
//    public JTextComponent getClientCPF() {
//        return jtfCPF;
//    }
//
//    public JTextComponent getClientEmail() {
//        return jtfEmail;
//    }
//
//    public JTextComponent getClientName() {
//        return jtfName;
//    }
//
//    public JTextComponent getClientPhone() {
//        return jtfPhone;
//    }
//        
//    public void setEditingClient(Client client) {
//        editingClient = client;
//        jtfCPF.setText(client.getCPF());
//        jtfEmail.setText(client.getEmail());
//        jtfName.setText(client.getName());
//        jtfPhone.setText(client.getPhone());
//    }
    private void setMappings() {
        KeyStroke shortcut = KeyStroke.getKeyStroke("F5");
        InputMap inputMap = btnSearch.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = btnSearch.getActionMap();

        inputMap.put(shortcut, "clickButton");
        actionMap.put("clickButton", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearch.doClick(); // simula clique
            }
        });
    }
}