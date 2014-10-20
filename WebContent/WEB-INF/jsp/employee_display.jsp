<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>        
        <jsp:include page="header.jsp" />
    </head>
    <body role="document">
        <jsp:include page="headermenu.jsp" />
        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text"><spring:message code="menu.main.employeereport" text="Label value is missing !!!"/></div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">

                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <ul>
                                <li class='has-sub active'><a href='employee.html'><span><spring:message code="menu.employeemanagement" text="Label value is missing !!!"/></span></a>
                                    <li class=''><a href='access_control.html'><span><spring:message code="menu.empmanagement.acl" text="Label value is missing !!!"/></span></a></li>
                                <li class=''><a href='payslips_list.html'><span><spring:message code="menu.payslips" text="Label value is missing !!!"/></span></a></li>
                                <li class='last'><a href='#'><span><spring:message code="menu.employeeleavemanagement" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li><a href='leave_types.html'><span><spring:message code="menu.addleavetype" text="Label value is missing !!!"/></span></a></li>
                                        <li class="active"><a href='hr_attendence.html'><span><spring:message code="menu.attendanceregister" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='hr_attendence_report.html'><span><spring:message code="menu.attendancereport" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='hr_employee_report.html'><span><spring:message code="menu.employeereport" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='hr_resetleaves.html'><span><spring:message code="menu.resetleave" text="Label value is missing !!!"/></span></a></li>
                                    </ul>
                                </li>
                                <li class=''><a href='#'><span><spring:message code="menu.settings" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li><a href='employee_category.html'><span><spring:message code="menu.employeecategory" text="Label value is missing !!!"/></span></a></li>
                                        <li class="active"><a href='employee_department.html'><span><spring:message code="menu.employeedepartment" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='payroll_category.html'><span><spring:message code="menu.payrollcategory" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='bank.html'><span><spring:message code="menu.bank" text="Label value is missing !!!"/></span></a></li>
                                    </ul>
                                </li>


                            </ul>
                        </div>
                        <!-- END MUNU -->    
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="menu.main.employeereport" text="Label value is missing !!!"/></div>
                            <table class="tab-pane active" id="employee_detailed_information">
                              <tr>
                                <td>
                                <label class="col-sm-4 col-xs-12">
                                    <spring:message code="label.employee.number" text="Label value is missing !!!"/>
	                            </label>
	                            </td>
	                            <td>
                                <label class="col-sm-8 col-xs-12">
                                    <input type="text" readonly="readonly" value="${emp.employeeNumber}" />
	                            </label>
	                            </td>
	                            </tr>
	                            <tr>
	                            <td>
                                <label class="col-sm-4 col-xs-12">
                                    <spring:message code="label.employee.firstname" text="Label value is missing !!!"/>
	                            </label>
	                            </td>
	                            <td>
                                <label class="col-sm-8 col-xs-12">
                                    <input type="text" readonly="readonly" value="${emp.firstName}" />
	                            </label>
	                            </td>
	                            </tr>
	                            <tr>
	                            <td>
                                <label class="col-sm-8 col-xs-12">
                                    <spring:message code="label.employee.birthdate" text="Label value is missing !!!"/>
	                            </label>
	                            </td>
	                            <td>
                                <label class="col-sm-8 col-xs-12">
                                    <input type="text" readonly="readonly" value="${emp.dateOfBirth}" />
	                            </label>
	                            </td>
	                            </tr>
	                            <tr>
	                            <td>
                                <label class="col-sm-4 col-xs-12">
                                    <spring:message code="label.employee.department" text="Label value is missing !!!"/>
	                            </label>
	                            </td>
	                            <td>
                                <label class="col-sm-8 col-xs-12">
                                    <input type="text" readonly="readonly" value="${department}" />
	                            </label>
	                            </td>
	                            </tr>
	                            <tr>
	                            <td>
                                <label class="col-sm-4 col-xs-12">
                                    <spring:message code="label.employee.category" text="Label value is missing !!!"/>
	                            </label>
	                            </td>
	                            <td>
                                <label class="col-sm-8 col-xs-12">
                                    <input type="text" readonly="readonly" value="${category}" />
	                            </label>
	                            </td>
	                            </tr>
	                            </table>
                    		</div>
                            <div class="form-group">
                                <div class="div-center-xs">
                                    <button type="button" class="btn btn-orange" onclick="printEmployeeDetails();">Print</button>
                                    <button type="button" class="btn btn-orange" onclick="javascript:history.back();">Back</button>
                                </div>
                            </div>
                </div>
            </div>
        </div>
        <!-- /container -->
        <!--Responsive Table-->
        <script type="text/javascript">
        </script>
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.responsive.min.js"></script>
        <script src="js/ajax-bootstrap3.js"></script>
        <script src="js/docs.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('.row-delete').click(function(eve) {
                    var row = this;
                    eve.preventDefault();
                    $.ajax({
                        url: $(row).attr('href')
                        , success: function(response) {
                            if (response === true) {
                                $(row).closest('tr').remove();
                            }
                        }
                    });
                    return false;
                });
            });
            function printEmployeeDetails() {
            	var originalPage = document.body.innerHTML;
            	var detail = document.getElementsByClassName("catagory-main-box top-radius")[1];
            	document.body.innerHTML = detail.innerHTML;
            	window.print();
            	document.body.innerHTML = originalPage;
            }
        </script>
    </body>
</html>
