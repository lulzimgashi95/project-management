package services;

import models.Project;

import java.util.List;

/**
 * Created by LulzimG on 19/12/16.
 */
public interface ProjectService {
    List<Project> getAllProject();

    Project getProject(String id);

    String insertProject(Project project);

    String deleteProject(String id);
}
