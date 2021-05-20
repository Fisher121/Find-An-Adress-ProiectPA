package com.project.CorrectAnAdressServer.api;

import com.project.CorrectAnAdressServer.model.Adress;
import com.project.CorrectAnAdressServer.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/adress")
public class AdressController {
    private final AdressService adressService;

    @Autowired
    public AdressController(AdressService adressService) {
        this.adressService = adressService;
    }

    @GetMapping("correct/{country}/{state}/{city}")
    public Adress  correct(@PathVariable("country")String country,
                           @PathVariable("state")String state,
                           @PathVariable("city")String city){
        country = country.replaceAll("~"," ");
        state = state.replaceAll("~"," ");
        city = city.replaceAll("~"," ");
        Adress adress= new Adress(country,city,state);
        System.out.println(adress);
        return adressService.correct(adress);
    }

    @GetMapping("correct")
    public Adress  correct(@RequestBody Adress adress){
        System.out.println(adress.toString());
        return adressService.correct(adress);
    }
}
