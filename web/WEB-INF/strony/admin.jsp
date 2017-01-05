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

<body id="admin-wrapper">

    <div class="admin-site">
        <nav class="navbar navbar-static-top">
            <div class="container-fluid">
                <div class="navbar-option pull-left">
                    <h3>ME&BIKE</h3>
                </div>
                <div class="navbar-option pull-right">
                    <a href="<c:url value="main" />" class="pull-right"><p>Wyloguj</p></a>
                    <a href="#" class="pull-right"><p>${admin.imie} ${admin.nazwisko}</p> <i class="fa fa-caret-down" aria-hidden="true"></i></p></a>
                </div>
            </div>
        </nav>
        <div class="sidebar-left">
            <div class="sidebar-option">
                <span class="sidebar-option-title">Admin</span>
                <ul>
                    <li><a href="<c:url value="/main/przydziel_zadania" />"><i class="fa fa-bookmark-o" aria-hidden="true"></i> Przydziel zadania</a></li>
                    <li><a href="<c:url value="/main/uzytkownicy" />"><i class="fa fa-male" aria-hidden="true"></i> Użytkownicy</a></li>
                    <li><a href="/ssi_projekt/main/cennik"><i class="fa fa-money" aria-hidden="true"></i> Cennik</a></li>
                    <li><a href="/ssi_projekt/main/ustawienia"><i class="fa fa-cogs" aria-hidden="true"></i> Ustawienia</a></li>
                </ul>
            </div>
        </div>
        <div class="main-wrapper">
            <div class="main-wrapper-inner">

                <div class="main-panel">
                    <h3 class="text-center">Admin</h3>
                    <h6 class="text-center">Przydziel zadania</h6>
                    
                    
                    
                    <c:url var="przydziel_url" value="/main/dodaj" />  
                    <form:form action="${przydziel_url}" method="post" modelAttribute="przydziel">
                    <div class="col-xs-6">
                        <p class="text-center" style="font-weight: 700;">Zadanie: </p>
                        <form:select path="zadanie" name="zadanie" class="input-own">
                            <c:forEach items="${zadania}" var="zad">
                                <form:option value="${zad.id}">${zad.opis}</form:option>>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="col-xs-6">
                        <p class="text-center" style="font-weight: 700;">Pracownik: </p>
                        <form:select path="pracownik" name="pracownik" class="input-own">
                             <c:forEach items="${pracownicy}" var="pra">
                                 <form:option value="${pra.id}">${pra.imie} 
                                     ${pra.nazwisko} </form:option>>
                             </c:forEach>
                        </form:select>
                    </div>
                    <input class="btn btn-custom pull-right" style="margin-top:15px; margin-right: 20px;" 
                           type="submit" value="Przydziel zadanie"/>
                    </form:form>

                    <div class="col-xs-12" id="przydzielone-zdania">
                        <h5 style="text-transform: uppercase; font-size: 20px;">Przydzielone zadania:</h5>
                         <c:forEach items="${aktywne}" var="akt">
                             <p>${akt[0]} ${akt[1]} - <span>${akt[2]}</span> <a href="usun/${akt[2]}" class="fa fa-times" aria-hidden="true"></a></p>
                         </c:forEach>  
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
