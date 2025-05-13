/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.ArrayList;

/**
 *
 * @author Ellian
 */
public class Sale {
    private Integer id;
    private Integer clientId;
    private String date;
    private ArrayList<Integer> arrProducts;

    public Sale(Integer id, Integer clientId, ArrayList<Integer> arrProducts) {
        this.id = id;
        this.clientId = clientId;
        this.arrProducts = arrProducts;
    }

    public Integer getId() {
        return id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public ArrayList<Integer> getArrProducts() {
        return arrProducts;
    }
    
    public void addProduct(Integer id) {
        arrProducts.add(id);
    }
}
