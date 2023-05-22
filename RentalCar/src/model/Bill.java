/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Bill implements Serializable{
    private String id;
    private Date day;
    private Contract contract;
    private float totalCompensation;
    private float totalAmount;
    private User user;
    private String note;

    public Bill() {
        super();
    }

    public Bill(String id, Date day, Contract contract, float totalCompensation, float totalAmount, User user, String note) {
        super();
        this.id = id;
        this.day = day;
        this.contract = contract;
        this.totalCompensation = totalCompensation;
        this.totalAmount = totalAmount;
        this.user = user;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public float getTotalCompensation() {
        return totalCompensation;
    }

    public void setTotalCompensation(float totalCompensation) {
        this.totalCompensation = totalCompensation;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public void setDay(){
        this.day = new Date();
    }
    
}
