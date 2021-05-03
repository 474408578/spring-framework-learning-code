package com.xschen.spring.withdao.dao;

import com.xschen.spring.withdao.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author xschen
 */

@Repository
public class DepartmentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Department department) {
        return jdbcTemplate.update("insert into tbl_dept (id, name, tel) values (?, ?, ?)",
                UUID.randomUUID().toString().replaceAll("-", ""),
                department.getName(), department.getTel());
    }

    public Department findById(String id) {
        List<Department> departmentList = jdbcTemplate.queryForList(
                "select * from tbl_dept where id = ?", Department.class, id);
        return departmentList.size() > 0 ? departmentList.get(0) : null;
    }

    public List<Department> findByDepartment(Department query) {
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>();
        sql.append("select * from tbl_dept where 1 = 1");
        if (query.getId() != null) {
            sql.append(" and id = ?");
            param.add(query.getId());
        }

        if (StringUtils.hasText(query.getName())) {
            sql.append(" and name like concat('%', ?, '%')");
            param.add(query.getName());
        }

        return jdbcTemplate.query(sql.toString(),
                param.toArray(),
                new BeanPropertyRowMapper<>(Department.class));
    }

    public int deleteById(String id) {
        return jdbcTemplate.update("delete from tbl_dept where id = ?", id);
    }

    public List<Department> findAll() {
        return jdbcTemplate.query("select * from tbl_dept",
                new BeanPropertyRowMapper<>(Department.class));
    }
}
