package utility.layout;

import daoimpl.SectionDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.section.Section;

/**
 *
 * @author francisunoxx
 */
public class SectionUtility {

    private SectionDaoImpl sdi = new SectionDaoImpl();

    public List getCreatedSectionById(Section aSection) {
        Object[] obj = sdi.getCreatedSectionById(aSection).toArray();
        List list = new ArrayList();
        for (Object o : obj) {
            Section section = (Section) o;

            list.add(section.getSectionName());
            list.add(section.gradeLevel.getLevel());
            list.add(section.schoolYear.getYearFrom());
            list.add(section.schoolYear.getYearTo());
//            list.add(section.getGradeFrom());
//            list.add(section.getGradeTo());
            list.add(section.getCategory());
            list.add(section.session.getCapacity());
            list.add(section.session.getSessionTitle());
        }
        return list;
    }
}
