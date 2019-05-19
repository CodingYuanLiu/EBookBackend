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
    public JSONObject Login(String username, String password) {
        JSONObject result = new JSONObject();
        List<User> finduser = repo.findByUsername(username);
        if(finduser.size() == 0){
            result.put("code",401);
            result.put("data","Unexist Username");
            return result;
        }
        else{
            User user= finduser.get(0);
            if(user.getAuthority().equals("BLOCKED")){
                result.put("code",403);
                result.put("data","BLOCKED USER");
                return result;
            }
            if(user.checkpassword(username,password)) {
                JSONObject info = new JSONObject();
                info.put("Authority",user.getAuthority());
                info.put("userid",user.getUserid());
                result.put("code",200);
                result.put("data",info);
                return result;
            }
            else {
                result.put("code", 401);
                result.put("data", "Wrong password");
                return result;
            }
        }
    }
}
