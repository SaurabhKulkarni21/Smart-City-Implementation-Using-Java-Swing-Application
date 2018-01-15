/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AutomobileWorkArea;

import Business.BudgetData.Budget;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Events.Event;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.WorkRequest.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amaha
 */
public class ViewAutomobileBudgetJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAutomobileBudgetJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;

    public ViewAutomobileBudgetJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount userAccount, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;
        populateAutoBudgetTable();
    }

    private void populateAutoBudgetTable() {
        DefaultTableModel model = (DefaultTableModel) tblDisplayAutoBudget.getModel();

        model.setRowCount(0);
       
          for(Network net: business.getNetworkList()){
            for(Enterprise ent: net.getEnterpriseDirectory().getEnterpriseList()){
                if(ent.getEnterpriseType() == Enterprise.EnterpriseType.GoGreenEnterprise){
                    for(WorkRequest request: ent.getWorkQueue().getWorkRequestlist()){
                        for(Budget budget: request.getBudgetList())
                            {
                                for(Event event : budget.getEventList())
                                {
                                    if(event.getOrganisationOfEvent().equals("Automobile"))
                                    {
                                        Object row[] = new Object[3];
                                        row[0]= event.getEventName();
                                        row[1]= event.getEventBudget();
                                        row[2] = event.getEventOutcome();
                                        model.addRow(row);
                                        
                                    }
                                }
                                   
                            }
                        }
                    }
                }
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisplayAutoBudget = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblDisplayAutoBudget.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "EventName", "BudgetAllocated", "Benefit"
            }
        ));
        jScrollPane1.setViewportView(tblDisplayAutoBudget);

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackBtn)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(BackBtn)
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code  userProcessContainer.remove(this);
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_BackBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDisplayAutoBudget;
    // End of variables declaration//GEN-END:variables
}
