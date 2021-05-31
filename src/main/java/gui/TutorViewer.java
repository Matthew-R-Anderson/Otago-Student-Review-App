/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.*;
import domain.*;
import gui_helpers.SimpleListModel;
import java.awt.Window;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author Finley
 */
public class TutorViewer extends javax.swing.JDialog {

    private final TutorDAO dao;
    //private final PaperDAO paperDAO;
    SimpleListModel tutorModel = new SimpleListModel();
    Collection<Tutor> tutors;

    /**
     * Creates new form ProductViewer
     */
    public TutorViewer(java.awt.Frame parent, boolean modal,TutorDAO dao) {
        super(parent);
        this.dao = dao;
        //this.paperDAO = paperDAO;
        tutors = dao.getTutors();
        initComponents();

        tutorModel.updateItems(tutors);
        listTutor.setModel(tutorModel);

        
        
        listTutor.setName("lstTutor");
        btnEdit.setName("btnEdit");
        btnDelete.setName("btnDelete");
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
        listTutor = new javax.swing.JList<>();
        btnClose = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSearchByName = new javax.swing.JTextField();
        btnSearchByName = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(listTutor);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel2.setText("Tutor Name");

        txtSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchByNameActionPerformed(evt);
            }
        });

        btnSearchByName.setText("Search");
        btnSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchByName)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchByName))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnClose)
                    .addComponent(btnEdit))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        Tutor tutor = listTutor.getSelectedValue();

        //if a paper is selected, asks user if they are sure they want to delete the paper, updates the paper model if pressed confirm
        if (!(listTutor.isSelectionEmpty())) {
            int confirm = JOptionPane.showConfirmDialog(this, "Delete Tutor: \nID:" + tutor.getTutor_ID() + "\nName: " + tutor.getName()+ "\nConfirm: ");
            if (confirm == JOptionPane.YES_OPTION) {
                dao.removeTutor(tutor);
                tutorModel.updateItems(dao.getTutors());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
         if (listTutor.isSelectionEmpty()) {
            return;
        }

        // get selected tutor from list
        Tutor selectedTutor = listTutor.getSelectedValue();
        //Paper selectedPapers = selectedTutor.getPaper();

        TutorEditor dialog = new TutorEditor(this, true, selectedTutor, dao);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        // update list to display new paper details
        tutorModel.updateItems(dao.getTutors());
        

    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchByNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchByNameActionPerformed

    private void btnSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByNameActionPerformed
        // TODO add your handling code here:
       String name = txtSearchByName.getText();
       Tutor tutor = dao.searchByName(name);
       tutorModel.updateItems(tutor);
        
    }//GEN-LAST:event_btnSearchByNameActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearchByName;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Tutor> listTutor;
    private javax.swing.JTextField txtSearchByName;
    // End of variables declaration//GEN-END:variables
}
