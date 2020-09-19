package com.timesangle.app.entity;

import com.timesangle.app.dto.SyntaxDto;

import javax.persistence.*;

@Entity
@Table(name = "Syntax")
@NamedQuery(name = "Syntax.findAll", query = "select s from Syntax s")
public class Syntax{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "syntax_id")
    private String id;

    @Column(name = "lang_version_id")
    private String langVersionId;

    @Column(name = "lang_construct_mapping_id")
    private String langConstructMappingId;

    @Column(name = "syntax_data")
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

    public SyntaxDto convertToSyntaxDto(){
        SyntaxDto syntaxDto = new SyntaxDto();
        syntaxDto.setId(this.getId());
        syntaxDto.setSyntaxData(this.getSyntaxData());
        syntaxDto.setLangConstructMappingId(this.getLangConstructMappingId());
        syntaxDto.setLangVersionId(this.langVersionId);

        return  syntaxDto;
    }


    @Override
    public String toString() {
        return "Syntax{" +
                "id='" + id + '\'' +
                ", langVersionId='" + langVersionId + '\'' +
                ", langConstructMappingId='" + langConstructMappingId + '\'' +
                ", syntaxData='" + syntaxData + '\'' +
                '}';
    }
}
