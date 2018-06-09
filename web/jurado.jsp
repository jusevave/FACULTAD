<%-- 
    Document   : jurado
    Created on : 20/05/2018, 10:14:47 PM
    
--%>

<%@page import="com.model.dto.TrabajoDeGradoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.dto.EvaluacionPropuestaDTO"%>
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
        <title>Jurado</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-12" align="right">
                <form action="GestionSesion" method="post">
                    <button type="submit" name="opcion" value="cerrar" class="btn btn-link">Cerrar sesión</button>
                </form>
            </div>
        </div>
        <%
        if(session.getAttribute("id") == null){
                response.sendRedirect("Login.jsp");
        }
        %>
        <div class="row">
            <div class="col-md-12" align="center">
                <h3>Nombre Jurado: <%= session.getAttribute("nombre")%></h3>
            </div>
                <% if(request.getAttribute("correcto") != null){ %>
                
                <div class="alert alert-success col-md-12" role="alert" align="center">
                    <%= request.getAttribute("correcto").toString() %>
                </div>
                
                <% } %>
                <% if(request.getAttribute("incorrecto") != null){ %>
                
                <div class="alert alert-danger col-md-12" role="alert" align="center">
                    <%= request.getAttribute("incorrecto").toString() %>
                </div>
                
                <% } %>
        </div>
        <div class="row" style="padding-right: 30px;padding-left: 30px;">
            <%
                        ArrayList<TrabajoDeGradoDTO> evaluacionesP = (ArrayList<TrabajoDeGradoDTO>)request.getAttribute("evaluacionesP");
                        if(evaluacionesP != null){
                    %>
            <div class="col-md-12">
                <label>Nombre del proyecto:</label>
                <form action="GestionJurado" method="post">
                    
                    <select class="form-control form-control-lg" name="evalucionesPendientes">
                        <%
                          for(TrabajoDeGradoDTO evaluacionp : evaluacionesP){
                        %>
                        <option value="<%= evaluacionp.getN_proyecto() %>"><%= evaluacionp.getNombre_proyecto() %></option>
                        <%      
                          }
                        
                        %>    
                    </select>
                    <br>
                    <center><button type="submit" name="opcion" value="evaluar" class="btn btn-primary">Evaluar Propuesta</button></center>
                </form>
            </div>
                    <%      
                          }
                        
                        %>
        </div>
        <%
            ArrayList<String> info = (ArrayList<String>)request.getAttribute("info");
            EvaluacionPropuestaDTO evaluacion = (EvaluacionPropuestaDTO)request.getAttribute("evaluacion");
            if(info != null){
        %>
        <label style="padding-left: 20px;padding-right: 30px;">Información del proyecto:</label>
        <div class="row" style="padding-left: 30px;padding-right: 30px;">
            
            <div class="col-md-4">
                <h5>Participante:</h5>
                <label><%= info.get(1) %></label>
            </div>
            <div class="col-md-4">
                <h5>Director:</h5>
                <label><%= info.get(0) %></label>
            </div>
            <div class="col-md-4">
                <h5>Programa</h5>
                <label><%= info.get(2) %></label>
            </div>
        </div>
            <div class="row" style="padding-right: 30px;padding-left: 30px;padding-bottom: 30px">
            <div class="col-md-12">
                <form action="" method="post">
                    <input type="text" name="nproyecto" value="<%= evaluacion.getN_proyecto() %>" style="display: none" >
                    <table class="table table-hover table-sm">
                        <thead>
                          <tr>
                              <th scope="col"><center>Apropiado(Marcar para SI)</center></th>
                            <th scope="col">Aspecto a evaluar</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                              <%
                                  if(evaluacion.getTitulo() == 1){
                              %>
                              <td><center><input name="caracteristicas" value="titulo" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="titulo" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Titulo</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getDescripcion()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="descripcion" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="descripcion" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Descripción del problema</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getHipotesis()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="hipotesis" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="hipotesis" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Hipótesis (cuando aplica)</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getObjetivos_generales()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="objetivog" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="objetivog" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Objetivos generales</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getObjetivos_especificos()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="objetivoe" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="objetivoe" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Objetivos específicos</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getJustificacion()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="justificacion" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="justificacion" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Justificación</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getMarco_referencia()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="marcof" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="marcof" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Marco de referencia, teórico y conceptual</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getMetodologia()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="metodologia" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="metodologia" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Metodología</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getResultados_esperados()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="resultadose" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="resultadose" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Resultados esperados</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getCronograma()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="cronograma" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="cronograma" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Cronograma de actividades</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getRecursos()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="recursos" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="recursos" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Recursos o presupuesto</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getLiteratura()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="literatura" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="literatura" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Literatura citada</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getRedaccion_ortografia()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="redaccion" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="redaccion" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Redacción y ortografía</td>
                          </tr>
                          <tr>
                            <%
                                  if(evaluacion.getPertinencia_formacion()== 1){
                              %>
                              <td><center><input name="caracteristicas" value="pertinencia" type="checkbox" class="form-check-input" checked></center></td>
                              <%
                                  }else{
                              %>
                              <td><center><input name="caracteristicas" value="pertinencia" type="checkbox" class="form-check-input"></center></td>
                              <%
                                  }
                              %>
                            <td>Pertinencia con el área de formación del estudiante</td>
                          </tr>
                        </tbody>
                    </table>
                    <div class="form-group">
                        <label for="exampleTextarea">Observaciones</label>
                        <textarea name="observaciones" class="form-control" id="exampleTextarea"  rows="3"><%= evaluacion.getObservaciones() %></textarea>
                    </div>
                    <center>
                    <label>Resultado Final</label><br>
                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <%
                                  if(evaluacion.getResultado()== 1){
                              %>
                              <input class="form-check-input" type="radio" name="resultado" id="inlineRadio1" value="1" checked> Pendiente
                           <%
                                  }else{
                              %>
                              <input class="form-check-input" type="radio" name="resultado" id="inlineRadio1" value="1"> Pendiente
                              <%
                                  }
                              %>
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <%
                                  if(evaluacion.getResultado()== 2){
                              %>
                          <input class="form-check-input" type="radio" name="resultado" id="inlineRadio2" value="2" checked> Aprobado
                          <%
                                  }else{
                              %>
                              <input class="form-check-input" type="radio" name="resultado" id="inlineRadio2" value="2"> Aprobado
                              <%
                                  }
                              %>
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <%
                                  if(evaluacion.getResultado()== 3){
                              %>
                              <input class="form-check-input" type="radio" name="resultado" id="inlineRadio3" value="3" checked> Reprobado
                              <%
                                  }else{
                              %>
                              <input class="form-check-input" type="radio" name="resultado" id="inlineRadio3" value="3"> Reprobado
                              <%
                                  }
                              %>
                        </label>
                    </div>
                    <br><br>
                    <button type="submit" name="opcion" value="registrar" class="btn btn-primary">Registrar evaluación</button></center>
                </form>
            </div>
        </div>
        <%        
            }
        %>
        
    </body>
</html>
