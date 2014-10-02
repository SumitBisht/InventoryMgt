<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="../header.jsp"></jsp:include>
        </head>

        <body role="document">

        <jsp:include page="../headermenu.jsp"></jsp:include>

        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text">Human Resource Management</div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">

                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <ul>
                                <li class=''><a href='employee.html'><span>Employee Management</span></a></li>
                                <li class='active'><a href='payslips_list.html'><span>PaySlips</span></a></li>
                                <li class='has-sub'><a href='#'><span>Employee Leave Management</span></a>
                                    <ul style='display: block;'>
                                        <li><a href='leave_types.html'><span>Add Leave Type</span></a></li>
                                        <li><a href='hr_attendence.html'><span>Attendence Register</span></a></li>
                                        <li><a href='hr_attendence_report.html'><span>Attendece Report</span></a></li>
                                        <li class='last'><a href='hr_resetleaves.html'><span>Reset Leave</span></a></li>
                                    </ul>
                                </li>
                                <li class='has-sub '><a href='#'><span>Settings</span></a>
                                    <ul style='display: block;'>
                                        <li><a href='employee_categogy.html'><span>Employee Category</span></a></li>
                                        <li><a href='employee_department.html'><span>Employee Department</span></a></li>
                                        <li class='last'><a href='payroll_category.html'><span>Payroll Category</span></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <!-- END MUNU -->    

                    </div>
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius">Create Employee Payslip</div>

                        <div class="row tb-margin">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-8">

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text"> Salary Date:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text"> Employee :</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>
                                

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text"> Basic:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text"> HRA:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>

                            </div>


                            <div class="col-sm-2"></div>
                        </div>
                        <div class="row text-pad-top visible-lg visible-md visible-sm">
                            <div class="div-center">
                                <button type="button" class="btn btn-orange">Save</button>
                                <button type="button" class="btn btn-orange" onclick="javascript:history.back()">Cancel</button>
                            </div>
                        </div>
                        <div class="row text-pad-top visible-xs ">
                            <div class="div-center-xs">
                                <button type="button" class="btn btn-orange">Save</button>
                                <button type="button" class="btn btn-orange" onclick="javascript:history.back()">Cancel</button>
                            </div>
                        </div>


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
