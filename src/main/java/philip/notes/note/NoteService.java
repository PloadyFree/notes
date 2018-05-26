package philip.notes.note;

import java.util.List;

public interface NoteService {

    List<Note> findAllByAuthor(String username);
    void save(Note note);
    void remove(int noteId);
}