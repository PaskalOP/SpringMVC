package com.example.SpringMVC;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "notes")
public class NoteEntity {
    @Id
    private long id;
    @Column
    private String title;
    @Column
    private String content;

    public NoteEntity(){}
    public NoteEntity(String title, String content){
        this.id = UUID.randomUUID().getLeastSignificantBits();
        this.title=title;
        this.content = content;

    }

}
