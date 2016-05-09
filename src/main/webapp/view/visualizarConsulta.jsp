<%-- 
    Document   : visualizarConsulta
    Created on : 27/04/2016, 21:17:30
    Author     : Eduardo
--%>

<h2>Visualizar Consulta</h2>
<p>Visualize suas consultas marcadas.</p>

<hr />

<table class="table-visualizar">
    <tbody>
        <tr>
            <td>
                <span class="table-label">Especialidade:</span>
                <span>${requestScope['consulta'].especialidade}</span>
            </td>
            <td rowspan="5">
                <a href="EditarConsultaServlet" class="btn btn-link btn-block">Editar</a>
                <br />
                <a href="" class="btn btn-link btn-block">Excluir</a>
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
    </tbody>
</table>

<div class="button-voltar">
    <a class="btn btn-warning btn-block btn-lg" href="HomeUsuarioServlet" tabindex="1">Voltar</a>
</div>





