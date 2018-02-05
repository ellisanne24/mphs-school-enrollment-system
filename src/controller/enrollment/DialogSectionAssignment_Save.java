package controller.enrollment;

import daoimpl.SectionDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.section.Section;
import model.student.Student;
import view.section.Dialog_SectionAssignment;

/**
 *
 * @author Jordan
 */
public class DialogSectionAssignment_Save implements ActionListener {

    private final Dialog_SectionAssignment view;

    public DialogSectionAssignment_Save(Dialog_SectionAssignment view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SectionDaoImpl sectionDaoImpl = new SectionDaoImpl();
        int sectionId = Integer.parseInt(view.getJcmbSection().getSelectedItem().toString().trim());
        JTable table = view.getJtblSectionStudents();
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            int studentId = Integer.parseInt(table.getValueAt(i, 0).toString().trim());
            Student student = new Student();
            student.setStudentId(studentId);
            studentList.add(student);
        }

        Section section = new Section();
        section.setSectionId(sectionId);
        section.setStudents(studentList);

        int choice = JOptionPane.showConfirmDialog(null, "Save?", "Save Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            boolean isSuccessful = sectionDaoImpl.addStudentsToSection(section);
            if (isSuccessful) {
                JOptionPane.showMessageDialog(null, "Successfully assigned students to section!");
            } else {
                JOptionPane.showMessageDialog(null, "Encountered problems while assigning students to section.\n Please contact your support.");
            }
        }
    }

}
