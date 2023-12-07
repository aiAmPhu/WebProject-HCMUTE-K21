<!--<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>
    <h1>Thanks for joining our email list</h1>
    <p>Here is the information that you entered:</p>
        <label>First Name:</label>
        <span>${users.userid}</span><br>
        <label>Last Name:</label>
        <span>${user.lastname}</span><br>
</body>
</html>-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Web bán đồ ăn gia súc</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>

 header div starts 
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

 home div starts 
<!--<div class="home" id="Trangchu">
  <div class="content">
    <h3>Đăng ký </h3>
    <p>Năm nay không vô địch thì khi nào vô địch nữa!</p>
    <a href="#" class="btn">order now</a>
        <form action="emailList" method="post">
             <input type="hidden" name="action" value="add">
            <label>Tài khoản</label>
            <input type="text" placeholder=" Username" name="username" ><br>
            <label>Mật khẩu</label>
            <input type="text" placeholder=" Password" name="password"><br>
            <label>Họ</label>
            <input type="text" placeholder=" Họ" name="firstname" ><br>
            <label>Tên</label>
            <input type="text" placeholder=" Tên" name="lastname" ><br>
            <label>Số điện thoại</label>
            <input type="text" placeholder=" SĐT" name="phonenumber" ><br>
            <label>Địa chỉ</label>
            <input type="text" placeholder=" Địa chỉ" name="address" ><br>
            
            
        <input type="submit" value="Đăng ký" class="margin_left">
        </form>
  </div>

  <div class="image">
    <img src="image/t1.png" alt="">
  </div>

</div>-->
  <div class="home" id="Trangchu">
  <div class="content">
    <h3>ĐÃ ĐĂNG KÝ THÀNH CÔNG </h3>
    <p>Năm nay không vô địch thì khi nào vô địch nữa!</p>
    <form action="emailList" method="post" class="registration-form">
      <input type="hidden" name="action" value="add">
      
      <div class="form-group">
        <label for="username">Tài khoản</label>
        <span>${user.username}</span><br>
      </div>
      
      <div class="form-group">
        <label for="password">Mật khẩu</label>
        <span>${user.password}</span><br>
      </div>
      
    </form>
  </div>

  <div class="image">
    <img src="image/t1.png" alt="">
  </div>
</div>          

 home div ends 

 footer starts 
<footer class="div-p1">
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