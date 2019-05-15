package com.Ebook.DaoImpl;

import com.Ebook.Dao.BookinfoDao;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Repository.BookinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookinfoDaoImpl implements BookinfoDao {
    @Autowired
    private  BookinfoRepository bookinfoRepo;

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
}
