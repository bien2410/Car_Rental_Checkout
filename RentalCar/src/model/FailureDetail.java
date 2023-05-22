/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class FailureDetail implements Serializable {
    private int id;
    private int quantity;
    private float totalCompensation;
    private Failure failure;

    public FailureDetail() {
        super();
    }

    public FailureDetail(int id, int quantity, float totalCompensation, Failure failure) {
        super();
        this.id = id;
        this.quantity = quantity;
        this.totalCompensation = totalCompensation;
        this.failure = failure;
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

    public float getTotalCompensation() {
        return totalCompensation;
    }

    public void setTotalCompensation(float totalCompensation) {
        this.totalCompensation = totalCompensation;
    }

    public Failure getFailure() {
        return failure;
    }

    public void setFailure(Failure failure) {
        this.failure = failure;
    }
    
//    public Object[] toObjects() {
//        return new Object[]{this.id, this.client.getName(), this.client.getAddress(), this.client.getTel(), new SimpleDateFormat("dd-MM-yyyy").format(this.day)};
//    }
}
