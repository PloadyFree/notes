package philip.notes.note;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import philip.notes.user.User;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public List<Note> findAllByAuthor(String username) {
        return noteRepository.findAllByAuthor(User.builder().username(username).build());
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(int noteId) {
        noteRepository.delete(new Note(noteId, null, null, null));
    }
}