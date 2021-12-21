 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto2.reto2.repository;

import com.usa.reto2.reto2.crud.UserCrud;
import com.usa.reto2.reto2.entity.User;
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
public class UserRepository {
    @Autowired
    private UserCrud crudInterface;

    public List<User> listAll() {
        return crudInterface.findAll();
    }

    public Optional<User> getUser(int id) {
        return crudInterface.findById(id);
    }

    public User create(User user) {
        return crudInterface.save(user);
    }

    public void update(User user) {
        crudInterface.save(user);
    }
    
    public void delete(User user) {
        crudInterface.delete(user);
    }

    public boolean emailExist(String email) {
        Optional<User> usuario = crudInterface.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticateUser(String email, String password) {
        return crudInterface.findByEmailAndPassword(email, password);
    }
    
     public Optional<User> lastUserId(){
        return crudInterface.findTopByOrderByIdDesc();
    }
     
    public List<User> listBirthtDayMonth(String month){
        return crudInterface.findByMonthBirthtDay(month);
    }
}