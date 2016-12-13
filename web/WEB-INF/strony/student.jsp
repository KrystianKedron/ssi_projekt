<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
        <h1><spring:message code="label.wprowadz" /> </h1>
        <c:url var="student_url"  value="/student" />    
        <form:form commandName="student" method="post" action="${student_url}">
            <form:hidden path="id" id="id"/>
            <table>
                <tr>
                    <td><label><spring:message code="label.imie" /></label></td>
                    <td><form:input path="imie" id="imie"/></td>
                    <td><form:errors path="imie"/> </td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.nazwisko" /></label></td>
                    <td><form:input path="nazwisko" id="nazwisko"/></td>
                    <td><form:errors path="nazwisko"/> </td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.uczelnia" /></label></td>
                    <td><form:input path="uczelnia" id="uczelnia"/></td>
                    <td><form:errors path="uczelnia"/> </td>
                </tr>
                <tr>
                    <spring:message code="input.zapisz" var="zapisz" />
                    <td><input type="submit" name="zapisz" value="${zapisz}"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
