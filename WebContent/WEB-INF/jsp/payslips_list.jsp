<%-- 
    Document   : payslips_list
    Created on : Sep 10, 2014, 11:53:12 AM
    Author     : ssweta
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>        
        <jsp:include page="header.jsp" />
         <script type="text/javascript">
                function submitDetailsForm() {
                    return true;
                }
            </script>
    </head>
    <body role="document">
        <jsp:include page="headermenu.jsp" />
        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text"><spring:message code="label.payslip" text="Label value is missing !!!"/></div>
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
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="label.payslip" text="Label value is missing !!!"/></div>
                        <spring:message text="Default Text" code="purorder.search.placeholder" var="search"/>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                                <div class="row tb-margin">
                                     <div class="col-sm-4">
                                        <a href="payslips_list.html" class="btn btn-info add-row addrow-btn-left"><spring:message code="label.createpayslip" text="Label value is missing !!!"/></a>
                                    </div>
                                    <div class="col-sm-4">
                                        <form method="post" action="get_payslip.html">
                                            <table width="100%">
                                                <tr>
                                                    <td width="30%">Month:  <select  name="month">
                                                            <option value="0">January</option>
                                                            <option value="1">February</option>
                                                            <option value="2">March</option>
                                                            <option value="3">April</option>
                                                            <option value="4">May</option>
                                                            <option value="5">June</option>
                                                            <option value="6">July</option>
                                                            <option value="7">August</option>
                                                            <option value="8">September</option>
                                                            <option value="9">October</option>
                                                            <option value="10">November</option>
                                                            <option value="11">December</option>
                                                        </select> </td> 
                                                    <td width="5%">&nbsp;</td> 
                                                    <td width="30%">Year: <select  name="year">
                                                            <option value="2013">2013</option>
                                                            <option value="2014">2014</option>
                                                            <option value="2015">2015</option>
                                                            <option value="2016">2016</option>
                                                            
                                                        </select></td>
                                                    <td width="25%"><input type="submit" value="Get Payslip" class="btn btn-info add-row addrow-btn-left" /></td>
                                                </tr>
                                            </table>
                                        </form>
                                    </div>
                                    <div class="col-sm-8">
                                        <!--<div class="form-group visible-sm visible-md visible-lg">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="purorder.search" text="Label value is missing !!!"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <input id="filter" class="form-control" type="text"/>
                                            </div>
                                        </div>
                                        <div class="form-group visible-xs">
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
                                                <spring:message code="label.employeenumber" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.firstname" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.lastname" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.salary" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.deduction" text="Label value is missing !!!"/> 
                                            </th>
                                             <th data-hide="phone">
                                                <spring:message code="label.net" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone" data-name="Delete">
                                                <spring:message code="label.purorder.action" text="Label value is missing !!!"/> 
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="employee" items="${employeeList}">
                                            <tr>
                                                
                                                <td>${payslipmap[employee].employeeNumber}</td>
                                                <td>${payslipmap[employee].firstName}</td>   
                                                <td>${payslipmap[employee].lastName}</td>   
                                                <td>${payslipmap[employee].salary}</td>   
                                                <td>${payslipmap[employee].deductions}</td>   
                                                <td>${payslipmap[employee].total}</td>   
                                                <td>
                                                    <a href="payslip_detail.html?id=${employee}" class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</a>
                                                </td>
                                            </tr>                                        
                                        </c:forEach>
                                    </tbody>
                                    <!--<tfoot class="hide-if-no-paging">
                                        <tr>
                                            <td colspan="8">
                                                <div class="pagination pagination-centered"></div>
                                            </td>
                                        </tr>
                                    </tfoot>-->
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

