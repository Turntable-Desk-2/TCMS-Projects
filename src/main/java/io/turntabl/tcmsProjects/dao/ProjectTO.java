package io.turntabl.tcmsProjects.dao;

public class ProjectTO {
    private int project_id;
    private String project_name;
    private String project_description;

    public ProjectTO() {
    }

    public ProjectTO(int project_id, String project_name, String project_description) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_description = project_description;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }
}
