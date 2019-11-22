package io.turntabl.tcmsProjects.extra;

public class DBVariables {
    public static String ADD_NEW_PROJECT = "insert into projects(project_id, project_name, project_description) values(?,?,?)";
    public static String GET_ALL_PROJECTS = "select * from projects";
    public static String UPDATE_PROJECT = "update projects set project_name = ?, project_description = ? where project_id = ?";
    public static String DELETE_PROJECT = "delete from projects where project_id = ?";
}
