<%-- 
    Document   : editarPerfil
    Created on : 27/04/2016, 21:20:41
    Author     : Eduardo
    Author     : Igorlima
--%>

<h2>Editar Perfil</h2>

<form role="form" action="RegistrarServlet" method="post">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="nome" id="nome" class="form-control input-lg" 
                       placeholder="Nome" tabindex="1" >
                    </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="sobrenome" id="sobrenome" class="form-control input-lg" 
                       placeholder="Sobrenome" tabindex="2">
                </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="cpf" id="cpf" class="form-control input-lg" placeholder="CPF" tabindex="3">
                </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="tel" name="telefone" id="telefone" class="form-control input-lg" placeholder="Telefone" tabindex="4">
                </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="datetime" name="dataNasc" id="dataNasc"  class="form-control input-lg" tabindex="5">
                </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="input-lg">
                <label for="fem">
                    <input type="radio" class="sexo" id="fem" name="sexo" tabindex="6"/>
                    Feminino
                    </label>
                <label for="masc">
                    <input type="radio" class="sexo" id="masc" name="sexo" tabindex="7" />
                    Masculino
                    </label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <input type="text" name="endereco" id="logradouro" class="form-control input-lg" placeholder="Endere�o" tabindex="8">
        </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="bairro" id="bairro" class="form-control input-lg" placeholder="Bairro" tabindex="9">
                </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="cidade" id="cidade" class="form-control input-lg" placeholder="Cidade" tabindex="10">
            </div>
        </div>
    </div>
  <div class="form-group">
        <input type="password" name="senha" id="senha" class="form-control input-lg" placeholder="Nova Senha" tabindex="12">
            </div>

    <hr>
    <div class="row">
        <div class="col-xs-12 col-md-6"><button class="btn btn-success btn-block btn-lg" type="submit" tabindex="11">Alterar</button></div>
        <div class="col-xs-12 col-md-6"><a class="btn btn-warning btn-block btn-lg" href="HomeUsuarioServlet" tabindex="12">Cancelar</a></div>
    </div>
</form>
