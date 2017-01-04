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
                    <a href="index.html" class="pull-right"><p>Wyloguj</p></a>
                    <a href="#" class="pull-right"><p>${admin.imie} ${admin.nazwisko}<i class="fa fa-caret-down" aria-hidden="true"></i></p></a>
                </div>
            </div>
        </nav>
        <div class="sidebar-left">
            <div class="sidebar-option">
                <span class="sidebar-option-title">Admin</span>
                <ul>
                    <li><a href="adminPrzydzielZadania.html"><i class="fa fa-bookmark-o" aria-hidden="true"></i> Przydziel zadania</a></li>
                    <li><a href="#"><i class="fa fa-male" aria-hidden="true"></i> Użytkownicy</a></li>
                    <li><a href="adminGrafik.html"><i class="fa fa-gg-circle" aria-hidden="true"></i> Grafik</a></li>
                    <li><a href="adminCennik.html"><i class="fa fa-money" aria-hidden="true"></i> Cennik</a></li>
                    <li><a href="adminUstawienia.html"><i class="fa fa-cogs" aria-hidden="true"></i> Ustawienia</a></li>
                </ul>
            </div>            
        </div>
        <div class="main-wrapper">
            <div class="main-wrapper-inner">

                <div class="main-panel">
                    <h3 class="text-center">Użytkownicy systemu</h3>


                    <!-- *****************************************pracownicy *************************************** -->
                    <div class="collapse-group">
                    <h4><a href="#colPracownicy" data-toggle="collapse" style="text-decoration: none">PRACOWNICY</a></h4>

                    <div id="colPracownicy" class="collapse panel-group">
                        <c:forEach items="${pracownicy}" var="pra">
                        <div class="panel panel-default" >
                            <a data-toggle="collapse" data-parent="#colPracownicy" style="text-decoration: none"><h5>${pra.imie} ${pra.nazwisko}</h5></a>
                            <div class="uzytkownik collapse in">
                                <span class="guzikiDoEdycji">
                                    <a href="edytuj/${pra.id}" class="button btn btn-success"> Edytuj dane</a>
                                    <button class="btn btn-danger">Usuń pracownika</button>
                                </span>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    </div>
                    <hr>

                    <!-- *************************klienci****************************** -->

                    <h4><a href="#colKlienci" data-toggle="collapse"  style="text-decoration: none">KLIENCI</a></h4>
                    <div id="colKlienci" class="panel-group collapse">
                        <c:forEach items="${users}" var="usr">
                            <div class="panel panel-default">
                                <a data-toggle="collapse" data-parent="#colKlienci" style="text-decoration: none"><h5>${usr[1]}</h5></a>
                                <div class="uzytkownik collapse in">
                                    <span class="guzikiDoEdycji">
                                       <a href="pracownik/${usr[0]}" class="button btn btn-success" aria-hidden="true" > Dodaj jako pracownik</a>
                                        <button class="btn btn-danger">Usuń Klienta</button>
                                    </span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <hr>

            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/jss/scrpit.js" />></script>
</script>
</body>
</html>
