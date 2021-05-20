package com.project.CorrectAnAdressServer.repository;

import com.project.CorrectAnAdressServer.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
