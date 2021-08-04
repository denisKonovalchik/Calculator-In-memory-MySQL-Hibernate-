package by.konovalchik.servlets;

import by.konovalchik.dao.LogOperationsDAO;
import by.konovalchik.dao.LogOperationsDAOImp;
import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "logOperationsServlet", urlPatterns = "/logHistory")
public class LogOperationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LogOperationsDAO log = new LogOperationsDAOImp();
        User user = (User) req.getSession().getAttribute("user");
        String login = user.getLogin();
        List<Operation> history = log.showLogsByLogin(login);
        req.setAttribute("history", history);
        getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }
}
