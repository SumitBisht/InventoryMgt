<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp"></jsp:include>
            <script type="text/javascript">
                function submitDetailsForm() {
                    return true;
                }
            </script>

            <style>
                .error {
                    color: #ff0000;
                }

                .errorblock {
                    color: #000;
                    background-color: #ffEEEE;
                    border: 3px solid #ff0000;
                    padding: 8px;
                    margin: 16px;
                }
            </style>

        </head>

        <body role="document">

        <jsp:include page="headermenu.jsp"></jsp:include>

            <div class="container">
                <div class="row container">
                    <div class="dashboard_main">
                        <div class="desh-icon-bg">
                            <img src="img/i-mgmt.png">
                        </div>
                        <div class="page-title-text"><spring:message code="label.updateempcategory" text="Default Text"/></div>
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
                <spring:message code="label.employee.number.placeholder" var="employeenumberplaceholder" text="Default Text" />
                <spring:message code="label.employee.category.placeholder" var="employeecategoryplaceholder" text="Default Text" />
                <spring:message code="label.employee.joiningdate.placeholder" var="joiningdateplaceholder" text="Default Text" />  
                <spring:message code="label.employee.firstname.placeholder" var="firstnameplaceholder" text="Default Text" />
                <spring:message code="label.employee.lastname.placeholder" var="lastnameplaceholder" text="Default Text" />     
                <spring:message code="label.employee.middlename.placeholder" var="middlenameplaceholder" text="Default Text" /> 
                <spring:message code="label.employee.gender.placeholder" var="genderplaceholder" text="Default Text" /> 
                <spring:message code="label.employee.jobtitle.placeholder" var="jobtitleplaceholder" text="Default Text" /> 
                <spring:message code="label.employee.department.placeholder" var="departmentplaceholder" text="Default Text" /> 
                <spring:message code="label.employee.reportingmanager.placeholder" var="reportingmanagerplaceholder" text="Default Text" /> 
                <spring:message code="label.employee.qualification.placeholder" var="qualificationplaceholder" text="Default Text" /> 
                <spring:message code="label.employee.experiencedetail.placeholder" var="experiencedetailplaceholder" text="Default Text" />
                <spring:message code="label.employee.expyears.placeholder" var="experienceyearsplaceholder" text="Default Text" />
                <spring:message code="label.employee.birthdate.placeholder" var="birthdateplaceholder" text="Default Text" />
                <spring:message code="label.employee.maritalstatus.placeholder" var="maritalstatusplaceholder" text="Default Text" />
                <spring:message code="label.employee.childrencount.placeholder" var="childrencountplaceholder" text="Default Text" />
                <spring:message code="label.employee.fathername.placeholder" var="fathernameplaceholder" text="Default Text" />
                <spring:message code="label.employee.mothername.placeholder" var="mothernameplaceholder" text="Default Text" />
                <spring:message code="label.employee.husbandname.placeholder" var="husbandnameplaceholder" text="Default Text" />
                <spring:message code="label.employee.homeaddress1.placeholder" var="homeaddress1placeholder" text="Default Text" />
                <spring:message code="label.employee.homeaddress2.placeholder" var="homeaddress2placeholder" text="Default Text" />
                <spring:message code="label.employee.homecity.placeholder" var="homecityplaceholder" text="Default Text" />
                <spring:message code="label.employee.homestate.placeholder" var="homestateplaceholder" text="Default Text" />
                <spring:message code="label.employee.homecountry.placeholder" var="homecountryplaceholder" text="Default Text" />
                <spring:message code="label.employee.homepincode.placeholder" var="homepincodeplaceholder" text="Default Text" />
                <spring:message code="label.employee.officeaddress1.placeholder" var="officeaddress1placeholder" text="Default Text" />
                <spring:message code="label.employee.officeaddress2.placeholder" var="officeaddress2placeholder" text="Default Text" />
                <spring:message code="label.employee.officecity.placeholder" var="officecityplaceholder" text="Default Text" />
                <spring:message code="label.employee.officestate.placeholder" var="officestateplaceholder" text="Default Text" />
                <spring:message code="label.employee.officecountry.placeholder" var="officecountryplaceholder" text="Default Text" />
                <spring:message code="label.employee.officepincode.placeholder" var="officepincodeplaceholder" text="Default Text" />
                <spring:message code="label.employee.officephone1.placeholder" var="officephone1placeholder" text="Default Text" />
                <spring:message code="label.employee.officephone2.placeholder" var="officephone2placeholder" text="Default Text" />
                <spring:message code="label.employee.mobilephone.placeholder" var="mobilephoneplaceholder" text="Default Text" />
                <spring:message code="label.employee.homephone.placeholder" var="homephoneplaceholder" text="Default Text" />
                <spring:message code="label.employee.email.placeholder" var="emailplaceholder" text="Default Text" />
                <spring:message code="label.employee.fax.placeholder" var="faxplaceholder" text="Default Text" />              
                <spring:message code="label.employee.passportno.placeholder" var="passportnoplaceholder" text="Default Text" />
                <spring:message code="label.employee.passportexpiry.placeholder" var="passportexoirydateplaceholder" text="Default Text" />
                <spring:message code="label.employee.iqamano.placeholder" var="iqamaplaceholder" text="Default Text" />
                <spring:message code="label.employee.iqamaexpiry.placeholder" var="iqamaexoirydateplaceholder" text="Default Text" />
                <spring:message code="label.employee.salary.placeholder" var="salaryplaceholder" text="Default Text" />
                <spring:message code="label.employee.accountnumber.placeholder" var="accountnumberplaceholder" text="Default Text" />
                <spring:message code="label.employee.bank.placeholder" var="bankplaceholder" text="Default Text" />
                <spring:message code="label.employee.codeno.placeholder" var="codenoplaceholder" text="Default Text" />
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="label.updateemployee" text="Default Text"/></div>
                        <div class="row text-pad-top visible-lg visible-md visible-sm">
                           
                           <c:forEach var="employee" items="employeeList">
                           <table>
                           <tr>
                           
                           <td>Employee Name</td>
                           <td>
                           ${employee.firstName}
                           </td>
                           </tr>
                           </table>
                           </c:forEach>
                           
                            </div>
                        </div>

                    </div>
                </div>

                <div class=""></div>
                <div class=""></div>

            </div>
        </div>
        <!-- /container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Jquery UI Javascript -->
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript">
                                         $(".datepicker").datepicker({dateFormat: 'dd/mm/yy'})
        </script>
    </body>
</html>