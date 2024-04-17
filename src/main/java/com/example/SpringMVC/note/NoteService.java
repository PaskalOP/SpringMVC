package com.example.SpringMVC.note;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Data
public class NoteService {

    private final NoteRepository noteRepository;


    public List<Note> listAll(){
        return noteRepository.findAll();
    }
    public Note add(Note note){
        noteRepository.save(note);
        return note;
    }
    public Note changeNote(Long id, String title, String content){
        Note note = noteRepository.getReferenceById(id);
        note.setContent(content);
        note.setTitle(title);
        noteRepository.save(note);
        return note;
    }

    public Note getNodeById(long id){
        return noteRepository.getReferenceById(id);
    }

    public void deleteById(long id){
        noteRepository.deleteById(id);
    }
}
