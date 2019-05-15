package com.Ebook.Dao;

import com.Ebook.Entity.Bookinfo;

import java.util.List;

public interface BookinfoDao {
    public Bookinfo findByBnum(int bnum);
    public List<Bookinfo> findAll();
    public void deleteByBnum(int bnum);
    public void save(Bookinfo book);
}
