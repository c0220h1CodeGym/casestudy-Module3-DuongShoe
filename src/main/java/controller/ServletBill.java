package main.java.controller;

import main.java.service.bill.BillDAO;
import main.java.model.Bill;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletBill", urlPatterns = "/bills")
public class ServletBill extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BillDAO billDAO;

    public void init() {
        billDAO = new BillDAO();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertBill(request, response);
                    break;
                case "edit":
                    updateBill(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteBill(request, response);
                    break;
                default:
                    listBill(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Bill> listBill = billDAO.selectAllBills();
        request.setAttribute("listBill", listBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Bill existingUser = billDAO.selectBill(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/edit.jsp");
        request.setAttribute("bill", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Double amount = Double.parseDouble(request.getParameter("amount"));
        String message = request.getParameter("message");
        Double discount = Double.parseDouble(request.getParameter("discount"));
        Double shipping_fee = Double.parseDouble(request.getParameter("shipping_fee"));
        String payment = request.getParameter("payment");
        String date_of_payment = request.getParameter("date_of_payment");
        int status = Integer.parseInt(request.getParameter("status"));
        String create_date = request.getParameter("create_date");
        String update_date = request.getParameter("update_date");
        Bill newBill = new Bill(
                id,
                amount,
                message,
                payment,
                discount,
                shipping_fee,
                payment,
                date_of_payment,
                status,
                create_date,
                update_date);

        billDAO.insertBill(newBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Double amount = Double.parseDouble(request.getParameter("amount"));
        String message = request.getParameter("message");
        Double discount = Double.parseDouble(request.getParameter("discount"));
        Double shipping_fee = Double.parseDouble(request.getParameter("shipping_fee"));
        String payment = request.getParameter("payment");
        String date_of_payment = request.getParameter("date_of_payment");
        int status = Integer.parseInt(request.getParameter("status"));
        String create_date = request.getParameter("create_date");
        String update_date = request.getParameter("update_date");
        Bill book = new Bill(
                id,
                amount,
                message,
                payment,
                discount,
                shipping_fee,
                payment,
                date_of_payment,
                status,
                create_date,
                update_date);
        billDAO.updateBill(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        billDAO.deleteBill(id);

        List<Bill> listBill = billDAO.selectAllBills();
        request.setAttribute("listBill", listBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/list.jsp");
        dispatcher.forward(request, response);
    }

}
