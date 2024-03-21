package com.example.task6.service;

import com.example.task6.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.task6.repo.UserRepo;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void generateData(int numberOfRecords) {
        Random random = new Random();
        for (int i = 0; i < numberOfRecords; i++) {
            User user = new User();
            user.setName(generateRandomName());
            userRepo.save(user);
        }
    }

    private String generateRandomName() {
        // Logic to generate random names
        // You can use libraries like Faker for better random data generation
        // For simplicity, let's just generate some random names
        return "User" + (new Random().nextInt(5000000) + 1);
    }

    public List<User> findByName(String name){
        return userRepo.searchByName(name);
    }

}

