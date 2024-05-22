package com.example.jspdemo02mvc2.da;

import com.example.jspdemo02mvc2.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/t2210m";
    private String jdbcUserName = "root";
    private String jdbcPassword = "";
    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employees" + "(fullName, birthday, address, Position, Department) VALUES " +
            "(?,?,?,?,?);";
    private static final String SELECT_ALL_USERS_SQL = "SELECT * FROM employees";

    public EmployeeDAO() {
    }

    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        return conn;
    }

    public void insertEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEES_SQL);
        ps.setString(1, employee.getFullName());
        ps.setString(2, employee.getBirthday());
        ps.setString(3, employee.getAddress());
        ps.setString(4, employee.getPosition());
        ps.setString(5, employee.getDepartment());
        ps.executeUpdate();
    }

    public List< Employee > selectAllEmployee() throws SQLException, ClassNotFoundException {
        List< Employee > employees = new ArrayList< >();
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(SELECT_ALL_USERS_SQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String fullName = rs.getString("fullName");
            String birthday = rs.getString("birthday");
            String address = rs.getString("address");
            String Position = rs.getString("Position");
            String Department = rs.getString("Department");
            employees.add(new Employee(fullName, birthday, address, Position, Department));
        }
        return employees;
    }
}


