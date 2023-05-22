/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class MortgageDetail implements Serializable{
    private int id;
    private int quantity;
    private String note;
    private Mortgage mortgage;

    public MortgageDetail() {
        super();
    }
    
    public MortgageDetail(int id, int quantity, String note, Mortgage mortgage) {
        super();
        this.id = id;
        this.quantity = quantity;
        this.note = note;
        this.mortgage = mortgage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Mortgage getMortgage() {
        return mortgage;
    }

    public void setMortgage(Mortgage mortgage) {
        this.mortgage = mortgage;
    }
    public Object[] toObjects() {
        return new Object[]{this.mortgage.getId(), this.mortgage.getName(), this.quantity, this.note};
    }
}
