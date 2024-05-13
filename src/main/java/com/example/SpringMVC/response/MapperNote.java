package com.example.SpringMVC.response;

import com.example.SpringMVC.NoteEntity;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class MapperNote {
    public ResponseNoteDTO toResponseDTO(NoteEntity note){
        if(note==null){
            throw new  NullPointerException ("Note is null");
        }
        ResponseNoteDTO responseDTO = new ResponseNoteDTO();
        responseDTO.setId(note.getId());
        responseDTO.setTitle(note.getTitle());
        responseDTO.setContent(note.getContent());
        return responseDTO;
    }
    public List<ResponseNoteDTO> toNoteResponses(List<NoteEntity> notes){
        return notes.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
    public ResponseOKMessege forStatusResponse(String message){
        ResponseOKMessege response = new ResponseOKMessege();
        response.setStatus("OK");
        response.setMassage(message);
        return response;
    }
    public NoteEntity fromNoteDTO(NoteDTO noteDTO){
        return new NoteEntity(noteDTO.getTitle(),noteDTO.getContent());
    }
}
