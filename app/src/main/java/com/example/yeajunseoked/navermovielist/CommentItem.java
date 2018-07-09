package com.example.yeajunseoked.navermovielist;

import java.io.Serializable;

/*한명을 위한  데이터만 들어간다. */
public class CommentItem implements Serializable{
    String name;
    String time;
    String comment;
    String select;

    public CommentItem(String name, String time, String comment, String select) {
        this.name = name;
        this.time = time;
        this.comment = comment;
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", comment='" + comment + '\'' +
                ", select='" + select + '\'' +
                '}';
    }
}
