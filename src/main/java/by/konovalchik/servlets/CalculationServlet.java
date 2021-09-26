package by.konovalchik.servlets;

import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;
import by.konovalchik.services.CalculationService;
import by.konovalchik.services.facade.CalculatorFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet(name = "CalculationServlet", urlPatterns = "/calculation")
public class CalculationServlet extends HttpServlet {
    private static final CalculatorFacade facade = new CalculatorFacade();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User)req.getSession().getAttribute("user");
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");

        Optional<Double> result = facade.getCalculation(num1,num2,operation,user);
        if(result.isPresent()){
            req.setAttribute("result", result.get());
            getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);
        }else {
            req.setAttribute("result", "Operation not found");
            getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);
        }
    }
}
