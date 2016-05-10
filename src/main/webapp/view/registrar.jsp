<%-- 
    Document   : registrar
    Created on : 24/04/2016, 17:45:42
    Author     : Eduardo
    Author     : IgorLima
--%>


<jsp:useBean id="model" class="br.com.ifpe.web2.model.Usuario"/>
<jsp:useBean id="controllet" class="br.com.ifpe.web2.controller.RegistrarServlet"/>

<h2>Registro</h2>


<form role="form" action="RegistrarServlet" method="get">
    <td${registrarServlet.novo}/td>
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="nome" id="nome" class="form-control input-lg" 
                       placeholder="Nome" tabindex="1" >
                <td${model.nome}/td>
                </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="sobrenome" id="sobrenome" class="form-control input-lg" 
                       placeholder="Sobrenome" tabindex="2">
                <td${model.sobrenome}/td>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="cpf" id="cpf" class="form-control input-lg" placeholder="CPF" tabindex="3">
                <td${model.cpf}/td>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="number" name="telefone" id="telefone" class="form-control input-lg" placeholder="Telefone" tabindex="4">
                <td${model.telefone}/td>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="date" name="dataNasc" id="dataNasc" class="form-control input-lg" tabindex="5">
                <td${model.dataCadastro}/td>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="input-lg">
                <label for="fem">
                    <input type="radio" class="sexo" id="fem" name="sexo" tabindex="6"/>
                    Feminino
                    <td${model.sexo}/td>
                </label>
                <label for="masc">
                    <input type="radio" class="sexo" id="masc" name="sexo" tabindex="7" />
                    Masculino
                    <td${model.sexo}/td>
                </label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <input type="text" name="logradouro" id="logradouro" class="form-control input-lg" placeholder="Endereço" tabindex="8">
        <td${model.endereco}/td>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="bairro" id="bairro" class="form-control input-lg" placeholder="Bairro" tabindex="9">
                <td${model.bairro}/td>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <input type="text" name="cidade" id="cidade" class="form-control input-lg" placeholder="Cidade" tabindex="10">
                <td${model.cidade}/td>
            </div>
        </div>
    </div>

    <div class="form-group">
        <input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email" tabindex="11">
        <td${model.email}/td>
    </div>
    <div class="form-group">
        <input type="password" name="senha" id="senha" class="form-control input-lg" placeholder="Senha" tabindex="12">
        <td${model.senha}/td>
    </div>

    <hr>
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <button class="btn btn-success btn-block btn-lg" 
                    type="submit" 
                    tabindex="13">Registrar</button>
            <td${registrarServlet.gravar}/td>
            
        </div>
        <div class="col-xs-12 col-md-6"><a class="btn btn-warning btn-block btn-lg" href="LoginServlet" tabindex="14">Cancelar</a></div>
    </div>
</form>