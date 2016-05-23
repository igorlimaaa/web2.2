<%-- 
    Document   : editarConsulta
    Created on : 28/04/2016, 22:57:19
    Author     : Eduardo
--%>

<h2>Editar Consulta</h2>

<hr>

<form role="form" action="EditarConsultaServlet" method="post" class="form-horizontal">

    <div class="form-group-lg">
        <span>Especialidade:</span>
        
        <span>${requestScope['consulta'].especialidade}</span>
        
    </div>
    
    <div class="form-group-lg">
        <label for="medico">Médico:</label>
        
        <select name="medico" id="medico" class="form-control input-lg" tabindex="1">
            <option>${requestScope['consulta'].medico.nome}</option>
        </select>
        
    </div>
    
    <div class="form-group-lg">

        <label for="clinica">Clínica:</label>
        <select name="clinica" id="clinica" class="form-control input-lg" tabindex="2">
            <option>${requestScope['consulta'].clinica.nome}</option>
        </select>

    </div>
    
    <div class="form-group-lg">
        <label for="data">Data:</label>
        
        <input type="date" id="data" name="data" class="form-control input-lg" tabindex="3" />
        
    </div>

    <hr>
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <button class="btn btn-success btn-block btn-lg" type="submit" tabindex="4">Confirmar</button>
        </div>
        <div class="col-xs-12 col-md-6">
            <a class="btn btn-warning btn-block btn-lg" href="VisualizarConsultaServlet" tabindex="5">Cancelar</a>
        </div>
    </div>
</form>

