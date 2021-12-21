/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto2.reto2.crud;

import com.usa.reto2.reto2.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author JuanDa
 * 
 */

public interface UserCrud extends MongoRepository<User, Integer> {  
    //aqui defino consultas adicionales que no estan predeterminadas en la Interfaz "MongoRepository"
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    
    //Para seleccionar el usuario con el id maximo
    //db.users.find().limit(1).sort({$natural:-1}) en mongo db
    Optional<User> findTopByOrderByIdDesc();
    
    //Reto 5: Listado de cumpleaños del mes
    List<User> findByMonthBirthtDay(String month);
}