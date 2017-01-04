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
                    <label>
                        <a href="index.html" style="text-decoration: none"><h3 style="color: black">ME&BIKE</h3></a>
                    </label>
                </div>
                <div class="navbar-option pull-right">
                    <a href="index.html" class="pull-right"><p>Wyloguj</p></a>
                    <a href="#" class="pull-right"><p>Jan Kowalski <i class="fa fa-caret-down" aria-hidden="true"></i></p></a>
                </div>
            </div>
        </nav>
        <div class="sidebar-left">
            <div class="sidebar-option">
                <span class="sidebar-option-title">Pracownik</span>
                <ul>
                    <li><a href="#"><i class="fa fa-check-circle" aria-hidden="true"></i> Moje zadania</a></li>
                    <li><a href="pracownikGrafik.html"><i class="fa fa-gg-circle" aria-hidden="true"></i> Grafik</a></li>
                    <li><a href="pracownikCennik.html"><i class="fa fa-money" aria-hidden="true"></i> Cennik usług</a></li>
                </ul>
            </div>
           
        </div>
        <div class="main-wrapper">
            <div class="main-wrapper-inner">

                <div class="main-panel">
                    <h3 class="text-center">Pracownik</h3>
                    <h6 class="text-center">Moje zadania</h6>

                    <div class="col-xs-6">
                        <p class="text-center" style="font-weight: 700;">Zadanie: </p>
                        <select name="" id="" class="input-own">
                            <option value="10">Hamulce</option>
                            <option value="10">Napęd</option>
                            <option value="10">Przerzutki</option>
                            <option value="10">Stery</option>
                            <option value="10">Zawieszenie</option>
                            <option value="10">Koła/ opony</option>
                            <option value="10">Montaż i regulacja</option>
                            <option value="10">Serwis napędu</option>
                            <option value="10">Przegląd</option>
                            <option value="10">Inne</option>
                        </select>
                    </div>

                    <div class="col-xs-6">
                        <p class="text-center" style="font-weight: 700;">Pracownik: </p>
                        <select name="" id="" class="input-own">
                            <option value="10">Jan Kowalski</option>
                        </select>
                    </div>

                    <div class="col-xs-12" id="przydzielone-zdania">
                        <h5 style="text-transform: uppercase; font-size: 20px;">Przydzielone zadania:</h5>
                        <p>Jan Kowalski - <span>Zawieszenie</span> <i class="fa fa-times" aria-hidden="true"></i></p>
                        <p>Jan Kowalski - <span>Przegląd</span> <i class="fa fa-times" aria-hidden="true"></i></p>
                    </div>

                </div>

            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
</body>
</html>
