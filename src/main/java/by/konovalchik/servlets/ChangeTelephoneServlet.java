package by.konovalchik.servlets;


import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import by.konovalchik.services.facade.CalculatorFacade;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ChangeTelephoneServlet", urlPatterns = "/editTel")
public class ChangeTelephoneServlet extends HttpServlet {
    private static final CalculatorFacade facade = new CalculatorFacade();
    private static final Logger logger = LoggerFactory.getLogger(ChangeTelephoneServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTelCurrent = Integer.parseInt(req.getParameter("idUpdate"));
        req.getSession().setAttribute("idTelCurrent", idTelCurrent);
        getServletContext().getRequestDispatcher("/editTel.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTel = (Integer) req.getSession().getAttribute("idTelCurrent");
        long newNumber = Long.parseLong(req.getParameter("newNumber"));

        User user = (User)req.getSession().getAttribute("user");
        if(facade.editTelephone(idTel, user.getId(), newNumber)){
            List<Telephone> telephones = facade.showTelephones(user.getEmail());
            req.getSession().setAttribute("telephones", telephones);
            req.setAttribute("messageTelephoneEdit1", "Phone number changed!");
            logger.info("Phone number changed!");
        }else{
            req.setAttribute("messageTelephoneEdit2", "Phone number not found!");
        }
        getServletContext().getRequestDispatcher("/editTel.jsp").forward(req, resp);

    }
}
