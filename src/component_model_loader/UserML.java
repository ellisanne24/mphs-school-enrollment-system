/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.UserDaoImpl;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.user.User;

/**
 *
 * @author John Ferdinand Antonio
 */
public class UserML {

    UserDaoImpl udi = new UserDaoImpl();

    public DefaultTableModel getAllUsers(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<User> list = udi.getAll();
        for (User u : list) {
            model.addRow(new Object[]{u.getId(), u.getUsername(), u.getRole().getRoleName(),
                u.getLastName() + ", " + u.getFirstName() + " " + u.getMiddleName()
            });
        }
        return model;
    }
}
