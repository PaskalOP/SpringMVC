package com.example.SpringMVC;

import com.example.SpringMVC.Note.Note;
import com.example.SpringMVC.Note.NoteService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

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
        noteService.add(note3);
        noteService.add(note4);
        Long id = note3.getId();
        noteService.changeNote(id,"День 3", "Все тоже самое");
        //noteService.printAllNotes();
        //noteService.printAllId();

        //System.out.println(noteService.getNodeById(5L));
        //System.out.println(noteService.getNodeById(id));
        // noteService.deleteById(id);
        // System.out.println("We delated note with id "+ id);
        //note4.setId(id);
        noteService.printAllNotes();
       // noteService.printAllId();

       // System.out.println(note4);
       // noteService.update(note4);
       // System.out.println("We update element  with id "+ id);
        //noteService.printAllNotes();
        noteService.printAllId();
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("I am dead");
    }
}
