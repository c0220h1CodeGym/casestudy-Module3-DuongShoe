<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bill Management Application</title>
</head>
<body>
<center>
    <h1>Bill Management</h1>
    <h2>
        <a href="bills?action=bills">List All Bills</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Bill
                </h2>
            </caption>
            <c:if test="${bill != null}">
                <input type="hidden" name="id" value="<c:out value='${bill.id}' />"/>
            </c:if>
            <tr>
                <th>Bill amount:</th>
                <td>
                    <input type="text" name="amount" id="amount" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Bill message:</th>
                <td>
                    <input type="text" name="message" id="message" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Bill discount:</th>
                <td>
                    <input type="text" name="discount" id="discount" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Bill shipping_fee:</th>
                <td>
                    <input type="text" name="shipping_fee" id="shipping_fee" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Bill payment:</th>
                <td>
                    <input type="text" name="payment" id="payment" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Bill date_of_payment:</th>
                <td>
                    <input type="text" name="date_of_payment" id="date_of_payment" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Bill create_date:</th>
                <td>
                    <input type="text" name="create_date" id="create_date" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Bill update_date:</th>
                <td>
                    <input type="text" name="update_date" id="update_date" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>