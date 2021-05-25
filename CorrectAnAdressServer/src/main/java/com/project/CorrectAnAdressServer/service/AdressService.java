package com.project.CorrectAnAdressServer.service;

import com.project.CorrectAnAdressServer.model.Adress;
import com.project.CorrectAnAdressServer.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        sanitize(adress);
        List<Adress> cityLocationList = adressRepository.findByCity(adress.getCity());

        if (cityLocationList.isEmpty()) {
            List<Adress> stateLocationList = adressRepository.findByState(adress.getState());
            List<Adress> countryLocationList = adressRepository.findByCountry(adress.getCountry());

            String country = "Need more information.";
            String state = "Need more information.";
            String city = "Need more information.";
            if (!stateLocationList.isEmpty()) {
                country = stateLocationList.get(0).getCountry();
                state = stateLocationList.get(0).getState();
            }else if (!countryLocationList.isEmpty()) {
                country = countryLocationList.get(0).getCountry();
            }

            return new Adress(country, state, city);
        } else if (cityLocationList.size() == 1) {
            return cityLocationList.get(0);
        } else {
            for (Adress location : cityLocationList) {
                if (location.getState().equals(adress.getState()) &&
                        location.getCountry().equals(adress.getCountry())) {
                    return location;
                }
                if (location.getState().equals(adress.getState()) || location.getCountry().equals(adress.getCountry()))
                    adress = location;
            }
        }
        return adress;
    }

    public void sanitize(Adress adress) {
        if (adress.getCity() == null) adress.setCity("Need more information");
        if (adress.getState() == null) adress.setState("Need more information");
        if (adress.getCountry() == null) adress.setCountry("Need more information");
    }
}
