package org.noob.design.pojo;

import java.util.Date;

public class Memorandum {
    private int id;
    private String title;
    private String all_text;
    private Date time;
    private int user_id ;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Memorandum{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", all_text='" + all_text + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAll_text() {
        return all_text;
    }

    public void setAll_text(String all_text) {
        this.all_text = all_text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
