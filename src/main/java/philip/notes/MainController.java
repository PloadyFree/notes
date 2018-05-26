package philip.notes;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import philip.notes.note.Note;
import philip.notes.note.NoteService;
import philip.notes.user.User;
import philip.notes.user.UserService;

import java.time.LocalDateTime;
import java.util.Map;

@Component
@Controller
@AllArgsConstructor
public class MainController {

    private static final String VIEWS_HOME = "/notes";
    private static final String VIEWS_REGISTRATION = "/register";
    private static final String VIEWS_LOGIN = "/login";
    private static final String VIEWS_REDIRECT_HOME = "redirect:" + VIEWS_HOME;
    private final UserService userService;
    private final NoteService noteService;

    @GetMapping("/register")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return VIEWS_REGISTRATION;
    }

    @PostMapping("/register")
    public String register(@RequestParam Map<String, String> body) {
        userService.register(body.get("username"), body.get("password"));
        return VIEWS_REDIRECT_HOME;
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return VIEWS_LOGIN;
    }

    @RequestMapping({"/notes", "/"})
    public String allNotes(@AuthenticationPrincipal UserDetails user, Model model) {
        model.addAttribute("notes", noteService.findAllByAuthor(user.getUsername()));
        model.addAttribute("newNote", new Note());
        return VIEWS_HOME;
    }

    @RequestMapping("/notes/{noteId}/remove")
    public String remove(@PathVariable int noteId) {
        noteService.remove(noteId);
        return VIEWS_REDIRECT_HOME;
    }

    @RequestMapping("/notes/create")
    public String create(Note note, @AuthenticationPrincipal UserDetails user) {
        note.setAuthor(new User().withUsername(user.getUsername()));
        note.setCreated(LocalDateTime.now());
        noteService.save(note);
        return VIEWS_REDIRECT_HOME;
    }
}