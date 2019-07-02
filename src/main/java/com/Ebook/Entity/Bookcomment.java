package com.Ebook.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Bookcomment")
public class Bookcomment {
    private ObjectId _id;
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

    public void addComment(Comment comment){
        this.comment.add(comment);
    }

    public void setComment(List<Comment> comment){
        this.comment = comment;
    }
    public Bookcomment(int bnum,String username,String comment){
        this.bnum = bnum;
        this.comment = new ArrayList<Comment>();
        this.comment.add(new Comment(username,comment));
    }
}
