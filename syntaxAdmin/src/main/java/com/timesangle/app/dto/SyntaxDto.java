package com.timesangle.app.dto;

import java.util.Objects;

public class SyntaxDto{

    private String id;
    private String langVersionId;
    private String langConstructMappingId;
    private String syntaxData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLangVersionId() {
        return langVersionId;
    }

    public void setLangVersionId(String langVersionId) {
        this.langVersionId = langVersionId;
    }

    public String getLangConstructMappingId() {
        return langConstructMappingId;
    }

    public void setLangConstructMappingId(String langConstructMappingId) {
        this.langConstructMappingId = langConstructMappingId;
    }

    public String getSyntaxData() {
        return syntaxData;
    }

    public void setSyntaxData(String syntaxData) {
        this.syntaxData = syntaxData;
    }

    @Override
    public String toString() {
        return "SyntaxDto{" +
                "id='" + id + '\'' +
                ", langVersionId='" + langVersionId + '\'' +
                ", langConstructMappingId='" + langConstructMappingId + '\'' +
                ", syntaxData='" + syntaxData + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SyntaxDto syntaxDto = (SyntaxDto) o;
        return Objects.equals(id, syntaxDto.id) &&
                Objects.equals(langVersionId, syntaxDto.langVersionId) &&
                Objects.equals(langConstructMappingId, syntaxDto.langConstructMappingId) &&
                Objects.equals(syntaxData, syntaxDto.syntaxData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, langVersionId, langConstructMappingId, syntaxData);
    }

    public SyntaxDto(String id, String langVersionId, String langConstructMappingId, String syntaxData) {
        super();
        this.id = id;
        this.langVersionId = langVersionId;
        this.langConstructMappingId = langConstructMappingId;
        this.syntaxData = syntaxData;
    }

    public SyntaxDto() {
        super();
    }
}
