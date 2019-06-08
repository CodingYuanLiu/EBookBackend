package com.Ebook.DaoImpl;

import com.Ebook.Dao.BookDao;
import com.Ebook.Entity.Bookcomment;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Repository.BookinfoRepository;
import com.Ebook.Repository.BookcommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private  BookinfoRepository bookinfoRepo;

    @Autowired
    private BookcommentRepository bookcommentRepo;

    @Override
    public Bookinfo findByBnum(int bnum){
        return bookinfoRepo.findByBnum(bnum);
    }

    @Override
    public List<Bookinfo> findAll(){
        return bookinfoRepo.findAll();
    }

    @Override
    public void deleteByBnum(int bnum){
        bookinfoRepo.deleteByBnum(bnum);
    }

    @Override
    public void save(Bookinfo book){
        bookinfoRepo.save(book);
    }

    @Override
    public Bookcomment Bkcomm_findByBnum(int bnum){
        return bookcommentRepo.findByBnum(bnum);
    }
}
