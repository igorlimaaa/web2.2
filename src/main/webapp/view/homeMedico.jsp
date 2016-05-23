<%-- 
    Document   : homeMedico
    Created on : 07/05/2016, 18:19:24
    Author     : Eduardo
--%>

<p>Seja Bem-Vindo!</p>

<h4>Listas de Consultas</h4>

<hr />

<div class="bloco-consulta">

    <div class="row">

        <div class="col-md-8 form-group">
            <span class="table-label">Paciente: </span>
            <span>${requestScope['consulta'].usuario.nome}</span>
        </div>
        <div class="col-md-4">
            <a href="FinalizarConsultaServlet" class="btn btn-block btn-info">Atender</a>
        </div>

    </div>

    <div class="row">
        <div class="col-md-8">
            <span class="table-label">Especialidade: </span>
            <span>${requestScope['consulta'].especialidade}</span>
        </div>
        <div class="col-md-4">
            <a href="VisualizarHistoricoServlet" class="btn btn-block btn-info">Histórico</a>
        </div>
    </div>
</div>