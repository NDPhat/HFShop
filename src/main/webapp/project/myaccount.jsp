<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta name="robots" content="index, follow" />
    <title>HFX</title>
    <meta name="description" content="Mioca - Handmade Goods eCommerce HTML Template" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<base href="${pageContext.request.contextPath}/project/">
    <!-- Add site Favicon -->
    <link rel="shortcut icon" href="assets/images/favicon/favicon.ico" type="image/png">
	

    <!-- vendor css (Icon Font) -->
    <link rel="stylesheet" type="text/css" href="css/vendor/bootstrap.bundle.min.css" >
    <link rel="stylesheet" type="text/css" href="css/vendor/pe-icon-7-stroke.css" >
    <link rel="stylesheet" type="text/css" href="css/vendor/font.awesome.css" >

    <!-- plugins css (All Plugins Files) -->
    <link rel="stylesheet" type="text/css" href="css/plugins/animate.css" >
    <link rel="stylesheet" type="text/css" href="css/plugins/swiper-bundle.min.css" >
    <link rel="stylesheet" type="text/css" href="css/plugins/jquery-ui.min.css" >
    <link rel="stylesheet" type="text/css" href="css/plugins/nice-select.css" >
    <link rel="stylesheet" type="text/css"  href="css/plugins/venobox.css" >

    <!-- Use the minified version files listed below for better performance and remove the files listed above -->
    <!-- <link rel="stylesheet" href="assets/css/vendor/vendor.min.css" />
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css" />
    <link rel="stylesheet" href="assets/css/style.min.css"> -->

    <!-- Main Style -->
   <link rel="stylesheet" href="assets/css/style.css" />
    <link rel="stylesheet" href="assets/css/myaccout.css" />
</head>

</head>

<body>
<c:if test="${isSuccess != null}">
    <c:if test="${isSuccess == false}">
        <div class="alert danger-alert">
            <h3>Update Failed</h3>
            <a class="close">&times;</a>
        </div>
    </c:if>
    
    <c:if test="${isSuccess == true}">
        <div class="alert success-alert">
            <h3>Update Successfully</h3>
            <a class="close">&times;</a>
        </div>
    </c:if>
    <c:if test="${message != null}">
            <div class="alert danger-alert">
                <h3><c:out  value="${requestScope.message}"/></h3>
                <a class="close">&times;</a>
            </div>
            <script>

            </script>
        </c:if>
</c:if>
<!-- Header Area End -->
<div class="offcanvas-overlay"></div>

<!-- OffCanvas Wishlist Start -->
<div id="offcanvas-wishlist" class="offcanvas offcanvas-wishlist">
    <div class="inner">
        <div class="head">
            <span class="title">Wishlist</span>
            <button class="offcanvas-close">×</button>
        </div>
        <div class="body customScroll">
            <ul class="minicart-product-list">
                <li>
                    <a href="single-product.html" class="image"><img src="assets/images/product-image/1.jpg"
                            alt="Cart product Image"></a>
                    <div class="content">
                        <a href="single-product.html" class="title">Hand-Made Garlic Mortar</a>
                        <span class="quantity-price">1 x <span class="amount">$21.86</span></span>
                        <a href="#" class="remove">×</a>
                    </div>
                </li>
                <li>
                    <a href="single-product.html" class="image"><img src="assets/images/product-image/2.jpg"
                            alt="Cart product Image"></a>
                    <div class="content">
                        <a href="single-product.html" class="title">Handmade Ceramic Pottery</a>
                        <span class="quantity-price">1 x <span class="amount">$13.28</span></span>
                        <a href="#" class="remove">×</a>
                    </div>
                </li>
                <li>
                    <a href="single-product.html" class="image"><img src="assets/images/product-image/3.jpg"
                            alt="Cart product Image"></a>
                    <div class="content">
                        <a href="single-product.html" class="title">Hand Painted Bowls</a>
                        <span class="quantity-price">1 x <span class="amount">$17.34</span></span>
                        <a href="#" class="remove">×</a>
                    </div>
                </li>
            </ul>
        </div>
        <div class="foot">
            <div class="buttons">
                <a href="wishlist.html" class="btn btn-dark btn-hover-primary mt-30px">view wishlist</a>
            </div>
        </div>
    </div>
</div>
<!-- OffCanvas Wishlist End -->
<!-- OffCanvas Cart Start -->
<div id="offcanvas-cart" class="offcanvas offcanvas-cart">
    <div class="inner">
        <div class="head">
            <span class="title">Cart</span>
            <button class="offcanvas-close">×</button>
        </div>
        
        <div class="body customScroll">
            <ul class="minicart-product-list">
                <li>
                    <a href="single-product.html" class="image"><img src="assets/images/product-image/1.jpg"
                            alt="Cart product Image"></a>
                    <div class="content">
                        <a href="single-product.html" class="title">Hand-Made Garlic Mortar</a>
                        <span class="quantity-price">1 x <span class="amount">$18.86</span></span>
                        <a href="#" class="remove">×</a>
                    </div>
                </li>
                <li>
                    <a href="single-product.html" class="image"><img src="assets/images/product-image/2.jpg"
                            alt="Cart product Image"></a>
                    <div class="content">
                        <a href="single-product.html" class="title">Handmade Ceramic Pottery</a>
                        <span class="quantity-price">1 x <span class="amount">$43.28</span></span>
                        <a href="#" class="remove">×</a>
                    </div>
                </li>
                <li>
                    <a href="single-product.html" class="image"><img src="assets/images/product-image/3.jpg"
                            alt="Cart product Image"></a>
                    <div class="content">
                        <a href="single-product.html" class="title">Hand Painted Bowls</a>
                        <span class="quantity-price">1 x <span class="amount">$37.34</span></span>
                        <a href="#" class="remove">×</a>
                    </div>
                </li>
            </ul>
        </div>
        <div class="foot">
            <div class="buttons mt-30px">
                <a href="cart.html" class="btn btn-dark btn-hover-primary mb-30px">view cart</a>
                <a href="checkout.html" class="btn btn-outline-dark current-btn">checkout</a>
            </div>
        </div>
    </div>
</div>
<!-- OffCanvas Cart End -->

<!-- OffCanvas Menu Start -->
<div id="offcanvas-mobile-menu" class="offcanvas offcanvas-mobile-menu">
    <button class="offcanvas-close"></button>

    <div class="inner customScroll">

        <div class="offcanvas-menu mb-4">
            <ul>
                <li><a href="#"><span class="menu-text">Home</span></a>
                </li>
                <li><a href="about.html">About</a></li>

                <li><a href="shop-left-sidebar.html"><span class="menu-text">Shop</span></a>
                </li>
                <li><a href="coming-soon.html"><span class="menu-text">Blog</span></a>
                </li>
                <li><a href="contact.html">Contact Us</a></li>
            </ul>
        </div>
        <!-- OffCanvas Menu End -->
        <div class="offcanvas-social mt-auto">
            <ul>
                <li>
                    <a href="#"><i class="fa fa-facebook"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-google"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-youtube"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-instagram"></i></a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- OffCanvas Menu End -->

    <!-- breadcrumb-area start -->
    <div class="breadcrumb-area">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-12 text-center">
                    <h2 class="breadcrumb-title">My Account</h2>
                    <!-- breadcrumb-list start -->
                    <ul class="breadcrumb-list">
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                        <li class="breadcrumb-item active">Account</li>
                    </ul>
                    <!-- breadcrumb-list end -->
                </div>
            </div>
        </div>
    </div>
    <!-- breadcrumb-area end -->
    
    <!-- account area start -->
    <div class="account-dashboard pt-100px pb-100px">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-3 col-lg-3">
                    <!-- Nav tabs -->
                    <div class="dashboard_tab_button" data-aos="fade-up" data-aos-delay="0">
                        <ul role="tablist" class="nav flex-column dashboard-list">
                            <li><a href="#dashboard" data-bs-toggle="tab" class="nav-link active">Dashboard</a></li>
                            <li><a id="Orders" onclick="loadOrder()" href="#orders" data-bs-toggle="tab" class="nav-link">Orders</a></li>
                          
                            <li><a id="UpdateIn4" href="#update-information" data-bs-toggle="tab" class="nav-link">Update information</a></li>
                            <li><a id="changePassword" href="#change-password" data-bs-toggle="tab" class="nav-link">Change password</a></li>
                            <li><a href="${pageContext.request.contextPath}/logout" class="nav-link">logout</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-12 col-md-9 col-lg-9">
                    <!-- Tab panes -->
                    <div class="tab-content dashboard_content" data-aos="fade-up" data-aos-delay="200">
                        <div class="tab-pane fade show active" id="dashboard">
                            <h4>Dashboard </h4>
                            <p role="tablist">Wellcome to your Dashboard</p>
                         
                        </div>
                        <div class="tab-pane fade" id="orders">
                            <h4>Orders</h4>
                            <div class="table_page table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Order</th>
                                            <th>Date</th>
                                            <th>Status</th>
                                            <th>Total</th>
                                            <th>Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       
                                    </tbody>
                                </table>
                            </div>
                        </div>
                     
                        <div class="tab-pane fade" id="update-information">
                            <h3>Update information </h3>
                            <div class="login">
                                <div class="login_form_container">
                                    <div class="account_login_form">
                                        <form action="${pageContext.request.contextPath}/UpdateInfoServlet" method="post">
                                          
                                            <div class="default-form-box mb-20">
                                                <label> Name</label>
                                                <input type="text" name="name" value="${user.getName()}">
                                            </div>
                                     
                                            <div class="default-form-box mb-20">
                                                <label>Email</label>
                                                <input type="text" name="email" value="${user.getEmail()}">
                                            </div>
                                            <div class="default-form-box mb-20">
                                                <label>Phone number</label>
                                                <input type="text" name="phone" value="${user.getPhone()}">
                                            </div>
                                            <div class="default-form-box mb-20">
                                                <label>Address</label>
                                                <input type="text" name="address" value="${user.getAddress()}">
                                            </div>
                                         
                                            <div class="save_button mt-3">
                                                <button class="btn" type="submit">Save</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="change-password">
                            <h3>Change password </h3>
                            <div class="login">
                                <div class="login_form_container">
                                    <div class="account_login_form">
                                        <form action="${pageContext.request.contextPath}/ChangePassServlet" method="post">
                                          
                                            <div class="default-form-box mb-20">
                                                <label>Email</label>
                                                <input type="text" name="email">
                                            </div>
                                            <div class="default-form-box mb-20">
                                                <label>Current Password</label>
                                                <input type="text" name="password">
                                            </div>
                                            <div class="default-form-box mb-20">
                                                <label>New Password</label>
                                                <input type="text" name="newpassword">
                                            </div>
                                            <div class="default-form-box mb-20">
                                                <label>Retype New Password</label>
                                                <input type="text" name="repassword">
                                            </div>
                                            <div class="save_button mt-3">
                                                <button class="btn" type="submit">Confirm</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- account area start -->

    <div class="newsletter-area ">
        <div class="container line-shape-bottom">
            <div class="row align-items-center">
                <div class="col-lg-6">
                    <div class="newsletter-content mb-lm-30px">
                        <i class="pe-7s-mail-open-file"></i>
                        <div class="newsletter-text">
                            <h3 class="title">Newsletter & Get Updates</h3>
                            <p>Sign up for our newsletter to get update from us</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="news-letter-form">
                        <div id="mc_embed_signup" class="subscribe-form">
                            <form id="mc-embedded-subscribe-form" class="validate" novalidate="" target="_blank"
                                name="mc-embedded-subscribe-form" method="post"
                                action="http://devitems.us11.list-manage.com/subscribe/post?u=6bbb9b6f5827bd842d9640c82&amp;id=05d85f18ef"
                                >
                                <div id="mc_embed_signup_scroll" class="mc-form">
                                    <input class="email" type="email" required=""
                                        placeholder="Enter Your Mail Here......." name="EMAIL" value="">
                                    <div class="mc-news d-none" aria-hidden="true">
                                        <input type="text" value="" tabindex="-1"
                                            name="b_6bbb9b6f5827bd842d9640c82_05d85f18ef">
                                    </div>
                                    <div class="clear">
                                        <!-- submit -->
                                        <button id="mc-embedded-subscribe" class="button" type="button" name="subscribe"
                                            value="" onclick="window.location.href='./404.html'"> Submit</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer Area Start -->
    <div class="footer-area">
        <div class="footer-container">
            <div class="footer-top">
                <div class="container">
                    <div class="row">
                        <!-- Start single blog -->
                        <div class="col-md-6 col-sm-6 col-lg-3 mb-md-30px mb-lm-30px">
                            <div class="single-wedge">
                                <h4 class="footer-herading">Information</h4>
                                <div class="footer-links">
                                    <div class="footer-row">
                                        <ul class="align-items-center">
                                            <li class="li"><a class="single-link" href="about.html">About us</a></li>
                                            <li class="li"><a class="single-link" href="privacy-policy.html">Privacy
                                                    Policy</a></li>
                                            <li class="li"><a class="single-link" href="faq.html">FAQ</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End single blog -->
                        <!-- Start single blog -->
                        <div class="col-md-6 col-lg-3 col-sm-6 mb-lm-30px">
                            <div class="single-wedge">
                                <h4 class="footer-herading">Account</h4>
                                <div class="footer-links">
                                    <div class="footer-row">
                                        <ul class="align-items-center">
                                            <li class="li"><a class="single-link" href="my-account.html"> My account</a>
                                            </li>
                                            <li class="li"><a class="single-link" href="cart.html">My orders</a></li>
                                            <!-- <li class="li"><a class="single-link"
                                                    href="shop-left-sidebar.html">Shipping</a></li> -->
                                            <li class="li"><a class="single-link" href="wishlist.html">Wish list</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End single blog -->
                        <!-- Start single blog -->
                        <div class="col-md-6 col-lg-2 col-sm-6 mb-sm-30px">
                            <div class="single-wedge">
                                <h4 class="footer-herading">Store </h4>
                                <div class="footer-links">
                                    <div class="footer-row">
                                        <ul class="align-items-center">
                                            <li class="li"><a class="single-link" href="${pageContext.request.contextPath}/home">Home</a></li>
                                            <li class="li"><a class="single-link"
                                                    href="shop-left-sidebar.html">Bestsellers</a></li>
                                            <li class="li"><a class="single-link" href="contact.html">Contact Us</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End single blog -->
                        <!-- Start single blog -->
                        <div class="col-md-6 col-lg-4 col-md-6 col-sm-6 pl-120px line-shape">
                            <div class="single-wedge ">

                                <h4 class="footer-herading">Contact Us</h4>
                                <div class="footer-links">
                                    <!-- News letter area -->
                                    <p class="mail">If you have any question.please <br>
                                        contact us at <a href="mailto:demo@example.com">demo@example.com</a> </p>
                                    <!-- <p class="address"><i class="pe-7s-map-marker"></i> <span>Your address goes here.
                                            <br>
                                            123, Address.</span> </p> -->
                                    <p class="phone m-0"><i class="pe-7s-phone"></i><span><a href="tel:0123456789">+ 0 123
                                                456 789</a> <br> <a href="tel:0123456789">+ 0 123 456 789</a></span></p>

                                    <!-- News letter area  End -->
                                </div>
                            </div>
                        </div>
                        <!-- End single blog -->
                    </div>
                </div>
            </div>
            <div class="footer-bottom">
                <div class="container">
                    <div class="line-shape-top">
                        <div class="row flex-md-row-reverse align-items-center">
                            <div class="col-md-6 text-center text-md-end">
                                <div class="payment-mth"><a href="#"><img class="img img-fluid"
                                            src="assets/images/icons/payment.png" alt="payment-image"></a></div>
                            </div>
                            <div class="col-md-6 text-center text-md-start">
                                <p class="copy-text"> © 2021 <strong>Mioca.</strong> Made With <i class="fa fa-heart"
                                        aria-hidden="true"></i> By <a class="company-name"
                                        href="https://hasthemes.com/">
                                        <strong> Aslan Team</strong></a>.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer Area End -->

    <!-- Search Modal Start -->
    <div class="modal popup-search-style" id="searchActive">
        <button type="button" class="close-btn" data-bs-dismiss="modal"><span aria-hidden="true">&times;</span></button>
        <div class="modal-overlay">
            <div class="modal-dialog p-0" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <h2>Search Your Product</h2>
                        <form class="navbar-form position-relative" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search here...">
                            </div>
                            <button type="submit" class="submit-btn"><i class="pe-7s-search"></i></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Search Modal End -->

    <!-- Global Vendor, plugins JS -->

    <!-- Vendor JS -->
     
	    <script src="assets/js/vendor/jquery-3.5.1.min.js"></script>
	
	    <script src="assets/js/vendor/bootstrap.bundle.min.js"></script>
	    <script src="assets/js/vendor/jquery-migrate-3.3.0.min.js"></script>
	    <script src="assets/js/vendor/modernizr-3.11.2.min.js"></script>
	
	    <!--Plugins JS-->
	    <script src="assets/js/plugins/swiper-bundle.min.js"></script>
	    <script src="assets/js/plugins/jquery-ui.min.js"></script>
	    <script src="assets/js/plugins/jquery.nice-select.min.js"></script>
	    <script src="assets/js/plugins/countdown.js"></script>
	    <script src="assets/js/plugins/scrollup.js"></script>
	    <script src="assets/js/plugins/jquery.zoom.min.js"></script>
	    <script src="assets/js/plugins/venobox.min.js"></script>
	    <script src="assets/js/plugins/ajax-mail.js"></script>
   
		<script>
		    function loadOrder() {
		        $.ajax({
		            url: "/hfshop10/OrderAPI",
		            type: "get",
		            data: {},
		            success: function (response) {
		                var row = document.querySelector('tbody');
		                row.innerHTML = response;
		
		            },
		            error: function (xhr) {
		                alert("Loading data not success. Please comeback later !!")
		            }
		
		        })
		    }
		
		</script>
    <!-- Main Js -->
 <script src="assets/js/main.js"></script>
<script src="assets/js/myaccount.js"></script>
<script src="assets/js/myaccountfirebase.js"></script>
</body>

</html>