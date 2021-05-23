package com.project.CorrectAnAdressServer.service;

import com.project.CorrectAnAdressServer.model.Adress;
import com.project.CorrectAnAdressServer.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressService {
    private final AdressRepository adressRepository;

    @Autowired
    public AdressService(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    public Adress correct(Adress adress) {
        List<Adress> locationsList = adressRepository.findByCity(adress.getCity());

        if (locationsList.isEmpty()) {
            return new Adress("Invalid data", "Invalid data", "Invalid data");
        } else if (locationsList.size() == 1) {
            return locationsList.get(0);
        } else {
            for (Adress location : locationsList) {

                if (location.getState().equals(adress.getState()) &&
                        location.getCountry().equals(adress.getCountry())) {
                    System.out.println(location.toString());
                    return location;
                }

                if (location.getState().equals(adress.getState()) || location.getCountry().equals(adress.getCountry()))
                    return location;
            }
        }
        return adress;
    }

}
