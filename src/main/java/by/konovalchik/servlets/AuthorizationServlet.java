package by.konovalchik.servlets;

import by.konovalchik.entity.User;
import by.konovalchik.dao.UsersDAO;
import by.konovalchik.dao.UsersDAOImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersDAO daoUser = new UsersDAOImp();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User userLog = new User(login,password);

        if(daoUser.getUsers().contains(userLog)) {
            User user = daoUser.getUserByLogin(login);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/calculation");
        }else{
            resp.sendRedirect(req.getContextPath() + "/main");
        }
    }
}
