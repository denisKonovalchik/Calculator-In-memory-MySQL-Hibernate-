package by.konovalchik.filters;

import by.konovalchik.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebFilter(servletNames = {"CalculationServlet", "LogOperationsServlet", "ChangePasswordServlet",
        "UserProfileServlet", "ChangeNameServlet", "AddTelephoneServlet", "ChangeTelephoneServlet", "TelephonesServlet",
        "AddAddressesServlet", "ChangeAddressServlet", "AddressesServlet"} )
public class AuthorizationFilter extends HttpFilter {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
      User user = (User) req.getSession().getAttribute("user");

      if(!Optional.ofNullable(user).isPresent()){
          res.sendRedirect(req.getContextPath() + "/main");
          logger.warn("An attempt to access the application of an unregistered user");
      }else{
          chain.doFilter(req, res);
      }
    }
}
