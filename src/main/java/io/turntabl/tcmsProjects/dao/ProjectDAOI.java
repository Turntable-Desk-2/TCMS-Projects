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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


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
    @GetMapping("/api/v1/projectbyname")
    @Override
    public List<ProjectTO> searchProjectByName(String project_name) {
        return this.jdbcTemplate.query(
                "select * from projects where project_name like '%"+project_name+"%'",
                new BeanPropertyRowMapper<ProjectTO>(ProjectTO.class));
    }

    @ApiOperation("Add a new project")
    @GetMapping("/api/v1/newproject")
    @Override
    public void addNewProject(ProjectTO project) {
                this.jdbcTemplate.update(
                "insert into projects(project_id, project_name, project_description) values(?,?,?)", project.getProject_id(), project.getProject_name(), project.getProject_description());

    }
    @ApiOperation("Update a project")
    @GetMapping("/api/v1/projectupdate")
    @Override
    public void updateProjectInfo(ProjectTO project) {
        this.jdbcTemplate.update(
                "update projects set project_name = ?, project_description = ? where project_id = ?", project.getProject_name(), project.getProject_description(), project.getProject_id());
    }

    @ApiOperation("delete a project")
    @GetMapping("/api/v1/projectdelete")
    @Override
    public void deleteProjectById(ProjectTO project) {
        this.jdbcTemplate.update("delete from projects where project_id = ?", project.getProject_id());
    }
}
