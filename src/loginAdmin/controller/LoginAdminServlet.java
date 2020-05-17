package loginAdmin.controller;

import common.Error;
import common.Link;
import loginAdmin.dao.UserDAO;
import loginAdmin.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginAdminServlet", urlPatterns = "/admin")
public class LoginAdminServlet extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confirmLoginAdmin(request, response);
    }

    private void confirmLoginAdmin(HttpServletRequest request, HttpServletResponse response) {
        User admin;
        String userName;
        String password;
        RequestDispatcher rd;
        try {
            admin = userDAO.selectAdmin();
            userName = request.getParameter("username");
            password = request.getParameter("password");
            if (userName.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                rd = request.getRequestDispatcher(Link.LOGIN_ADMIN_TO_DASHBOARD);
                rd.forward(request, response);
            } else {
                request.setAttribute(Error.ERROR, Error.ERROR_004);
                rd = request.getRequestDispatcher(Link.LOGIN_ADMIN_TO_LOGIN_ADMIN);
                rd.forward(request, response);
            }
        } catch (ServletException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(Error.ERROR_005);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        try {
            rd = request.getRequestDispatcher(Link.LOGIN_ADMIN_TO_LOGIN_ADMIN);
            rd.forward(request, response);
        } catch (ServletException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(Error.ERROR_006);
        }
    }
}