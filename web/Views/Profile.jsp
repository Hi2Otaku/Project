<%-- 
    Document   : Profile
    Created on : Mar 14, 2024, 6:39:10 AM
    Author     : hi2ot
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Registor</title>

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
                                <a href="MainPage"><strong class="text-dark">Back to Home Page</strong></a>                                
                            </p>
                        </div>
                    </div>  
                </div>
            </header>
            <section class="contact-section section-padding">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-12 mx-auto">
                            <h3 class="text-center mb-4">Account</h3>
                            <p>
                                <strong>User Name: </strong>  ${us.getUserName()}                               
                            </p>
                            <p>
                                <strong>Date of Birth: </strong>  ${us.getDoB()}                               
                            </p>
                            <p>
                                <strong>Role: </strong>  ${role}                               
                            </p>
                            <c:if test="${us.getRole() == '2'}">
                                <p>
                                    <strong>Wallet: </strong>  ${us.getWallet()}$                               
                                </p>
                            </c:if>
                            <p class="custom-form">
                                <a href="Profile?cha=1">Change Password</strong></a>
                            </p>
                        </div>
                        <div class="col-lg-8 col-12 mx-auto">            
                            <c:if test="${us.getRole() == '2'}">
                                <h3 class="text-center mb-4">Bought Games</h3>
                            </c:if>
                            <c:if test="${us.getRole() == '1'}">
                                <h3 class="text-center mb-4">Published Games</h3>
                            </c:if>

                            <div class="tab-content shadow-lg mt-5" id="nav-tabContent">
                                <div class="tab-pane fade show active" id="nav-ContactForm" role="tabpanel"
                                     aria-labelledby="nav-ContactForm-tab">
                                    <div class="row">
                                        <c:forEach items="${bl}" var='i'>
                                            <div class="col-lg-6 col-6">
                                                <div class="artists-thumb">                                        
                                                    <div class="artists-image-wrap">
                                                        <img src="images/${i.getImg()}"
                                                             class="artists-image img-fluid">
                                                    </div>                                                     
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>   
                                </div>                                                                                      
                            </div>
                        </div>
                    </div>
                </div>
            </section>            

        </main>                        
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/click-scroll.js"></script>
        <script src="js/custom.js"></script>

    </body>

</html>
