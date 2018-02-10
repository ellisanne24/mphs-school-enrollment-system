package component_model_loader;

import daoimpl.GradeLevelDaoImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import model.gradelevel.GradeLevel;

public class GradeLevelJCompModelLoader {

    private final GradeLevelDaoImpl gradeLevelDaoImpl; 
    
    public GradeLevelJCompModelLoader(){
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
    }

    /**
     * Gets all gradelevels both ACTIVE and INACTIVE 
     * @return 
     * DefaultComboBoxModel - containing gradelevel no only. As in gradLevel.getLevelNo() 
     *
     */
    public DefaultComboBoxModel getAllGradeLevels() {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        List<GradeLevel> gradeLevelList = gradeLevelDaoImpl.getAllGradeLevelsInfo();
        for (GradeLevel g : gradeLevelList) {
            comboModel.addElement(g.getLevelNo());
        }
        comboModel.setSelectedItem(null);
        return comboModel;
    }
    
    public DefaultComboBoxModel getAllActiveGradeLevelNo(){
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        List<GradeLevel> gradeLevelList = gradeLevelDaoImpl.getAllActiveGradeLevels();
        for (GradeLevel g : gradeLevelList) {
            comboModel.addElement(g.getLevelNo());
        }
        return comboModel;
    }
    
    public DefaultComboBoxModel getAllActiveGradeLevelId(){
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        List<GradeLevel> gradeLevelList = gradeLevelDaoImpl.getAllActiveGradeLevels();
        for (GradeLevel g : gradeLevelList) {
            comboModel.addElement(g.getId());
        }
        comboModel.setSelectedItem(null);
        return comboModel;
    }

    public DefaultComboBoxModel getAllRegisteredSubjectGradeLevel() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        List<GradeLevel> gradeLevelList = gradeLevelDaoImpl.getAllRegisteredSubjectGradeLevel();
        Object[] obj = gradeLevelList.toArray();

        for (Object o : obj) {
            GradeLevel g = (GradeLevel) o;
            dcm.addElement(g.getLevelNo());
        }

        return dcm;
    }
}
