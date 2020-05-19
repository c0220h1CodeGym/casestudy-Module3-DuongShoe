package main.java.service.bill;
import main.java.model.Bill;

import java.sql.*;
import java.util.List;

public interface IBillDAO {
    public void insertBill(Bill bill) throws SQLException;
    public Bill selectBill(int id);
    public List<Bill> selectAllBills();
    public boolean deleteBill(int id)throws SQLException;
    public boolean updateBill(Bill bill)throws SQLException;

}
