<%-- 
    Document   : marcarConsulta
    Created on : 24/04/2016, 19:57:13
    Author     : Eduardo
    Author     : Igorlima
--%>

<h2>Marcar Consulta</h2>

<hr>

<form id="formMarcar" role="form" action="MarcarConsultaServlet" method="post" class="form-horizontal" onsubmit="return validaData()">

    <div class="form-group-lg">
        <label for="especialidade">Especialidade:</label>
        
        <select name="especialidade" id="especialidade" class="form-control input-lg" tabindex="1">
            <option value="">Selecione</option>
            <c:forEach var="especialidade" items="${especialidades}">
                <option value="${especialidade}">
                    ${especialidade}
                </option>
            </c:forEach>
        </select>
        
    </div>
    
    <div class="form-group-lg">
        <label for="medico">Médico:</label>
        
        <select name="medico" id="medico" class="form-control input-lg" tabindex="2">
            <option value="">Selecione</option>
            <c:forEach var="medico" items="${medicos}">
                <option value="${medico.codigo}">
                    ${medico.nome}
                </option>
            </c:forEach>
        </select>
        
    </div>
    
    <div class="form-group-lg">
        <label for="clinica">Clínica:</label>
        <select name="clinica" id="clinica" class="form-control input-lg" tabindex="2">
            <option value="">Selecione</option>
            <c:forEach var="clinica" items="${clinicas}">
                <option value="${clinica.nome}">
                    ${clinica.nome}
                </option>
            </c:forEach>
        </select>
    </div>
    
    <div class="form-group-lg">
        <label for="data">Data:</label>
        
        <input type="date" id="data" name="data" class="form-control input-lg" tabindex="4" required="required" />
        
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

