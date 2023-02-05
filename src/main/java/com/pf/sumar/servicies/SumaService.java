package com.pf.sumar.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.sumar.entity.Suma;
import com.pf.sumar.repository.SumaRepository;

@Service
public class SumaService {
	
	@Autowired
	SumaRepository repository;
	
	public Suma save(Suma suma) {
		return repository.save(suma);
	}
	
	public List<Suma> list(){
		return repository.findAll();
	}
	
	public Suma getSumaById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public void remove(int id) {
		repository.deleteById(id);
	}
	


}
