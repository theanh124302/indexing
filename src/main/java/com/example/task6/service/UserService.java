package com.example.task6.service;

import com.example.task6.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
        long money = 1000;
        for (int i = 0; i < numberOfRecords; i++) {
            User user = new User();
            user.setName("User"+ (random.nextInt(5000000) + 1));
            user.setMoney(money);
            userRepo.save(user);
        }
    }

//    public void addMoney(){
//        Random random = new Random();
//        long id = random.nextInt(100000)%10000;
//        System.out.println(id);
//        User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
//        user.setMoney(user.getMoney()+100);
//        userRepo.save(user);
//    }
//    public void addMoney(long id){
//        User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
//        user.setMoney(user.getMoney()+1);
//        userRepo.save(user);
//    }
//    @Async
//    public void addMoney(long id) {
//        User user = userRepo.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
//        user.setMoney(user.getMoney() + 1);
//        userRepo.save(user);
//    }


    public void addMoney(long id) {
        // Tạo một đối tượng Runnable
        Runnable addMoneyTask = new Runnable() {
            @Override
            public void run() {
                // Code cần chạy bất đồng bộ
                User user = userRepo.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
                user.setMoney(user.getMoney() + 1);
                userRepo.save(user);
            }
        };

        // Khởi chạy Runnable trong một thread mới
        Thread thread = new Thread(addMoneyTask);
        thread.start();
    }

    public List<User> findByName(String name){
        return userRepo.searchByName(name);
    }

}

