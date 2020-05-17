<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/05/2020
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Duong shoe's Admin</title>
    <link rel="stylesheet" href="style/vendors/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="style/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="style/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="style/css/style.css"/>
    <link rel="shortcut icon" href="style/images/62581209.jpg"/>
</head>
<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth">
            <div class="row flex-grow">
                <div class="col-lg-4 mx-auto">
                    <div class="auth-form-light text-left p-5">
                        <div class="brand-logo">
                            <img src="style/images/logo.svg">
                        </div>
                        <h4>Hello! let's get started</h4>
                        <h6 class="font-weight-light">Sign in to countinue</h6>
                        <c:if test="${requestScope.error != null}">
                            <span class="font-weight-light">${requestScope.error}</span>
                        </c:if>
                        <form class="pt-3" method="post">
                            <div class="form-group">
                                <input type="text" name="username" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="Username">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control form-control-lg" id="exampleInputPassword1" placeholder="Password">
                            </div>
                            <div class="mt-3">
<%--                                <a class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" href="/admin?action=dashboard">SIGN IN</a>--%>
                                <input type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" value="SIGN IN">
                            </div>
                            <div class="my-2 d-flex justify-content-between align-items-center">
                                <div class="form-check">
                                    <label class="form-check-label text-muted">
                                        <input type="checkbox" class="form-check-input"> Keep me signed in </label>
                                </div>
                                <a href="#" class="auth-link text-black">Forgot password?</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="style/vendors/js/vendor.bundle.base.js"></script>
<script src="style/js/off-canvas.js"></script>
<script src="style/js/misc.js"></script>
</body>
</html>