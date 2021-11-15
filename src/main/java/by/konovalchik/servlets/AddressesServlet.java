package by.konovalchik.servlets;

import by.konovalchik.entity.Address;
import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import by.konovalchik.services.facade.CalculatorFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddressesServlet", urlPatterns = "/address" )
public class AddressesServlet extends HttpServlet {
    private static final CalculatorFacade facade = new CalculatorFacade();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/address.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idAddrDelete = Integer.parseInt(req.getParameter("idAddrDelete"));

        User user = (User)req.getSession().getAttribute("user");
        if(facade.deleteAddress(idAddrDelete, user.getId())){
            List<Address> addresses = facade.showAddresses(user.getEmail());
            req.getSession().setAttribute("addresses", addresses);
            req.setAttribute("messageAddress1", "Address deleted!");
        }else {
            req.setAttribute("messageAddress2", "The address cannot be deleted!");
        }
        getServletContext().getRequestDispatcher("/address.jsp").forward(req, resp);

    }

}
