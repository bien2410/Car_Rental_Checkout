/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Contract implements Serializable{
    private String id;
    private Date day;
    private Client client;
    private ArrayList<CarRental> cars;
    private ArrayList<MortgageDetail> mortgages;
    private float totalAmount;
    private User user;
    private String note;

    public Contract() {
        super();
    }
    
    public Contract(String id, Date day, Client client, ArrayList<CarRental> cars, ArrayList<MortgageDetail> mortgages, float totalAmount, User user, String note) {
        super();
        this.id = id;
        this.day = day;
        this.client = client;
        this.cars = cars;
        this.mortgages = mortgages;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<CarRental> getCars() {
        return cars;
    }

    public void setCars(ArrayList<CarRental> cars) {
        this.cars = cars;
    }

    public ArrayList<MortgageDetail> getMortgages() {
        return mortgages;
    }

    public void setMortgages(ArrayList<MortgageDetail> mortgages) {
        this.mortgages = mortgages;
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
    public Object[] toObjects() {
        return new Object[]{this.id, this.client.getName(), this.client.getAddress(), this.client.getTel(), new SimpleDateFormat("dd-MM-yyyy").format(this.day)};
    }
}
