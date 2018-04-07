package com.projectfunction;

import com.connectdb.ConnectDB;
import oracle.jdbc.OracleTypes;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.Date;

public class ProjectFunction {
    /**
     * 添加员工信息
     * @param
     */
    public static boolean addWorker(String wId,String dId,String wName,String sex,String age,String date,String dName,String post){
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        System.out.println(wId+dId+wName+sex+age+date+dName+post);
        try {
            CallableStatement c = conn.prepareCall("{call p_addworker(?,?,?,?,?,?,?)}");
            c.setString(1,wId);
            c.setString(2,wName);
            c.setString(3,sex);
            c.setString(4,age);
            System.out.println("传入的时间是 "+date);
            c.setString(5,date);
            c.setString(6,post);
            c.setString(7,dId);
            //c.setDate(6,Date.valueOf(date));
            //执行Oracle存储过程
            c.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
        return true;
    }

    /**
     * 删除员工信息
     * @param
     */
    public static void deleteWorker(String wId){
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement c = conn.prepareCall("{call p_delworker(?)}");
            c.setString(1,wId);
            //执行Oracle存储过程
            c.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
    }

    /**
     * 查询员工信息
     * @param
     */
    public static Vector<Vector<String>> queryWorker(String sql){
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        ResultSet rs=null;
        Vector<Vector<String>> list=new Vector<Vector<String>>();
        int i=0;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("执行查询");
            // 判断结果集是否有效
            while(rs.next()){
                // 数据库存在，返回结果集
                System.out.println(rs.getString("w_id"));
                System.out.println(rs.getString("w_name"));
                System.out.println(rs.getString("sex"));
                System.out.println(rs.getString("post"));
                Vector<String> result=new Vector<String>();
                result.add(rs.getString("w_id"));
                result.add(rs.getString("w_name"));
                result.add(rs.getString("sex"));
                result.add(rs.getString("d_name"));
                result.add(rs.getString("post"));
                result.add(rs.getDate("contract_date").toString());
                list.add(i,result);
                i++;
            }
            // 释放此 ResultSet 对象的数据库和 JDBC 资源
            rs.close();
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
        return list;
    }

    /**
     * 修改员工信息
     * @param
     */
    public static boolean updateWorker(String wId,String dId,String wName,String sex,String age,String date,String dName,String post){
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        System.out.println(wId+dId+wName+sex+age+date+dName+post);
        try {
            CallableStatement c = conn.prepareCall("{call p_updateworker(?,?,?,?,?,?,?)}");
            c.setString(1,wId);
            c.setString(2,wName);
            c.setString(3,sex);
            c.setString(4,age);
            System.out.println("传入的时间是 "+date);
            c.setString(5,date);
            c.setString(6,post);
            c.setString(7,dId);
            //c.setDate(6,Date.valueOf(date));
            //执行Oracle存储过程
            c.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
        return true;
    }

    /**
     * 获取员工列表
     * @param
     */
    public static Vector<Vector<String>> getWorkerList(){
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        ResultSet rs=null;
        Vector<Vector<String>> list=new Vector<Vector<String>>();
        int i=0;
        try {
            Statement st = conn.createStatement();
            String sql="SELECT * FROM \"worker\"";
            rs = st.executeQuery(sql);
            // 判断结果集是否有效
            while(rs.next()){
                // 数据库存在，返回结果集
                Vector<String> result=new Vector<String>();
                result.add(rs.getString("w_id"));
                result.add(rs.getString("w_name"));
                result.add(rs.getString("sex"));
                result.add(rs.getString("post"));
                result.add(rs.getDate("contract_date").toString());
                result.add(rs.getString("d_id"));
                list.add(i,result);
                i++;
            }
            System.out.println("长度  "+list.size());
            rs.close();
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
        return list;
    }

    /**
     * 查询部门经理
     * @param
     */
    public static Vector<String> queryManager(String dName){
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        String wId="",wName="",sex="",age="",post="",contractTime="";
        Vector<String> list=new Vector<String>();
        try {
            CallableStatement c = conn.prepareCall("{call P_FDMANAGER(?,?,?,?,?,?,?)}");
            c.setString(1,dName);
            c.registerOutParameter(2, OracleTypes.VARCHAR);
            c.registerOutParameter(3,OracleTypes.VARCHAR);
            c.registerOutParameter(4,OracleTypes.CHAR);
            c.registerOutParameter(5,OracleTypes.CHAR);
            c.registerOutParameter(6,OracleTypes.DATE);
            c.registerOutParameter(7,OracleTypes.VARCHAR);
            //执行Oracle存储过程
            c.execute();
            wId=c.getString(2);
            wName=c.getString(3);
            sex=c.getString(4);
            age=c.getString(5);
            contractTime=c.getDate(6).toString();
            post=c.getString(7);
            System.out.println("执行查询");
            list.add(wId);
            list.add(wName);
            list.add(sex);
            list.add(age);
            list.add(contractTime);
            list.add(post);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
        return list;
    }

    /**
     * 查询项目设备采购信息
     * @param
     */
    public static Vector<String> getEqubyPro(String pName){
        Vector<String> result=new Vector<String>();
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        String eNmae="",eSupplier="";
        float eFee;
        try {
            CallableStatement c = conn.prepareCall("{call P_GETEBYP(?,?,?,?)}");
            c.setString(1,pName);
            c.registerOutParameter(2, OracleTypes.VARCHAR);
            c.registerOutParameter(3,OracleTypes.FLOAT);
            c.registerOutParameter(4,OracleTypes.VARCHAR);
            //执行Oracle存储过程
            c.execute();
            eNmae=c.getString(2);
            eFee=c.getFloat(3);
            eSupplier=c.getString(4);
            result.add(eNmae);
            result.add(String.valueOf(eFee));
            result.add(eSupplier);
            System.out.println("查询设备  "+eNmae+eFee+eSupplier);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
        return result;
    }

    /**
     * 查询设备采购费用信息
     * @param
     */
    public static float getEquFee(String eName){
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        float eFee=0;
        try {
            CallableStatement c = conn.prepareCall("{call P_GETEFEE(?,?)}");
            c.setString(1,eName);
            c.registerOutParameter(2,OracleTypes.FLOAT);
            //执行Oracle存储过程
            c.execute();
            eFee=c.getFloat(2);
            System.out.println("查询设备  "+eName+eFee+"----");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
        return eFee;
    }

    /**
     * 添加设备
     * @param
     */
    public static void addEqu(String eId,String eName,float fee,String supplier,String remarks,String pId){
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        System.out.println(eId+eName+fee+supplier+remarks+pId);
        try {
            CallableStatement c = conn.prepareCall("{call p_addequ(?,?,?,?,?,?)}");
            c.setString(1,eId);
            c.setString(2,eName);
            c.setFloat(3,fee);
            c.setString(4,supplier);
            c.setString(5,pId);
            c.setString(6,remarks);
            //执行Oracle存储过程
            c.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
    }

    /**
     * 查询设备供应商信息
     * @param
     */
    public static String getEquSup(String eName){
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        String eSupplier="";
        try {
            CallableStatement c = conn.prepareCall("{call P_GETESUP(?,?)}");
            c.setString(1,eName);
            c.registerOutParameter(2,OracleTypes.VARCHAR);
            //执行Oracle存储过程
            c.execute();
            eSupplier=c.getString(2);
            System.out.println("查询设备  "+eName+eSupplier);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
        return eSupplier;
    }

    /**
     * 查询项目员工信息
     * @param
     */
    public static void getWerbyPro(String pName){
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
        String wNmae="",wId="";
        float eFee;
        try {
            CallableStatement c = conn.prepareCall("{call P_GETEBYP(?,?,?,?)}");
            c.setString(1,pName);
            c.registerOutParameter(2, OracleTypes.VARCHAR);
            c.registerOutParameter(3,OracleTypes.FLOAT);
            c.registerOutParameter(4,OracleTypes.VARCHAR);
            //执行Oracle存储过程
            c.execute();
            wNmae=c.getString(2);
            wId=c.getString(4);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
    }

    /**
     * 查询项目完成情况
     * @param
     */
    public static Vector<String> queryComplete(String ManagerName){
        Vector<String> result=new Vector<String>();
        // 获取数据库连接Connection对象
        Connection conn = ConnectDB.getConnection();
       String date1="",date2="",pName="",isComplete="";
        try {
            CallableStatement c = conn.prepareCall("{call P_ISFINISHED(?,?,?,?)}");
            c.setString(1,ManagerName);
            c.registerOutParameter(2, OracleTypes.DATE);
            c.registerOutParameter(3, OracleTypes.DATE);
            c.registerOutParameter(4, OracleTypes.VARCHAR);
            //执行Oracle存储过程
            c.execute();
            date1=c.getString(2).toString();
            date2=c.getString(3).toString();
            pName=c.getString(4);
            System.out.println("签订时间是："+date2);
            System.out.println("应完成时间是："+date1);
            //pName=c.getString(4);
            Date date;
            date=c.getDate(2);
            System.out.println("应完成时间是  "+date1);
            System.out.println("时间格式        "+date);
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            String hehe = dateFormat.format( now );
            System.out.println(hehe);
            if(date1.compareTo(hehe)<0){
                isComplete="已完成";
                System.out.println("已经完成");
            } else {
                isComplete="未完成";
            }
            result.add(pName);
            result.add(date2);
            result.add(date1);
            result.add(isComplete);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
        return result;
    }
}
