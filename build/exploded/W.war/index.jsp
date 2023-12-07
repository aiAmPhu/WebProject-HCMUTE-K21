<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a href="#Banchay">Bán chạy</a>
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

<!-- home div starts -->
<section class="home" id="Trangchu">
  <div class="content">
    <h3>Thức ăn thân thiện với gia súc</h3>
    <p>Chào mừng bạn đến với Phú Hợp Vinh - Nơi cung cấp đầy đủ và chất lượng nhất về thức ăn chăn nuôi. Tại đây, chúng tôi cam kết đem đến cho bạn trải nghiệm mua sắm trực tuyến thuận lợi và đáng tin cậy.</p>
    <a href="#" class="btn">Hello</a>
  </div>

  <div class="image">
    <img src="image/home-product.png" alt="">
  </div>

</section>
<!-- home div ends -->

<section class="category" id="Danhmuc">
    <h1 class="heading"> Our <span>category</span> </h1>

    <div class="box-container">
        
      <div class="box"> 
          <img class="image" src="image/chicken.jpg" alt="">
          <div class="content">
            <img src="image/chicken.png" alt="">
            <h3>Thức ăn gia cầm</h3>
            <p>Chúng tôi tự hào mang đến những sản phẩm thức ăn gia cầm chất lượng cao, đảm bảo sức khỏe và phát triển tốt nhất cho đàn gia cầm của bạn.!</p>
          </div>
      </div>

      <div class="box"> 
        <img class="image" src="image/pig.jpg" alt="">
        <div class="content">
          <img src="image/pig.png" alt="">
          <h3>Thức ăn heo</h3>
          <p>Sản phẩm của chúng tôi được thiết kế để cung cấp đầy đủ chất dinh dưỡng như protein, vitamin và khoáng chất để hỗ trợ sự phát triển toàn diện của heo.!</p>
        </div>
      </div>

      <div class="box"> 
        <img class="image" src="image/fish.jpg" alt="">
        <div class="content">
          <img src="image/fish.png" alt="">
          <h3>Thức ăn cá</h3>
          <p>Chúng tôi cung cấp thức ăn hạt, thức ăn sống, và thức ăn tươi cho các loại cá khác nhau, giúp đáp ứng nhu cầu dinh dưỡng đặc biệt của từng loại cá.!</p>
        </div>
      </div>

      <div class="box"> 
        <img class="image" src="image/shrimp.jpg" alt="">
        <div class="content">
          <img src="image/shrimp.png" alt="">
          <h3>Thức ăn tôm</h3>
          <p>Sản phẩm của chúng tôi được chế biến để cung cấp chất dinh dưỡng cần thiết, bao gồm protein, vitamin, khoáng chất và axit amin.!</p>
        </div>
      </div>

    </div>
</section>

<!-- best seller div starts-->
<section class="bestseller" id="Banchay">
  <h1 class="heading"> Our <span>Best Seller</span> Products</h1>
    
    <div class="box-container">
        <c:forEach items="${listP}" var="o">
        <div class="box">
            <span class="price">${o.price}đ</span>
            <img src="${o.images}" alt="">
            <h3>${o.productName}</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="far fa-star"></i>
            </div>
            <a href="cart?action=add&productID=${o.productID}" class="btn btn-success btn-block">Add cart</a>
        </div>
      </c:forEach>  
    </div>
    
  </section>
<!-- best seller div end-->

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