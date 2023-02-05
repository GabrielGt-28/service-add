package com.pf.sumar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pf.sumar.entity.Suma;

@Repository
public interface SumaRepository extends JpaRepository<Suma, Integer> {

}
