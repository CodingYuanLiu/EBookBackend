package com.Ebook.Repository;

import com.Ebook.Entity.Bookinfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookinfoRepository extends CrudRepository<Bookinfo, Long> {
    public Bookinfo findByBnum(int id);
    public List<Bookinfo> findAll();
    @Modifying
    @Query(value="update Bookinfo set remain=:remain where bnum=:bnum")
    public void updateRemainByBnum(int bnum,int remain);
}