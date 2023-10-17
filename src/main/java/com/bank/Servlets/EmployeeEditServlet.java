package com.bank.Servlets;

import com.bank.DAO.AgencyDAO;
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

@WebServlet("/employee/edit/*")
public class EmployeeEditServlet extends HttpServlet {
    @Inject
    private EmployeeService employeeService;
    @Inject
    private EmployeeDAOImpl employeeDao;
    @Inject
    private AgencyDAO agencyDao;

    @Inject
    private AgencyEmployeeDAOImpl agencyEmployeeDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int matricule = Integer.parseInt(req.getPathInfo().substring(1));
        try{
            Employee emp = employeeDao.findByRegistrationNbr(matricule).get();
            if(emp == null)
                resp.sendRedirect(req.getContextPath());
            List<Agency> list1 = agencyDao.find().get();
            req.setAttribute("employee", emp);
            req.setAttribute("agencies", list1);
            req.getRequestDispatcher("/employeeEdit.jsp").forward(req, resp);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int matricule = Integer.parseInt(req.getPathInfo().substring(1));
        try{
            Employee emp = employeeDao.findByRegistrationNbr(matricule).get();
            if(emp == null)
                resp.sendRedirect(req.getContextPath());
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String birthDay = req.getParameter("birthDay");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            String dateOfRecrutement = req.getParameter("dateOfRecrutement");
            String agencyCode = req.getParameter("agencyCode");
            String agencyDate = req.getParameter("agencyDate");
            emp.setFirstName(firstName);
            emp.setLastName(lastName);
            emp.setBirthDay(LocalDate.parse(birthDay));
            emp.setPhone(phone);
            emp.setAddress(address);
            emp.setDateOfRecrutment(LocalDate.parse(dateOfRecrutement));
            System.out.println(emp.getFirstName());
            if(employeeService.updateEmployee(emp) != null)
                resp.sendRedirect(req.getContextPath()+"/employee");
            if(emp.getAgency().getCode().equals(agencyCode) == false && agencyDate.isEmpty() == false){
                emp.setAgency(agencyDao.findByCode(agencyCode).get());
                agencyEmployeeDao.create(
                        emp.getRegistrationNbr(),
                        agencyCode,
                        LocalDate.parse(agencyDate)
                        );
            }
            req.getRequestDispatcher("/employee.jsp").forward(req, resp);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
