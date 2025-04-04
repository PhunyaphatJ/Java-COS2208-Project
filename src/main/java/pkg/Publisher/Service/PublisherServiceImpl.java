/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Publisher.Service;

import java.util.ArrayList;
import models.Publisher;
import pkg.Publisher.Repository.IPublisherRepository;

/**
 *
 * @author black
 */
public class PublisherServiceImpl implements IPublisherService {
    IPublisherRepository publisherRepo;
    
    public PublisherServiceImpl(IPublisherRepository publisherRepo){
        this.publisherRepo = publisherRepo;
    }
    
    
    @Override
    public ArrayList<Publisher> getAll() {
        return publisherRepo.getAll();
    }

    @Override
    public Publisher findById(int id) {
        return publisherRepo.findById(id);
    }

    public Boolean addPublisher(String name) {
        if(name.isEmpty()){
            return false;
        }
        Publisher publisher = new Publisher(name);
        return publisherRepo.addPublisher(publisher);
    }

    @Override
    public Boolean updatePublisher(int id, String name) {
        Publisher publisher = new Publisher(id,name);
        return publisherRepo.updatePublisher(publisher);
    }
    
}
