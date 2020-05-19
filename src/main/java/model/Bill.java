package main.java.model;


public class Bill {
    protected int id;

    protected double amount;
    protected String message;
    protected String payment;
    protected double discount;
    protected double shipping_fee;
    protected String date_of_payment;
    protected int status;
    protected String created_date;
    protected String update_date;

    public Bill(int id, Double amount, String message, String payment, Double discount, Double shipping_fee, String s, String date_of_payment, int status, String create_date, String update_date) {
    }
    public Bill(double amount, String message, String payment,
                double discount, double shipping_fee, String date_of_payment,
                int status, String created_date, String update_date) {
        super();
        this.amount = amount;
        this.message = message;
        this.discount = discount;
        this.shipping_fee = shipping_fee;
        this.payment = payment;
        this.date_of_payment = date_of_payment;
        this.status = status;
        this.created_date = created_date;
        this.update_date = update_date;
    }
    public Bill(int id, double amount, String message, String payment,
                double discount, double shipping_fee, String date_of_payment,
                int status, String created_date, String update_date) {
        super();
        this.id = id;
        this.amount = amount;
        this.message = message;
        this.discount = discount;
        this.shipping_fee = shipping_fee;
        this.payment = payment;
        this.date_of_payment = date_of_payment;
        this.status = status;
        this.created_date = created_date;
        this.update_date = update_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(double shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public String getDate_of_payment() {
        return date_of_payment;
    }

    public void setDate_of_payment(String date_of_payment) {
        this.date_of_payment = date_of_payment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }
}
