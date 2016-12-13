<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<c:url value="/student?siteLanguage=pl"/>">PL</a> | <a href="<c:url value="/student?siteLanguage=en"/>">EN</a> <br/>
        <spring:message code="label.list" />
        <table>
            <tr>
            <th> <spring:message code="label.imie" /> |</th>
            <th> <spring:message code="label.nazwisko" /> | </th>
            <th> <spring:message code="label.uczelnia" /></th>
            </tr>
            <c:forEach items="${studenci}" var="student">
                <tr>
                    <td>${student.imie}</td>
                    <td>${student.nazwisko}</td>
                    <td>${student.uczelnia}</td>
                    <td>
                        <form action="<c:url value="/student/edytuj/${student.id}"/>" method="post">
                             <button type="submit">  <spring:message code="button.edytuj" /> </button>
                        </form>
                    </td>
                    <td>
                        <form action="<c:url value="/student/usun/${student.id}"/>" method="post">
                        <button type="submit"> <spring:message code="button.usun" /> </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="<c:url value="/student/nowy"/>"> <spring:message code="a.dodajNowego" /></a>
    </body>
</html>