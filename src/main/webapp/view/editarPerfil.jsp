<%-- 
    Document   : editarPerfil
    Created on : 27/04/2016, 21:20:41
    Author     : Eduardo
--%>

<h2>Editar Perfil</h2>

<form role="form" action="EditarPerfilServlet" method="post">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" name="nome" id="nome" class="form-control input-lg" placeholder="Nome" tabindex="1" value="${requestScope['usuario'].nome}" />
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="sobrenome">Sobrenome:</label>
                <input type="text" name="sobrenome" id="sobrenome" class="form-control input-lg" placeholder="Sobrenome" tabindex="2" value="${requestScope['usuario'].sobrenome}" />
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email" tabindex="3" value="${requestScope['usuario'].email}" />
    </div>

    <div class="row">
        <div class="col-md-3">
            <label for="ddd">DDD:</label>
            <input type="number" name="ddd" id="ddd" class="form-control input-lg" placeholder="DDD" tabindex="4" value="${requestScope['usuario'].telefone.ddd}" maxlength="2" />
        </div>

        <div class="col-md-9">
            <div class="form-group">
                <label for="telefone">Telefone:</label>
                <input type="number" name="telefone" id="telefone" class="form-control input-lg" placeholder="Telefone" tabindex="5" value="${requestScope['usuario'].telefone.numero}" maxlength="9" />
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="logradouro">Logradouro:</label>
        <input type="text" name="logradouro" id="logradouro" class="form-control input-lg" placeholder="Endereço" tabindex="6" value="${requestScope['usuario'].endereco.logradouro}" />
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="bairro">Bairro:</label>
                <input type="text" name="bairro" id="bairro" class="form-control input-lg" placeholder="Bairro" tabindex="7" value="${requestScope['usuario'].endereco.bairro}" />
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="cidade">Cidade:</label>
                <input type="text" name="cidade" id="cidade" class="form-control input-lg" placeholder="Cidade" tabindex="8" value="${requestScope['usuario'].endereco.cidade}" />
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="estado">Estado:</label>
                <input type="text" name="estado" id="estado" class="form-control input-lg" placeholder="Estado" tabindex="8" value="${requestScope['usuario'].endereco.estado}" />
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="cep">CEP:</label>
                <input type="number" name="cep" id="cep" class="form-control input-lg" placeholder="CEP" tabindex="9" value="${requestScope['usuario'].endereco.cep}" maxlength="8" />
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="senha">Nova senha:</label>
        <input type="password" name="senha" id="senha" class="form-control input-lg" placeholder="Nova Senha" tabindex="10" />
    </div>

    <hr>
    <div class="row">
        <div class="col-xs-12 col-md-6"><button class="btn btn-success btn-block btn-lg" type="submit" tabindex="11">Confirmar</button></div>
        <div class="col-xs-12 col-md-6"><a class="btn btn-warning btn-block btn-lg" href="HomeUsuarioServlet" tabindex="12">Cancelar</a></div>
    </div>
</form>
