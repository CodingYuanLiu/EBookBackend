package com.Ebook.ServiceImpl;

import com.Ebook.Dao.BookDao;
import com.Ebook.Dao.OrderItemsDao;
import com.Ebook.Entity.Bookcomment;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Entity.Comment;
import com.Ebook.Repository.BookcommentRepository;
import com.Ebook.Entity.OrderItems;
import com.Ebook.Service.ScanningService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanningServiceImpl implements ScanningService {
    @Autowired
    private BookDao repo;
    @Autowired
    private OrderItemsDao oirepo;
    @Autowired
    private BookcommentRepository bcrepo;

    @Override
    public JSONArray GetBookService(){
        List<Bookinfo> books = repo.findAll();
        for(int i=books.size()-1;i>=0;i--){
            Bookinfo deletedbook = books.get(i);
            if(deletedbook.getBnum()==0){
                books.remove(deletedbook);
            }
        }
        JSONArray array = JSONArray.parseArray(JSON.toJSONString(books));
        return array;
    }


    @Override
    public Bookinfo ModifyService(String bookstring){
        Bookinfo book = JSON.parseObject(bookstring,Bookinfo.class);
        repo.save(book);
        return book;
    }

    @Override
    public int DeleteBookService(String bnumstr){
        int bnum = Integer.parseInt(bnumstr);
        Bookinfo book = repo.findByBnum(bnum);
        Bookinfo deletedbook = repo.findByBnum(0);
        List<OrderItems> items = oirepo.findByBook(book);
        //oirepo.deleteByBook(book);
        for(OrderItems item:items){
            item.setBook(deletedbook);
            oirepo.save(item);
        }
        repo.deleteByBnum(bnum);
        return bnum;
    }

    @Override
    public List<Comment> GetCommentService(int bnum){
        Bookcomment comment = repo.Bkcomm_findByBnum(bnum);
        if(comment == null)
            return null;
        else
            return comment.getComment();
    }
}
