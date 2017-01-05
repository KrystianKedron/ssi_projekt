<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

<body id="admin-wrapper">

    <div class="admin-site">
        <nav class="navbar navbar-static-top">
            <div class="container-fluid">
                <div class="navbar-option pull-left">
                    <label>
                        <a href="index.html" style="text-decoration: none"><h3 style="color: black">ME&BIKE</h3></a>
                    </label>
                </div>
                <div class="navbar-option pull-right">
                    <a href="http://localhost:8080/SSI/main" class="pull-right"><p>Wyloguj</p></a>
                    <a href="#" class="pull-right"><p>${user.email}<i class="fa fa-caret-down" aria-hidden="true"></i></p></a>
                </div>
            </div>
        </nav>
        <div class="sidebar-left">
            <div class="sidebar-option">
                <span class="sidebar-option-title">Klient</span>
                <ul>
                    <li><a href="klientDane.html"><i class="fa fa-address-card-o" aria-hidden="true"></i> Moje dane</a></li>
                    <li><a href="#"><i class="fa fa-bicycle" aria-hidden="true"></i> Zamów usługę</a></li>
                    <li><a href="klientStatus.html"><i class="fa fa-question-circle-o" aria-hidden="true"></i> Status zamówienia</a></li>
                    <li><a href="klientCennik.html"><i class="fa fa-money" aria-hidden="true"></i> Cennik usług</a></li>
                </ul>
            </div>
        </div>
        <div class="main-wrapper">
            <div class="main-wrapper-inner">

               <div class="main-panel">
                    <h3 class="text-center">Złóż zamówienie</h3>
                    <h6 class="text-center">Zaufaj nam</h6>
                    <div class="zamow-form">                        
                        <div class="col-xs-6" style="padding-top: 10px;">
                            <p class="text-center" style="font-weight: 700; font-size: larger; text-align: left;">Zadanie:</p>
                            <c:url var="przydziel_url" value="/main/dodajZadanie" /> 
                            <form:form action="${przydziel_url}" method="post" modelAttribute="przydziel">
                                <div class="col-xs-6">
                                    <p class="text-center" style="font-weight: 700;">Zadanie: </p>
                                    <form:select path="zadanieString" name="zadanieString" class="input-own">
                                            <form:option value="Hamulce">Hamlulce</form:option>
                                            <form:option value="Kolo">Kolo</form:option>>
                                    </form:select>
                                </div>
                                <input type="submit" class="btn btn-success" name="" value="Złóż zamówienie" style="margin-top: 250px; float: right; margin-right: 20px; font-size: larger; " />
                            </form:form>
                        </div>
                    </div>
                    
                    
                
                </div>

            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <script src="<c:url value="/resources/jss/scrpit.js" />"></script>
</body>
</html>
