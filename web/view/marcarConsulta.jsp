<%-- 
    Document   : marcarConsulta
    Created on : 24/04/2016, 19:57:13
    Author     : Eduardo
--%>

<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">

        <h2>Marcar Consulta</h2>

        <form role="form" action="MarcarConsultaServlet" method="post" class="form-horizontal">
            <select class="form-control input-lg">
                <option>Teste</option>
            </select>

            <hr>
            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <button class="btn btn-success btn-block btn-lg" type="submit" tabindex="13">Marcar</button>
                </div>
                <div class="col-xs-12 col-md-6">
                    <a class="btn btn-warning btn-block btn-lg" href="HomeUsuarioServlet" tabindex="14">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
</div>

