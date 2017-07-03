package com.howtodoinjava.demo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.EmployeeVO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    public List<EmployeeVO> getAllEmployees() {
        List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/webapp", "root", "t_miss_h");
            Statement sm = ct.createStatement();
            ResultSet rs = sm.executeQuery("select * from wikidoc ");
            while (rs.next()) {
                EmployeeVO em = new EmployeeVO();
                em.setFirstName(rs.getString(3));
                em.setId(rs.getInt(1));
                em.setLastName(rs.getString(2));
                employees.add(em);
            }
            return employees;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
//		EmployeeVO vo1 = new EmployeeVO();
//		vo1.setId(1);
//		vo1.setFirstName("Lokesh");
//		vo1.setLastName("Gupta");
//		employees.add(vo1);
//
//		EmployeeVO vo2 = new EmployeeVO();
//		vo2.setId(2);
//		vo2.setFirstName("Raj");
//		vo2.setLastName("Kishore");
//		employees.add(vo2);
//
//		return employees;
    }
}