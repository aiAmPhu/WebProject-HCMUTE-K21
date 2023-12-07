<%-- 
    Document   : cart.jsp
    Created on : Dec 5, 2023, 4:45:47 PM
    Author     : Duc Vinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
<a href="index.html" class="logo"><img src="image/logo.png" alt=""></a> 

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

<!-- header-page div starts -->
<section id="page-header">
    <h2>#GioHang</h2>

    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ipsa a magnam aut deserunt quae ullam dolores quam sit, porro esse possimus provident nam, tenetur architecto quod molestiae itaque iusto magni.</p>

</section>
<!-- header-page div ends -->

<section id="cart">
    <table width="100%">
        <thead>
            <tr>
                <td>Remove</td>
                <td>Image</td>
                <td>Product</td>
                <td>Price</td>
                <td>Quantity</td>
                <td>Subtotal</td>
            </tr>
        </thead>
        <tbody>
            <c:set var="totalAmount" value="0" />
            <c:forEach items="${cart.cartLines}" var="o">
            <tr>
                <<td><a href="cart?action=delete&productID=${o.product.productID}">
                <i class="far fa-times-circle"></i>
                </a></td>
                <td><img src="${o.product.images}" alt=""></td>
                <td><a href="detail?pid=${o.product.productID}" class="text-dark d-inline-block">${o.product.productName}</a></td>
                <td>${o.product.price}</td>
                <td class="align-middle">
                    <a href="cart?action=minusquantity&productID=${o.product.productID}"><button class="btnSub">-</button></a>
                    <strong>${o.quantity}</strong>
                    <a href="cart?action=addquantity&productID=${o.product.productID}"><button class="btnAdd">+</button></a>
                </td>
                <c:set var="lineTotal" value="${o.product.price * o.quantity}" />
                <fmt:formatNumber value="${lineTotal}" pattern="#,##0.00" var="totalProduct" />
                <td>${totalProduct}</td>
            </tr>
            
            <c:set var="totalAmount" value="${totalAmount + lineTotal}" />
            </c:forEach>
        </tbody>
    </table>
</section>

<section id="cart-add">
  <div id="subtotal">
        <h3>Cart Totals</h3>
        <table>
            <fmt:formatNumber value="${totalAmount}" pattern="#,##0.00" var="roundTotalAmount" />
            <fmt:formatNumber value="${totalAmount}" var="roundTotalMoney" />
            <tr>
                <td>Cart Subtotal</td>
                <td>${roundTotalAmount} đ</td>
            </tr>
            <tr>
                <td>Shipping</td>
                <td>Free</td>
            </tr>
            <tr>
            </tr>
            <tr>
                <td><strong>Total</strong></td>
                <td><strong>${roundTotalAmount} đ</strong></td>
            </tr>
        </table>
            <a href="order?action=add&totalPrice=${roundTotalMoney}"><button class="normal">Thanh Toán</button></a>
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
