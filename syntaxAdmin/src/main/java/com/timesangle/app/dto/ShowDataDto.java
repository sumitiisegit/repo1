package com.timesangle.app.dto;

public class ShowDataDto {

    private String id;
    private String langName;
    private String versionName;
    private String constructName;
    private String syntaxData;

    public ShowDataDto() {
    }

    public ShowDataDto(String id, String langName, String versionName, String constructName, String syntaxData) {
        this.id = id;
        this.langName = langName;
        this.versionName = versionName;
        this.constructName = constructName;
        this.syntaxData = syntaxData;
    }

    public String getId() {
        return id;
    }

    public String getLangName() {
        return langName;
    }

    public String getVersionName() {
        return versionName;
    }

    public String getConstructName() {
        return constructName;
    }

    public String getSyntaxData() {
        return syntaxData;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public void setConstructName(String constructName) {
        this.constructName = constructName;
    }

    public void setSyntaxData(String syntaxData) {
        this.syntaxData = syntaxData;
    }
}
