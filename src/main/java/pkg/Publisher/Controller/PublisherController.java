/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Publisher.Controller;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Publisher;
import pkg.Publisher.Repository.IPublisherRepository;
import pkg.Publisher.Repository.PublisherRepositoryImpl;
import pkg.Publisher.Service.IPublisherService;
import pkg.Publisher.Service.PublisherServiceImpl;

/**
 *
 * @author black
 */
public class PublisherController {

    IPublisherService publisherService;

    public PublisherController(IPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public ArrayList<Publisher> getPublishers() {
        return publisherService.getAll();
    }

    public Publisher findById(int id) {
        return publisherService.findById(id);
    }

    public void addPublisher(String name) {
        if (publisherService.addPublisher(name)) {
            JOptionPane.showMessageDialog(null, "Add Publisher Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Add Publisher!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updatePublisher(int id,String name){
          if (publisherService.updatePublisher(id, name)) {
            JOptionPane.showMessageDialog(null, "Update Publisher Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Update Publisher!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static PublisherController getPublisherController(Connection db) {
        IPublisherRepository publisherRepo = new PublisherRepositoryImpl(db);
        IPublisherService publisherService = new PublisherServiceImpl(publisherRepo);

        return new PublisherController(publisherService);
    }
}
