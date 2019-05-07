package com.Ebook.Repository;

import com.Ebook.Entity.Bookinfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface BookinfoRepository extends CrudRepository<Bookinfo, Long> {
    public Bookinfo findByBnum(int bnum);
    public List<Bookinfo> findAll();
    @Transactional
    public void deleteByBnum(int bnum);
}