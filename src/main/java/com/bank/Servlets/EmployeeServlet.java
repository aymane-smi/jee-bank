package com.bank.Servlets;

import com.bank.DAO.AgencyDAOImpl;
import com.bank.DAO.AgencyEmployeeDAOImpl;
import com.bank.DAO.EmployeeDAOImpl;
import com.bank.Entity.Agency;
import com.bank.Entity.Employee;
import com.bank.Service.AgencyService;
import com.bank.Service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/employee")

public class EmployeeServlet extends HttpServlet {
    @Inject
    private EmployeeService employeeService;
    @Inject
    private AgencyDAOImpl agencyDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> list = employeeService.findAll();
        List<Agency> list1 = agencyDao.find().get();
        req.setAttribute("employees", list);
        req.setAttribute("agencies", list1);
        req.getRequestDispatcher("/employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthDay = req.getParameter("birthDay");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String dateOfRecrutment = req.getParameter("dateOfRecrutement");
        String agencyCode = req.getParameter("agencyCode");
        String agencyDate = req.getParameter("agencyDate");
        System.out.println(dateOfRecrutment);
        Employee emp = new Employee(
                firstName,
                lastName,
                LocalDate.parse(birthDay),
                phone,
                address,
                0,
                LocalDate.parse(dateOfRecrutment)
                );
        emp.setAgency(agencyDao.findByCode(agencyCode).get());
        try{
            employeeService.addEmployee(emp, LocalDate.parse(agencyDate));
            resp.sendRedirect(req.getContextPath()+"/employee");
        }catch(Exception e){
            resp.sendRedirect(req.getContextPath());
        }
    }
}
