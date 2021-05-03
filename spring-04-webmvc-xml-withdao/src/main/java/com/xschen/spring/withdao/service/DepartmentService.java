package com.xschen.spring.withdao.service;

import com.xschen.spring.withdao.dao.DepartmentDao;
import com.xschen.spring.withdao.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xschen
 */

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void save(Department department) {
        departmentDao.save(department);
    }

    public void deleteById(String id) {
        departmentDao.deleteById(id);
    }

    public List<Department> findDepartmentsByName(String name) {
        Department query = new Department();
        query.setName(name);
        return departmentDao.findByDepartment(query);
    }

    public List<Department> findDepartments(Department query) {
        if (query == null) {
            return departmentDao.findAll();
        }
        return departmentDao.findByDepartment(query);
    }

    public Department findById(String id) {
        return departmentDao.findById(id);
    }
}
