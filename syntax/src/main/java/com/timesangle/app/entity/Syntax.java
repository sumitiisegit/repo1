package com.timesangle.app.entity;

import com.timesangle.app.dto.SyntaxDto;

import javax.persistence.*;

@Entity
@Table(name = "Syntax")
@NamedQuery(name = "Syntax.findAll", query = "select s from Syntax s")
public class Syntax{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sid")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SyntaxDto convertToSyntaxDto(){
        SyntaxDto syntaxDto = new SyntaxDto();
        syntaxDto.setId(this.getId());
        syntaxDto.setName(this.getName());

        return  syntaxDto;
    }

    @Override
    public String toString() {
        return "Syntax{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
