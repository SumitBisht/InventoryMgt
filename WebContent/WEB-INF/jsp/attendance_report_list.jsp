<%-- 
    Document   : attendance_report_list
    Created on : Sep 6, 2014, 8:16:01 PM
    Author     : sweta
--%>


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
                    <div class="page-title-text"><spring:message code="payrollcategories.list" text="Label value is missing !!!"/></div>
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
                                <li class=''><a href='payslips_list.html'><span><spring:message code="menu.payslips" text="Label value is missing !!!"/></span></a></li>
                                <li class='last'><a href='#'><span><spring:message code="menu.employeeleavemanagement" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li><a href='leave_types.html'><span><spring:message code="menu.addleavetype" text="Label value is missing !!!"/></span></a></li>
                                        <li class="active"><a href='hr_attendence.html'><span><spring:message code="menu.attendanceregister" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='hr_attendence_report.html'><span><spring:message code="menu.attendancereport" text="Label value is missing !!!"/></span></a></li>
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
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="label.attendance.report" text="Label value is missing !!!"/></div>
                        <spring:message text="Default Text" code="payrollcategory.search.placeholder" var="search"/>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                                <div class="row tb-margin">
                                    <div class="col-sm-4">
<!--                                        <a href="add_payroll_category.html" class="btn btn-info add-row addrow-btn-left"><spring:message code="payrollcategory.add" text="Label value is missing !!!"/></a>-->
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="form-group visible-sm visible-md visible-lg">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.search" text="Label value is missing !!!"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <input id="filter" class="form-control" type="text"/>
                                            </div>
                                        </div>
                                        <!--                                        <div class="form-group visible-xs">
                                                                                    <div class="col-xs-12">
                                                                                        <input id="filter" placeholder="${search}" class="form-control" type="text"/>
                                                                                    </div>
                                                                                </div>-->
                                    </div>
                                </div>
                                <table id="dttable" class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                    <thead class="orange-bg border-t">
                                        <tr>
                                            <th data-toggle="true">
                                                <spring:message code="label.attendance.employee" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-toggle="true">
                                                <spring:message code="label.attendance.fromdate" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-toggle="true">
                                                <spring:message code="label.attendance.todate" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-toggle="true">
                                                <spring:message code="label.attendance.presentdays" text="Label value is missing !!!"/>
                                            </th>  
                                            <th data-toggle="true">
                                                <spring:message code="label.attendance.absentdays" text="Label value is missing !!!"/>
                                            </th>  -
                                            <th data-hide="phone" data-name="Delete">
                                                <spring:message code="label.attendance.totaldays" text="Label value is missing !!!"/> 
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="attendanceReport" items="${attendanceReportList}">
                                            <tr>
                                                <td>${attendanceReport.employee}</td>
                                                <td>${attendanceReport.fromDate}</td>
                                                <td>${attendanceReport.toDate}</td>
                                                <td>${attendanceReport.presentDays}</td>
                                                <td>${attendanceReport.absentDays}</td>
                                                 <td>${attendanceReport.totalDays}</td>
                                               
                                            </tr>                                        
                                        </c:forEach>
                                    </tbody>
                                    <tfoot class="hide-if-no-paging">
                                        <tr>
                                            <td colspan="8">
                                                <div class="pagination pagination-centered"></div>
                                            </td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>                            
                        </div>
                    </div>
                </div>
            </div>
            <div class=""></div>
            <div class=""></div>
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
        </script>
    </body>
</html>

