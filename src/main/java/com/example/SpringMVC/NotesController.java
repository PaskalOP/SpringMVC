package com.example.SpringMVC;

import com.example.SpringMVC.response.MapperNote;
import com.example.SpringMVC.response.NoteDTO;
import com.example.SpringMVC.response.ResponseNoteDTO;
import com.example.SpringMVC.response.ResponseOKMessege;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NotesController {
    private final NotesService noteService;
    private final MapperNote mapperNote;
    @GetMapping("/list")
    public ResponseEntity<List<ResponseNoteDTO>>getAllNotes(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapperNote.toNoteResponses(noteService.listAll()));
    }

//    @GetMapping("/list")
//    public ModelAndView getAllNotes(){
//        ModelAndView result = new ModelAndView("all-notes");
//        result.addObject("listNotes",noteService.listAll());
//        return result;
//
//    }

    @DeleteMapping ("/delete")
    public ResponseEntity<ResponseOKMessege>deleteNote(@RequestParam  Long id){
        noteService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapperNote.forStatusResponse("Your note is deleted"));

    }
    @GetMapping("/edit/{id}")
    public ResponseEntity<ResponseNoteDTO> getNoteForEdit(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapperNote.toResponseDTO(noteService.getNodeById(id)));
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView getNoteForEdit(@PathVariable Long id){
//        ModelAndView result = new ModelAndView("edit-note");
//        result.addObject("note",noteService.getNodeById(id));
//        return result;
//
//    }
    @PostMapping("/edit")
    public ResponseEntity<ResponseOKMessege> editNote(@RequestParam Long id, @RequestParam String title, @RequestParam String content){
        noteService.changeNote(id, title,content);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapperNote.forStatusResponse("You note is changed"));
    }

//    @PostMapping("/edit")
//    public String editNote(@RequestParam Long id, @RequestParam String title, @RequestParam String content){
//        noteService.changeNote(id, title,content);
//        return "redirect:/note/list";
//    }
    @GetMapping("/add")
    public ResponseEntity<ResponseOKMessege>getPageForAdding(){
        return ResponseEntity.status(HttpStatus.OK).body(mapperNote.forStatusResponse("You can add new note"));
    }

//    @GetMapping("/add")
//    public ModelAndView getPageForAdding(){
//        return new ModelAndView("addNewNote");
//    }

    @PostMapping("/addNote")
    public ResponseEntity<ResponseNoteDTO> addNewNote (@RequestBody NoteDTO noteDTO){
       NoteEntity note = mapperNote.fromNoteDTO(noteDTO);
        noteService.add(note);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapperNote.toResponseDTO(note));
    }

//    @PostMapping("/addNote")
//    public String addNewNote(@RequestParam String title, @RequestParam String content){
//        NoteEntity newNote = new NoteEntity(title,content);
//        noteService.add(newNote);
//        return "redirect:/note/list";
//    }
}
