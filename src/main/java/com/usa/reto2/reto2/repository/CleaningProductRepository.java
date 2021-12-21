/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto2.reto2.repository;

import com.usa.reto2.reto2.crud.CleaningProductCrud;
import com.usa.reto2.reto2.entity.CleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JuanDa
 * 
 */

@Repository
public class CleaningProductRepository {
    @Autowired
    private CleaningProductCrud crudInterface;

    public List<CleaningProduct> listAll() {
        return crudInterface.findAll();
    }

    public Optional<CleaningProduct> getAccesory(String reference) {
        return crudInterface.findById(reference);
    }

    public CleaningProduct create(CleaningProduct accesory) {
        return crudInterface.save(accesory);
    }

    public void update(CleaningProduct accesory) {
        crudInterface.save(accesory);
    }

    public void delete(CleaningProduct accesory) {
        crudInterface.delete(accesory);
    }
    
    //Reto 5
    public List<CleaningProduct> productsByPrice(double precio){
        return crudInterface.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<CleaningProduct> findByDescriptionLike(String description){
	return crudInterface.findByDescriptionLike(description);
    }
}
