/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto2.reto2.crud;

import com.usa.reto2.reto2.entity.CleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author JuanDa
 * 
 */

public interface CleaningProductCrud extends MongoRepository<CleaningProduct, String> {    
    Optional<CleaningProduct> findByBrand(String brand);
    
    //Reto 5
    public List<CleaningProduct> findByPriceLessThanEqual(double precio);
    
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<CleaningProduct> findByDescriptionLike(String description);
}