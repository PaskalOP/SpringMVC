package com.example.SpringMVC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NotesController {
    private final NotesService noteService;
    @GetMapping("/list")
    public ModelAndView getAllNotes(){
        ModelAndView result = new ModelAndView("all-notes");
        result.addObject("listNotes",noteService.listAll());
        return result;

    }
    @PostMapping ("/delete")
    public String deleteNote(@RequestParam  Long id){
        noteService.deleteById(id);
        return "redirect:/note/list";

    }
    @GetMapping("/edit/{id}")
    public ModelAndView getNoteForEdit(@PathVariable Long id){
        ModelAndView result = new ModelAndView("edit-note");
        result.addObject("note",noteService.getNodeById(id));
        return result;

    }
    @PostMapping("/edit")
    public String editNote(@RequestParam Long id, @RequestParam String title, @RequestParam String content){
        noteService.changeNote(id, title,content);
        return "redirect:/note/list";
    }
    @GetMapping("/add")
    public ModelAndView getPageForAdding(){
        return new ModelAndView("addNewNote");
    }

    @PostMapping("/addNote")
    public String addNewNote(@RequestParam String title, @RequestParam String content){
        NoteEntity newNote = new NoteEntity(title,content);
        noteService.add(newNote);
        return "redirect:/note/list";
    }
}