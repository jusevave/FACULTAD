<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <!--<link rel="icon" href="img/favicon.ico">-->
        <script src="js/jquery.js" ></script>
        <script src="js/bootstrap.min.js"></script>           
        <link href="css/login.css" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>
        <center>
            <img src="img/logoUnillanos.png" width="100%" class="img-fluid" style="padding-left: 30px;padding-right: 30px;max-width: 200px" alt="" />
        </center>
        <form class="form-signin" method ="post" action="GestionSesion">
            <center>
                <center><h2 class="form-signin-heading">Iniciar Sesión</h2></center>
                <div class="form-group">
                  <input type="text" class="form-control" name="user"  placeholder="Usuario" required>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="pass" placeholder="Contraseña" required=>
                </div>
                <button type="submit" name="opcion" value="iniciar" class="btn btn-outline-danger">Entrar</button>
            </center>
            <br>
            <%if(request.getAttribute("incorrecto")!= null){%>
            <div class="alert alert-warning" role="alert">
                <%= request.getAttribute("incorrecto")%>
            </div>
            <%}%>
        </form>
        
    </body>
</html>
