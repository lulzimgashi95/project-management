package controllers;

import models.Note;
import services.NoteService;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by LulzimG on 21/12/16.
 */
@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getNotes(Model model, @RequestParam String projectId) {
        List<Note> notesForProject = noteService.getNotesForProject(projectId);

        model.addAttribute("notes", notesForProject);
        model.addAttribute("projectId",projectId);
        return "notes";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNote(@ModelAttribute Note note, MultipartFile file, String projectId) {


        String encoded = null;
        try {
            encoded = Base64.encode(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        note.setImage(encoded);
        String result = noteService.insertNote(note, projectId);

        return "redirect:/project/" + projectId;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeNote(@RequestParam String noteId, @RequestParam String projectId) {

        noteService.removeNote(noteId);
        return "redirect:/note?projectId=" + projectId;
    }

}
