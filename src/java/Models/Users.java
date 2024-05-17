/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.*;

/**
 *
 * @author hi2ot
 */
public class Users {
    private String userName;
    private String pass;
    private Date DoB;
    private int role;
    private String Mail;
    private int SQ_Id;
    private String SAnswer;
    private float Wallet;

    @Override
    public String toString() {
        return "Users{" + "userName=" + userName + ", pass=" + pass + ", DoB=" + DoB + ", role=" + role + ", Mail=" + Mail + ", SQ_Id=" + SQ_Id + ", SAnswer=" + SAnswer + ", Wallet=" + Wallet + '}';
    }

    public Users() {
    }

    public Users(String userName, String pass, Date DoB, int role, String Mail, int SQ_Id, String SAnswer, float Wallet) {
        this.userName = userName;
        this.pass = pass;
        this.DoB = DoB;
        this.role = role;
        this.Mail = Mail;
        this.SQ_Id = SQ_Id;
        this.SAnswer = SAnswer;
        this.Wallet = Wallet;
    }  

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date DoB) {
        this.DoB = DoB;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public int getSQ_Id() {
        return SQ_Id;
    }

    public void setSQ_Id(int SQ_Id) {
        this.SQ_Id = SQ_Id;
    }

    public String getSAnswer() {
        return SAnswer;
    }

    public void setSAnswer(String SAnswer) {
        this.SAnswer = SAnswer;
    }

    public float getWallet() {
        return Wallet;
    }

    public void setWallet(float Wallet) {
        this.Wallet = Wallet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
