package by.konovalchik.filters;

import by.konovalchik.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(servletNames = {"CalculationServlet", "logOperationsServlet"} )
public class AuthorizationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
      User user = (User) req.getSession().getAttribute("user");
      if(user==null){
          res.sendRedirect(req.getContextPath() + "/main");
      }else{
          chain.doFilter(req, res);
      }
    }
}
