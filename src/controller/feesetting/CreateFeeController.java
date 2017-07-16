/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.feesetting;

import component_model_loader.FeeML;
import component_utility.JPanelUtil;
import daoimpl.FeeDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Fee;
import model.FeeCategory;
import model.SchoolYear;

/**
 *
 * @author John Ferdinand Antonio
 */
public class CreateFeeController implements ActionListener {

    private FeeML feeModelLoader = new FeeML();
    private FeeDaoImpl feeDaoImpl = new FeeDaoImpl();
    private SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
    private JTextField jtfFeeName;
    private JTextArea jtaFeeDescription;
    private JComboBox jcmbFeeCategory;
    private JPanel jpnlGradeLevels;
    private JTextField jtfKinderGartenAmount;
    private JTextField jtfGrade1Amount;
    private JTextField jtfGrade2Amount;
    private JTextField jtfGrade3Amount;
    private JTextField jtfGrade4Amount;
    private JTextField jtfGrade5Amount;
    private JTextField jtfGrade6Amount;
    private JTextField jtfGrade7Amount;
    private JTextField jtfGrade8Amount;
    private JTextField jtfGrade9Amount;
    private JTextField jtfGrade10Amount;
    private JList jlstFeeNamesList;

    public CreateFeeController(JTextField jtfFeeName, JTextArea jtaFeeDescription, JComboBox jcmbFeeCategory,
            JTextField jtfKinderGartenAmount,
            JTextField jtfGrade1Amount, JTextField jtfGrade2Amount, JTextField jtfGrade3Amount,
            JTextField jtfGrade4Amount, JTextField jtfGrade5Amount, JTextField jtfGrade6Amount,
            JTextField jtfGrade7Amount, JTextField jtfGrade8Amount, JTextField jtfGrade9Amount,
            JTextField jtfGrade10Amount, JPanel jpnlGradeLevels, JList jlstFeeNamesList) {

        this.jtfFeeName = jtfFeeName;
        this.jtaFeeDescription = jtaFeeDescription;
        this.jcmbFeeCategory = jcmbFeeCategory;
        this.jtfKinderGartenAmount = jtfKinderGartenAmount;
        this.jtfGrade1Amount = jtfGrade1Amount;
        this.jtfGrade2Amount = jtfGrade2Amount;
        this.jtfGrade3Amount = jtfGrade3Amount;
        this.jtfGrade4Amount = jtfGrade4Amount;
        this.jtfGrade5Amount = jtfGrade5Amount;
        this.jtfGrade6Amount = jtfGrade6Amount;
        this.jtfGrade7Amount = jtfGrade7Amount;
        this.jtfGrade8Amount = jtfGrade8Amount;
        this.jtfGrade9Amount = jtfGrade9Amount;
        this.jtfGrade10Amount = jtfGrade10Amount;
        this.jpnlGradeLevels = jpnlGradeLevels;
        this.jlstFeeNamesList = jlstFeeNamesList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String feeName = jtfFeeName.getText().trim();
        if (feeDaoImpl.exists(feeName)) {
            JOptionPane.showMessageDialog(null, feeName + " already exists. \n Try a different name.");
            jtfFeeName.setText("");
        } else {
            int choice = JOptionPane.showConfirmDialog(null, "Add Fee?");
            if (choice == JOptionPane.YES_OPTION) {
                try {
                    if (addFee()) {
                        JOptionPane.showMessageDialog(null, "Successfully added " + feeName);
                        reloadFeeList();
                        resetCreateForm();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error. Failed to add " + feeName);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(CreateFeeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private boolean addFee() throws ParseException {
        boolean isSuccessful;

        SchoolYear schoolYear = getFeeSchoolYear();
        String feeName = jtfFeeName.getText().trim();
        String feeDescription = jtaFeeDescription.getText().trim();
        FeeCategory feeCategory = getFeeCategory();
        Map<Integer, Double> gradeLevelAmountPair = getGradeLevelAmountPair();

        Fee fee = new Fee();
        fee.setName(feeName);
        fee.setDescription(feeDescription);
        fee.setFeeCategory(feeCategory);
        fee.setGradeLevelAmountPair(gradeLevelAmountPair);
        fee.setSchoolYear(schoolYear);

        isSuccessful = feeDaoImpl.add(fee) == true;
        return isSuccessful;
    }

    private Map<Integer, Double> getGradeLevelAmountPair() throws ParseException {
        Map<Integer, Double> gradeLevelAmountPair = new HashMap<>();
        Integer key = null;
        Double value = null;

        NumberFormat nf = NumberFormat.getInstance();
        Component[] comp = jpnlGradeLevels.getComponents();
        for (Component c : comp) {
            if (c instanceof JCheckBox) {
                if (((JCheckBox) c).isSelected() && !((JCheckBox) c).getText().equals("Kindergarten")) {
                    String glStr = ((JCheckBox) c).getText().replaceAll("[^-?0-9]+", " "); //takes out all numeric from string 
                    String aGradeLevel = glStr.replaceAll("\\s+", ""); // removes all whitespace
                    if (!aGradeLevel.isEmpty()) {
                        int aGradeLevelInt = Integer.parseInt(aGradeLevel);
                        switch (aGradeLevelInt) {
                            
                            case 1:
                                key = 1;
                                value = nf.parse(jtfGrade1Amount.getText().trim()).doubleValue();
                                break;
                            case 2:
                                key = 2;
                                value = nf.parse(jtfGrade2Amount.getText().trim()).doubleValue();
                                break;
                            case 3:
                                key = 3;
                                value = nf.parse(jtfGrade3Amount.getText().trim()).doubleValue();
                                break;
                            case 4:
                                key = 4;
                                value = nf.parse(jtfGrade4Amount.getText().trim()).doubleValue();
                                break;
                            case 5:
                                key = 5;
                                value = nf.parse(jtfGrade5Amount.getText().trim()).doubleValue();
                                break;
                            case 6:
                                key = 6;
                                value = nf.parse(jtfGrade6Amount.getText().trim()).doubleValue();
                                break;
                            case 7:
                                key = 7;
                                value = nf.parse(jtfGrade7Amount.getText().trim()).doubleValue();
                                break;
                            case 8:
                                key = 8;
                                value = nf.parse(jtfGrade8Amount.getText().trim()).doubleValue();
                                break;
                            case 9:
                                key = 9;
                                value = nf.parse(jtfGrade9Amount.getText().trim()).doubleValue();
                                break;
                            case 10:
                                key = 10;
                                value = nf.parse(jtfGrade10Amount.getText().trim()).doubleValue();
                                break;
                        }
                        gradeLevelAmountPair.put(key, value);
                    }
                } else if (((JCheckBox) c).isSelected() && ((JCheckBox) c).getText().equals("Kindergarten")) {
                    key = 0;
                    value = nf.parse(jtfKinderGartenAmount.getText().trim()).doubleValue();
                    gradeLevelAmountPair.put(key, value);
                }
            }
        }

        return gradeLevelAmountPair;
    }

    private FeeCategory getFeeCategory() {
        FeeCategory feeCategory = new FeeCategory();
        String fCat = jcmbFeeCategory.getSelectedItem().toString();
        feeCategory.setCategory(fCat);
        return feeCategory;
    }

    private SchoolYear getFeeSchoolYear() {
        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());
        return schoolYear;
    }
    
    private void reloadFeeList(){
        jlstFeeNamesList.setModel(feeModelLoader.getAllFeeNamesAsModel());
    }
    
    private void resetCreateForm() {
        JPanelUtil.uncheckCheckBoxes(jpnlGradeLevels);
        JPanelUtil.clearJTextFields(jpnlGradeLevels);
        jtfFeeName.setText("");
        jcmbFeeCategory.setSelectedIndex(-1);
        jtaFeeDescription.setText(null);
    }
}
