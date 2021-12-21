/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto2.reto2.controller;

import com.usa.reto2.reto2.entity.CleaningProduct;
import com.usa.reto2.reto2.service.CleaningProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JuanDa
 * 
 */

@RestController
@RequestMapping("/api/cleaningproduct")
public class CleaningProductController {

    @Autowired
    private CleaningProductService servicio;

    @GetMapping("/all")
    public List<CleaningProduct> listAll() {
        return servicio.listAll();
    }

    @GetMapping("/{reference}")
    public Optional<CleaningProduct> getAccesory(@PathVariable("reference") String reference) {
        return servicio.getAccesory(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct create(@RequestBody CleaningProduct accessory) {
        return servicio.create(accessory);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct accessory) {
        return servicio.update(accessory);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return servicio.delete(reference);
    }
    
    @GetMapping("/price/{price}")
    public List<CleaningProduct> productsByPrice(@PathVariable("price") double precio){
        return servicio.productsByPrice(precio);
    }
    
    //Reto 5
    @GetMapping("/description/{description}")
    public List<CleaningProduct> findByDescriptionLike(@PathVariable("description") String description){
	return servicio.findByDescriptionLike(description);
    }    
}