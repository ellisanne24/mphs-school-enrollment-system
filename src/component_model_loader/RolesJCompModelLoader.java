
package component_model_loader;

import daoimpl.RoleDaoImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import model.role.Role;

/**
 *
 * @author John Ferdinand Antonio
 */
public class RolesJCompModelLoader {

    RoleDaoImpl rdi = new RoleDaoImpl();

    public DefaultComboBoxModel getAllRoleNames() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<Role> roleList = rdi.getAll();
        for (Role r : roleList) {
            model.addElement(r.getRoleName());
            System.out.println("Role : "+r.getRoleName());
        }
        return model;
    }
}
