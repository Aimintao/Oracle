package com.guitest2;

import com.projectfunction.ProjectFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class EquPanel extends JPanel implements ActionListener {

    protected JPanel mainPanel;
    protected JFrame frame;
    protected JButton cost_btn;
    protected JButton supplier_btn;
    protected JButton addEqu_btn;
    EquPanel(JFrame F) {
        this.frame=F;
        this.setLayout(new BorderLayout());
        this.mainPanel=new JPanel();
        //JPanel panel_btn1=new JPanel();
        JPanel panel_btn2=new JPanel();
        //添加控件
        this.cost_btn=new JButton();
        cost_btn.setText("设备费用");
        cost_btn.addActionListener(this);
        this.supplier_btn=new JButton();
        supplier_btn.setText("设备供应商");
        supplier_btn.addActionListener(this);
        this.addEqu_btn=new JButton();
        addEqu_btn.setText("添加设备");
        addEqu_btn.addActionListener(this);
        panel_btn2.add(cost_btn);
        panel_btn2.add(supplier_btn);
        panel_btn2.add(addEqu_btn);
        this.mainPanel.setLayout(new BorderLayout());
        //panel_btn1.setBorder(BorderFactory.createTitledBorder("添加"));
        //this.mainPanel.add(panel_btn1,"South");

        panel_btn2.setBorder(BorderFactory.createTitledBorder("查询"));
        this.add(mainPanel,"Center");
        this.add(panel_btn2,"South");
        mainPanel.setBorder(BorderFactory.createTitledBorder("结果"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("设备费用".equals(e.getActionCommand())) {
            mainPanel.removeAll();
            String eName = JOptionPane.showInputDialog(null, "请输入设备名称", "设备费用", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(eName);
            if(! eName.equals("") && eName != null) {
                float fee = ProjectFunction.getEquFee(eName);
                //-------------------------------------------------
                Vector<String> colHeader = new Vector<String>();
                colHeader.add("设备名称");
                colHeader.add("费用");
                Vector<Vector<String>> dataVec = new Vector<Vector<String>>();
                Vector<String> row1 = new Vector<String>();
                row1.add(eName);
                row1.add(String.valueOf(fee));
                dataVec.add(row1);
                JTable table = new JTable(dataVec, colHeader);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(table);
                mainPanel.add(scrollPane);
                //----------------------------------------------------
            }
                mainPanel.updateUI();
                mainPanel.repaint();

        }
        else if("设备供应商".equals(e.getActionCommand())) {
            mainPanel.removeAll();
            String eName = JOptionPane.showInputDialog(null, "请输入设备名称", "供应商", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(eName);
            if(! eName.equals("") && eName != null) {
                String supplier = ProjectFunction.getEquSup(eName);
                //-------------------------------------------------
                Vector<String> colHeader = new Vector<String>();
                colHeader.add("设备名称");
                colHeader.add("供应商");
                Vector<Vector<String>> dataVec = new Vector<Vector<String>>();
                Vector<String> row1 = new Vector<String>();
                row1.add(eName);
                row1.add(supplier);
                dataVec.add(row1);
                JTable table = new JTable(dataVec, colHeader);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(table);
                mainPanel.add(scrollPane);
                //----------------------------------------------------
            }
                mainPanel.updateUI();
                mainPanel.repaint();
        }
        else if("添加设备".equals(e.getActionCommand())){
            mainPanel.removeAll();
            JPanel addEquPanel=new JPanel();
            addEquPanel.setBorder(BorderFactory.createTitledBorder("输入条件"));
            //-----------------------------------------------
            JLabel lab_eid=new JLabel("设备编号");
            JLabel lab_ename=new JLabel("设备名称");
            JLabel lab_fee=new JLabel("费用");
            JLabel lab_supplier=new JLabel("供应商");
            JLabel lab_remarks=new JLabel("备注");
            JLabel lab_pid=new JLabel("项目编号");
            JTextField tf_eid=new JTextField();
            tf_eid.setColumns(12);
            JTextField tf_ename=new JTextField();
            tf_ename.setColumns(12);
            JTextField tf_fee=new JTextField();
            tf_fee.setColumns(12);
            JTextField tf_sup=new JTextField();
            tf_sup.setColumns(12);
            JTextField tf_remarks=new JTextField();
            tf_remarks.setColumns(12);
            String[] pidSelect={"001","002","003","004"};
            JComboBox cb_pid=new JComboBox(pidSelect);
            JButton add_btn=new JButton("确定");

            addEquPanel.add(lab_eid);
            addEquPanel.add(tf_eid);
            addEquPanel.add(lab_ename);
            addEquPanel.add(tf_ename);
            addEquPanel.add(lab_fee);
            addEquPanel.add(tf_fee);
            addEquPanel.add(lab_supplier);
            addEquPanel.add(tf_sup);
            addEquPanel.add(lab_remarks);
            addEquPanel.add(tf_remarks);
            addEquPanel.add(lab_pid);
            addEquPanel.add(cb_pid);
            addEquPanel.add(add_btn);
            add_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String eId=tf_eid.getText();
                    String eName=tf_ename.getText();
                    System.out.println(eName+"--------");
                    Float eFee=Float.valueOf(tf_fee.getText());
                    String supplier=tf_sup.getText();
                    String remarks=tf_remarks.getText();
                    String pId=cb_pid.getSelectedItem().toString();
                    if(eId !=null && eName != null && eFee != null && supplier != null && pId != null)
                        ProjectFunction.addEqu(eId,eName,eFee,supplier,remarks,pId);
                }
            });


            addEquPanel.setLayout(new FlowLayout(FlowLayout.LEADING,30,10));
            addEquPanel.setVisible(true);
            mainPanel.add(addEquPanel);
            mainPanel.updateUI();
            mainPanel.repaint();
        }

    }
}
