package by.konovalchik.servlets;

import by.konovalchik.dao.LogOperationsDAOImp;
import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;
import by.konovalchik.services.LogOperationsService;
import by.konovalchik.services.facade.CalculatorFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "logOperationsServlet", urlPatterns = "/history")
public class LogOperationsServlet extends HttpServlet {
    private static final  CalculatorFacade facade = new CalculatorFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        int valuesPage = 5;

        User user = (User) req.getSession().getAttribute("user");
        List<Operation> list = facade.showUserHistory(user.getEmail(), page, valuesPage);
        req.setAttribute("history", list);
        getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }

}
