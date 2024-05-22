package com.example.jspdemo02mvc2.controller;

import com.example.jspdemo02mvc2.da.EmployeeDAO;
import com.example.jspdemo02mvc2.entity.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    public void init() {employeeDAO = new EmployeeDAO();}


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(req,resp);
                    break;
                case "/insert":
                    insertEmployee(req,resp);
                    break;
                default:
                    listUsers(req,resp);
                    break;
            }
        }catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listUsers(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Employee> listUser = employeeDAO.selectAllEmployee();
        req.setAttribute("listEmployee", listUser);
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
        dispatcher.forward(req,resp);
    }
    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException, ClassNotFoundException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("employee-form.jsp");
        dispatcher.forward(req,resp);
    }
    private void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException, ClassNotFoundException {
        String fullName = req.getParameter("fullName");
        String birthday = req.getParameter("birthday");
        String address = req.getParameter("address");
        String Position = req.getParameter("Position");
        String Department = req.getParameter("Department");
        Employee newEmployee = new Employee(fullName, birthday, address, Position, Department);
        employeeDAO.insertEmployee(newEmployee);
        resp.sendRedirect("");
    }
}
