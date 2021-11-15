package by.konovalchik.servlets;


import by.konovalchik.entity.Address;
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

@WebServlet(name="ChangeAddressServlet", urlPatterns = "/editAddr")
public class ChangeAddressServlet extends HttpServlet {
    private static final CalculatorFacade facade = new CalculatorFacade();
    private static final Logger logger = LoggerFactory.getLogger(ChangeAddressServlet.class.getName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idAddrCurrent = Integer.parseInt(req.getParameter("idAddrUpdate"));
        req.getSession().setAttribute("idAddrCurrent", idAddrCurrent);
        getServletContext().getRequestDispatcher("/editAddr.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idAddr = (Integer) req.getSession().getAttribute("idAddrCurrent");
        String newCity = req.getParameter("newCity");
        String newStreet = req.getParameter("newStreet");
        int newHomeNumber = Integer.parseInt(req.getParameter("newHomeNumber"));
        int newApartNumber = Integer.parseInt(req.getParameter ("newApartNumber"));


        User user = (User)req.getSession().getAttribute("user");
        Address address = new Address(idAddr,newCity, newStreet, newHomeNumber, newApartNumber, new User(user.getId()));
        if(facade.editAddress(address)){
            List<Address> addresses = facade.showAddresses(user.getEmail());
            req.getSession().setAttribute("addresses", addresses);
            req.setAttribute("messageAddressEdit1", "Address changed!");
            logger.info("Address changed!");
        }else{
            req.setAttribute("messageAddressEdit2", "Address not found!");
            logger.info("Address has not changed!");
        }
        getServletContext().getRequestDispatcher("/editAddr.jsp").forward(req, resp);

    }





}
