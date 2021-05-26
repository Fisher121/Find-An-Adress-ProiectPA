package com.project.CorrectAnAdressServer.service;

import com.project.CorrectAnAdressServer.model.Adress;
import com.project.CorrectAnAdressServer.repository.AdressRepository;
import org.junit.Test;
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


    /**
     * Returns the correct form of an address.
     * It takes firstly the city, and search in the database for all rows.
     * If there is no city, it takes the state, and search in the database after state,
     * If there is no state, it takes the country, and if is not correct, it is not displaying it
     * If it receive a valid data, it will execute a query in the database.
     * Then it search for the best match in the result set.
     * If the input is empty or locations are not correct, it will send back 'need more information'
     * @param adress an address containing of country, state and city
     * @return the corrected address
     */
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
                if (location.getState().equals(adress.getState()))
                    return location;
                else if (location.getCountry().equals(adress.getCountry()))
                    adress = location;
            }
        }
        return adress;
    }

    public void sanitize(Adress adress) {
        if (adress.getCountry().equals("c")) adress.setCountry("Need more information");
        if (adress.getState().equals("c")) adress.setState("Need more information");
        if (adress.getCity().equals("c")) adress.setCity("Need more information");
    }
}
