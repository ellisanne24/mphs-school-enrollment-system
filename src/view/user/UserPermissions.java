/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user;

/**
 *
 * @author John Ferdinand Antonio
 */
public class UserPermissions extends javax.swing.JPanel {

    /**
     * Creates new form UserPermissions
     */
    public UserPermissions() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspPermissionCategory = new javax.swing.JScrollPane();
        jlstPermissionCategory = new javax.swing.JList<>();
        jpnlPermissionsContainer = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        jlstPermissionCategory.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Dashboard", "Settings", "Payment", "Enrollment", "Registration" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jspPermissionCategory.setViewportView(jlstPermissionCategory);

        add(jspPermissionCategory, new java.awt.GridBagConstraints());

        jpnlPermissionsContainer.setLayout(new java.awt.GridBagLayout());
        add(jpnlPermissionsContainer, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jlstPermissionCategory;
    private javax.swing.JPanel jpnlPermissionsContainer;
    private javax.swing.JScrollPane jspPermissionCategory;
    // End of variables declaration//GEN-END:variables
}