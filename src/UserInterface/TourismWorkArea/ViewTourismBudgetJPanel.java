/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.TourismWorkArea;

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
public class ViewTourismBudgetJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewTourismBudgetJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;

    public ViewTourismBudgetJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount userAccount, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;
        populateTourBudgetTable();
    }

    private void populateTourBudgetTable() {
        DefaultTableModel model = (DefaultTableModel) tblDisplayTourBudget.getModel();

        model.setRowCount(0);
   
         for(Network net: business.getNetworkList()){
            for(Enterprise ent: net.getEnterpriseDirectory().getEnterpriseList()){
                if(ent.getEnterpriseType() == Enterprise.EnterpriseType.GoGreenEnterprise){
                    for(WorkRequest request: ent.getWorkQueue().getWorkRequestlist()){
                        for(Budget budget: request.getBudgetList())
                            {
                                for(Event event : budget.getEventList())
                                {
                                    if(event.getOrganisationOfEvent().equals("Tourism"))
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
        tblDisplayInfraBudget = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDisplayTourBudget = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        tblDisplayInfraBudget.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sender", "Message", "Receiver"
            }
        ));
        jScrollPane1.setViewportView(tblDisplayInfraBudget);

        setBackground(new java.awt.Color(255, 255, 255));

        tblDisplayTourBudget.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Event Name", "Budget", "Benefit"
            }
        ));
        jScrollPane3.setViewportView(tblDisplayTourBudget);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
             userProcessContainer.remove(this);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblDisplayInfraBudget;
    private javax.swing.JTable tblDisplayTourBudget;
    // End of variables declaration//GEN-END:variables
}
