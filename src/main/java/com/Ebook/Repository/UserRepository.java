package com.Ebook.Repository;

import com.Ebook.Entity.User;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findByUsername(String username);
}