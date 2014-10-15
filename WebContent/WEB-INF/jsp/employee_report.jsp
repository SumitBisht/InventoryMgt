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

                                    <li class='has-sub active'><a href='#'><span>Reports</span></a>
                                        <ul style='display: block;'>
                                            <li class="active"><a href='report.htm'><span>Items</span></a></li>
                                            <li><a href='hr_employee_report.html'><span>Employee</span></a></li>
                                                  </ul>
                            </div>
                           
                        <%-- <div id='cssmenu'>
                            <ul>
                                <li class='has-sub active'><a href='employee.html'><span><spring:message code="menu.employeemanagement" text="Label value is missing !!!"/></span></a>
                                    <li class=''><a href='access_control.html'><span><spring:message code="menu.empmanagement.acl" text="Label value is missing !!!"/></span></a></li>
                                <li class=''><a href='payslips_list.html'><span><spring:message code="menu.payslips" text="Label value is missing !!!"/></span></a></li>
                                <li class=''><a href='#'><span><spring:message code="menu.employeeleavemanagement" text="Label value is missing !!!"/></span></a>
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
                                
                                <li class='last'><a href='#'><span><spring:message code="menu.listmanagement" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li class='last'><a href='hr_employee_report.html'><span><spring:message code="menu.employeereport" text="Label value is missing !!!"/></span></a></li>
                                    </ul>
                                </li>
                                
                            </ul>
                            
                        </div>
 --%>                        <!-- END MUNU -->    
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="menu.employeereport" text="Label value is missing !!!"/></div>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                                <table id="dttable" class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                    <thead class="orange-bg border-t">
                                        <tr>
                                            <th data-toggle="true">
                                                <spring:message code="label.employee.emp_number" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.employee.user_name" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.employee.designation" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone" data-name="Edit">
                                                <spring:message code="label.employee.edit" text="Label value is missing !!!"/> 
                                            </th>  
                                            <th data-hide="phone" data-name="Delete">
                                                <spring:message code="label.employee.delete" text="Label value is missing !!!"/> 
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="empl" items="${employees}">
                                            <tr>
                                                <td>${empl.employeeNumber}</td>
                                                <td>${empl.username}</td>                                                
                                                <td>${empl.jobTitle}</td>
                                                <td>
                                                    <a href="edit_employee.html?id=${empl.id}" class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</a>
                                                </td>
                                                <td>
                                                    <a href="delete_employee.html?id=${empl.id}" class="btn btn-default btn-sm row-delete" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</a>
                                                </td>
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
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.responsive.min.js"></script>
        <script src="js/ajax-bootstrap3.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("#fromDate").datepicker({
                    dateFormat: 'yy/mm/dd'
                });
                $("#toDate").datepicker(
                        {dateFormat: 'yy/mm/dd'});
                var table = $('#dttable').DataTable();
                $('.row-delete').click(function(eve) {
                    var row = this;
                    eve.preventDefault();
                    $.ajax({
                        url: $(row).attr('href')
                        , success: function(response) {
                            if (response === true) {
                                table.row($(row).closest('tr')).remove().draw(false);
                            }
                        }
                    });
                    return false;
                });
            });
        </script>
    </body>
</html>