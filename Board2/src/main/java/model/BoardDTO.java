package model;

import java.util.Calendar;

public class BoardDTO {
    private int id;
    private int writerId;
    private String title;
    private String content;
    private Calendar writtenDate;
    private Calendar updatedDate;

    
    public Calendar getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Calendar writtenDate) {
		this.writtenDate = writtenDate;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object o) {
        if (o instanceof BoardDTO) {
            BoardDTO b = (BoardDTO) o;
            return id == b.id;
        }
        return false;
    }
}
