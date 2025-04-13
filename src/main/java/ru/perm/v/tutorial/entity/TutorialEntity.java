package ru.perm.v.tutorial.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tutorial")
public class TutorialEntity {
    @Id
    @Column(name = "n", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // имя "n" , не "id" , т.к. в нектр. БД слово id ключевое
    private Long n;
    @Column(name = "title", columnDefinition = "varchar(255) default ''")
    private String title = "";
    @Column(name = "description", columnDefinition = "varchar(255) default ''")
    private String description = "";
    @Column(name = "published", columnDefinition = "boolean default false", nullable = false)
    private Boolean published = false;
    @Column(name = "submitted", columnDefinition = "boolean default false", nullable = false)
    private Boolean submitted = false;

    public TutorialEntity() {
    }

    public TutorialEntity(long n) {
        super();
        this.n = n;
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
        if (!(o instanceof TutorialEntity)) return false;
        TutorialEntity that = (TutorialEntity) o;
        return Objects.equals(n, that.n) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(published, that.published) && Objects.equals(submitted, that.submitted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, title, description, published, submitted);
    }
}
