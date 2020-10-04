package com.timesangle.app.entity;

import com.timesangle.app.dto.ShowDataDto;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Immutable
@NamedQuery(name = "ShowDataView.findAll", query = "select s from ShowDataView s")
public class ShowDataView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name="lang_name")
    private String langName;

    @Column(name="version_name")
    private String versionName;

    @Column(name="construct_name")
    private String constructName;

    @Column(name="syntax_data")
    private String syntaxData;

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

    @Override
    public String toString() {
        return "ShowDataView{" +
                "id='" + id + '\'' +
                ", langName='" + langName + '\'' +
                ", VersionName='" + versionName + '\'' +
                ", constructName='" + constructName + '\'' +
                ", syntaxData=" + syntaxData +
                '}';
    }

    public ShowDataDto convertoShowDataDto(){
        ShowDataDto showDataDto = new ShowDataDto();
        showDataDto.setId(this.getId());
        showDataDto.setConstructName(this.constructName);
        showDataDto.setLangName(this.langName);
        showDataDto.setVersionName(this.versionName);
        showDataDto.setSyntaxData(this.syntaxData);

        return showDataDto;
    }
}
