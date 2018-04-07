package com.guitest2;

import com.projectfunction.ProjectFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ProjectPanel extends JPanel implements ActionListener {

    protected JPanel mainPanel;
    protected JFrame frame;
    protected JButton wnum_btn;
    protected JButton enum_btn;

    ProjectPanel(JFrame F) {
        this.frame=F;
        this.setLayout(new BorderLayout());
        this.mainPanel=new JPanel();
        JPanel panel_btn=new JPanel();
        //添加控件
        this.wnum_btn=new JButton();
        this.enum_btn=new JButton();
        wnum_btn.setText("查询完成情况");
        wnum_btn.addActionListener(this);
        enum_btn.setText("查询设备采购");
        enum_btn.addActionListener(this);
        panel_btn.add(wnum_btn);
        panel_btn.add(enum_btn);

        this.mainPanel.setLayout(new BorderLayout());
        panel_btn.setBorder(BorderFactory.createTitledBorder("查询"));
        this.add(mainPanel,"Center");
        this.add(panel_btn,"South");
        mainPanel.setBorder(BorderFactory.createTitledBorder("结果"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("查询完成情况".equals(e.getActionCommand())){
            mainPanel.removeAll();
            String mName=JOptionPane.showInputDialog(null,"请输入项目经理姓名","查询完成情况",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(mName);
            if(! mName.equals("") && mName != null) {
                Vector<String> result = ProjectFunction.queryComplete(mName);
                //-------------------------------------------------
                Vector<String> colHeader = new Vector<String>();
                colHeader.add("经理姓名");
                colHeader.add("项目名称");
                colHeader.add("签订时间");
                colHeader.add("应完成时间");
                colHeader.add("完成情况");
                Vector<Vector<String>> dataVec = new Vector<Vector<String>>();
                Vector<String> row1 = new Vector<String>();
                row1.add(mName);
                row1.add(result.get(0));
                row1.add(result.get(1));
                row1.add(result.get(2));
                row1.add(result.get(3));
                dataVec.add(row1);
                JTable table = new JTable(dataVec, colHeader);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(table);
                mainPanel.add(scrollPane);
            }
            //----------------------------------------------------
            mainPanel.updateUI();
            mainPanel.repaint();
        }
        else if("查询设备采购".equals(e.getActionCommand())){
            mainPanel.removeAll();
            String pName=JOptionPane.showInputDialog(null,"请输入项目名称","查询设备",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(pName);
            if(! pName.equals("") && pName != null) {
                Vector<String> result = ProjectFunction.getEqubyPro(pName);
                //-------------------------------------------------
                Vector<String> colHeader = new Vector<String>();
                colHeader.add("项目名称");
                colHeader.add("设备名称");
                colHeader.add("费用");
                colHeader.add("供货商");
                Vector<Vector<String>> dataVec = new Vector<Vector<String>>();
                Vector<String> row1 = new Vector<String>();
                row1.add(pName);
                row1.add(result.get(0));
                row1.add(result.get(1));
                row1.add(result.get(2));

                dataVec.add(row1);
                JTable table = new JTable(dataVec, colHeader);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(table);
                mainPanel.add(scrollPane);
            }
            //----------------------------------------------------
            mainPanel.updateUI();
            mainPanel.repaint();
        }
    }
}
