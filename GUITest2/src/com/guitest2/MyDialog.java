package com.guitest2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import com.eltima.components.ui.DatePicker;
import com.projectfunction.ProjectFunction;

public class MyDialog extends JDialog implements ActionListener {
    protected JButton but_apply;
    protected JButton but_cancel;
    protected JPanel info_panel;
    protected JLabel lab_wid;
    protected JLabel lab_wname;
    protected JLabel lab_did;
    protected JLabel lab_sex;
    protected JLabel lab_dname;
    protected JLabel lab_age;
    protected JLabel lab_date;
    protected JLabel lab_dpost;
    protected JTextField tf_wid;
    protected JTextField tf_wname;
    protected JComboBox tf_sex;
    protected JComboBox tf_dname;
    protected JComboBox tf_age;
    protected JComboBox tf_did;
    protected JTextField tf_date;
    protected JComboBox tf_dpost;
    protected DatePicker datepick;
    protected String command;
    //protected JButton btn_date;

    protected Container contentPane = this.getContentPane();

    MyDialog(JFrame f, String s) {
        super(f, s);
        this.command=s;
        this.contentPane.setLayout(new BorderLayout());
        this.setModal(true);
        this.setResizable(false);
        this.but_apply = new JButton("确认");
        this.but_apply.addActionListener(this);
        this.but_cancel = new JButton("取消");
        this.but_cancel.addActionListener(this);
        this.lab_wid=new JLabel("编号");
        this.lab_wname=new JLabel("姓名");
        this.lab_age=new JLabel("年龄");
        this.lab_sex=new JLabel("性别");
        this.lab_did=new JLabel("部门编号");
        this.lab_dname=new JLabel("部门名称");
        this.lab_date=new JLabel("合同日期");
        this.lab_dpost=new JLabel("职务");
        String[] sex={"男","女"},d_id={"11","12","13","14"},dname={"采购部","销售部","策划部","人事部"},dpost={"职员","部门经理","经理"};
        String[] age=new String[40];
        int index=0;
        for(int i=21;i<=60;i++)
        {
            age[index]=i+"";
            index++;
        }
        //日期控件
        this.datepick = getDatePicker();

        this.tf_wid=new JTextField();
        tf_wid.setColumns(10);
        if("修改".equals(s)){
            tf_wid.setText("必须存在");
        }
        this.tf_wname=new JTextField();
        tf_wname.setColumns(10);
        this.tf_sex=new JComboBox(sex);
        this.tf_age=new JComboBox(age);
        this.tf_did=new JComboBox(d_id);
        this.tf_dname=new JComboBox(dname);
        this.tf_date=new JTextField();
        tf_date.setColumns(10);
        this.tf_dpost=new JComboBox(dpost);
        JPanel but_panel = new JPanel();
        but_panel.add(this.but_apply);
        but_panel.add(this.but_cancel);
        this.info_panel = new JPanel();
        info_panel.setLayout(new FlowLayout(FlowLayout.LEADING,30,10));
        info_panel.add(lab_wid);
        info_panel.add(tf_wid);
        info_panel.add(lab_wname);
        info_panel.add(tf_wname);
        info_panel.add(lab_sex);
        info_panel.add(tf_sex);
        info_panel.add(lab_age);
        info_panel.add(tf_age);
        info_panel.add(lab_dpost);
        info_panel.add(tf_dpost);
        info_panel.add(lab_date);
        info_panel.add(datepick);
        info_panel.add(lab_did);
        info_panel.add(tf_did);
        //获取控件上时间的方法 datepick.getValue()

        this.info_panel.setBorder(BorderFactory.createTitledBorder(s+"信息"));
        contentPane.add(this.info_panel,"Center");
        contentPane.add(but_panel,"South");

    }

    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        Dimension dimension = new Dimension(177, 24);
        int[] hilightDays = { 1, 3, 5, 7 };
        int[] disabledDays = { 4, 6, 5, 9 };
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
        datepick.setLocation(137, 83);
        datepick.setBounds(137, 83, 177, 24);
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("取消".equals(e.getActionCommand())){
            this.dispose();
        }
        else{
            if("添加".equals(this.command)) {
                String wId = this.tf_wid.getText(),
                        wName = this.tf_wname.getText(),
                        sex = this.tf_sex.getSelectedItem().toString(),
                        age = this.tf_age.getSelectedItem().toString(),
                        dName = this.tf_dname.getSelectedItem().toString(),
                        dId = this.tf_did.getSelectedItem().toString(),
                        post = this.tf_dpost.getSelectedItem().toString(),
                        date = this.datepick.getText();
                System.out.println("获得控件时间" + this.datepick.getText());
                //java.sql.Date date2=java.sql.Date.valueOf(date);
                System.out.println("添加" + wId + dId + wName + sex + age + date + dName + post);
                System.out.println(dId.length());
                boolean flage=ProjectFunction.addWorker(wId, dId, wName, sex, age, date, dName, post);
                if(flage){
                    JOptionPane.showMessageDialog(null, "添加成功!", "提示", JOptionPane.QUESTION_MESSAGE);
                    this.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "添加失败!", "提示", JOptionPane.QUESTION_MESSAGE);
                }
            }else {
                String wId = this.tf_wid.getText(),
                        wName = this.tf_wname.getText(),
                        sex = this.tf_sex.getSelectedItem().toString(),
                        age = this.tf_age.getSelectedItem().toString(),
                        dName = this.tf_dname.getSelectedItem().toString(),
                        dId = this.tf_did.getSelectedItem().toString(),
                        post = this.tf_dpost.getSelectedItem().toString(),
                        date = this.datepick.getText();
                boolean flage=ProjectFunction.updateWorker(wId, dId, wName, sex, age, date, dName, post);
                if(flage){
                    JOptionPane.showMessageDialog(null, "修改成功!", "提示", JOptionPane.QUESTION_MESSAGE);
                    this.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "修改失败!", "提示", JOptionPane.QUESTION_MESSAGE);
                }
            }
        }
    }
}
