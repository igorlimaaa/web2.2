<%-- 
    Document   : visualizarHistorico
    Created on : 07/05/2016, 21:56:16
    Author     : Eduardo
--%>


<h2>Histórico de Diagnóstico</h2>

<hr />

<c:choose>
    <c:when test="${requestScope['consultasRealizadas'].size() > 0}">

        <c:forEach items="${requestScope['consultasRealizadas']}" var="consulta">

            <table class="table-visualizar">
                <tbody>
                    <tr>
                        <td>
                            <span class="table-label">Especialidade:</span>
                            <span>${consulta.especialidade}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="table-label">Data:</span>
                            <span>${consulta.dataConsulta}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="table-label">Médico:</span>
                            <span>Dr(a). ${consulta.medico}</span>            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="table-label">Clínica:</span>
                            <span>${consulta.clinica}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="table-label">Diagnóstico: </span>
                            <span>${consulta.diagnostico.diagnostico}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="table-label">Medicamentos: </span>
                            <span>${consulta.diagnostico.medicamentos}</span>
                        </td>
                    </tr>
                </tbody>
            </table>

        </c:forEach>

    </c:when>

    <c:otherwise>
        <p>Não há histórico registrado.</p>
    </c:otherwise>
</c:choose>

<div class="button-voltar">
    <a class="btn btn-warning btn-block btn-lg" href="HomeMedicoServlet" tabindex="1">Voltar</a>
</div>