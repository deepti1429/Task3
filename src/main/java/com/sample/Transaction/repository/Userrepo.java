package com.sample.Transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.Transaction.model.User;

@Repository
public interface Userrepo extends JpaRepository<User,Long> {

}
