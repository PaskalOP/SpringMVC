package com.example.SpringMVC.note;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    private long id;
    @Column
    private String title;
    @Column
    private String content;

    public Note(){}
    public Note (String title, String content){
        this.id = UUID.randomUUID().getLeastSignificantBits();
        this.title=title;
        this.content = content;

    }

}
