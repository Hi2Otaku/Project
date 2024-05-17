<%-- 
    Document   : Store
    Created on : Mar 12, 2024, 1:12:33 PM
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

        <title>Store</title>

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
        
        <script>
            function myFun(){
                document.getElementById("filter").submit();
            }
        </script>
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
                        <div class="col-lg-3 col-12 mx-auto">
                            <h3 class="text-center mb-4">Filter</h3>
                            <form class="custom-form contact-form mb-5 mb-lg-0" action="Store" method="post"
                                  role="form" id="filter">
                                <div class="contact-form-body">
                                    <c:forEach items="${cl}" var ="i">
                                        <input type="checkbox" name="chk${i.getId()}" value="${i.getId()}" ${ftl.contains(i) == true?"checked":""} onclick="myFun()"/>${i.getName()}<br/>
                                    </c:forEach>
                                        <input type="submit" value="Filter">                                     
                                </div>
                            </form>
                        </div>
                        <div class="col-lg-9 col-12 mx-auto">            
                            <h3 class="text-center mb-4">Games Store</h3>                         

                            <div class="tab-content shadow-lg mt-5" id="nav-tabContent">
                                <div class="tab-pane fade show active" id="nav-ContactForm" role="tabpanel"
                                     aria-labelledby="nav-ContactForm-tab">
                                    <div class="row">
                                        <c:forEach items="${il}" var='i'>
                                            <div class="col-lg-6 col-12">
                                                <div class="artists-thumb">                                        
                                                    <div class="artists-image-wrap">
                                                        <img src="images/${i.getImg()}"
                                                             class="artists-image img-fluid">
                                                    </div>                        
                                                    <div class="artists-hover">
                                                        <p>
                                                            <strong>Name: </strong> ${i.getName()}                                                            
                                                        </p>
                                                        <p>
                                                            <strong>Release Date: </strong> ${i.getReleaseDate()}                                                            
                                                        </p>
                                                        <p>
                                                            <strong>Price: </strong> ${i.getPrice()}                                                            
                                                        </p>
                                                        <c:if test="${dao.checkb(us.getUserName(), i.getId()) == 0}">
                                                            <a class="btn custom-btn smoothscroll" href="Store?type=${i.getId()}">Buy</a>
                                                        </c:if>
                                                        <c:if test="${dao.checkb(us.getUserName(), i.getId()) == 1}">
                                                            <a class="btn custom-btn smoothscroll" href="Store?ToProfile=1">Check in Profile</a>
                                                        </c:if>
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
