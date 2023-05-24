package com.example.portfolioworking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Database {
    @Autowired
    private PortRepo portRepo;
    @GetMapping("/getAllUsers")
    private List<Model> getAllUsers()
    {
return  portRepo.findAll();
    }
    @DeleteMapping("/deleteById/{id}")
    private String  deleteUserById(@PathVariable("id") int id)
    { portRepo.deleteById(id);
        return  "deleted sucessfully";
    }
//    @GetMapping("/getUserByName")
//    public ResponseEntity<String> getUserBYname(@PathVariable("name") String name)
//    {
//        return portRepo.find
//    }
}
