package com.project.CorrectAnAdressServer.service;

import com.project.CorrectAnAdressServer.model.Adress;
import com.project.CorrectAnAdressServer.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {
    private final AdressRepository adressRepository;

    @Autowired
    public AdressService(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    public Adress correct(Adress adress){
        //System.out.println(adressRepository.findAll());
        return adressRepository.findById(1624958412).orElse(null);
    }


}
