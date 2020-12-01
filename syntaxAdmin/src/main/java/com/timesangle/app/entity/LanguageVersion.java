package com.timesangle.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "Language_Version")
public class LanguageVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="lang_version_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lang_id", referencedColumnName = "lang_id", insertable = true, updatable = true)
    private Language language;

    @Column(name="version_name")
    private String versionName;

    public LanguageVersion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    @Override
    public String toString() {
        return "LanguageVersion{" +
                "id=" + id +
                ", language=" + language +
                ", versionName='" + versionName + '\'' +
                '}';
    }

    public LanguageVersion(Long id, Language language, String versionName) {
        this.id = id;
        this.language = language;
        this.versionName = versionName;
    }

    public LanguageVersion(Long id, String versionName) {
        this.id = id;
        this.versionName = versionName;
    }

    public LanguageVersion(Language language, String versionName) {
        this.language = language;
        this.versionName = versionName;
    }
}
