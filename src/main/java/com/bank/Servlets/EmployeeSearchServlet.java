package com.bank.Servlets;

import com.bank.DAO.EmployeeDAOImpl;
import com.bank.Entity.Agency;
import com.bank.Entity.Employee;
import com.bank.Service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "EmployeeSearchServlet", value = "/employee/search")
public class EmployeeSearchServlet extends HttpServlet {
    @Inject
    private EmployeeService employeeService;
    @Inject
    private EmployeeDAOImpl employeeDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/employeeSearch.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int matricule = Integer.parseInt(req.getParameter("searchMatricule"));
        try{
            Optional<Employee> emp = employeeDao.findByRegistrationNbr(matricule);
            if(emp.isPresent() == false)
                resp.sendRedirect(req.getContextPath());
            else{
                req.setAttribute("employee", emp.get());
                req.getRequestDispatcher("/employeeSearch.jsp").forward(req, resp);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}