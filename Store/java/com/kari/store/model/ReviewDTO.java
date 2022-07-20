package com.kari.store.model;

import java.sql.Timestamp;
import java.util.Calendar;

public class ReviewDTO {
    private int id;
    private int productId;
    private int writerId;
    private String content;
    private int star;
    private Calendar writtenDate;
    private Calendar updatedDate;

    public void setWrittenDate(Timestamp writtenDate) {
        this.writtenDate = Calendar.getInstance();
        this.writtenDate.setTime(writtenDate);
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = Calendar.getInstance();
        this.updatedDate.setTime(updatedDate);
    }

    public boolean equals(Object o) {
        if(o instanceof ReviewDTO) {
            ReviewDTO r = (ReviewDTO) o;
            return id == r.id;
        }
        return false;
    }
}
