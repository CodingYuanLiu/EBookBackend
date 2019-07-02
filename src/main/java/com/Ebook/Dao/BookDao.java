package com.Ebook.Dao;

import com.Ebook.Entity.Bookcomment;
import com.Ebook.Entity.Bookinfo;
import com.Ebook.Entity.Comment;

import java.util.List;

public interface BookDao {
    public Bookinfo findByBnum(int bnum);
    public List<Bookinfo> findAll();
    public void deleteByBnum(int bnum);
    public void save(Bookinfo book);
    public Bookcomment Bkcomm_findByBnum(int bnum);
    public void addComment(Bookcomment comment);
}
