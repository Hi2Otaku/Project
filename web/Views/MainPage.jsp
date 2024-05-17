<%-- 
    Document   : MainPage
    Created on : Mar 2, 2024, 2:52:42 PM
    Author     : hi2ot
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Storam - The Best Game Distributor</title>

        <!-- CSS FILES -->
        <link rel="preconnect" href="https://fonts.googleapis.com">

        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@100;200;400;700&display=swap" rel="stylesheet">

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link href="css/templatemo-festava-live.css" rel="stylesheet">

        <!--
    
    TemplateMo 583 Festava Live
    
    https://templatemo.com/tm-583-festava-live
    
        -->
    </head>

    <body>

        <main>

            <header class="site-header">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-12 col-12 d-flex flex-wrap">
                            <p class="d-flex me-4 mb-0">
                                <i class="bi-person custom-icon me-2"></i>
                                <strong class="text-dark">Welcome to Storam!</strong>
                            </p>
                        </div>

                    </div>
                </div>
            </header>


            <nav class="navbar navbar-expand-lg">
                <div class="container">
                    <a class="navbar-brand" href="index.html">
                        Storam
                    </a>                   

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav align-items-lg-center ms-auto me-lg-5">
                            <li class="nav-item">
                                <a class="nav-link click-scroll" href="#section_1">Home</a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link click-scroll" href="#section_2">About</a>
                            </li>      
                            <li class="nav-item">
                                <a class="nav-link click-scroll" href="#section_3">New & Trending</a>
                            </li> 
                            <c:if test="${role != 1}">
                            <li class="nav-item">
                                <a class="nav-link" href="MainPage?type=4">Store</a>
                            </li>               
                            </c:if>
                            <c:if test="${role == 1}">
                                <li class="nav-item">
                                    <a class="nav-link" href="MainPage?type=2">Add Items</a>
                                </li>
                            </c:if>                                
                            <c:if test="${role != null}">
                                <li class="nav-item">
                                    <a class="nav-link" href="MainPage?type=3">Profile</a>
                                </li>
                            </c:if>
                            <li class="nav-item">
                                <a class="nav-link click-scroll" href="#section_4">Contact</a>
                            </li>
                        </ul>
                        <c:if test="${logged == true}">
                            <a href="MainPage?type=1" class="btn custom-btn d-lg-block d-none">Login</a>
                        </c:if>
                        <c:if test="${logged == false}">
                            <a href="MainPage?type=0" class="btn custom-btn d-lg-block d-none">Logout</a>
                        </c:if>
                    </div>
                </div>
            </nav>


            <section class="hero-section" id="section_1">
                <div class="section-overlay"></div>

                <div class="container d-flex justify-content-center align-items-center">
                    <div class="row">

                        <div class="col-12 mt-auto mb-5 text-center">
                            <small>The Best Game Distributor</small>

                            <h1 class="text-white mb-5">Storam</h1>
                            <c:if test="${logged == true}">
                                <a class="btn custom-btn smoothscroll" href="MainPage?type=1">Let's begin</a>
                            </c:if>
                        </div>

                        <div class="col-lg-12 col-12 mt-auto d-flex flex-column flex-lg-row text-center">

                        </div>
                    </div>
                </div>

                <div class="video-wrap">
                    <video autoplay="" loop="" muted="" class="custom-video" poster="">
                        <source src="video/vid1.mp4" type="video/mp4">

                        Your browser does not support the video tag.
                    </video>
                </div>
            </section>


            <section class="about-section section-padding" id="section_2">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-6 col-12 mb-4 mb-lg-0 d-flex align-items-center">
                            <div class="services-info">
                                <h2 class="text-white mb-4">The Best Game Distributor You Can Ever Find</h2>

                                <p class="text-white">blabla.</p>

                                <h6 class="text-white mt-4">blabla</h6>

                                <p class="text-white">yes you are right</p>

                                <h6 class="text-white mt-4">Whole Night Party</h6>

                                <p class="text-white">Please tell your friends about our website. Thank you.</p>
                            </div>
                        </div>

                        <div class="col-lg-6 col-12">
                            <div class="about-text-wrap">
                                <img src="images/pexels-alexander-suhorucov-6457579.jpg" class="about-image img-fluid">

                                <div class="video-wrap">
                                    <video autoplay="" loop="" muted="" class="custom-video" poster="">
                                        <source src="video/vid2.mp4" type="video/mp4">

                                        Your browser does not support the video tag.
                                    </video>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </section>


            <section class="artists-section section-padding" id="section_3">
                <div class="container">
                    <div class="row justify-content-center">

                        <div class="col-12 text-center">
                            <h2 class="mb-4">New & Trending</h2>
                        </div>

                        <div class="col-lg-5 col-12">
                            <div class="artists-thumb">
                                <c:set var="stU" value="${t1}"></c:set>
                                    <div class="artists-image-wrap">
                                        <img src="images/${t1.getImg()}"
                                         class="artists-image img-fluid">
                                </div>                                
                            </div>
                            <div class="artists-thumb">
                                <c:set var="stU" value="${t4}"></c:set>
                                    <div class="artists-image-wrap">
                                        <img src="images/${t4.getImg()}"
                                         class="artists-image img-fluid">
                                </div>                                
                            </div>
                        </div>

                        <div class="col-lg-5 col-12">
                            <div class="artists-thumb">
                                <c:set var="stU" value="${t2}"></c:set>
                                    <div class="artists-image-wrap">
                                        <img src="images/${t2.getImg()}"
                                         class="artists-image img-fluid">
                                </div>                     
                            </div>                       

                            <div class="artists-thumb">
                                <c:set var="stU" value="${t3}"></c:set>
                                <img src="images/${t3.getImg()}"
                                     class="artists-image img-fluid">                                                             
                            </div>
                        </div>
                        <div class="col-12 mt-auto mb-5 text-center">
                            <a class="btn custom-btn smoothscroll" href="MainPage?type=4">Go to Store</a>
                        </div>
                    </div>
                </div>
            </section>                      
        </main>


        <footer class="site-footer" id="section_4"> 
            <div class="site-footer-top">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-6 col-12">
                            <h2 class="text-white mb-lg-0">Storam</h2>
                        </div>

                        <div class="col-lg-6 col-12 d-flex justify-content-lg-end align-items-center">
                            <ul class="social-icon d-flex justify-content-lg-end">
                                <li class="social-icon-item">
                                    <a href="#" class="social-icon-link">
                                        <span class="bi-twitter"></span>
                                    </a>
                                </li>

                                <li class="social-icon-item">
                                    <a href="#" class="social-icon-link">
                                        <span class="bi-apple"></span>
                                    </a>
                                </li>

                                <li class="social-icon-item">
                                    <a href="#" class="social-icon-link">
                                        <span class="bi-instagram"></span>
                                    </a>
                                </li>

                                <li class="social-icon-item">
                                    <a href="#" class="social-icon-link">
                                        <span class="bi-youtube"></span>
                                    </a>
                                </li>

                                <li class="social-icon-item">
                                    <a href="#" class="social-icon-link">
                                        <span class="bi-pinterest"></span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0">
                        <h5 class="site-footer-title mb-3">Have a question?</h5>

                        <p class="text-white d-flex mb-1">
                            <a href="tel: 090-080-0760" class="site-footer-link">
                                090-080-0760
                            </a>
                        </p>

                        <p class="text-white d-flex">
                            <a href="mailto:hello@company.com" class="site-footer-link">
                                hello@company.com
                            </a>
                        </p>
                    </div>

                    <div class="col-lg-3 col-md-6 col-11 mb-4 mb-lg-0 mb-md-0">
                        <h5 class="site-footer-title mb-3">Location</h5>

                        <p class="text-white d-flex mt-3 mb-2">
                            Silang Junction South, Tagaytay, Cavite, Philippines</p>

                        <a class="link-fx-1 color-contrast-higher mt-3" href="#">
                            <span>Our Maps</span>
                            <svg class="icon" viewBox="0 0 32 32" aria-hidden="true">
                            <g fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round">
                            <circle cx="16" cy="16" r="15.5"></circle>
                            <line x1="10" y1="18" x2="16" y2="12"></line>
                            <line x1="16" y1="12" x2="22" y2="18"></line>
                            </g>
                            </svg>
                        </a>
                    </div>
                </div>
            </div>

            <div class="site-footer-bottom">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-3 col-12 mt-5">
                            <p class="copyright-text">Copyright © 2036 Festava Live Company</p>
                            <p class="copyright-text">Distributed by: <a href="https://themewagon.com">ThemeWagon</a></p>
                        </div>

                        <div class="col-lg-8 col-12 mt-lg-5">
                            <ul class="site-footer-links">
                                <li class="site-footer-link-item">
                                    <a href="#" class="site-footer-link">Terms &amp; Conditions</a>
                                </li>

                                <li class="site-footer-link-item">
                                    <a href="#" class="site-footer-link">Privacy Policy</a>
                                </li>

                                <li class="site-footer-link-item">
                                    <a href="#" class="site-footer-link">Your Feedback</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <!--
    
    T e m p l a t e M o
    
        -->

        <!-- JAVASCRIPT FILES -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/click-scroll.js"></script>
        <script src="js/custom.js"></script>

    </body>

</html>