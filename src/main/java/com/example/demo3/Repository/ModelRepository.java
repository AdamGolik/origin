package com.example.demo3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo3.Model.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    @Query("SELECT m FROM Model m WHERE m.grade LIKE %:grade%")
    List<Model> findByGradeContains(@Param("grade") String grade);

    @Query("SELECT m FROM Model m WHERE m.name LIKE %:name%")
    List<Model> findByNameContains(@Param("name") String name);

    @Query("SELECT m FROM Model m WHERE m.lastname LIKE %:lastName%")
    List<Model> findByLastNameContains(@Param("lastName") String lastName);
}