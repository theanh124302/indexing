package com.example.task6.controller;

import com.example.task6.dto.User;
import com.example.task6.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/addMoney")
//    public ResponseEntity<String> addMoney() {
//        userService.addMoney();
//        return ResponseEntity.status(HttpStatus.OK).body("Successfully added 100 to user's money.");
//    }

    @PostMapping("/addMoney/{id}")
    public ResponseEntity<String> addMoneyById(@PathVariable long id) {
        userService.addMoney(id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully added 100 to user's money.");
    }
}
