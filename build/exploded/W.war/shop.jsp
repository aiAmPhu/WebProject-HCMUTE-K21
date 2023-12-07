<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <a href="index.jsp#Danhmuc">Danh mục</a>
    <a href="shop">Sản phẩm</a>
    <a href="index.jsp#Banchay">Bán chạy</a>
    <a href="contact.jsp">Liên hệ</a>
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
            <c:if test="${sessionScope.account != null}">
                <span class="badge badge-light">
                        ${cart.countCartLine()}
                </span>
            </c:if>
        </a>
</nav>

</header>
<!-- header div ends -->

<!-- header-page div starts -->
<section id="shoppage-header">
    <h2>SanPham</h2>

    <p>Sản phẩm của chúng tôi được chế biến để cung cấp chất dinh dưỡng cần thiết, bao gồm protein, vitamin, khoáng chất và axit amin</p>

</section>

<!-- product div starts-->
<section class="products">
    <h1 class="heading"> Our <span>Products</span></h1>
    <div class="box-container">
    <c:forEach items="${listP}" var="o">
        
            <div class="box" onclick="window.location.href="product?pid=${o.productID}" title="View Product";>
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
                <a href="cart?action=add&productID=${o.productID}" class="btn">Add cart</a>
            </div>
        
        
                
    </c:forEach>
        </div>
</section>
<!--<div class="container">

        <div class="col-sm-9">
            <div class="row">
                <c:forEach items="${listP}" var="o">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <img class="card-img-top" src="${o.images}" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-title show_txt"><a href="detail?pid=${o.productID}" title="View Product">${o.productName}</a></h4>
                                <p class="card-text show_txt">${o.description}</p>
                                <p class="card-text show_txt"> Brand : ${o.brand}</p>

                                <p class="card-text show_txt"> Size  : ${o.weight}</p>

                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-danger btn-block">${o.price} $</p>
                                    </div>
                                    <div class="col">
                                        <a href="cart?action=add&productID=${o.productID}" class="btn btn-success btn-block">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>-->

<!-- product div end-->

<!-- pagination div starts-->
<section id="pagination">
    <a href="#">1</a>
    <a href="#">2</a>
    <a href="#">3</a>
    <a href="#"><i class="fas fa-long-arrow-alt-right"></i></a>
</section>
<!-- pagination div starts-->

<!-- footer starts -->
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
<!-- footer ends -->





<!--custom js file link -->
<script src="js/script.js"></script>
</body>
</html>