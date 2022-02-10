package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data

@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String state;

    protected Users(){}
    public Users(String name,String state){
        this.name=name;this.state=state;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public String getState(){
        return state;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setName(String names){
        this.name = names;
    }

    public void setState(String states){
        this.state = states;
    }
}
