package by.konovalchik.servlets;


import by.konovalchik.entity.Address;
import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import by.konovalchik.services.facade.CalculatorFacade;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    private static final CalculatorFacade facade = new CalculatorFacade();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        long number = Long.parseLong( req.getParameter("telephoneNumber"));
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        int homeNumber = Integer.parseInt(req.getParameter("homeNumber"));
        int apartNumber = Integer.parseInt(req.getParameter("apartNumber"));

        User user = new User(name, email, password);
        Telephone telephone = new Telephone(number);
        Address address = new Address(city, street, homeNumber, apartNumber);
        if(facade.registrationUser(user, address, telephone) ){
            req.setAttribute("message1","Registration successful!");
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }else{
            req.setAttribute("message2","Email already exists!");
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }
    }
}
