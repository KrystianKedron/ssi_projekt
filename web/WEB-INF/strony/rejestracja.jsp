<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SSI</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300,400,700" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body id="login-wrapper">

    <div class="container-fluid no-padding login-wrapper-inner">
        <div class="col-xs-4 no-padding left-side">
            <div class="left-side-inner">
                <div class="logo-wrapper">
                    <img src="<c:url value="/resources/img/logo.png" />" alt="">
                    <h4>Me&Bike</h4>
                </div>
                <div class="logo-desc">
                    <h2>Me&Bike</h2>
                    <h6>Serwis Rowerowy</h6>
                    <p>Zepsuł Ci się Twój nieodzowny przyjaciel szosy? Potrzebuje nowych gadżetów? A może wymaga małego odświeżenia? Jeśli na jedno z tych pytań odpowiedź brzmi TAK - koniecznie zaloguj się do naszego serwisu!</p>
                </div>
            </div>
        </div>
        <div class="col-xs-8 no-padding right-side">
            <div class="right-side-inner">
                <div class="col-xs-6 col-xs-offset-3">
                    <div class="login-form">
                        <label class="col-md-offset-3" style="font-size: 2vmax;">
                            <spring:message code="label.wprowadz" /> </label>
                            <c:url var="main_url"  value="/main" />    
                            <form:form commandName="user" method="post" action="${main_url}">
                                <form:hidden path="id" id="id"/>
                                <div class="form-group col-md-offset-1" style="margin-top: 30px;">
                                        <label><spring:message code="label.imie" /></label>
                                        <form:input path="email" id="email"/>
                                        <form:errors path="email"/>
                                </div>
                                <div class="form-group" style="margin-bottom: 30px;">
                                        <label><spring:message code="label.nazwisko" /></label>
                                        <form:input path="haslo" id="haslo"/>
                                        <form:errors path="haslo"/>
                                </div>  
                                    <spring:message code="input.zapisz" var="zapisz" />
                                    <input class="btn btn-custom pull-right" type="submit" name="zapisz" value="${zapisz}"/>
                            </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/js/script.css" />></script>
</body>
</html>