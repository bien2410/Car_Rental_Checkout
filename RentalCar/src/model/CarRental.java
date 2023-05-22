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
public class CarRental implements Serializable{
    private int id;
    private Date dayStart;
    private Date dayEnd;
    private float price;
    private float totalAmount;
    private boolean isReturned;
    private String note;
    private Car car;
    private ArrayList<FailureDetail> failures;

    public CarRental() {
        super();
    }

    public CarRental(int id, Date dayStart, Date dayEnd, float price, float totalAmount, boolean isReturned, String note, Car car, ArrayList<FailureDetail> failures) {
        super();
        this.id = id;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.price = price;
        this.totalAmount = totalAmount;
        this.isReturned = isReturned;
        this.note = note;
        this.car = car;
        this.failures = failures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isIsReturned() {
        return isReturned;
    }

    public void setIsReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ArrayList<FailureDetail> getFailures() {
        return failures;
    }

    public void setFailures(ArrayList<FailureDetail> failures) {
        this.failures = failures;
    }
    
    public void addFailureDetail(FailureDetail failureDetail){
        for(FailureDetail f : this.failures){
            if(f.getFailure().getId() == failureDetail.getFailure().getId()){
                f.setQuantity(f.getQuantity() + failureDetail.getQuantity());
                return;
            }
        }
        this.failures.add(failureDetail);
    }
    
    public void addFailureDetailNoId(FailureDetail failureDetail){
        this.failures.add(failureDetail);
    }
    
    public void deleteFailureDetail(FailureDetail failureDetail){
        if(this.failures.contains(failureDetail)){
            this.failures.remove(failureDetail);
        }
    }
    
    public Object[] toObjects() {
        return new Object[]{this.car.getId(), this.car.getManufacturer(), this.car.getType(), this.car.getNumberPlate(), new SimpleDateFormat("dd-MM-yyyy").format(this.dayStart), new SimpleDateFormat("dd-MM-yyyy").format(this.dayEnd), this.totalAmount};
    }
}