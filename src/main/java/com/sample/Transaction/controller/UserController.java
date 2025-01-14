package com.sample.Transaction.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sample.Transaction.service.UserService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
private UserService userService;

@PostMapping("/saveWithPdf")
public ResponseEntity<String> saveUserWithPdf(@RequestParam("name") String name,
                                              @RequestParam("address") String address,
                                              @RequestParam("phno") String phno,
                                              @RequestParam("pincode") String pincode,
                                              @RequestParam("file") MultipartFile file) {
    try {
        userService.saveUserWithPdf(name, address, phno, pincode, file);
        return new ResponseEntity<>("User and PDF saved successfully", HttpStatus.OK);
    } catch (IOException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
}
