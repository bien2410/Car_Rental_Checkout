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
public class Failure implements Serializable{
    private int id;
    private String name;
    private String description;
    private float compensation;

    public Failure() {
        super();
    }
    
    public Failure(int id, String name, String description, float compensation) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.compensation = compensation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCompensation() {
        return compensation;
    }

    public void setCompensation(float compensation) {
        this.compensation = compensation;
    }
    public Object[] toObjects() {
        return new Object[]{this.id, this.name, this.description, this.compensation};
    }
    
    public Object[] toObjects2(){
        return new Object[]{this.name};
    }
}
