package com.example.task6.controller;

import com.example.task6.dto.User;
import com.example.task6.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//
@RequestMapping("/")
@RequiredArgsConstructor
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("gen")
    public ResponseEntity<String> genData(){
        userService.generateData(5000);
        return ResponseEntity.ok("Generate Successfully");
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<User>> findByName(@PathVariable String name){
        return ResponseEntity.ok(userService.findByName(name));
    }
}
