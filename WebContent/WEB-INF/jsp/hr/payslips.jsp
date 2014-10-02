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
                                <li class=''><a href='access_control.html'><span><spring:message code="menu.empmanagement.acl" text="Label value is missing !!!"/></span></a></li>
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
                        <div class="cat-box-title top-radius"></div>

                        <div class="tab-pane active" id="demo">
                                <div class="row tb-margin">
                                    <div class="col-sm-4">
                                        <a href="create_payslip.html" class="btn btn-info add-row addrow-btn-left">Create Payslip</a>
                                    </div>
                                    
                                </div>
                                <table id="dttable" class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                    <thead class="orange-bg border-t">
                                        <tr>
                                            <th data-toggle="true">
                                            Ref No.
                                            </th>
                                            <th data-toggle="true">
                                            Employee No.
                                            </th>
                                            <th data-toggle="true">
                                            Employee Name
                                            </th>
                                            <th data-toggle="true">
                                            Net Salary
                                            </th>
                                            <th data-toggle="true">
                                            Date
                                            </th>
                                            <th data-sort-ignore="true" ></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Isidra</td>
                                            <td><a href="#">Boudreaux</a></td>
                                            <td data-value="78025368997">225500</td>
                                            <td data-value="370961043292">10 Aug 2014</td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Shona</td>
                                            <td>Woldt</td>
                                            <td data-value="370961043292">370961043292</td>
                                            <td data-value="370961043292">10 Aug 2014</td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Granville</td>
                                            <td>Leonardo</td>
                                            <td data-value="-22133780420">11969</td>
                                            <td data-value="370961043292">10 Aug 2014</td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Easer</td>
                                            <td>Dragoo</td>
                                            <td data-value="250833505574">2251977</td>
                                            <td data-value="370961043292">10 Aug 2014</td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Maple</td>
                                            <td>Halladay</td>
                                            <td data-value="694116650726">301991</td>
                                            <td data-value="370961043292">10 Aug 2014</td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Maxine</td>
                                            <td><a href="#">Woldt</a></td>
                                            <td data-value="561440464855">171987</td>
                                            <td data-value="370961043292">10 Aug 2014</td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Lorraine</td>
                                            <td>Mcgaughy</td>
                                            <td data-value="437400551390">111983</td>
                                            <td data-value="370961043292">10 Aug 2014</td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Lizzee</td>
                                            <td><a href="#">Goodlow</a></td>
                                            <td data-value="-257733999319">11961</td>
                                            <td data-value="370961043292">10 Aug 2014</td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Judi</td>
                                            <td>Badgett</td>
                                            <td data-value="362134712000">231981</td>
                                            <td data-value="370961043292">10 Aug 2014</td>
                                            <td><a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        </tr>
                                        <tr>
                                            <td>1155222</td>
                                            <td>Lauri</td>
                                            <td>Hyland</td>
                                            <td data-value="500874333932">151985</td>
                                            <td data-value="370961043292">10 Aug 2014</td>
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
