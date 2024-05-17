/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author hi2ot
 */
public class SQuestion {
    private int Id;
    private String Question;

    public SQuestion() {
    }

    public SQuestion(int Id, String Question) {
        this.Id = Id;
        this.Question = Question;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "SQuestion{" + "Id=" + Id + ", Question=" + Question + '}';
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }                
}
