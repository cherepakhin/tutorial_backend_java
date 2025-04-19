package ru.perm.v.tutorial.critery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TutorialCritery {
    private List<Long> nn = new ArrayList<>();
    private String title = "%";
    private String description = "";
    private Boolean submitted;

    private TutorialSortBy sortBy = TutorialSortBy.N;

    public TutorialSortBy getSortBy() {
        return sortBy;
    }

    public void setSortBy(TutorialSortBy sortBy) {
        this.sortBy = sortBy;
    }

    public List<Long> getNn() {
        return nn;
    }

    public void setNn(List<Long> nn) {
        this.nn = nn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TutorialCritery)) return false;
        TutorialCritery that = (TutorialCritery) o;
        return Objects.equals(nn, that.nn) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(submitted, that.submitted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nn, title, description, submitted);
    }
}
