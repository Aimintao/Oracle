package com.guitest2;

import com.projectfunction.ProjectFunction;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class WorkerPanel extends JPanel implements ActionListener{
    protected JButton but_new;
    protected JButton but_edit;
    protected JButton but_delete;
    protected JButton but_query;
    protected JButton but_clean;
    protected JButton but_show;
    protected JButton but_close;
    protected JLabel lab_id;
    protected JLabel lab_name;
    protected JLabel lab_dp;
    protected JLabel lab_sex;
    protected JTextField tf_id;
    protected JTextField tf_name;
    protected JComboBox tf_sex;
    protected JComboBox tf_dp;
    protected JFrame frame;
    protected JPanel mainPanel;
    protected JPanel panel_queryInput;
    protected JPanel panel_but1;
    WorkerPanel(JFrame F) {
        this.frame = F;
        this.setLayout(new BorderLayout());
        panel_but1=new JPanel();
        //JPanel panel_but1 = new JPanel();
        JPanel panel_but2 = new JPanel();
        JPanel panel_query = new JPanel();
        panel_query.setLayout(new BorderLayout());
        this.mainPanel = new JPanel();
        this.panel_queryInput = new JPanel();
        this.but_show = new JButton("打开表格");
        this.but_show.addActionListener(this);
        this.but_close = new JButton("关闭表格");
        this.but_close.addActionListener(this);
        this.but_new = new JButton("添加信息");
        this.but_new.addActionListener(this);
        this.but_edit = new JButton("修改信息");
        this.but_edit.setToolTipText("先选择一条记录");
        this.but_edit.addActionListener(this);
        this.but_delete = new JButton("删除信息");
        this.but_delete.setToolTipText("先选择一条记录");
        this.but_delete.addActionListener(this);

        this.but_query = new JButton("查询");
        this.but_query.addActionListener(this);
        this.but_clean = new JButton("清空");
        this.but_clean.addActionListener(this);

        this.lab_id=new JLabel("编号");
        this.lab_name=new JLabel("姓名");
        this.lab_sex=new JLabel("性别");
        this.lab_dp=new JLabel("部门");
        this.tf_id=new JTextField(20);
        this.tf_name=new JTextField(20);
        String[] sex={"","男","女"},dName={"","采购部","销售部","策划部","人事部"};
        this.tf_sex=new JComboBox(sex);
        this.tf_dp=new JComboBox(dName);
        panel_but1.add(this.but_show);
        panel_but1.add(this.but_close);
        panel_but1.add(this.but_new);
        panel_but1.add(this.but_edit);
        panel_but1.add(this.but_delete);
        panel_but2.add(this.but_query);
        panel_but2.add(this.but_clean);
        GridBagLayout glayout = new GridBagLayout();
        panel_queryInput.setLayout(glayout);

        panel_queryInput.add(lab_id);
        panel_queryInput.add(tf_id);
        panel_queryInput.add(lab_name);
        panel_queryInput.add(tf_name);
        panel_queryInput.add(lab_sex);
        panel_queryInput.add(tf_sex);
        panel_queryInput.add(lab_dp);
        panel_queryInput.add(tf_dp);
        //定义一个GridBagConstraints，
        //是用来控制添加进的组件的显示位置
        GridBagConstraints s= new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;
        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        glayout.setConstraints(lab_id,s);
        s.gridwidth=4;
        s.weightx = 1;
        s.weighty=0;
        glayout.setConstraints(tf_id,s);
        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        glayout.setConstraints(lab_name,s);
        s.gridwidth=0;
        s.weightx = 1;
        s.weighty=0;
        glayout.setConstraints(tf_name,s);
        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        glayout.setConstraints(lab_sex,s);
        s.gridwidth=4;
        s.weightx = 1;
        s.weighty=0;
        glayout.setConstraints(tf_sex,s);
        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        glayout.setConstraints(lab_dp,s);
        s.gridwidth=0;
        s.weightx = 1;
        s.weighty=0;
        glayout.setConstraints(tf_dp,s);
        this.mainPanel.setLayout(new BorderLayout());
        panel_but1.setBorder(BorderFactory.createTitledBorder("操作"));
        this.mainPanel.add(panel_but1, "South");
        panel_query.setBorder(BorderFactory.createTitledBorder("查询"));
        panel_query.add(this.panel_queryInput, "Center");
        panel_query.add(panel_but2, "South");
        this.add(this.mainPanel, "Center");
        this.add(panel_query, "South");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("添加信息".equals(e.getActionCommand())) {
            MyDialog md=new MyDialog(this.frame,"添加");
            md.setSize(800,300);
            md.setLocationRelativeTo(this);
            md.setVisible(true);

        }
        else if("修改信息".equals(e.getActionCommand())){
            MyDialog md=new MyDialog(this.frame,"修改");
            md.setSize(800,300);
            md.setLocationRelativeTo(this);
            md.setVisible(true);
        }
        else if("删除信息".equals(e.getActionCommand())){
            mainPanel.removeAll();
            mainPanel.add(panel_but1,"South");
            JPanel deletePanel=new JPanel();
            deletePanel.setLayout(new FlowLayout(FlowLayout.LEADING,30,10));
            JLabel lab_deid=new JLabel("员工编号");
            JTextField tf_deid=new JTextField(20);
            JButton btn_de=new JButton();
            btn_de.setText("删除");
            btn_de.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   int respon=JOptionPane.showConfirmDialog(null, "确认删除员工 "+tf_deid.getText()+" 吗？","提示",JOptionPane.YES_NO_OPTION);
                   if(respon==0){
                       ProjectFunction.deleteWorker(tf_deid.getText());
                       System.out.println("执行");
                   }
                   else {
                       System.out.println("未执行");
                   }
                }
            });
            deletePanel.add(lab_deid);
            deletePanel.add(tf_deid);
            deletePanel.add(btn_de);
            deletePanel.setBorder(BorderFactory.createTitledBorder("删除"));
            this.mainPanel.add(deletePanel,"Center");
            this.mainPanel.updateUI();
            mainPanel.repaint();
        }
        else if("查询".equals(e.getActionCommand())){
            mainPanel.removeAll();
            mainPanel.add(panel_but1,"South");
            System.out.println("查询");
            JPanel resultPanel=new JPanel();
            resultPanel.setBorder(BorderFactory.createTitledBorder("结果"));
            String w_id=tf_id.getText();
            String w_name=tf_name.getText();
            String sex=tf_sex.getSelectedItem().toString();
            String department=tf_dp.getSelectedItem().toString();
            String []input=new String[4];
            input[0]=w_id;
            input[1]=w_name;
            input[2]=sex;
            input[3]=department;
            String sql="select * from \"worker\" where ";
            for(int i=0;i<4;i++){
                if(! input[i].equals(""))
                {
                    if(i==0)
                        sql+="\"w_id\"="+"\'"+input[i]+"\'"+" and ";
                    else if (i==1) {
                        sql+="\"w_name\"="+"\'"+input[i]+"\'"+" and ";
                    }
                    else if (i==2) {
                        sql+="\"sex\"="+"\'"+input[i]+"\'"+" and ";
                    }
                    else if (i==3) {
                        sql+="\"d_name\"="+"\'"+input[i]+"\'"+" and ";
                    }
                }
            }
            sql=sql.substring(0, sql.length()-5);
            System.out.println(sql);
            Vector<Vector<String>> list=new Vector<Vector<String>>();
            if(sql.length()>24){
                list=ProjectFunction.queryWorker(sql);
                System.out.println("条件查询");
            }
            else {
                String sql2="select * from \"worker\"";
                list=ProjectFunction.queryWorker(sql2);
            }

            //-------------------------------------------------
            Vector<String> colHeader = new Vector<String>();
            colHeader.add("编号");
            colHeader.add("姓名");
            colHeader.add("性别");
            colHeader.add("部门");
            colHeader.add("职务");
            colHeader.add("合同日期");
            Vector<Vector<String>> dataVec = new Vector<Vector<String>>();
            for(int i=0;i<list.size();i++){
                Vector<String> row = new Vector<String>();
                for(int j=0;j<list.get(0).size();j++){
                    row.add(list.get(i).get(j));
                }
                dataVec.add(row);
            }
            JTable table = new JTable(dataVec, colHeader);
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportView(table);
            //resultPanel.add(scrollPane);
            //----------------------------------------------------
            mainPanel.add(scrollPane,"Center");
            mainPanel.updateUI();
            mainPanel.repaint();
        }
        else if("清空".equals(e.getActionCommand())){
            System.out.println("清空");
            tf_id.setText("");
            tf_name.setText("");
            tf_sex.setSelectedIndex(0);
            tf_dp.setSelectedIndex(0);
        }
        else if("打开表格".equals(e.getActionCommand())){
            mainPanel.removeAll();
            mainPanel.add(panel_but1,"South");
            Vector<Vector<String>> list=ProjectFunction.getWorkerList();
            //-------------------------------------------------
            Vector<String> colHeader = new Vector<String>();
            colHeader.add("编号");
            colHeader.add("姓名");
            colHeader.add("性别");
            colHeader.add("职务");
            colHeader.add("合同日期");
            colHeader.add("部门编号");
            Vector<Vector<String>> dataVec = new Vector<Vector<String>>();
            for(int i=0;i<list.size();i++){
                Vector<String> row = new Vector<String>();
                for(int j=0;j<list.get(0).size();j++){
                   row.add(list.get(i).get(j));
                }
                dataVec.add(row);
            }
            JTable table = new JTable(dataVec, colHeader);
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportView(table);
            mainPanel.add(scrollPane);
            //----------------------------------------------------
            mainPanel.updateUI();
            mainPanel.repaint();
        }
        else if("关闭表格".equals(e.getActionCommand())){
            mainPanel.removeAll();
            mainPanel.add(panel_but1,"South");
            mainPanel.updateUI();
            mainPanel.repaint();
        }
    }
}
