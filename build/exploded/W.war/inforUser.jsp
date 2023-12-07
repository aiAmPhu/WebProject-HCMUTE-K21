<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Web bán đồ ăn gia súc</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/style_login.css">
</head>
<body>

 header section starts 
<header>
<a href="index.jsp" class="logo"><img src="image/logo.png" alt=""></a> 

<div id="menu-bar" class="fas fa-bars"></div>

<nav class="navbar">
    <a href="index.jsp">Trang Chủ</a>
    <a href="#Danhmuc">Danh mục</a>
    <a href="shop.jsp">Sản phẩm</a>
    <a href="#Banchay">Bán chạy</a>
    <a href="contact.jsp">Liên hệ</a>
    <a href="login">Đăng nhập</a>
</nav>

</header>


  <section class="home" id="Trangchu">
  <div class="content">
    <h3>Thông tin người dùng </h3>
    <p>Năm nay không vô địch thì khi nào vô địch nữa!</p>
      
      <div class="form-group">
        <label for="firstname">Họ</label>
        <input type="text" id="firstname" value="${user.firstname}"><br>
      </div>
      
      <div class="form-group">
        <label for="lastname">Tên</label>
        <input type="text" id="lastname" value="${user.lastname}"><br>
      </div>
      
      <div class="form-group">
        <label for="phonenumber">Số điện thoại</label>
        <input type="tel" id="phonenumber" value="${user.phonenumber}"><br>
      </div>
      
      <div class="form-group">
        <label for="address">Địa chỉ</label>
        <input type="text" id="address" value="${user.address}"><br>
      </div>
      
    <form action="login" method="post" class="registration-form">
      <input type="hidden" name="action" value="logout">
      <div class="form-group">
        <input type="submit" value="Đăng xuất" class="margin_left">
      </div>
    </form>
<!--      <div class="form-group">
        <input type="submit" value="Đăng ký" class="margin_left">
      </div>-->
<!--    </form>-->
  </div>

  <div class="image">
    <img src="image/t1.png" alt="">
  </div>
<!--</section>          -->

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>Order</b></h2>
                        </div>
<!--                        <div class="col-sm-6">
                            <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                            <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
                        </div>-->
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
<!--                            <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                            </th>-->
                            <th>Customer ID</th>
                            <th>Order Date</th>
                            <th>Order Status</th>
                            <th>Total Money</th>
<!--                            <th>Category</th>
                            <th>Weight</th>
                            <th>Nutritional Value</th>-->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listP}" var="o">
                            <tr>
                                <td>${o.customer.getUserid()}</td>
                                <td>${o.orderDate}</td>
                                <td>
                                    <c:if test="${o.orderStatus==0}">
                                        Chờ xác nhận
                                    </c:if>
                                    <c:if test="${o.orderStatus==1}">
                                        Đã xác nhận
                                    </c:if>
                                </td>
                                <td>${o.totalMoney}</td>
                                <td>
<!--                                    <a href="check?oid=${o.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE834;</i></a>
                                    <a href="deleteO?pid=${o.id}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>-->
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                </div>
            </div>
        </div>
</section> 
 footer starts 
<footer class="section-p1">
    <div class="col">
      <h4>Contact</h4>
      <p><strong>Address: </strong> 01 Võ Văn Ngân, P. Linh Chiểu, Q. Thủ Đức, TP. Hồ Chí Minh</p>
      <p><strong>Phone: </strong> +84 0123456789/ +84 0987654321</p>
      <p><strong>Hours: </strong> 9:00 A.M - 6:00 P.M, Mon - Sat</p>
      <div class="follow">
        <h4>Follow us:</h4>
        <div class="icon">
          <i class="fab fa-facebook-f"></i>
          <i class="fab fa-twitter"></i>
          <i class="fab fa-instagram"></i>
          <i class="fab fa-pinterest-p"></i>
          <i class="fab fa-youtube"></i>
        </div>
      </div>
    </div>

    <div class="col">
      <h4>About</h4>
      <a href="#">About us</a>
      <a href="#">Delivery Information</a>
      <a href="#">Privacy Policy</a>
      <a href="#">Contact us</a>
    </div>

    <div class="col">
      <h4>Account</h4>
      <a href="#">Sign In</a>
      <a href="#">View Cart</a>
      <a href="#">Track My order</a>
      <a href="#">Help</a>
    </div>

    <div class="col-paythod">
      <h4>Secured Payment Gateways</h4>
      <img src="image/momo.png" alt="">
      <img src="image/zalopay.png" alt="">
    </div>

    <div class="copyright">
      <p>@ 2023, Final Project, Lập trình Web</p>
    </div>
</footer>