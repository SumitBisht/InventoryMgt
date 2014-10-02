<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp"></jsp:include>
    </head>

    <body role="document">

        <jsp:include page="headermenu.jsp"></jsp:include>


        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/home.png">
                    </div>
                    <div class="page-title-text">Dashboard ..</div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius">Some Text Here</div>
                        <!--<div class="cat-table-title"></div>-->


                        <table class="table table-striped table-font-size">
                            <thead>
                                <tr class="cat-table-title">
                                    <th colspan="2">Customer Name</th>
                                    <th width="43%" colspan="2">Grand Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>

                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>
                                <tr>
                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>
                                <tr>
                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>
                                <tr>
                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>

                            </tbody>
                        </table>




                    </div>

                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="label.email"/>here ...  <spring:message code="label.firstname"/></div>
                        <!--<div class="cat-table-title"></div>-->


                        <table class="table table-striped table-font-size">
                            <thead>
                                <tr class="cat-table-title">
                                    <th colspan="2">Customer Name</th>
                                    <th width="43%" colspan="2">Grand Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>

                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>
                                <tr>
                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>
                                <tr>
                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>
                                <tr>
                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>

                            </tbody>
                        </table>




                    </div>

                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius">Some Text Here</div>
                        <!--<div class="cat-table-title"></div>-->


                        <table class="table table-striped table-font-size">
                            <thead>
                                <tr class="cat-table-title">
                                    <th colspan="2">Customer Name</th>
                                    <th width="43%" colspan="2">Grand Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>

                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>
                                <tr>
                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>
                                <tr>
                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>
                                <tr>
                                    <td colspan="2">Name</td>
                                    <td>12.64</td>
                                </tr>

                            </tbody>
                        </table>




                    </div>
                </div>
                <div class="col-md-6">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title top-radius"></div>
                        <center><img src="img/graph.jpg" class="img-responsive graph"></center>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title top-radius"></div>
                    </div>

                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title top-radius"></div>
                    </div>
                </div>
            </div>

            <div class=""></div>
            <div class=""></div>


        </div>
        <!-- /container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
