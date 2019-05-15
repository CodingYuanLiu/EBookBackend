package com.Ebook.ServiceImpl;

import com.Ebook.Dao.UserDao;
import com.Ebook.Entity.User;
import com.Ebook.Service.UsermanageService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsermanageServiceImpl implements UsermanageService {
    @Autowired
    private UserDao repo;

    @Override
    public JSONArray GetUserinfoService(){
        List<User> users= repo.findByAuthority("USER");
        List<User> blockedusers=repo.findByAuthority("BLOCKED");
        users.addAll(blockedusers);
        return JSONArray.parseArray(JSON.toJSONString(users));
    }

    @Override
    public String BlockService(String userid){
        User user=repo.findByUserid(Integer.parseInt(userid));
        String res="";
        if(user.getAuthority().equals("BLOCKED")){
            user.setAuthority("USER");
            repo.save(user);
            res="USER";
        }
        else if(user.getAuthority().equals("USER")){
            user.setAuthority("BLOCKED");
            repo.save(user);
            res="BLOCKED";
        }
        return res;
    }
}
