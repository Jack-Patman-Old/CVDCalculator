/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamma.cvd.calculator.gui.menu;

import gamma.cvd.calculator.CVDPatient;
import gamma.cvd.calculator.CVDPatientDataParser;
import gamma.cvd.calculator.gui.GuiUtils;
import gamma.cvd.calculator.gui.calculator.CalculatorScreen;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author Jack
 */
public class PatientSelectionScreen extends javax.swing.JFrame {

    CVDPatientDataParser parser;

    /**
     * Creates new form PatientSelectionScreen
     */
    public PatientSelectionScreen() {
        try {
            parser = new CVDPatientDataParser();
            GuiUtils.centerScreen(this);
            initComponents();

            txtNameSearch.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    if (!txtNameSearch.getText().isEmpty()) {
                        searchPatients();
                    } else {
                        loadPatients(parser.getPatientList());
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if (!txtNameSearch.getText().isEmpty()) {
                        searchPatients();
                    } else {
                        loadPatients(parser.getPatientList());
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    if (!txtNameSearch.getText().isEmpty()) {
                        searchPatients();
                    } else {
                        loadPatients(parser.getPatientList());
                    }
                }
                // implement the methods
            });
            
            loadPatients(parser.getPatientList());

        } catch (SAXException | IOException | GeneralSecurityException | XPathExpressionException ex) {
            Logger.getLogger(PatientSelectionScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchPatients() 
    {
        List<CVDPatient> searchCandidates = new ArrayList<>();
        
        for (CVDPatient patient: parser.getPatientList())
        {
            String firstname = patient.getFirstName().toLowerCase();
            String surname = patient.getLastName().toLowerCase();
            String searchTerm = txtNameSearch.getText().toLowerCase();
            
            if (firstname.contains(searchTerm))
            {
                searchCandidates.add(patient);
            }
            else if (surname.contains(searchTerm))
            {
                searchCandidates.add(patient);                
            }
            else if ((firstname+" "+surname).contains(searchTerm))
            {
                searchCandidates.add(patient);                
            }            
        }
        
         loadPatients(searchCandidates);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnLoadPatient = new javax.swing.JButton();
        btnDeletePatient = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        scrollPanePatients = new javax.swing.JScrollPane();
        listPatients = new javax.swing.JList();
        txtNameSearch = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select a patient");

        btnLoadPatient.setText("Load Patient");
        btnLoadPatient.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLoadPatientActionPerformed(evt);
            }
        });

        btnDeletePatient.setText("Delete Patient");
        btnDeletePatient.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeletePatientActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCloseActionPerformed(evt);
            }
        });

        listPatients.setModel(new DefaultListModel());
        scrollPanePatients.setViewportView(listPatients);

        txtNameSearch.setToolTipText("");
        txtNameSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtNameSearchActionPerformed(evt);
            }
        });

        lblName.setText("Patient Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanePatients)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLoadPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeletePatient)
                                .addGap(24, 24, 24)
                                .addComponent(btnClose))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPanePatients, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadPatient)
                    .addComponent(btnClose)
                    .addComponent(btnDeletePatient))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnLoadPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadPatientActionPerformed

        String selectedPatient = listPatients.getSelectedValue().toString();
        CVDPatient patient = findPatient(selectedPatient);

        new CalculatorScreen(patient).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoadPatientActionPerformed

    private void btnDeletePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePatientActionPerformed
        try {
            CVDPatient patient = findPatient(listPatients.getSelectedValue().toString());
            parser.removePatient(patient);
            loadPatients(parser.getPatientList());
        } catch (XPathExpressionException | TransformerException | GeneralSecurityException | IOException ex) {
            Logger.getLogger(PatientSelectionScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletePatientActionPerformed

    private void txtNameSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientSelectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientSelectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientSelectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientSelectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientSelectionScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDeletePatient;
    private javax.swing.JButton btnLoadPatient;
    private javax.swing.JLabel lblName;
    private javax.swing.JList listPatients;
    private javax.swing.JScrollPane scrollPanePatients;
    private javax.swing.JTextField txtNameSearch;
    // End of variables declaration//GEN-END:variables

    private void loadPatients(List<CVDPatient> patients) {
        DefaultListModel model = (DefaultListModel) listPatients.getModel();
        model.removeAllElements();

        for (CVDPatient patient : patients) {
            StringBuilder patientText = new StringBuilder();
            patientText.append(patient.getPatientId()).append(": ");
            patientText.append(patient.getFirstName()).append(" ").append(patient.getLastName()).append("       ");
            patientText.append(patient.getSex()).append("        ");
            patientText.append(patient.getBirthdate().toString());

            model.addElement(patientText.toString());
        }

        listPatients.setModel(model);
        listPatients.repaint();
        listPatients.revalidate();
    }

    private CVDPatient findPatient(String selectedPatient) {
        String[] data = selectedPatient.split(":");
        return (parser.findPatient(Integer.parseInt(data[0])));
    }

}
