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
}
