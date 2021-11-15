package by.konovalchik.servlets;


import by.konovalchik.entity.User;
import by.konovalchik.services.facade.CalculatorFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", urlPatterns = "/pass")
public class ChangePasswordServlet extends HttpServlet {
   private static final CalculatorFacade facade = new CalculatorFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("old password");
        String newPassword = req.getParameter("new password");
        String confirmPassword = req.getParameter("confirm password");
        User user = (User) req.getSession().getAttribute("user");

        if(facade.changeUserPassword(oldPassword, newPassword, confirmPassword, user)) {
            user.setPassword(newPassword);
            req.setAttribute("messagePassword1", "Password was changed!");
            req.getSession().setAttribute("user", user);

        }else{
            req.setAttribute("messagePassword2", "Wrong password!");
        }
        getServletContext().getRequestDispatcher("/pass.jsp").forward(req, resp);
    }
}
