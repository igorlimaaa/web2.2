<%-- 
    Document   : editarConsulta
    Created on : 28/04/2016, 22:57:19
    Author     : Eduardo
--%>

<h2>Remarcar Consulta</h2>

<hr>

<form role="form" action="EditarConsultaServlet" method="post" class="form-horizontal">

    <div class="form-group-lg">
        <span>Especialidade:</span>
        
        <span>${requestScope['consultaEditar'].especialidade}</span>
        
    </div>
    
    <div class="form-group-lg">
        <span>M�dico:</span>
        
        <span>Dr(a). ${requestScope['consultaEditar'].medico}</span>
    </div>
        
    <div class="form-group-lg">

        <span>Cl�nica:</span>
        
        <span>${requestScope['consultaEditar'].clinica}</span>

    </div>
    
    <div class="form-group-lg">
        <label for="data">Data:</label>
        
        <input type="date" id="data" name="dataremarcada" class="form-control input-lg" tabindex="1" />
        
    </div>

    <hr>
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <button class="btn btn-success btn-block btn-lg" type="submit" tabindex="2">Confirmar</button>
        </div>
        <div class="col-xs-12 col-md-6">
            <a class="btn btn-warning btn-block btn-lg" href="VisualizarConsultaServlet" tabindex="3">Cancelar</a>
        </div>
    </div>
</form>

