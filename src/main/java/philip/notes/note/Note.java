package philip.notes.note;

import lombok.*;
import philip.notes.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "note", schema = "public")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "noteId")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noteId;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    private LocalDateTime created;
    private String text;
}