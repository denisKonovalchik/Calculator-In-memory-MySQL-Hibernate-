package by.konovalchik.servlets;

import by.konovalchik.dao.UsersDAOImp;
import by.konovalchik.entity.Address;
import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import by.konovalchik.services.AuthorizationUserService;
import by.konovalchik.services.facade.CalculatorFacade;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "AuthorizationServlet", urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {
    private static final CalculatorFacade facade = new CalculatorFacade();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> user = facade.authorizationUser(email, password);
        if(user.isPresent()){
            List<Address> addresses = facade.showAddresses(user.get().getEmail());
            List<Telephone> telephones = facade.showTelephones(user.get().getEmail());
            req.getSession().setAttribute("user", user.get());
            req.getSession().setAttribute("addresses", addresses);
            req.getSession().setAttribute("telephones", telephones);
            resp.sendRedirect(req.getContextPath() + "/calculation");
        }else {
            req.setAttribute("message", "User not found!");
            getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
        }
    }
}
