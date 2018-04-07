package com.guitest2;

import com.connectdb.ConnectDB;
import com.user.UserInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Chan
 * @date 2017/12/23 14:23
 */
public class Login implements ActionListener {
    protected JTextField tf_dbname;
    protected  JTextField tf_id;
    protected  JPasswordField pf_paswd;
    protected JFrame jf;

    /**
     * 程序入口主函数
     */
    public static void main(String[] args) {
        // 实例化一个Qlogin对象
        Login login=new Login();
        // 调用初始化界面方法
        login.initUI();
    }

    /**
     * 初始化界面方法
     */
    public void initUI(){
        jf=new JFrame();
        //设置窗体各项属性
        jf.setTitle("项目管理系统");
        jf.setSize(400,300);
        jf.setLocation(490, 230);
        jf.setDefaultCloseOperation(3);
        jf.setResizable(false);
        setbackground(jf);
        // 添加一个边框布局管理器对象
        jf.setLayout(new BorderLayout());
        jf.add(newNorthPanel(),BorderLayout.NORTH);
        jf.add(newWestPanel(),BorderLayout.WEST);
        jf.add(newSouthPanel(),BorderLayout.SOUTH);
        jf.add(newCenterPanel(),BorderLayout.CENTER);
        // 设置窗体可见
        jf.setVisible(true);
    }

    /**
     * 设置窗体背景
     */
    public void setbackground(JFrame jf)
    {
        ImageIcon image=new ImageIcon("./pic/bg3.jpg");
        JLabel jlb=new JLabel(image);
        //设置标签大小位置
        jlb.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        //得到第二层面板并将标签放在上面
        jf.getLayeredPane().add(jlb,new Integer(Integer.MIN_VALUE));
        JPanel contentPanel=(JPanel)jf.getContentPane();
        //设置透明
        contentPanel.setOpaque(false);
    }

    /**
     * 生成中部面板的方法
     */
    public JPanel newCenterPanel(){
        JPanel centerPanel=new JPanel();
        //centerPanel.setBackground(Color.BLACK);
        //添加一个左对齐的流式布局管理器对象
        centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        tf_dbname=new JTextField();
        tf_dbname.setText("orcl");
        tf_dbname.setPreferredSize(new Dimension(180,25));
        JLabel lab_dbname=new JLabel("服务名");
        centerPanel.add(tf_dbname);
        centerPanel.add(lab_dbname);
        tf_id=new JTextField();
        tf_id.setText("CHAN");
        tf_id.setPreferredSize(new Dimension(180,25));
        centerPanel.add(tf_id);
        JLabel lab_Reg=new JLabel("用户名");
        lab_Reg.setForeground(new Color(27,59,92));
        centerPanel.add(lab_Reg);
        pf_paswd=new JPasswordField();
        pf_paswd.setPreferredSize(new Dimension(180,25));
        centerPanel.add(pf_paswd);
        JLabel laPwd=new JLabel("密码");
        laPwd.setForeground(new Color(27,59,92));
        centerPanel.add(laPwd);
        //设置面板透明色
        centerPanel.setOpaque(false);
        return centerPanel;
    }

    /**
     * 生成北部面板的方法
     */
    public JPanel newNorthPanel(){
        JPanel northPanel=new JPanel();
        //设置北部面板的大小
        northPanel.setPreferredSize(new Dimension(0,100));
        //northPanel.setBackground(Color.BLUE);
        northPanel.setOpaque(false);
        return northPanel;
    }

    /**
     * 生成西部面板的方法
     */
    public JPanel newWestPanel(){
        JPanel westPanel=new JPanel();
        //设置西部面板的大小
        westPanel.setPreferredSize(new Dimension(105,0));
        //westPanel.setBackground(Color.YELLOW);
        westPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //实例化一个ImageIcon类的对象
        ImageIcon image=new ImageIcon("./pic/touxiang2.jpg");
        JLabel jlabelImage=new JLabel(image);
        //设置面板透明色
        westPanel.setOpaque(false);
        //把image加到标签中
        westPanel.add(jlabelImage);
        return westPanel;
    }

    /**
     * 生成南部面板的方法
     */
    public JPanel newSouthPanel(){
        JPanel southPanel=new JPanel();
        //设置南部面板的大小
        southPanel.setPreferredSize(new Dimension(0,50));
        JButton login_bu= new JButton("登             录");
        login_bu.setBackground(new Color(206,219,252));
        login_bu.setPreferredSize(new Dimension(150,30));
        //设置面板透明色
        southPanel.setOpaque(false);
        southPanel.add(login_bu);
        login_bu.addActionListener(this);
        return southPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String dbName=tf_dbname.getText();
        String usr=tf_id.getText();
        String passwd=new String(pf_paswd.getPassword());
        UserInfo user=new UserInfo();
        user.setServer(dbName);
        user.setUsrName(usr);
        user.setPasswd(passwd);
        ConnectDB.init(user);
        if(ConnectDB.getConnection() != null){
            jf.setVisible(false);
            MyWindow win = new MyWindow();
            win.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        } else {
            JOptionPane.showMessageDialog(jf, "无法连接到数据库，请检查输入是否有误", "登录错误", JOptionPane.QUESTION_MESSAGE);
        }
    }
}
