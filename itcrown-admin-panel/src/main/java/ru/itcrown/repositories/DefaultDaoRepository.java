package ru.itcrown.repositories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DefaultDaoRepository {

    protected DataSource dataSource;
    protected JdbcTemplate jdbcTemplateObject;

}
