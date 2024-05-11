package com.example.SpringMVC;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface NotesRepository extends JpaRepository<NoteEntity,Long> {
}
