/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author hi2ot
 */
import Models.*;
import java.util.*;
import java.sql.*;

public class DAO {

    private Connection con;
    private List<Items> li;
    private List<Users> ul;
    private List<Category> cl;
    private List<SQuestion> sl;
    private String status = "OK";
    public static DAO INS = new DAO();

    private DAO() {
        if (INS == null) {
            try {
                con = new DBContext().connection;
            } catch (Exception e) {
                status = "Error at Connection" + e.getMessage();
            }
        } else {
            INS = this;
        }
    }

    public List<Users> getUl() {
        return ul;
    }

    public void setUl(List<Users> ul) {
        this.ul = ul;
    }

    public List<Items> getli() {
        return li;
    }

    public void setli(List<Items> li) {
        this.li = li;
    }

    public String getStatus() {
        return status;
    }

    public List<Items> getLi() {
        return li;
    }

    public void setLi(List<Items> li) {
        this.li = li;
    }

    public List<Category> getCl() {
        return cl;
    }

    public void setCl(List<Category> cl) {
        this.cl = cl;
    }

    public List<SQuestion> getSl() {
        return sl;
    }

    public void setSl(List<SQuestion> sl) {
        this.sl = sl;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void loadAll() {
        String sql = "Select * From Items";
        li = new Vector<Items>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                String img = rs.getString("Img");
                java.sql.Date rls = rs.getDate("ReleaseDate");
                int sn = rs.getInt("SaleNum");
                int grd = rs.getInt("Grading");
                li.add(new Items(id, name, price, img, rls, sn, grd));
            }
        } catch (Exception e) {
            status = "Error at load Items " + e.getMessage();
            System.out.println(status);
        }
        sql = "Select * From Account";
        ul = new Vector<Users>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("UserName");
                String pass = rs.getString("Pass");
                java.sql.Date dob = rs.getDate("DoB");
                int role = rs.getInt("Role");
                String mail = rs.getString("Mail");
                int sqid = rs.getInt("SQ_id");
                String ans = rs.getString("SAnswer");
                float mn = rs.getFloat("Wallet");
                ul.add(new Users(name, pass, dob, role, mail, sqid, ans, mn));
            }
        } catch (Exception e) {
            status = "Error at load Account " + e.getMessage();
            System.out.println(status);
        }
        sql = "Select * From Category";
        cl = new Vector<Category>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                cl.add(new Category(id, name));
            }
        } catch (Exception e) {
            status = "Error at load Category " + e.getMessage();
            System.out.println(status);
        }
        sql = "Select * From SQuestion";
        sl = new Vector<SQuestion>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String qs = rs.getString("Question");
                sl.add(new SQuestion(id, qs));
            }
        } catch (Exception e) {
            status = "Error at load SQuestion " + e.getMessage();
            System.out.println(status);
        }
    }

    public void addUser(String name, String pass, String dob, int role, String mail, int sqid, String ans) {
        String sql = "Insert into Account Values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, dob);
            ps.setInt(4, role);
            ps.setString(5, mail);
            ps.setInt(6, sqid);
            ps.setString(7, ans);
            ps.setFloat(8, 0);
            ps.execute();
        } catch (Exception e) {
            status = "Error at Insert Account " + e.getMessage();
        }
    }

    public void addItems(String name, float price, String img, String rls, String us,  Vector<Integer> ilist) {
        int id = li.size() + 1;
        String sql = "Insert into Items (Id, Name, Price, Img, ReleaseDate, SaleNum, Grading) Values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setFloat(3, price);
            ps.setString(4, img);
            ps.setString(5, rls);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.execute();
        } catch (Exception e) {
            status = "Error at Insert Items " + e.getMessage();
        }
        sql = "Insert into Published (UserName, Item_Id) Values(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, us);
            ps.setInt(2, id);
            ps.execute();
        } catch (Exception e) {

        }
        sql = "Insert into Item_Category (Item_Id, Cate_Id) Values(?,?)";
        try {
            for (int i : ilist) {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setInt(2, i);
                ps.execute();
            }
        } catch (Exception e) {
            status = "Error at Insert Item_Category " + e.getMessage();
        }
    }

    public void updPass(String name, String pass) {
        String sql = "Update Account Set Pass = ? Where UserName = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, name);
            ps.execute();
        } catch (Exception e) {
            status = "Error at Update Account " + e.getMessage();
        }
    }

    public void updUser(String name) {
        String sql = "Update Account Set Role = 2 Where UserName = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
        } catch (Exception e) {
            status = "Error at Update Account " + e.getMessage();
        }
    }

    public void delUser(String name) {
        String sql = "Delete From Account Where UserName = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
        } catch (Exception e) {
            status = "Error at Delete Account " + e.getMessage();
        }
    }

    public List<Items> getGItem(List<Integer> idlist) {
        String sql = "Select distinct i.Id, i.Name, i.Price, i.Img, i.ReleaseDate From Items i\n"
                + "Join Item_Category ic on ic.Item_Id = i.Id\n"
                + "where";
        int cnt = 0;
        for (int i : idlist) {
            cnt++;
            if (cnt == idlist.size()) {
                sql += " ic.Cate_Id = " + i + ";";
            } else {
                sql += " ic.Cate_Id = " + i + " or";
            }
        }
        List<Items> ilist = new Vector<Items>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                String img = rs.getString("Img");
                java.sql.Date rls = rs.getDate("ReleaseDate");
                ilist.add(new Items(id, name, price, img, rls));
            }

        } catch (Exception e) {
            status = "Error at load items " + e.getMessage();
            System.out.println(status);
        }
        return ilist;
    }

    public List<Items> getBItem(String n) {
        String sql = "Select Bought.Id From Bought Where UserName = ?";
        List idlist = new Vector();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, n);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                idlist.add(id);
            }
        } catch (Exception e) {

        }

        List<Items> ilist = new Vector<Items>();
        sql = "Select * From Items Where id = ?";
        try {
            for (Object var : idlist) {
                PreparedStatement ps = con.prepareStatement(sql);
                int i = (int) var;
                ps.setInt(1, i);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    float price = rs.getFloat("Price");
                    String img = rs.getString("Img");
                    java.sql.Date rls = rs.getDate("ReleaseDate");
                    int sn = rs.getInt("SaleNum");
                    int grd = rs.getInt("Grading");
                    ilist.add(new Items(id, name, price, img, rls, sn, grd));
                }
            }
        } catch (Exception e) {

        }
        return ilist;
    }

    public List<Items> getPItem(String n) {
        String sql = "Select Published.Item_Id From Published Where UserName = ?";
        List idlist = new Vector();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, n);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Item_Id");
                idlist.add(id);
            }
        } catch (Exception e) {

        }
        List<Items> ilist = new Vector<Items>();
        sql = "Select * From Items Where id = ?";
        try {
            for (Object var : idlist) {
                PreparedStatement ps = con.prepareStatement(sql);
                int i = (int) var;
                ps.setInt(1, i);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    float price = rs.getFloat("Price");
                    String img = rs.getString("Img");
                    java.sql.Date rls = rs.getDate("ReleaseDate");
                    int sn = rs.getInt("SaleNum");
                    int grd = rs.getInt("Grading");
                    ilist.add(new Items(id, name, price, img, rls, sn, grd));
                }
            }
        } catch (Exception e) {

        }
        return ilist;
    }

    public int checkb(String n, int Item_Id) {
        String sql = "Select Bought.Id From Bought Where UserName = ?";
        List idlist = new Vector();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, n);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                idlist.add(id);
            }
        } catch (Exception e) {

        }
        for (Object var : idlist) {
            int num = (int) var;
            if (num == Item_Id) {
                return 1;
            }
        }
        return 0;
    }

    public void addBought(String n, int Item_Id) {
        String sql = "Insert into Bought (Id, UserName, Order_Id) Values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Item_Id);
            ps.setString(2, n);
            ps.setInt(3, 1);
            ps.execute();
        } catch (Exception e) {
            status = "Error at Insert Account " + e.getMessage();
        }
    }

    public List<Items> gettop3() {
        List<Items> ss = new Vector<Items>();
        String sql = "Select top 4 * From Items I Order by I.SaleNum";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                String img = rs.getString("Img");
                java.sql.Date rls = rs.getDate("ReleaseDate");
                int sn = rs.getInt("SaleNum");
                int grd = rs.getInt("Grading");
                ss.add(new Items(id, name, price, img, rls, sn, grd));
            }
        } catch (Exception e) {
            status = "Error at load Items " + e.getMessage();
            System.out.println(status);
        }
        return ss;
    }

    public void addCategory(int Cate_Id, String name) {
        String sql = "Insert into Category Values(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Cate_Id);
            ps.setString(2, name);
            ps.execute();
        } catch (Exception e) {
            status = "Error at Insert Category " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        DAO d = new DAO();
        d.loadAll();
        for (Items i : d.li) {
            System.out.println(i);
        }


    }
}
