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
                <spring:message code="label.employee.salary.placeholder" var="salaryplaceholder" text="Default Text" />
                <spring:message code="label.employee.accountnumber.placeholder" var="accountnumberplaceholder" text="Default Text" />
                <spring:message code="label.employee.bank.placeholder" var="bankplaceholder" text="Default Text" />
                <spring:message code="label.employee.codeno.placeholder" var="codenoplaceholder" text="Default Text" />
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="label.updateemployee" text="Default Text"/></div>
                        <div class="row text-pad-top visible-lg visible-md visible-sm">
                            <form:form action="edit_employee.html" method="POST" modelAttribute="employee">
                                <form:hidden path="id" />
                                <div class="row tb-margin">
                                    <div class="col-sm-2"></div>
                                    <div class="col-sm-8">

                                        <c:if test="${not empty error}">  
                                            <div class="row text-pad-top visible-lg visible-md visible-sm"><div class="errorblock">${error}</div></div>
                                            </c:if>
                                            <c:if test="${not empty success}">  
                                            <div class="row text-pad-top visible-lg visible-md visible-sm"><div class="successblock">${success}</div></div>
                                            </c:if>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.number" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="employeeNumber" placeholder="${employeenumberplaceholder}" />
                                                <form:errors path="employeeNumber" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.category" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="employeeCategoryId">
                                                    <form:option value=""><spring:message code="label.employee.category.placeholder" text="Default Text"/></form:option>
                                                    <form:options items="${employeeCategoryList}" itemLabel="category" itemValue="id"/>
                                                </form:select>
                                                <form:errors path="employeeCategoryId" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.employee.joiningdate" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="date" class="form-control" path="joiningDate" placeholder="${joiningdateplaceholder}" />
                                                <form:errors path="joiningDate" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.firstname" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="firstName" placeholder="${firstnameplaceholder}" />
                                                <form:errors path="firstName" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.lastname" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="lastName" placeholder="${lastnameplaceholder}" />
                                                <form:errors path="lastName" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.middlename" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="middleName" placeholder="${middlenameplaceholder}" />
                                                <form:errors path="middleName" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.gender" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <div class="form-control">
                                                    <form:radiobutton path="gender" value="1" checked="checked"/><spring:message code="label.employee.male" text="Default Text"/>
                                                    <form:radiobutton path="gender" value="0" /><spring:message code="label.employee.female" text="Default Text"/>
                                                </div>
                                                <form:errors path="gender" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.jobtitle" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="jobTitle" placeholder="${jobtitleplaceholder}" />
                                                <form:errors path="jobTitle" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.department" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="employeeCategoryId">
                                                    <form:option value=""><spring:message code="label.employee.department.placeholder" text="Default Text"/></form:option>
                                                    <form:options items="${employeeDepartmentList}" itemLabel="department" itemValue="id"/>
                                                </form:select>
                                                <form:errors path="employeeDepartmentId" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.reportingmanager" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="reportingManagerId">
                                                    <form:option value=""><spring:message code="label.employee.reportingmanager.placeholder" text="Default Text"/></form:option>
                                                    <form:options items="${employeeList}" itemLabel="employeeNumber" itemValue="id"/>
                                                </form:select>
                                                <form:errors path="reportingManagerId" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.qualification" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="qualification" placeholder="${qualificationplaceholder}" />
                                                <form:errors path="qualification" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.experiencedetail" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:textarea path="experienceDetail" rows="5" cols="30"  placeholder="${experiencedetailplaceholder}" />
                                                <form:errors path="experienceDetail" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.expyears" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="experienceYear" placeholder="${experienceyearsplaceholder}" />
                                                <form:errors path="experienceYear" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.expmonths" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="experienceMonth" placeholder="${experiencemonthsplaceholder}" />
                                                <form:errors path="experienceMonth" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.employee.birthdate" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="date" class="form-control" path="dateOfBirth" placeholder="${birthdateplaceholder}" />
                                                <form:errors path="dateOfBirth" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.maritalstatus" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="maritalStatus">
                                                    <form:option value=""><spring:message code="label.employee.maritalstatus.placeholder" text="Default Text"/></form:option>
                                                    <form:option value=""><spring:message code="label.employee.maritalstatus.single" text="Default Text"/></form:option>
                                                    <form:option value=""><spring:message code="label.employee.maritalstatus.married" text="Default Text"/></form:option>
                                                </form:select>
                                                <form:errors path="maritalStatus" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.childrencount" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="childrenCount" placeholder="${childrencountplaceholder}" />
                                                <form:errors path="childrenCount" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.fathername" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="fatherName" placeholder="${fathernameplaceholder}" />
                                                <form:errors path="fatherName" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.mothername" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="motherName" placeholder="${mothernameplaceholder}" />
                                                <form:errors path="motherName" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.husbandname" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="husbandName" placeholder="${husbandnameplaceholder}" />
                                                <form:errors path="husbandName" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.bloodgroup.placeholder" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="bloodGroup">
                                                    <form:option value=""><spring:message code="label.employee.bloodgroup.placeholder" text="Default Text"/></form:option>
                                                    <form:option value=""><spring:message code="label.employee.bloodgroup.apos" text="Default Text"/></form:option>
                                                    <form:option value=""><spring:message code="label.employee.bloodgroup.aneg" text="Default Text"/></form:option>
                                                    <form:option value=""><spring:message code="label.employee.bloodgroup.bpos" text="Default Text"/></form:option>
                                                    <form:option value=""><spring:message code="label.employee.bloodgroup.bneg" text="Default Text"/></form:option>
                                                    <form:option value=""><spring:message code="label.employee.bloodgroup.opos" text="Default Text"/></form:option>
                                                    <form:option value=""><spring:message code="label.employee.bloodgroup.oneg" text="Default Text"/></form:option>
                                                    <form:option value=""><spring:message code="label.employee.bloodgroup.abpos" text="Default Text"/></form:option>
                                                    <form:option value=""><spring:message code="label.employee.bloodgroup.abneg" text="Default Text"/></form:option>
                                                </form:select>
                                                <form:errors path="bloodGroup" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.homeaddress1" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="homeAddressLine1" placeholder="${homeaddress1placeholder}" />
                                                <form:errors path="homeAddressLine1" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.homeaddress2" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="homeAddressLine2" placeholder="${homeaddress2placeholder}" />
                                                <form:errors path="homeAddressLine2" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.homecity" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="homeCity" placeholder="${homecityplaceholder}" />
                                                <form:errors path="homeCity" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.homestate" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="homeState" placeholder="${homestateplaceholder}" />
                                                <form:errors path="homeState" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.homepincode" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="homePinCode" placeholder="${homepincodeplaceholder}" />
                                                <form:errors path="homePinCode" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.officeaddress1" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="officeAddressLine1" placeholder="${officeaddress1placeholder}" />
                                                <form:errors path="officeAddressLine1" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.officeaddress2" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="officeAddressLine2" placeholder="${officeaddress2placeholder}" />
                                                <form:errors path="officeAddressLine2" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.officecity" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="officeCity" placeholder="${officecityplaceholder}" />
                                                <form:errors path="officeCity" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.officestate" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="officeState" placeholder="${officestateplaceholder}" />
                                                <form:errors path="officeState" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.officepincode" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="officePinCode" placeholder="${officepincodeplaceholder}" />
                                                <form:errors path="officePinCode" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.officephone1" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="officePhone1" placeholder="${officephone1placeholder}" />
                                                <form:errors path="officePhone1" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.officephone2" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="officePhone2" placeholder="${officephone2placeholder}" />
                                                <form:errors path="officePhone2" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.mobilephone" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="mobilePhone" placeholder="${mobilephoneplaceholder}" />
                                                <form:errors path="mobilePhone" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.homephone" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="homePhone" placeholder="${homephoneplaceholder}" />
                                                <form:errors path="homePhone" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.email" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="email" placeholder="${emailplaceholder}" />
                                                <form:errors path="email" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.fax" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="fax" placeholder="${faxplaceholder}" />
                                                <form:errors path="fax" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.passportno" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="passportNumber" placeholder="${passportnoplaceholder}" />
                                                <form:errors path="passportNumber" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.employee.passportexpiry" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="date" class="form-control" path="passportExpiryDate" placeholder="${passportexoirydateplaceholder}" />
                                                <form:errors path="passportExpiryDate" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.salary" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="salary" placeholder="${salaryplaceholder}" />
                                                <form:errors path="salary" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.bank" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="bankId">
                                                    <form:option value=""><spring:message code="label.employee.bank.placeholder" text="Default Text"/></form:option>
                                                    <form:options items="${bankList}" itemLabel="name" itemValue="id"/>
                                                </form:select>
                                                <form:errors path="bankId" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.accountnumber" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="accountNumber" placeholder="${accountnumberplaceholder}" />
                                                <form:errors path="accountNumber" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.codeno" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="codeNumber" placeholder="${codenoplaceholder}" />
                                                <form:errors path="codeNumber" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.uploadimage" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input path="fileData" type="file"/>
<!--                                                <img src="/employee_image.html?id=?id=${employee.id}" height="75px" width="75px" align="left" />-->
                                                <form:errors path="fileData" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="col-sm-2"></div>
                                    </div>

                                    <div class="div-center">
                                        <button type="submit" class="btn btn-orange" onclick="return submitDetailsForm();"><spring:message code="label.update" text="Default Text"/></button>
                                        <button type="button" class="btn btn-orange" onclick="javascript:history.back();"><spring:message code="label.cancel" text="Default Text"/></button>
                                    </div>
                                </form:form>
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
                                        //    $('input[type=date]').datepicker({dateFormat: 'dd/mm/yy'});
        </script>
    </body>
</html>