package com.projeto.idealcolors.repository;

import com.projeto.idealcolors.model.CartelaDeCores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartelaDeCoresRepository extends JpaRepository<CartelaDeCores, Long> {

}