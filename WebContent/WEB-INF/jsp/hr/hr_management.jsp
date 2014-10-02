<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <li class=''><a href='access_control.html'><span><spring:message code="menu.empmanagement.acl" text="Label value is missing !!!"/></span></a></li>
                                <li class=''><a href='payslips_list.html'><span>PaySlips</span></a></li>
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
                                        <li><a href='employee_category.html'><span>Employee Category</span></a></li>
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
                        <div class="cat-box-title top-radius"></div>

                        <div class="tab-pane active" id="demo">
                                <div class="row tb-margin">
                                    <div class="col-sm-4">
                                        <a href="addemployee.html" class="btn btn-info add-row addrow-btn-left">Add Employee</a>
                                    </div>
                                    
                                </div>
                                <table id="dttable" class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                    <thead class="orange-bg border-t">
                                        <tr>
                                            <th data-toggle="true">
                                            Employee No.
                                            </th>
                                            <th data-toggle="true">
                                            First Name
                                            </th>
                                            <th data-toggle="true">
                                            Date of Birth
                                            </th>
                                            <th data-toggle="true">
                                            Department
                                            </th>
                                            <th data-toggle="true">
                                            Category
                                            </th>
                                            <th data-toggle="true">
                                            Position  
                                            </th>
                                            <th data-sort-ignore="true" data-hide="phone" data-name="Delete"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Isidra</td>
                                            <td><a href="#">Boudreaux</a></td>
                                            <td>Traffic Court Referee</td>
                                            <td data-value="78025368997">22 Jun 1972</td>
                                            <td data-value="1"><span class="status-metro status-active" title="Active">Active</span></td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Shona</td>
                                            <td>Woldt</td>
                                            <td><a href="#">Airline Transport Pilot</a></td>
                                            <td data-value="370961043292">3 Oct 1981</td>
                                            <td data-value="2"><span class="status-metro status-disabled" title="Disabled">Disabled</span></td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Granville</td>
                                            <td>Leonardo</td>
                                            <td>Business Services Sales Representative</td>
                                            <td data-value="-22133780420">19 Apr 1969</td>
                                            <td data-value="3"><span class="status-metro status-suspended" title="Suspended">Suspended</span></td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Easer</td>
                                            <td>Dragoo</td>
                                            <td>Drywall Stripper</td>
                                            <td data-value="250833505574">13 Dec 1977</td>
                                            <td data-value="1"><span class="status-metro status-active" title="Active">Active</span></td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Maple</td>
                                            <td>Halladay</td>
                                            <td>Aviation Tactical Readiness Officer</td>
                                            <td data-value="694116650726">30 Dec 1991</td>
                                            <td data-value="3"><span class="status-metro status-suspended" title="Suspended">Suspended</span></td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Maxine</td>
                                            <td><a href="#">Woldt</a></td>
                                            <td><a href="#">Business Services Sales Representative</a></td>
                                            <td data-value="561440464855">17 Oct 1987</td>
                                            <td data-value="2"><span class="status-metro status-disabled" title="Disabled">Disabled</span></td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Lorraine</td>
                                            <td>Mcgaughy</td>
                                            <td>Hemodialysis Technician</td>
                                            <td data-value="437400551390">11 Nov 1983</td>
                                            <td data-value="2"><span class="status-metro status-disabled" title="Disabled">Disabled</span></td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Lizzee</td>
                                            <td><a href="#">Goodlow</a></td>
                                            <td>Technical Services Librarian</td>
                                            <td data-value="-257733999319">1 Nov 1961</td>
                                            <td data-value="3"><span class="status-metro status-suspended" title="Suspended">Suspended</span></td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Judi</td>
                                            <td>Badgett</td>
                                            <td>Electrical Lineworker</td>
                                            <td data-value="362134712000">23 Jun 1981</td>
                                            <td data-value="1"><span class="status-metro status-active" title="Active">Active</span></td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Lauri</td>
                                            <td>Hyland</td>
                                            <td>Blackjack Supervisor</td>
                                            <td data-value="500874333932">15 Nov 1985</td>
                                            <td data-value="3"><span class="status-metro status-suspended" title="Suspended">Suspended</span></td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                    </tbody>
                                    <tfoot class="hide-if-no-paging">
                                        <tr>
                                            <td colspan="6">
                                                <div class="pagination pagination-centered"></div>
                                            </td>
                                        </tr>
                                    </tfoot>
                                </table>
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
