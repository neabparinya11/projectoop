package com.example.backend.controller;

import com.example.backend.entity.Users;
import com.example.backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    private UsersRepository userRespository;

    @Autowired
    public UsersController(UsersRepository usersRepository){
        this.userRespository = usersRepository;
    }

    @PostMapping("/user/save")
    public Users saveUsers(@RequestBody Users users){
        return this.userRespository.save(users);
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<Users>> getUser(){
        return ResponseEntity.ok(
                this.userRespository.findAll()
        );
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Users> getUser(@PathVariable(value = "id") Long id){
        Users users = this.userRespository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User not found")
        );
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/user/{id}")
    public Users updateUsers(@RequestBody Users newUse, @PathVariable(value = "id") Long id){
            return this.userRespository.findById(id)
                    .map(users -> {
                        users.setId(newUse.getId());
                        users.setName(newUse.getName());
                        users.setState(newUse.getState());
                        return this.userRespository.save(users);
                    }).orElseGet(()->{
                       newUse.setId(id);
                       return this.userRespository.save(newUse);
                    });
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> removeUsers(@PathVariable(value = "id") Long id){
            Users users = this.userRespository.findById(id).orElseThrow(
                    ()->new ResourceNotFoundException("Not found Id: " + id)
            );
            this.userRespository.delete(users);
            return ResponseEntity.ok().build();
    }
}
