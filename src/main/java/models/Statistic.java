package models;

/**
 * Created by LulzimG on 24/12/16.
 */
public class Statistic {
    private String projects;
    private String members;
    private String sponsors;

    @Override
    public String toString() {
        return "Statistic{" +
                "projects='" + projects + '\'' +
                ", members='" + members + '\'' +
                ", sponsors='" + sponsors + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getSponsors() {
        return sponsors;
    }

    public void setSponsors(String sponsors) {
        this.sponsors = sponsors;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    private String notes;


}
