package by.konovalchik.servlets;


import by.konovalchik.entity.Address;
import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import by.konovalchik.services.facade.CalculatorFacade;
import by.konovalchik.services.facade.FacadeDependencies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name="AddTelephoneServlet", urlPatterns = "/addTel")
public class AddTelephoneServlet extends HttpServlet {
    private static final CalculatorFacade facade = new CalculatorFacade();
    private static final Logger logger = LoggerFactory.getLogger(ChangeAddressServlet.class.getName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addTel.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long number = Long.parseLong(req.getParameter("phoneNumber"));

        User user = (User) req.getSession().getAttribute("user");
        if(facade.addTelephone(new Telephone(number, user))){
            List<Telephone> telephones = facade.showTelephones(user.getEmail());
            req.getSession().setAttribute("telephones", telephones);
            req.setAttribute("messageTelephoneAdd1", "Phone number added!");
            logger.info("Phone number added!");
        }else{
            req.setAttribute("messageTelephoneAdd2", "Telephone number has not been added!!");
        }
        getServletContext().getRequestDispatcher("/addTel.jsp").forward(req, resp);

    }
}
