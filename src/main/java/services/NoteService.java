package services;

import models.Note;

import java.util.List;

/**
 * Created by LulzimG on 22/12/16.
 */
public interface NoteService {
    List<Note> getNotesForProject(String projectId);

    String insertNote(Note note, String projectId);

    String removeNote(String id);
}
