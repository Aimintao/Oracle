package com.guitest2;

import com.projectfunction.ProjectFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class DepartPanel extends JPanel implements ActionListener {

    protected JPanel mainPanel;
    protected JFrame frame;
    protected JButton maName_btn;
    protected JButton dNum_btn;
    DepartPanel(JFrame F) {
        this.frame=F;
        this.setLayout(new BorderLayout());
        this.mainPanel=new JPanel();
        JPanel panel_btn=new JPanel();

        this.maName_btn=new JButton();
        this.dNum_btn=new JButton();
        maName_btn.setText("查询部门经理信息");
        maName_btn.addActionListener(this);
        dNum_btn.setText("查询部门人数");
        dNum_btn.addActionListener(this);
        panel_btn.add(maName_btn);
        panel_btn.add(dNum_btn);
        this.mainPanel.setLayout(new BorderLayout());
        panel_btn.setBorder(BorderFactory.createTitledBorder("查询"));
        this.add(mainPanel,"Center");
        this.add(panel_btn,"South");
        mainPanel.setBorder(BorderFactory.createTitledBorder("结果"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if("查询部门人数".equals(e.getActionCommand())){

        }
        else if("查询部门经理信息".equals(e.getActionCommand())){
            mainPanel.removeAll();
            String dName = JOptionPane.showInputDialog(null, "请输入部门名称", "查询部门经理", JOptionPane.INFORMATION_MESSAGE);
            if(! dName.equals("") && dName != null) {
                Vector<String> result = ProjectFunction.queryManager(dName);
                Vector<String> colHeader = new Vector<String>();
                colHeader.add("编号");
                colHeader.add("姓名");
                colHeader.add("年龄");
                colHeader.add("性别");
                colHeader.add("合同日期");
                colHeader.add("职务");
                colHeader.add("部门");
                Vector<Vector<String>> dataVec = new Vector<Vector<String>>();
                Vector<String> row1 = new Vector<String>();
                row1.add(result.get(0));
                row1.add(result.get(1));
                row1.add(result.get(2));
                row1.add(result.get(3));
                row1.add(result.get(4));
                row1.add(result.get(5));
                row1.add(dName);
                dataVec.add(row1);
                JTable table = new JTable(dataVec, colHeader);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(table);
                mainPanel.add(scrollPane);
            }
            mainPanel.updateUI();
            mainPanel.repaint();
        }
    }
}
