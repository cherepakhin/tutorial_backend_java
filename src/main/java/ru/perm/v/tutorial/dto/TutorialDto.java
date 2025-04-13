package ru.perm.v.tutorial.dto;

import java.util.Objects;

public class TutorialDto {
    private Long n;
    private String title = "";
    private String description = "";
    private Boolean published = false;
    private Boolean submitted = false;

    public TutorialDto() {
        super();
    }

    public TutorialDto(Long n) {
        this();
        this.n = n;
    }

    public TutorialDto(Long n, String title, String description, Boolean published, Boolean submitted) {
        this.n = n;
        this.title = title;
        this.description = description;
        this.published = published;
        this.submitted = submitted;
    }

    public Long getN() {
        return n;
    }

    public void setN(Long n) {
        this.n = n;
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

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
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
        if (!(o instanceof TutorialDto)) return false;
        TutorialDto that = (TutorialDto) o;
        return Objects.equals(n, that.n) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(published, that.published) && Objects.equals(submitted, that.submitted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, title, description, published, submitted);
    }

    @Override
    public String toString() {
        return "TutorialDto{" +
                "n=" + n +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                ", submitted=" + submitted +
                '}';
    }
}
