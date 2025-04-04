/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg.Publisher.Service;

import java.util.ArrayList;
import models.Publisher;

/**
 *
 * @author black
 */
public interface IPublisherService {
    ArrayList<Publisher> getAll();
    Publisher findById(int id);
    Boolean addPublisher(String name);
    Boolean updatePublisher(int id,String name);
}
