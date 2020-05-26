package com.rzk.dao;

import com.rzk.pojo.Department;
import com.rzk.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {
    //模拟数据库中的数据

    private static Map<Integer, Employee> employees=null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<>();//创建一个部门表

        employees.put(1001,new Employee(1001,"AA","282828@qq.com",1,new Department(1,"教学部")));
        employees.put(1002,new Employee(1002,"AA","282828@qq.com",0,new Department(2,"市场部")));
        employees.put(1003,new Employee(1003,"AA","282828@qq.com",1,new Department(3,"教研部")));
        employees.put(1004,new Employee(1004,"AA","282828@qq.com",0,new Department(4,"运营部")));
        employees.put(1005,new Employee(1005,"AA","282828@qq.com",1,new Department(5,"后勤部")));

    }

    //主键自增
    private static Integer initId =1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);

    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //通过id删除员工
    public void deleteEmployee(Integer id){
        employees.remove(id);
    }
}

























