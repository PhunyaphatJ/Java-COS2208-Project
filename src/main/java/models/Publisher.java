/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.logging.Logger;

/**
 *
 * @author black
 */
public class Publisher {
    int id;
    String name;

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Publisher(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
