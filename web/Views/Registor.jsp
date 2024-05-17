<%-- 
    Document   : Registor
    Created on : Mar 12, 2024, 5:04:47 AM
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
            <c:if test="${otp == null}">
                <section class="contact-section section-padding">
                    <div class="container">
                        <div class="row">

                            <div class="col-lg-8 col-12 mx-auto">
                                <h2 class="text-center mb-4">New to Storam? Get yourself an account for free!</h2>

                                <div class="col-12 mt-auto mb-5 text-center">
                                    <small>${err}</small>
                                </div>
                                <div class="tab-content shadow-lg mt-5" id="nav-tabContent">
                                    <div class="tab-pane fade show active" id="nav-ContactForm" role="tabpanel"
                                         aria-labelledby="nav-ContactForm-tab">
                                        <form class="custom-form contact-form mb-5 mb-lg-0" action="Registor" method="post"
                                              role="form">
                                            <div class="contact-form-body">
                                                <div class="row">
                                                    <div class="col-lg-6 col-md-6 col-12">
                                                        <input type="text" name="u" 
                                                               class="form-control" placeholder="UserName">
                                                    </div>
                                                    <div class="col-lg-6 col-md-6 col-12">
                                                        <input type="password" name="p"
                                                               class="form-control" placeholder="Password">
                                                    </div>
                                                    <div class="col-lg-6 col-md-6 col-6">
                                                        <input type="date" name="dob"
                                                               class="form-control" placeholder="Date of Birth">
                                                    </div>
                                                    <div class="col-lg-6 col-md-6 col-6">
                                                        <input type="password" name="rp"
                                                               class="form-control" placeholder="Re-Enter Password"\>
                                                    </div>
                                                    <div class="col-lg-6 col-md-6 col-6">
                                                        <input type="email" name="mail"
                                                               class="form-control" placeholder="Mail">
                                                    </div>                                                    
                                                </div>                                                
                                                <div class="row">                                                    
                                                    <div class="col-lg-12 col-md-12 col-6">
                                                        <select name="sq" class="form-control">
                                                            <c:forEach items="${sl}" var='i'>
                                                                <option value="${i.getId()}">${i.getQuestion()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-lg-12 col-md-12 col-12">
                                                        <input type="text" name="sa" 
                                                               class="form-control" placeholder="Your Answer">
                                                    </div>
                                                <div class="col-lg-4 col-md-10 col-8 mx-auto">
                                                    <button type="submit" value='Registor' class="form-control">Register</button>
                                                </div>
                                            </div>
                                            <div class="col-12 mt-2 mb-2 text-center">
                                                <a href='Registor?Login=1'>Already have an account? Login here!</a>
                                            </div>
                                        </form>
                                    </div>                                                                                      

                                </div>
                            </div>

                        </div>
                    </div>
                </section>            
            </c:if>
            <c:if test="${otp != null}">
                <section class="contact-section section-padding">
                    <div class="container">
                        <div class="row">
                            
                            <div class="col-lg-8 col-12 mx-auto">
                                <h2 class="text-center mb-4">Please enter the OTP sent to your E-Mail </h2>
                                <div class="tab-content shadow-lg mt-5" id="nav-tabContent">
                                    <div class="tab-pane fade show active" id="nav-ContactForm" role="tabpanel"
                                         aria-labelledby="nav-ContactForm-tab">
                                        <form class="custom-form contact-form mb-5 mb-lg-0" action="Registor" method="post"
                                              role="form">
                                            <div class="contact-form-body">
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-12 col-12">
                                                        <input type="text" name="otp2" 
                                                               class="form-control" placeholder="OTP Code">
                                                    </div>                                                 
                                                    <input type="text" name="otp" value="${otp}" hidden>
                                                    <input type="text" name="u" value="${u}" hidden>
                                                </div>                                                                                               
                                                <div class="col-lg-4 col-md-10 col-8 mx-auto">
                                                    <button type="submit" value='Registor' class="form-control">Submit</button>
                                                </div>
                                            </div>                                           
                                        </form>
                                    </div>                                                                                      

                                </div>
                            </div>

                        </div>
                    </div>
                </section>           
            </c:if>
        </main>                        
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/click-scroll.js"></script>
        <script src="js/custom.js"></script>

    </body>

</html>
