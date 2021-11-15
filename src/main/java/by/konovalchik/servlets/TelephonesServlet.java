package by.konovalchik.servlets;

import by.konovalchik.entity.Operation;
import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import by.konovalchik.services.facade.CalculatorFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name= "TelephonesServlet", urlPatterns = "/telephone")
public class TelephonesServlet extends HttpServlet {
    private static final CalculatorFacade facade = new CalculatorFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/telephone.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDelete = Integer.parseInt(req.getParameter("idDelete"));


        User user = (User)req.getSession().getAttribute("user");
        if(facade.deleteTelephone(idDelete, user.getId())){
            List<Telephone> telephones = facade.showTelephones(user.getEmail());
            req.getSession().setAttribute("telephones", telephones);
            req.setAttribute("messageTelephone1", "Phone number deleted!");
        }else {
            req.setAttribute("messageTelephone2", "Phone number not found!");
        }
        getServletContext().getRequestDispatcher("/telephone.jsp").forward(req, resp);

    }

}
