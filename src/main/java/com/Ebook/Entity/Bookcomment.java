package com.Ebook.Entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Bookcomment")
public class Bookcomment {
    private int bnum;
    private List<String> comment;
    public void setBnum(int bnum){
        this.bnum = bnum;
    }

    public int getBnum(){
        return this.bnum;
    }

    public List<String> getComment(){
        return this.comment;
    }

    public void setComment(List<String > comment){
        this.comment = comment;
    }
}
