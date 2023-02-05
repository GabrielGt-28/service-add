package com.pf.sumar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pf.sumar.entity.Suma;
import com.pf.sumar.servicies.SumaService;

import java.util.List;

@RestController
@RequestMapping("suma")
public class SumaController {

	@Autowired
	private SumaService service;
	
	
	@PostMapping("/add")
	public int getResult(@RequestBody Suma suma) {
		Suma newSuma = service.save(suma);
		int result = newSuma.getNumberA() + newSuma.getNumberB();
		newSuma.setResult(result);
		service.save(newSuma);
		return newSuma.getResult();
	}

	@GetMapping("/list")
	public ResponseEntity<List<Suma>> getList(){
		List<Suma> list = service.list();

		if (list.isEmpty()){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(list);
	}

	@PostMapping("add/{id}")
	public ResponseEntity<Suma> getAddById(@PathVariable("id") int id){
		Suma getSuma = service.getSumaById(id);
		if (getSuma == null){
			return  ResponseEntity.noContent().build();
		}
		return  ResponseEntity.ok(getSuma);
	}

	@DeleteMapping("remove/{id}")
	public ResponseEntity<String> remove(@PathVariable("id") int id){
		Suma getSuma = service.getSumaById(id);
		if (getSuma == null){
			return  ResponseEntity.noContent().build();
		}
		service.remove(getSuma.getId());
		return ResponseEntity.ok("Usuario Eliminado");
	}
}
