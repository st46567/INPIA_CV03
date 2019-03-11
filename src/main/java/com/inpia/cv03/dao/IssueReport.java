package com.inpia.cv03.dao;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class IssueReport {

    @Id
    @GeneratedValue
    private long id;

    private String description;
    private String url;
    private String email;

    @ManyToOne(optional = false)
    private User user;

    public IssueReport() {
    }

    public IssueReport(String description, String url) {
        this.description = description;
        this.url = url;
    }

    public IssueReport(String description, String url, String email) {
        this.description = description;
        this.url = url;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
