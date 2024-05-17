<%-- 
    Document   : AddItems
    Created on : Mar 14, 2024, 9:24:02 AM
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

        <title>Add Items</title>

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

                        <div class="col-lg-8 col-12 mx-auto">
                            <h2 class="text-center mb-4">Enter Information About Your Product</h2>

                            <div class="col-12 mt-auto mb-5 text-center">
                                <small>${err}</small>
                            </div>
                            <div class="tab-content shadow-lg mt-5" id="nav-tabContent">
                                <div class="tab-pane fade show active" id="nav-ContactForm" role="tabpanel"
                                     aria-labelledby="nav-ContactForm-tab">
                                    <form class="custom-form contact-form mb-5 mb-lg-0" action="AddItems" method="post"
                                          role="form">
                                        <div class="contact-form-body">
                                            <div class="row">
                                                <div class="col-lg-6 col-md-6 col-12">
                                                    <p>Name</p>
                                                    <input type="text" name="name" 
                                                           class="form-control" placeholder="Product Name" required>
                                                </div>
                                                <div class="col-lg-6 col-md-6 col-12">
                                                    <p>Price ($)</p>
                                                    <input type="number" name="price"
                                                           class="form-control" placeholder="Product Price" min="1" required>
                                                </div>
                                                <div class="col-lg-6 col-md-6 col-6">
                                                    <p>Image</p>
                                                    <input type="text" name="img"
                                                           class="form-control" placeholder="Image" required>
                                                </div>
                                                <div class="col-lg-6 col-md-6 col-6">
                                                    <p>Release Date</p>
                                                    <input type="date" name="date"
                                                           class="form-control" placeholder="Release Date" required>
                                                </div>                                                    
                                            </div>                    
                                            <div class="row">
                                                <p>Category</p>
                                                <c:forEach items="${cl}" var ="i">
                                                    <div class="col-lg-3 col-md-3 col-3">
                                                        <input type="checkbox" name="chk${i.getId()}" value="${i.getId()}"/>${i.getName()}
                                                    </div>
                                                </c:forEach>
                                            </div>
                                            <div class="col-lg-4 col-md-10 col-8 mx-auto">
                                                <button type="submit" value='Registor' class="form-control">Add Product</button>
                                            </div>
                                        </div>                                            
                                    </form>
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
