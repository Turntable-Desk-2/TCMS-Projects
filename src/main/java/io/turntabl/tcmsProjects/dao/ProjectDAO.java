package io.turntabl.tcmsProjects.dao;

import java.util.List;

public interface ProjectDAO {
    public List<ProjectTO> getAllProjects();
    public List<ProjectTO> searchProjectByName(String project_name);
    public void addNewProject();
    public void updateProjectInfo();
    public void deleteProjectById(int id);

}
