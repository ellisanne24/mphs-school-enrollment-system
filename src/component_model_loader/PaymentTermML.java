package component_model_loader;

import daoimpl.PaymentTermDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import model.paymentterm.PaymentTerm;
import model.schoolyear.SchoolYear;

/**
 *
 * @author John Ferdinand Antonio
 */
public class PaymentTermML {
    PaymentTermDaoImpl ptdi = new PaymentTermDaoImpl();
    SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    
    public DefaultComboBoxModel getNames() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        List<PaymentTerm> paymentTerms = ptdi.getAll();
        Object[] pt = paymentTerms.toArray();
        for (Object o : pt) {
            PaymentTerm p = (PaymentTerm) o;
            String name = p.getName();
            if (!name.equals("Cash")) {
                dcm.addElement(name);
            }
        }
        dcm.setSelectedItem(null);
        return dcm;
    }
    
    public DefaultListModel getSchoolYearsWithPenalty(){
        DefaultListModel dlm = new DefaultListModel();
        List<SchoolYear> syList = ptdi.getSchoolYearsWithPenalty();
        Object[] pt = syList.toArray();
        for (Object o : pt) {
            SchoolYear sy = (SchoolYear) o;
                int schoolYearId = sy.getSchoolYearId();
                int penaltySchoolYear = sydi.getById(schoolYearId).getYearFrom();
                dlm.addElement(penaltySchoolYear);
        }
        return dlm;
    }
}
