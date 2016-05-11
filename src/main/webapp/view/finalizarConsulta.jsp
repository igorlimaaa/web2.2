<%-- 
    Document   : finalizarConsulta
    Created on : 07/05/2016, 21:56:28
    Author     : Eduardo
--%>

<h2>Finalizar Consulta</h2>

<hr>

<form role="form" action="FinalizarConsultaServlet" method="post" class="form-horizontal">

    <div class="form-group-lg">
        <label for="paciente">Paciente: </label>
        <span id="paciente">${requestScope['consulta'].usuario.nome} ${requestScope['consulta'].usuario.sobrenome}</span>
    </div>
    
    <div class="form-group-lg">
        <label for="especialidade">Especialidade:</label>
        <span id="especialidade">${requestScope['consulta'].especialidade}</span>
    </div>

    <div class="form-group-lg">
        <label for="medico">M�dico:</label>
        <span id="medico">${requestScope['consulta'].medico.nome} ${requestScope['consulta'].medico.sobrenome}</span>
    </div>

    <div class="form-group-lg">

        <label for="clinica">Cl�nica:</label>
        <span id="clinica">${requestScope['consulta'].clinica.nome}</span>

    </div>

    <div class="form-group-lg">
        <label for="data">Data:</label>
        <span id="data">${requestScope['consulta'].data}</span>
    </div>

    <div class="form-group-lg">
        <label for="diagnostico">Diagn�stico: </label>
        <textarea placeholder="Descreva o diagn�stico do paciente." id="diagnostico" rows="4" name="diagnostico" class="form-control"  tabindex="1"></textarea>
    </div>

    <div class="form-group-lg">
        <label for="medicamentos">Medicamentos:</label>
        <textarea placeholder="Descreva os medicamentos receitados para o paciente." id="medicamentos" rows="4" name="medicamentos" class="form-control" tabindex="2"></textarea>
    </div>

    <hr>
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <button class="btn btn-success btn-block btn-lg" type="submit" tabindex="3">Finalizar</button>
        </div>
        <div class="col-xs-12 col-md-6">
            <a class="btn btn-warning btn-block btn-lg" href="HomeMedicoServlet" tabindex="4">Cancelar</a>
        </div>
    </div>
</form>
