package io.turntabl.tcmsProjects.dao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.tcmsProjects.extra.DBVariables;
import io.turntabl.tcmsProjects.pubsub.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.*;


import javax.sql.DataSource;
import java.util.List;
@Api
@RestController
public class ProjectDAOI implements ProjectDAO{

     @Autowired
     JdbcTemplate jdbcTemplate;



    @ApiOperation("Get all Projects")
    @GetMapping("/api/v1/projects")
    @Override
    public List<ProjectTO> getAllProjects() {
        return jdbcTemplate.query(DBVariables.GET_ALL_PROJECTS, BeanPropertyRowMapper.newInstance(ProjectTO.class));
    }
    @ApiOperation("Get Project by name")
    @GetMapping("/api/v1/projects/search")
    @Override
    public List<ProjectTO> searchProjectByName(@RequestParam(value = "project_name") String project_name) {
        Publisher.publis("projects", "Searched for project: " + project_name);
        return this.jdbcTemplate.query(
                "select * from projects where project_name like '%"+project_name+"%'",
                new BeanPropertyRowMapper<ProjectTO>(ProjectTO.class));
    }

    @ApiOperation("Add a new project")
    @PostMapping("/api/v1/projects")
    @Override
    public void addNewProject(ProjectTO project) {
        this.jdbcTemplate.update(
                DBVariables.ADD_NEW_PROJECT, project.getProject_id(), project.getProject_name(), project.getProject_description());
        Publisher.publis("new_project", "Added new Project " + project.getProject_name());
    }
    @ApiOperation("Update a project")
    @PutMapping("/api/v1/projects/{id}")
    @Override
    public void updateProjectInfo(@PathVariable("id") Integer id, ProjectTO project) {
        this.jdbcTemplate.update(
                DBVariables.UPDATE_PROJECT, project.getProject_name(), project.getProject_description(), project.getProject_id());
        Publisher.publis("update", "Updated a Project with id " + id);
    }

    @ApiOperation("delete a project")
    @DeleteMapping("/api/v1/projects/{id}")
    @Override
    public void deleteProjectById(@PathVariable("id") Integer id) {
        this.jdbcTemplate.update(DBVariables.DELETE_PROJECT, id);
        Publisher.publis("remove", "Removed a Project with id " + id);
    }
}
