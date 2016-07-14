<%-- 
    Document   : homeMedico
    Created on : 07/05/2016, 18:19:24
    Author     : Eduardo
--%>
    
<p>Seja Bem-Vindo!</p>
<p>Olá ${usuarioLogado.nome} ${usuarioLogado.sobrenome}!</p>

<h4>Listas de Consultas</h4>

<div class="row">
    <div class="col-md-3 pull-right">
        <a href="HomeMedicoServlet" class="btn btn-default form-control">Atualizar</a>
    </div>
</div>

<hr />

<c:choose>
    <c:when test="${requestScope['consultasMarcadas'].size() > 0}">

        <c:forEach items="${requestScope['consultasMarcadas']}" var="consulta">

            <div class="bloco-consulta">

                <div class="row">

                    <div class="col-md-8 form-group">
                        <span class="table-label">Paciente: </span>
                        <span>${consulta.usuario}</span>
                    </div>
                    <div class="col-md-4">
                        <a href="FinalizarConsultaServlet?codigo=${consulta.codigo}" class="btn btn-block btn-info">Atender</a>
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-8">
                        <span class="table-label">Data: </span>
                        <span>${consulta.dataConsulta}</span>
                    </div>
                    <div class="col-md-4">
                        <a href="VisualizarHistoricoServlet?codigo=${consulta.idUsuario}" class="btn btn-block btn-info">Histórico</a>
                    </div>
                </div>
            </div>

        </c:forEach>

    </c:when>

    <c:otherwise>
        <p>Não há consultas a serem realizadas.</p>
    </c:otherwise>
</c:choose>

<a href="HomeMedicoServlet?logout=s" class="btn btn-danger form-control">Sair</a>