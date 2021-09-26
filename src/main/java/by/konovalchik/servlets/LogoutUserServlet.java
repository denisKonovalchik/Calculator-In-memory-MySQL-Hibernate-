package by.konovalchik.servlets;

import by.konovalchik.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutUserServlet", urlPatterns = "/logout")
public class LogoutUserServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) req.getSession().getAttribute("user");
        logger.info("User {} sign out", user.getName());
        session.invalidate();

        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
