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
    @ApiOperation("Get by name")
    @GetMapping("/api/v1/projectbyname")
    @Override
    public List<ProjectTO> searchProjectByName(String project_name) {
        return this.jdbcTemplate.query(
                "select * from projects where project_name like '%"+project_name+"%'",
                new BeanPropertyRowMapper<ProjectTO>(ProjectTO.class));
    }

    @Override
    public void addNewProject() {

    }

    @Override
    public void updateProjectInfo() {

    }

    @Override
    public void deleteProjectById(int id) {

    }
}
