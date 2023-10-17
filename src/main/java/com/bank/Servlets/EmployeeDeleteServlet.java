package com.bank.Servlets;

import com.bank.DAO.EmployeeDAOImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "EmployeeDeleteServlet", value = "/employee/delete/*")
public class EmployeeDeleteServlet extends HttpServlet {
    @Inject
    private EmployeeDAOImpl employeeDao;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int matricule = Integer.parseInt(request.getPathInfo().substring(1));
        if(employeeDao.delete(matricule) == 1)
            response.sendRedirect(request.getContextPath());
    }
}