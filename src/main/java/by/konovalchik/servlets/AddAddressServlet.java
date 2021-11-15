package by.konovalchik.servlets;

import by.konovalchik.entity.Address;
import by.konovalchik.entity.User;
import by.konovalchik.services.facade.CalculatorFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddAddressesServlet", urlPatterns = "/addAddr" )
public class AddAddressServlet extends HttpServlet {
    private static final CalculatorFacade facade = new CalculatorFacade();
    private static final Logger logger = LoggerFactory.getLogger(ChangeAddressServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addAddr.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        int homeNumber = Integer.parseInt(req.getParameter("homeNumber"));
        int apartNumber = Integer.parseInt(req.getParameter("apartNumber"));


        User user = (User) req.getSession().getAttribute("user");
        if(facade.addAddress(new Address(city, street, homeNumber, apartNumber, user ))){
            List<Address> addresses = facade.showAddresses(user.getEmail());
            req.getSession().setAttribute("addresses", addresses);
            req.setAttribute("messageAddressAdd1", "Address added!");
            logger.info("Address added!");
        }else{
            req.setAttribute("messageAddressAdd2", "Address has not been added!");
            logger.info("Address has not changed!");
        }
        getServletContext().getRequestDispatcher("/addAddr.jsp").forward(req, resp);

    }
}
