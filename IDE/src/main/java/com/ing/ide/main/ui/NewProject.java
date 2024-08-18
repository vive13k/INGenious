
package com.ing.ide.main.ui;

import com.ing.datalib.testdata.TestDataFactory;
import com.ing.ide.main.mainui.AppMainFrame;
import com.ing.ide.main.utils.Utils;
import com.ing.ide.util.Validator;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class NewProject extends javax.swing.JDialog {

    private final AppMainFrame sMainFrame;

    private Boolean created = false;

    public NewProject(AppMainFrame sMainFrame) throws IOException {
        this.sMainFrame = sMainFrame;
        initComponents();

        setIconImage(((ImageIcon) Utils.getIconByResourceName("/ui/resources/main/NewProject")).getImage());
        String currDirectory = new File(System.getProperty("user.dir")).getCanonicalPath() + File.separator + "Projects";
        fileChooser.setCurrentDirectory(new File(currDirectory));
        projLocation.setText(fileChooser.getCurrentDirectory().getAbsolutePath());
    }

    public void createNew() {
        created = false;
        setSize(480, 270);
        error.setText("  ");
        setLocationRelativeTo(null);
        testDataType.setModel(new DefaultComboBoxModel(TestDataFactory.getDATA_PROVIDER_NAMES().toArray()));
        setVisible(true);
    }

    public Boolean isCreated() {
        return created;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        testDataType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        projName = new javax.swing.JTextField();
        projLocation = new javax.swing.JTextField();
        createProject = new javax.swing.JButton();
        error = new javax.swing.JLabel();

        fileChooser.setDialogTitle("Select Project Location");
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        testDataType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Testdata Type");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create new Project");
        setModal(true);

        jLabel3.setText("Project Name");

        jLabel4.setText("Project Location");

        projName.setText("NewProject");
        projName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projNameActionPerformed(evt);
            }
        });

        projLocation.setEditable(false);
        projLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projLocationActionPerformed(evt);
            }
        });

        createProject.setText("Create Project");
        createProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProjectActionPerformed(evt);
            }
        });

        error.setForeground(java.awt.Color.red);
        error.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(projName)
                    .addComponent(projLocation))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(createProject)
                .addGap(180, 180, 180))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(error)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(projName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(createProject)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProjectActionPerformed
        createProject();
    }//GEN-LAST:event_createProjectActionPerformed

    private void projNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projNameActionPerformed
        createProject.doClick();
    }//GEN-LAST:event_projNameActionPerformed

    private void projLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projLocationActionPerformed
        projLocation.setText(System.getProperty("user.dir") + File.separator + "Projects");
    }//GEN-LAST:event_projLocationActionPerformed

    private void createProject() {
        if (Validator.isValidName(projName.getText().trim())) {
            String location = System.getProperty("user.dir") + File.separator + "Projects";
           /* if (projLocation.getText().trim().isEmpty()) {
                location = System.getProperty("user.dir") + File.separator + "Projects";
            } else {
                location = FilenameUtils.getFullPath(projLocation.getText().trim());
            }*/
            createProject(location);
        } else {
            error.setText("Invalid Project Name");
        }
    }

    private void createProject(String location) {
        File file = null;
        try {
            String fileloc = new File(location + File.separator + projName.getText()).getCanonicalPath();
            file = new File(fileloc);
        } catch (IOException ex) {
            Logger.getLogger(NewProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!file.exists()
                && (sMainFrame.getProject() == null
                || !sMainFrame.getProject().getLocation().equals(file.getAbsolutePath()))) {
            sMainFrame.createProject(projName.getText().trim(), location, testDataType.getSelectedItem().toString());
            created = true;
            dispose();
        } else {
            error.setText("Project Location is not Empty / Project already present in the location");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createProject;
    private javax.swing.JLabel error;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField projLocation;
    private javax.swing.JTextField projName;
    private javax.swing.JComboBox<String> testDataType;
    // End of variables declaration//GEN-END:variables
}