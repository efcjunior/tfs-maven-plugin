package pojo;

import java.util.Date;

/**
 * Created by c114416 on 05/07/2016.
 */
public class Value {

    private long changesetId;
    private User author;
    private User checkedInBy;
    private Date createdDate;

    public long getChangesetId() {
        return changesetId;
    }

    public void setChangesetId(long changesetId) {
        this.changesetId = changesetId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getCheckedInBy() {
        return checkedInBy;
    }

    public void setCheckedInBy(User checkedInBy) {
        this.checkedInBy = checkedInBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
