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
public class Items {
    private int Id;
    private String Name;
    private float Price;
    private String img;
    private Date ReleaseDate;
    private int SaleNum;
    private int Grading;

    public Items(int Id, String Name, float Price, String img, Date ReleaseDate) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.img = img;
        this.ReleaseDate = ReleaseDate;
    }    
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "Items{" + "Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", img=" + img + ", ReleaseDate=" + ReleaseDate + ", SaleNum=" + SaleNum + ", Grading=" + Grading + '}';
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(Date ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    public int getSaleNum() {
        return SaleNum;
    }

    public void setSaleNum(int SaleNum) {
        this.SaleNum = SaleNum;
    }

    public int getGrading() {
        return Grading;
    }

    public void setGrading(int Grading) {
        this.Grading = Grading;
    }

    public Items(int Id, String Name, float Price, String img, Date ReleaseDate, int SaleNum, int Grading) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.img = img;
        this.ReleaseDate = ReleaseDate;
        this.SaleNum = SaleNum;
        this.Grading = Grading;
    }
}


