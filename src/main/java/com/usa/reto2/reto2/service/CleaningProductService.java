/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto2.reto2.service;

import com.usa.reto2.reto2.entity.CleaningProduct;
import com.usa.reto2.reto2.repository.CleaningProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanDa
 * 
 */

@Service
public class CleaningProductService {
    @Autowired
    private CleaningProductRepository repositorio;

    public List<CleaningProduct> listAll() {
        return repositorio.listAll();
    }

    public Optional<CleaningProduct> getAccesory(String reference) {
        return repositorio.getAccesory(reference);
    }

    public CleaningProduct create(CleaningProduct accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return repositorio.create(accesory);
        }
    }

    public CleaningProduct update(CleaningProduct accesory) {

        if (accesory.getReference() != null) {
            Optional<CleaningProduct> accesoryDb = repositorio.getAccesory(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repositorio.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getAccesory(reference).map(accesory -> {
            repositorio.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    //Reto 5
    public List<CleaningProduct> productsByPrice(double precio){
        return repositorio.productsByPrice(precio);
    }
    
    //Reto 5
    public List<CleaningProduct> findByDescriptionLike(String description) {
	return repositorio.findByDescriptionLike(description);
    }
}