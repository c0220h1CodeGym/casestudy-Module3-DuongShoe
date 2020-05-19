package main.java.service.bill;

import main.java.service.bill.IBillDAO;
import main.java.model.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

public class BillDAO implements IBillDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/duongshoe?useSSL=true";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "123456";

    private static final String INSERT_BILL_SQL = "INSERT INTO bill" + "(" +
            "id, " +
            "amount," +
            "message,discount," +
            "shipping_fee," +
            "payment," +
            "date_of_payment," +
            "status," +
            "create_date," +
            "update_date) VALUES " +
            " (?, ?, ?,?,?,?,?);";

    private static final String SELECT_BILL_BY_ID = "select id," +
            "amount," +
            "message," +
            "discount," +
            "shipping_fee," +
            "payment," +
            "date_of_payment," +
            "status," +
            "create_date," +
            "update_date" +
            "from bill where id =?";
    private static final String SELECT_ALL_BILLS = "select * from bill";
    private static final String DELETE_BILLS_SQL = "delete from bill where id = ?;";
    private static final String UPDATE_BILLS_SQL = "update bill " +
            "set id=?, " +
            "amount=?, " +
            "message=?," +
            "discount=?," +
            "shipping_fee=?," +
            "payment=?," +
            "status =?, " +
            "where id = ?;";

    public BillDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            /* TODO Auto-generated catch block */
            e.printStackTrace();
        }
        return connection;
    }

    public void insertBill(Bill bill) throws SQLException {
        System.out.println(INSERT_BILL_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (INSERT_BILL_SQL)) {
            preparedStatement.setDouble(1, bill.getAmount()); //bill_id, amount, message,discount,shipping_fee,payment,date_of_payment,status,create_date,update_date
            preparedStatement.setString(2, bill.getMessage());
            preparedStatement.setDouble(3, bill.getDiscount());
            preparedStatement.setDouble(4, bill.getShipping_fee());
            preparedStatement.setString(5, bill.getPayment());
            preparedStatement.setString(6, bill.getDate_of_payment());
            preparedStatement.setInt(7, bill.getStatus());
            preparedStatement.setString(8, bill.getCreated_date());
            preparedStatement.setString(9, bill.getUpdate_date());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Bill selectBill(int id) {
        Bill bill = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BILL_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Double amount = rs.getDouble("amount");
                String message = rs.getString("message");
                Double discount = rs.getDouble("discount");
                Double shipping_fee = rs.getDouble("shipping_fee");
                String payment = rs.getString("payment");
                String date_of_payment = rs.getString("date_of_payment");
                int status = rs.getInt("status");
                String create_date = rs.getString("create_date");
                String update_date = rs.getString("update_date");
                bill = new Bill(
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
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bill;
    }

    public List<Bill> selectAllBills() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Bill> bills = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BILLS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                Double amount = rs.getDouble("amount");
                String message = rs.getString("message");
                Double discount = rs.getDouble("discount");
                Double shipping_fee = rs.getDouble("shipping_fee");
                String payment = rs.getString("payment");
                String date_of_payment = rs.getString("date_of_payment");
                int status = rs.getInt("status");
                String create_date = rs.getString("create_date");
                String update_date = rs.getString("update_date");
                bills.add(new Bill(
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
                        update_date));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bills;
    }

    public boolean deleteBill(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement
                     (DELETE_BILLS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateBill(Bill bill) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     UPDATE_BILLS_SQL);) {

            statement.setDouble(1, bill.getAmount());
            statement.setString(2, bill.getMessage());
            statement.setDouble(3, bill.getDiscount());
            statement.setDouble(4, bill.getShipping_fee());
            statement.setString(5, bill.getPayment());
            statement.setString(6, bill.getDate_of_payment());
            statement.setInt(7, bill.getStatus());
            statement.setString(8, bill.getCreated_date());
            statement.setString(9, bill.getUpdate_date());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}