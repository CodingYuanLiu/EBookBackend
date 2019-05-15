package com.Ebook.DaoImpl;

import com.Ebook.Dao.UserDao;
import com.Ebook.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.Ebook.Repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository repo;

    @Override
    public List<User> findByUsername(String username){
        return repo.findByUsername(username);
    }

    @Override
    public User findByUserid(int userid){
        return repo.findByUserid(userid);
    }

    @Override
    public List<User> findByAuthority(String authority){
        return repo.findByAuthority(authority);
    }

    @Override
    public void save(User user){
        repo.save(user);
    }
}
