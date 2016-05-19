<%-- 
    Document   : marcarConsulta
    Created on : 24/04/2016, 19:57:13
    Author     : Eduardo
    Author     : Igorlima
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Marcar Consulta</h2>

<hr>

<form role="form" action="MarcarConsultaServlet" method="post" class="form-horizontal">

    <div class="form-group-lg">
        <label for="especialidade">Especialidade:</label>
        
        <select name="especialidade" id="especialidade" class="form-control input-lg" tabindex="1">
            <option>Selecione</option>
        </select>
        
    </div>
    
    <div class="form-group-lg">
        <label for="medico">Médico:</label>
        
        <select name="medico" id="medico" class="form-control input-lg" tabindex="2">
            <option>Selecione</option>
        </select>
        
    </div>
    
    <div class="form-group-lg">
        <label for="clinica">Clínica:</label>
        <select name="comboClinica" class="form-control input-lg" tabindex="2">
            <option value="">Selecione</option>
            <c:forEach var="clinica" items="${clinicas}">
                <option value="${clinica.codigo}">
                    ${clinica.nome}
                </option>
             </c:forEach>
        </select>
    </div>
    
    <div class="form-group-lg">
        <label for="data">Data:</label>
        
        <input type="date" id="data" name="data" class="form-control input-lg" tabindex="4" />
        
    </div>

    <hr>
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <button class="btn btn-success btn-block btn-lg" type="submit" tabindex="5">Confirmar</button>
        </div>
        <div class="col-xs-12 col-md-6">
            <a class="btn btn-warning btn-block btn-lg" href="HomeUsuarioServlet" tabindex="6">Cancelar</a>
        </div>
    </div>
</form>

