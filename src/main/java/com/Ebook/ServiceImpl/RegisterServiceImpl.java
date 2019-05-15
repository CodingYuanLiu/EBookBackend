package com.Ebook.ServiceImpl;

import com.Ebook.Dao.UserDao;
import com.Ebook.Entity.User;
import com.Ebook.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserDao repo;

    @Override
    public User RegisterService(String username,String password,String email){
        User newuser = new User(username,password,email,"USER");
        repo.save(newuser);
        return newuser;
    }

    @Override
    public boolean CheckDupUsernameService(String username) {
        List<User> finduser = repo.findByUsername(username);
        if(finduser.size()>0)
            return true;
        else
            return false;
    }
}
