package com.Ebook.Service;

import com.Ebook.Entity.User;

public interface RegisterService {
    public User RegisterService(String username,String password,String email);
    public boolean CheckDupUsernameService(String username);
}
