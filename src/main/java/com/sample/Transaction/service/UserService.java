package com.sample.Transaction.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sample.Transaction.model.User;
import com.sample.Transaction.repository.Userrepo;

@Service
public class UserService {
@Autowired
private Userrepo userrepo;

public User saveUserWithPdf(String name, String address, String phno, String pincode, MultipartFile file) throws IOException {
    User user = new User();
    user.setName(name);
    user.setAddress(address);
    user.setPhno(phno);
    user.setPincode(pincode);

    if (file.getContentType().equals("application/pdf") && file.getSize() <= 104857600) {
        user.setPdf(file.getBytes());
    } else {
        throw new IOException("File is not a PDF or is larger than 100MB");
    }

    return userrepo.save(user);
}
}