package com.project.CorrectAnAdressServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orase")
public class Adress{

    @Id
    public Integer ID;
    @Column(name = "country")
    public String country;
    @Column(name = "admin_name")
    public String state;
    @Column(name = "city")
    public String city;
    public Adress(@JsonProperty("country") String country,
                  @JsonProperty("state") String state,
                  @JsonProperty("city") String city){
        this.country = country;
        this.state=state;
        this.city=city;
    }
    public Adress(){}

    public String getCity() { return city; }
    public String getCountry() { return country; }
    public String getState() { return state; }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
