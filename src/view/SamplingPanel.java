/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author fatih
 */
public class SamplingPanel extends javax.swing.JPanel {
    JScrollPane jScrollPane;

    /**
     * Creates new form SamplingPanel
     */
    public SamplingPanel(JScrollPane jScrollPane) {
        initComponents();
        this.jScrollPane = jScrollPane;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        methodButtonGroup = new javax.swing.ButtonGroup();
        filePathTextField = new javax.swing.JTextField();
        pilihFileButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jumlahDataLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        simpleWRRadioButton = new javax.swing.JRadioButton();
        simpleWORRadioButton = new javax.swing.JRadioButton();
        systematicRadioButton = new javax.swing.JRadioButton();
        ppsButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jumlahSampelSpinner = new javax.swing.JSpinner();
        pilihOutputButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sizeComboBox = new javax.swing.JComboBox<>();

        pilihFileButton.setText("Pilih File");
        pilihFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihFileButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SAMPLING MENU");

        jumlahDataLabel.setText("Jumlah Data:");

        jLabel2.setText("Pilih metode sample:");

        methodButtonGroup.add(simpleWRRadioButton);
        simpleWRRadioButton.setText("Simple Random Samping WR (SRS WR)");
        simpleWRRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleWRRadioButtonActionPerformed(evt);
            }
        });

        methodButtonGroup.add(simpleWORRadioButton);
        simpleWORRadioButton.setText("Simple Random Sampling WOR (SRS WOR)");
        simpleWORRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleWORRadioButtonActionPerformed(evt);
            }
        });

        methodButtonGroup.add(systematicRadioButton);
        systematicRadioButton.setText("Systematic Random Sampling");
        systematicRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                systematicRadioButtonActionPerformed(evt);
            }
        });

        methodButtonGroup.add(ppsButton);
        ppsButton.setText("Probability Proportional to Size WR (PPS WR)");
        ppsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppsButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Jumlah sampel:");

        jumlahSampelSpinner.setModel(new javax.swing.SpinnerNumberModel(5, 1, null, 1));

        pilihOutputButton.setText("Ambil Sampel");

        jLabel4.setText("Size:");

        sizeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jumlahDataLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(simpleWORRadioButton)
                                            .addComponent(simpleWRRadioButton)
                                            .addComponent(systematicRadioButton)
                                            .addComponent(ppsButton)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(pilihOutputButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jumlahSampelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 56, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pilihFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filePathTextField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pilihFileButton)
                    .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jumlahDataLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(simpleWRRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simpleWORRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(systematicRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ppsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jumlahSampelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihOutputButton))
                .addContainerGap(179, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pilihFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihFileButtonActionPerformed
        //Pilih file csv buat sample
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Pilih file *.csv");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new FileNameExtensionFilter("File CSV (*.csv)", "csv"));

        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            filePathTextField.setText(chooser.getSelectedFile().toString());
        }
        else{
            JOptionPane.showMessageDialog(this, "No Selection");
        }

    }//GEN-LAST:event_pilihFileButtonActionPerformed

    private void simpleWRRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleWRRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simpleWRRadioButtonActionPerformed

    private void simpleWORRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleWORRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simpleWORRadioButtonActionPerformed

    private void systematicRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_systematicRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_systematicRadioButtonActionPerformed

    private void ppsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filePathTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jumlahDataLabel;
    private javax.swing.JSpinner jumlahSampelSpinner;
    private javax.swing.ButtonGroup methodButtonGroup;
    private javax.swing.JButton pilihFileButton;
    private javax.swing.JButton pilihOutputButton;
    private javax.swing.JRadioButton ppsButton;
    private javax.swing.JRadioButton simpleWORRadioButton;
    private javax.swing.JRadioButton simpleWRRadioButton;
    private javax.swing.JComboBox<String> sizeComboBox;
    private javax.swing.JRadioButton systematicRadioButton;
    // End of variables declaration//GEN-END:variables
}