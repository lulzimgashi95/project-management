package models;

import java.util.Date;

/**
 * Created by LulzimG on 21/12/16.
 */
public class Note {
    private String id;
    private String note;
    private String image;
    private Date date;
    private String projectId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", note='" + note + '\'' +
                ", image='" + image + '\'' +
                ", date=" + date +
                '}';
    }
}
