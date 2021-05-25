package com.project.CorrectAnAdressServer.repository;

import com.project.CorrectAnAdressServer.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface AdressRepository extends JpaRepository<Adress, String> {
    @Query(value = "SELECT * FROM orase o WHERE LOWER(o.city) = LOWER(:city)", nativeQuery = true)
    List<Adress> findByCity(@Param("city") String city);

    @Query(value = "SELECT * FROM orase o WHERE LOWER(o.admin_name) = LOWER(:state)", nativeQuery = true)
    List<Adress> findByState(@Param("state") String state);

    @Query(value = "SELECT * FROM orase o WHERE LOWER(o.country) = LOWER(:country)", nativeQuery = true)
    List<Adress> findByCountry(@Param("country") String state);
}
