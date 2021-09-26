package by.konovalchik.servlets;

import by.konovalchik.entity.User;
import by.konovalchik.services.facade.CalculatorFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ChangeNameServlet", urlPatterns = "/name" )
public class ChangeNameServlet extends HttpServlet {
    private static final CalculatorFacade facade = new CalculatorFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/name.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("newName");
        User user = (User) req.getSession().getAttribute("user");

        facade.changeUserName(user.getEmail(), newName);
        user.setName(newName);
        req.getSession().setAttribute("user", user);
        req.setAttribute("messageName", "Name was changed!");
        getServletContext().getRequestDispatcher("/name.jsp").forward(req, resp);

    }
}
