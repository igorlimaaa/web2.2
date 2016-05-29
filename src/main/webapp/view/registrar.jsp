<%-- 
    Document   : registrar
    Created on : 24/04/2016, 17:45:42
    Author     : Eduardo
    Author     : IgorLima
--%>

<h2>Registro</h2>

<form role="form" action="RegistrarServlet" method="post">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="nome" id="nome" class="form-control input-lg" placeholder="Nome" tabindex="1">
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="sobrenome" id="sobrenome" class="form-control input-lg" placeholder="Sobrenome" tabindex="2">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="form-group">
                <input type="text" name="cpf" id="cpf" class="form-control input-lg" placeholder="CPF" tabindex="3">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3">
            <input type="number" name="ddd" id="ddd" class="form-control input-lg" placeholder="DDD" tabindex="4" maxlength="2" />
        </div>

        <div class="col-md-9">
            <div class="form-group">
                <input type="number" name="telefone" id="telefone" class="form-control input-lg" placeholder="Telefone" tabindex="5" maxlength="9" />
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="date" name="dataNasc" id="dataNasc" placeholder="Data de Nascimento" class="form-control input-lg" tabindex="6">
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="input-lg">
                <label for="fem">
                    <input type="radio" class="sexo" id="fem" name="sexo" tabindex="7"/>
                    Feminino
                </label>
                <label for="masc">
                    <input type="radio" class="sexo" id="masc" name="sexo" tabindex="8" />
                    Masculino
                </label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <input type="text" name="logradouro" id="logradouro" class="form-control input-lg" placeholder="Endereço" tabindex="9">
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="bairro" id="bairro" class="form-control input-lg" placeholder="Bairro" tabindex="10">
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="cidade" id="cidade" class="form-control input-lg" placeholder="Cidade" tabindex="11">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="estado" id="estado" class="form-control input-lg" placeholder="Estado" tabindex="12" />
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="number" name="cep" id="cep" class="form-control input-lg" placeholder="CEP" tabindex="13" maxlength="8" />
            </div>
        </div>
    </div>

    <div class="form-group">
        <input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email" tabindex="14">
    </div>
    <div class="form-group">
        <input type="password" name="senha" id="senha" class="form-control input-lg" placeholder="Senha" tabindex="15">
    </div>

    <hr>
    <div class="row">
        <div class="col-xs-12 col-md-6"><button class="btn btn-success btn-block btn-lg" type="submit" tabindex="16">Registrar</button></div>
        <div class="col-xs-12 col-md-6"><a class="btn btn-warning btn-block btn-lg" href="LoginServlet" tabindex="17">Cancelar</a></div>
    </div>
</form>