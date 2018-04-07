package com.guitest2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyWindow extends JFrame implements ActionListener {
    private JTabbedPane tabPane;

    MyWindow() {
        super("项目管理系统");
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((width-800)/2, (height-500)/2, 800, 500);
        this.tabPane = new JTabbedPane();
        this.tabPane.setTabPlacement(1);
        this.add(this.tabPane);
        WorkerPanel drugPanel = new WorkerPanel(this);
        this.tabPane.addTab("员工", createImageIcon("workers"), drugPanel);
        DepartPanel hospitalPanel = new DepartPanel(this);
        this.tabPane.addTab("部门", createImageIcon("department"), hospitalPanel);
        ProjectPanel supplerPanel = new ProjectPanel(this);
        this.tabPane.addTab("项目", createImageIcon("project"), supplerPanel);
        EquPanel purchasePanel = new EquPanel(this);
        this.tabPane.addTab("设备", createImageIcon("equipment"), purchasePanel);
        JPanel salePanel = new JPanel();

        HelpPanel helpPanel = new HelpPanel(this);
        this.tabPane.addTab("帮助", createImageIcon("help"), helpPanel);

        this.setVisible(true);
        this.validate();
    }

    protected static ImageIcon createImageIcon(String name) {
        String path = "./pic/" + name + ".png";
        return new ImageIcon(path);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
}
