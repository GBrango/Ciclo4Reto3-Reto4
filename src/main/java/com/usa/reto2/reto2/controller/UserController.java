/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto2.reto2.controller;

import com.usa.reto2.reto2.entity.User;
import com.usa.reto2.reto2.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * @author Gabriel Brango
 * 
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {
    @Autowired/**Hacemos el llamado de las dependecias*/
    private UserService servicio;
    /**
     * Obtenemos a todos los usuarios
     */
    @GetMapping("/all")
    public List<User> listAll() {
        return servicio.listAll();
    }
    /**
     * LLamamos al usuario por Id
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return servicio.getUser(id);
    }  
    /*
     *Creamos un nuevo usuario 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return servicio.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return servicio.update(user);
    }
    /**
    *Validamos la existencia del email
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExist(@PathVariable("email") String email) {
        return servicio.emailExist(email);
    }
    /**
     * Borramos por ID
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicio.delete(id);
    }
     /**Validamos la que exista la cuenta del usuario*/
    @GetMapping("/{email}/{password}")
    public User autenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return servicio.autenticateUser(email, password);
    }
    
    //Reto 5: Cumpleaños del mes
    @GetMapping("/birthday/{month}")
    public List<User> listBirthtDayMonth(@PathVariable("month") String month){
        return servicio.listBirthtDayMonth(month);
    }
}