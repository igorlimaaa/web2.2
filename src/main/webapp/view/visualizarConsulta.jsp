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

            <table class="table-visualizar">
                <tbody>
                    <tr>
                        <td>
                            <span class="table-label">Especialidade:</span>
                            <span>${consulta.medico.especialidade}</span>
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
                            <span>${consulta.data}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="table-label">M�dico:</span>
                            <span>Dr(a). ${consulta.medico.nome}</span>            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="table-label">Cl�nica:</span>
                            <span>${consulta.clinica.nome}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="table-label">Endere�o:</span>
                            <span>${consulta.clinica.endereco.getEnderecoCompleto()}</span>
                        </td>
                    </tr>
                </tbody>
            </table>

        </c:forEach>

    </c:when>

    <c:otherwise>
        <p>N�o h� consultas marcadas.</p>
    </c:otherwise>
</c:choose>


<div class="button-voltar">
    <a class="btn btn-warning btn-block btn-lg" href="HomeUsuarioServlet" tabindex="1">Voltar</a>
</div>





