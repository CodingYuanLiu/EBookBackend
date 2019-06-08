package com.Ebook.Repository;

import com.Ebook.Entity.Bookcomment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookcommentRepository extends MongoRepository<Bookcomment,Long> {
    //public Bookcomment findOne();

    @Query("{ 'bnum' : ?0 }")
    public Bookcomment findByBnum(int bnum);

    public List<Bookcomment> findAll();
}
