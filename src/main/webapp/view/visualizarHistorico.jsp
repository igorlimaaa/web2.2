<%-- 
    Document   : visualizarHistorico
    Created on : 07/05/2016, 21:56:16
    Author     : Eduardo
--%>


<h2>Histórico de Diagnóstico</h2>

<hr />

<table class="table-visualizar">
    <tbody>
        <tr>
            <td>
                <span class="table-label">Especialidade:</span>
                <span>${requestScope['consulta'].especialidade}</span>
            </td>
        </tr>
        <tr>
            <td>
                <span class="table-label">Data:</span>
                <span>${requestScope['consulta'].data}</span>
            </td>
        </tr>
        <tr>
            <td>
                <span class="table-label">Médico:</span>
                <span>Dr(a). ${requestScope['consulta'].medico.nome}</span>            
            </td>
        </tr>
        <tr>
            <td>
                <span class="table-label">Clínica:</span>
                <span>${requestScope['consulta'].clinica.nome}</span>
            </td>
        </tr>
        <tr>
            <td>
                <span class="table-label">Endereço:</span>
                <span>${requestScope['consulta'].clinica.endereco.getEnderecoCompleto()}</span>
            </td>
        </tr>
        <tr>
            <td>
                <span class="table-label">Diagnóstico: </span>
                <span>${requestScope['consulta'].diagnostico.diagnostico}</span>
            </td>
        </tr>
        <tr>
            <td>
                <span class="table-label">Medicamentos: </span>
                <span>${requestScope['consulta'].diagnostico.medicamentos}</span>
            </td>
        </tr>
    </tbody>
</table>

<div class="button-voltar">
    <a class="btn btn-warning btn-block btn-lg" href="HomeMedicoServlet" tabindex="1">Voltar</a>
</div>