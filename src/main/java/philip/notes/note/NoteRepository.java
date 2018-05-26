package philip.notes.note;

import org.springframework.data.jpa.repository.JpaRepository;
import philip.notes.user.User;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    List<Note> findAllByAuthor(User author);
}