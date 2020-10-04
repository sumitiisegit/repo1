package com.timesangle.app.entity;

import javax.persistence.*;

@Entity

@Table(name = "Language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="lang_id")
    private Long id;

    @Column(name="lang_name")
    private String languageName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id='" + id + '\'' +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
