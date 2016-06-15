<%-- 
    Document   : home
    Created on : 24/04/2016, 17:36:40
    Author     : Eduardo
--%>

<h2>Bem vindo ao DocSystem.</h2>
<p>Olá ${usuarioLogado.nome} ${usuarioLogado.sobrenome}!</p>

<ul class="list-inline">
    <li><a href="MarcarConsultaServlet" class="btn btn-default">Marcar Consulta</a></li>
    <li><a href="VisualizarConsultaServlet" class="btn btn-default">Visualizar Consultas Agendadas</a></li>
    <li><a href="EditarPerfilServlet" class="btn btn-default">Editar Perfil</a></li>
</ul>

<a href="HomeUsuarioServlet?logout=s" class="btn btn-danger form-control">Sair</a>