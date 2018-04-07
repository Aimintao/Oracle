package com.user;

/**
 * @author Chan
 * @date 2017/12/23 14:16
 */
public class UserInfo {
    private String usrName;
    private String passwd;
    private String server;

    public void setServer(String server){
        this.server=server;
    }
    public void setUsrName(String usrName){
        this.usrName=usrName;
    }
    public void setPasswd(String passwd){
        this.passwd=passwd;
    }

    public String getServer() {
        return server;
    }
    public String getUsrName() {
        return usrName;
    }
    public String getPasswd() {
        return passwd;
    }
}
