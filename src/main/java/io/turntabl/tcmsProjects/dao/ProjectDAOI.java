package io.turntabl.tcmsProjects.dao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
        return jdbcTemplate.query("select * from projects", BeanPropertyRowMapper.newInstance(ProjectTO.class));
    }
    @ApiOperation("Get Project by name")
    @GetMapping("/api/v1/projects/search")
    @Override
    public List<ProjectTO> searchProjectByName(@RequestParam(value = "project_name") String project_name) {
        return this.jdbcTemplate.query(
                "select * from projects where project_name like '%"+project_name+"%'",
                new BeanPropertyRowMapper<ProjectTO>(ProjectTO.class));
    }

    @ApiOperation("Add a new project")
    @PostMapping("/api/v1/projects")
    @Override
    public void addNewProject(ProjectTO project) {
                this.jdbcTemplate.update(
                "insert into projects(project_id, project_name, project_description) values(?,?,?)", project.getProject_id(), project.getProject_name(), project.getProject_description());

    }
    @ApiOperation("Update a project")
    @PutMapping("/api/v1/projects/{id}")
    @Override
    public void updateProjectInfo(@PathVariable("id") Integer id, ProjectTO project) {
        this.jdbcTemplate.update(
                "update projects set project_name = ?, project_description = ? where project_id = ?", project.getProject_name(), project.getProject_description(), project.getProject_id());
    }

    @ApiOperation("delete a project")
    @DeleteMapping("/api/v1/projects/{id}")
    @Override
    public void deleteProjectById(@PathVariable("id") Integer id) {
        this.jdbcTemplate.update("delete from projects where project_id = ?", id);
    }
}
