package com.example.SpringMVC;

import com.example.SpringMVC.Note.Note;
import com.example.SpringMVC.Note.NoteService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;

@Service
public class InitClass {
    NoteService noteService;
    public InitClass (NoteService noteService){
        this.noteService = noteService;
    }
    Note note2 = new Note("Day 1","It was good day");
    Note note3 = new Note("Day 2","The weather was rainy");
    Note note4 = new Note("Day 3","I want ice-cream, but I am at diet");
    @PostConstruct
    public void init(){
        noteService.add(note2);

    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("I am dead");
    }
}
