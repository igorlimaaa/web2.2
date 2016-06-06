<%-- 
    Document   : visualizarConsulta
    Created on : 27/04/2016, 21:17:30
    Author     : Eduardo
--%>


<h2>Visualizar Consulta</h2>
<p>Visualize suas consultas marcadas.</p>

<hr />

<c:choose>
    <c:when test="${requestScope['lConsultasMarcadas'].size() > 0}">

        <c:forEach items="${requestScope['lConsultasMarcadas']}" var="consulta">

            <table class="table-visualizar table-margin">
                <tbody>
                    <tr>
                        <td>
                            <span class="table-label">Especialidade:</span>
                            <span>${consulta.especialidade}</span>
                        </td>
                        <td rowspan="5">
                            <a href="EditarConsultaServlet?codigo=${consulta.codigo}" class="btn btn-link btn-block">Editar</a>
                            <br />
                            <a href="VisualizarConsultaServlet?codigo=${consulta.codigo}" class="btn btn-link btn-block">Excluir</a>
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
                </tbody>
            </table>

        </c:forEach>

    </c:when>

    <c:otherwise>
        <p>Não há consultas marcadas.</p>
    </c:otherwise>
</c:choose>


<div class="button-voltar">
    <a class="btn btn-warning btn-block btn-lg" href="HomeUsuarioServlet" tabindex="1">Voltar</a>
</div>





