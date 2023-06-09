/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Store {
    private int id;
    private String name;
    private String address;
    private String description;
    private ArrayList<Car> listCar;

    public Store(int id, String name, String address, String description, ArrayList<Car> listCar) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.listCar = listCar;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Car> getListCar() {
        return listCar;
    }

    public void setListCar(ArrayList<Car> listCar) {
        this.listCar = listCar;
    }
    
}
