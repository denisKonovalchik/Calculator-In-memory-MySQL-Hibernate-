package by.konovalchik.servlets;

import by.konovalchik.dao.LogsOperationsDAO;
import by.konovalchik.dao.LogsOperationsDAOImp;
import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "logsOperationServlet", urlPatterns = "/logsHistory")
public class LogsOperationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LogsOperationsDAO logs = new LogsOperationsDAOImp();
        User user = (User) req.getSession().getAttribute("user");
        String login = user.getLogin();
        List<Operation> history = logs.showLogsByLogin(login);
        resp.getWriter().println(history);
        // req.setAttribute("history", history);
        //  getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);

    }

}
