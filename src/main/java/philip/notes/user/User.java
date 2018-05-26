package philip.notes.user;

import lombok.*;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user", schema = "public")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "username")
public class User {

    @Id
    @Wither
    private String username;

    private String password;
}