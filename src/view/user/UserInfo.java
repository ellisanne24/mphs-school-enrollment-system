package view.user;

import component_model_loader.UserJCompModelLoader;
import daoimpl.RoleDaoImpl;
import daoimpl.UserDaoImpl;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.role.Role;
import model.user.User;
import utility.password.PasswordUtil;
import utility.puzzler.Puzzler;
import utility.string.StringUtil;
import static view.user.AllUsersRecord.jtblRecord;

/**
 *
 * @author John Ferdinand Antonio
 */
public class UserInfo extends javax.swing.JDialog {
    UserDaoImpl userDaoImpl = new UserDaoImpl();
   
    public UserInfo(java.awt.Frame parent, boolean modal, DefaultComboBoxModel rolesComboModel) {
        super(parent, modal);
        initComponents();
        jcmbUserRole.setModel(rolesComboModel);
        initializeControllers();
    }

    private void initializeControllers(){
//        jcmbUserRole.addItemListener(new AddUserPermissionsPanel(jcmbUserRole, jpnlInfo));
    }
    
    private boolean addUser(User user) {
        boolean isAdded;
        isAdded = userDaoImpl.add(user);
        return isAdded;
    }
    
    private boolean passwordHasSpecialChars(){
        boolean hasSpecialChar = true;
        String newPassword = PasswordUtil.toString(jpfPassword.getPassword());
        String newPasswordReEnter = PasswordUtil.toString(jpfPasswordReEnter.getPassword());
        if(!StringUtil.hasSpecialCharaters(newPassword) && !StringUtil.hasSpecialCharaters(newPasswordReEnter)){
            hasSpecialChar = false;
        }
        return hasSpecialChar;
    }
    
    private boolean passwordMatched(){
        boolean matched;
        String newPassword = PasswordUtil.toString(jpfPassword.getPassword());
        String newPasswordReEnter = PasswordUtil.toString(jpfPasswordReEnter.getPassword());
        matched = newPassword.equals(newPasswordReEnter);
        return matched;
    }
    
    private boolean passwordLengthIsValid(){
        boolean valid = true;
        int minimumLength = 8;
        String newPassword = PasswordUtil.toString(jpfPasswordReEnter.getPassword());
        char[] parts = newPassword.toCharArray();
        if(parts.length < minimumLength){
            valid = false;
        }
        return valid;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpnlInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jpfPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jtfFirstName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfMiddleName = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcmbUserRole = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jpfPasswordReEnter = new javax.swing.JPasswordField();
        jpnlControls = new javax.swing.JPanel();
        jbtnCancel = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlInfo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Username ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel1, gridBagConstraints);

        jtfUserName.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jtfUserName, gridBagConstraints);

        jLabel2.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel2, gridBagConstraints);

        jpfPassword.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jpfPassword, gridBagConstraints);

        jLabel4.setText("First Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel4, gridBagConstraints);

        jtfFirstName.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jtfFirstName, gridBagConstraints);

        jLabel6.setText("Middle Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Last Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel7, gridBagConstraints);

        jtfMiddleName.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jtfMiddleName, gridBagConstraints);

        jtfLastName.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jtfLastName, gridBagConstraints);

        jLabel3.setText("Role ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel3, gridBagConstraints);

        jcmbUserRole.setSelectedIndex(-1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jcmbUserRole, gridBagConstraints);

        jLabel5.setText("Re-enter password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel5, gridBagConstraints);

        jpfPasswordReEnter.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jpfPasswordReEnter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlInfo, gridBagConstraints);

        jpnlControls.setLayout(new java.awt.GridBagLayout());

        jbtnCancel.setText("Cancel");
        jpnlControls.add(jbtnCancel, new java.awt.GridBagConstraints());

        jbtnSave.setText("Save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });
        jpnlControls.add(jbtnSave, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlControls, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isFormValid(){
        boolean isValid;
        if (passwordHasSpecialChars()) {
            JOptionPane.showMessageDialog(null, "Special characters are not allowed.");
            isValid = false;
        } else if (!passwordMatched()) {
            JOptionPane.showMessageDialog(null, "passwords didn't match");
            isValid = false;
        } else if (jtfUserName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a username");
            isValid = false;
        } else if(!passwordLengthIsValid()){
            JOptionPane.showMessageDialog(null,"Password must have at least 8 charaters");
            isValid = false;
        } else{
            isValid = true;
        }
        return isValid;
    }
    
    private User getUser(){
        RoleDaoImpl rdi = new RoleDaoImpl();
        String username = jtfUserName.getText().trim();
        String password = PasswordUtil.toString(jpfPassword.getPassword());
        Puzzler puzzler = new Puzzler(password);
        String enryptedPassword = puzzler.getEncrypted();
        String firstName = jtfFirstName.getText().trim();
        String lastName = jtfLastName.getText().trim();
        String middleName = jtfMiddleName.getText().trim();
        
        String roleAssigned = jcmbUserRole.getSelectedItem().toString().trim();
        Role role = new Role();
        role.setId(rdi.getId(roleAssigned));
        role.setRoleName(roleAssigned);
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(enryptedPassword);
        user.setLastName(lastName);
        user.setMiddleName(middleName);
        user.setFirstName(firstName);
        user.setRole(role);
        
        return user;
    }
    
    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        if (isFormValid()) {
            if (addUser(getUser())) {
                JOptionPane.showMessageDialog(null, "Successfully added user");
                jtblRecord.setModel(new UserJCompModelLoader().getAllUsers(jtblRecord));
            } else {
                JOptionPane.showMessageDialog(null, "Error encountered. User not added.");
            }
        } 
    }//GEN-LAST:event_jbtnSaveActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JComboBox<String> jcmbUserRole;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JPasswordField jpfPasswordReEnter;
    private javax.swing.JPanel jpnlControls;
    private javax.swing.JPanel jpnlInfo;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfMiddleName;
    private javax.swing.JTextField jtfUserName;
    // End of variables declaration//GEN-END:variables
}
