/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author hi2ot
 */
public class Category {
    private int Id;
    private String Name;

    public Category(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public Category() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Category{" + "Id=" + Id + ", Name=" + Name + '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

   
    
    
}
