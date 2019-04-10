package com.Ebook.Repository;

import com.Ebook.Entity.Bookinfo;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookinfoRepository extends CrudRepository<Bookinfo, Long> {

}