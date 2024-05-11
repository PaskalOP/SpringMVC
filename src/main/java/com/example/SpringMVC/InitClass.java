package com.example.SpringMVC;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class InitClass {
    NotesService noteService;

    public InitClass (NotesService noteService){
        this.noteService = noteService;
    }
    NoteEntity note2 = new NoteEntity("Day 1","It was good day");
    NoteEntity note3 = new NoteEntity("Day 2","The weather was rainy");
    NoteEntity note4 = new NoteEntity("Day 3","I want ice-cream, but I am at diet");
    @PostConstruct
    public void init(){

        System.out.println("Init");

    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("I am dead");
    }
}
