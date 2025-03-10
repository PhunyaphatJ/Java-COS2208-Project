/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cos2208project;

import config.Config;
import database.PostgresDb;

/**
 *
 * @author black
 */
public class main {
 public static void main(String[]args){
     Config config = Config.getInstance();
     PostgresDb postgres = new PostgresDb(config);
     postgres.Connection();
 }   
}
