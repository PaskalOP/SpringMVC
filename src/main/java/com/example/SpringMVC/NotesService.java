package com.example.SpringMVC;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Data
public class NotesService {

    private final NotesRepository noteRepository;


    public List<NoteEntity> listAll(){
        return noteRepository.findAll();
    }
    public NoteEntity add(NoteEntity note){
        noteRepository.save(note);
        return note;
    }
    public NoteEntity changeNote(Long id, String title, String content){
        NoteEntity note = noteRepository.getReferenceById(id);
        note.setContent(content);
        note.setTitle(title);
        noteRepository.save(note);
        return note;
    }

    public NoteEntity getNodeById(long id){
        return noteRepository.getReferenceById(id);
    }

    public void deleteById(long id){
        noteRepository.deleteById(id);
    }
}
