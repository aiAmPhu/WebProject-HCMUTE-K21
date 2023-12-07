<%-- 
    Document   : contact
    Created on : Nov 15, 2023, 10:14:56 AM
    Author     : Huynh Hop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

<!-- header div starts -->
<header>
<a href="index.jsp" class="logo"><img src="image/logo.png" alt=""></a> 

<div id="menu-bar" class="fas fa-bars"></div>

<nav class="navbar">
        <a href="index">Trang Chủ</a>
    <a href="#Danhmuc">Danh mục</a>
    <a href="shop">Sản phẩm</a>
<!--    <a href="ManagerProduct.jsp">Sản phẩm</a>-->
    <a href="index#Banchay">Bán chạy</a>
    <a href="review">Liên hệ</a>
<!--    <a href="login">Đăng nhập</a>-->
<!--    <a href="login.jsp">Đăng ký</a>-->
    <a href="#" id="usernameLink">Xin chào ${username}</a>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            // Lấy danh sách các cookie từ trình duyệt
            var cookies = document.cookie.split(";");

            // Biến để theo dõi xem cookie "username" có tồn tại hay không
            var usernameCookieExists = false;
            var usernameValue;

            // Duyệt qua danh sách cookie để kiểm tra sự tồn tại của cookie "username"
            for (var i = 0; i < cookies.length; i++) {
                var cookie = cookies[i].trim();
                if (cookie.startsWith("username=")) {
                    usernameCookieExists = true;
                    // Lấy giá trị của cookie "username"
                    usernameValue = cookie.substring("username=".length, cookie.length);
                    break;
                }
            }

            // Lấy đối tượng anchor (thẻ a) bằng cách sử dụng id
            var usernameLink = document.getElementById("usernameLink");

            // Nếu cookie "username" tồn tại, cập nhật nội dung của liên kết
            if (usernameCookieExists) {
                usernameLink.textContent = "Xin chào " + usernameValue;
                // Đặt href để chuyển hướng đến một trang cụ thể nếu cần
                usernameLink.href = "infor";
            } else {
                // Nếu không có cookie, đặt thuộc tính href để chuyển hướng đến một trang đăng nhập
                usernameLink.href = "login"; //phuong thuc Get
                usernameLink.textContent = "Đăng nhập";
            }

            // Gán một hàm xử lý sự kiện cho sự kiện nhấp chuột
            usernameLink.addEventListener("click", function() {
                // Hiển thị giá trị trong cửa sổ cảnh báo (có thể thay đổi thành xử lý khác)
                alert("Xin chào " + usernameValue);
            });
        });
        </script>
        <a href="cart.jsp">
            <i class="fa fa-shopping-cart"></i> Cart
        </a>
</nav>

</header>
<!-- header div ends -->

<!-- header-page div starts -->
<section id="page-header">
    <h2>LienHe</h2>

    <p>Kết nối với nhau</p>

</section>

<section id="about-head" class="about-header">
    <img src="image/about_us.png" alt="">
    <div>
        <h2>Who We Are?</h2>
        <p></p>
        <abbr title="">Thức ăn gia súc uy tín</abbr>

        <marquee bgcolor="#ccc" loop="-1" scrollamount="S" width="100%"></marquee>
    </div>
</section>
<!-- header-page div ends -->

<section id="contact-details" class="div-p1">
    <div class="details">
        <span>CONTACT</span>
        <h2>Ghé thăm chúng tôi tại địa chỉ hoặc có thể liên lạc với chúng tôi theo thông tin sao</h2>
        <h3>Trụ Sở</h3>
        <div>
            <li>
                <i class="far fa-map"></i>
                <p>01 Võ Văn Ngân, P. Linh Chiểu, Q. Thủ Đức, TP. Hồ Chí Minh</p>
            </li>
            <li>
                <i class="far fa-envelope"></i>
                <p>contact@gmail.com</p>
            </li>
            <li>
                <i class="fas fa-phone-alt"></i>
                <p>+84 0123456789/ +84 0987654321</p>
            </li>
            <li>
                <i class="far fa-clock"></i>
                <p>Monday to Saturday: 9.00 A.M to 6.00 P.M</p>
            </li>
        </div>
    </div>

    <div class="map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15673.94560876527!2d106.7642746!3d10.850561100000002!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175270ac7eca1a9%3A0x4acd9831a3137ca1!2zVHLGsOG7nW5nIMSQ4bqhaSBI4buNYyBTxrAgUGjhuqFtIEvhu7kgVGh14bqtdCAtIDEgVsO1IFbEg24gTmfDom4gLSBQaMaw4budbmcgTGluaCBDaGnhu4N1!5e0!3m2!1svi!2s!4v1699809179553!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>
</section>

<section id="form-details">
  <form action="review" method="post">
    <span>LEAVE A MESSAGE</span>
    <h2>Chúng tôi rất vui khi nghe phản hồi từ bạn</h2>
      <input type="hidden" name="action" value="add">
        <input type="text" id="name" placeholder="Name" name="name"><br>
        <input type="text" id="phone" placeholder="Phone" name="phone"><br>
        <input type="text" id="subject" placeholder="Subject" name="subject"><br>
        <input type="text" id="feedback" placeholder="Feedback" name="feedback"><br>
        <div class="form-group">
          <input type="submit" value="Gửi" class="margin_left">
        </div>
  </form>

  <div class="people">
    <div>
      <img src="image/profile.png" alt="">
      <p><span>Phu Pham</span>Senior Marketing Manager <br> Phone: +84 0123456789
      <br>Email: contact@gmail.com</p>
    </div>
    <div>
      <img src="image/profile.png" alt="">
      <p><span>Hop Ho</span>Senior Marketing Manager <br> Phone: +84 0123456789
      <br>Email: contact@gmail.com</p>
    </div>
    <div>
      <img src="image/profile.png" alt="">
      <p><span>Vinh Tran</span>Senior Marketing Manager <br> Phone: +84 0123456789
      <br>Email: contact@gmail.com</p>
    </div>
  </div>
</section>

<!-- footer starts -->
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
<!-- footer ends -->





<!--custom js file link -->
<script src="js/script.js"></script>
</body>
</html>
