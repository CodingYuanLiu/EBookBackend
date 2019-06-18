package com.Ebook.Entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Bookcomment")
public class Bookcomment {
    private int bnum;
    private List<Comment> comment;
    public void setBnum(int bnum){
        this.bnum = bnum;
    }

    public int getBnum(){
        return this.bnum;
    }

    public List<Comment> getComment(){
        return this.comment;
    }

    public void setComment(List<Comment> comment){
        this.comment = comment;
    }
}
