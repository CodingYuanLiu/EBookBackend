package com.Ebook.Dao;

import com.Ebook.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {
    public List<User> findByUsername(String username);
    public User findByUserid(int userid);
    public List<User> findByAuthority(String authority);
    public void save(User user);
}
