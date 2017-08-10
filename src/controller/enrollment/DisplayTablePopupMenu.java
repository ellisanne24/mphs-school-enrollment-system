/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.enrollment;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import view.student.JdlgStudentInfo;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DisplayTablePopupMenu implements MouseListener{
    private final JTable jtblStudentsList;
    private JPopupMenu jPopupMenu;
    private JMenuItem jmiCopyStudentId;
    private JMenuItem jmiCopyRegistrationId;
    private JMenuItem jmiCopyStudentLastName;
    
    public DisplayTablePopupMenu(JTable jtblStudentsList){
        initComponents();
        this.jtblStudentsList = jtblStudentsList;
    }

    private void initComponents(){
        jPopupMenu = new JPopupMenu();
        jmiCopyStudentId = new JMenuItem("Copy Student Id");
        jmiCopyRegistrationId = new JMenuItem("Copy Registration Id");
        jmiCopyStudentLastName = new JMenuItem("Copy Last Name");
        
        jPopupMenu.add(jmiCopyStudentId);
        jPopupMenu.add(jmiCopyRegistrationId);
        jPopupMenu.add(jmiCopyStudentLastName);
    }
    
    private void initializeControllers(MouseEvent mouseEvent){
        jmiCopyStudentId.addActionListener(new ClickPopupMenuItem(jtblStudentsList, jmiCopyStudentId, jmiCopyRegistrationId, jmiCopyStudentLastName,mouseEvent));
        jmiCopyRegistrationId.addActionListener(new ClickPopupMenuItem(jtblStudentsList, jmiCopyStudentId, jmiCopyRegistrationId, jmiCopyStudentLastName,mouseEvent));
        jmiCopyStudentLastName.addActionListener(new ClickPopupMenuItem(jtblStudentsList, jmiCopyStudentId, jmiCopyRegistrationId, jmiCopyStudentLastName,mouseEvent));
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int rowSelected = jtblStudentsList.getSelectedRow();
        int studentId = Integer.parseInt(jtblStudentsList.getValueAt(rowSelected, 0).toString());
        if (e.getClickCount() == 2) {
            JdlgStudentInfo jdlgStudentInfo = new JdlgStudentInfo(studentId);
            jdlgStudentInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jdlgStudentInfo.setTitle("Student Information");
            jdlgStudentInfo.setLocationRelativeTo(null);
            jdlgStudentInfo.pack();
            jdlgStudentInfo.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        jtblStudentsList.setComponentPopupMenu(jPopupMenu);
        // selects the row at which point the mouse is clicked
        initializeControllers(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}