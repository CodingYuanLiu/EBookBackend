package com.Ebook.ServiceImpl;

import com.Ebook.Dao.UserDao;
import com.Ebook.Entity.User;
import com.Ebook.Service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao repo;

    @Override
    public String Login(String username, String password) {
        List<User> finduser = repo.findByUsername(username);
        if(finduser.size() == 0){
            return "Unexist Username";
        }
        else{
            User user= finduser.get(0);
            if(user.getAuthority().equals("BLOCKED")){
                return "BLOCKED USER";
            }
            if(user.checkpassword(username,password)) {
                String info=new String(user.getAuthority());
                info="{\"Authority\":\""+info+"\",";
                info=info+"\"userid\":" + user.getUserid();
                return info+"}";
            }
            else{
                return "Wrong password";
            }
        }
    }
}
