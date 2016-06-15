<%-- 
    Document   : editarPerfil
    Created on : 27/04/2016, 21:20:41
    Author     : Eduardo
    Author     : Igorlima
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Editar Perfil</h2>

<form role="form" action="EditarPerfilServlet" method="post">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" name="nome" id="nome" class="form-control input-lg" placeholder="Nome" tabindex="1" value="${requestScope['usuario'].nome}" />
                <c:forEach var="usuario" items="${nome}">
                    <option value="${usuario.nome}"/>
                    ${usuario.nome}
                    </option>
                </c:forEach>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="sobrenome">Sobrenome:</label>
                <input type="text" name="sobrenome" id="sobrenome" class="form-control input-lg" placeholder="Sobrenome" tabindex="2" value="${requestScope['usuario'].sobrenome}" />
                <c:forEach var="usuario" items="${sobrenome}">
                    <option value="${usuario.sobrenome}"/>
                    ${usuario.sobrenome}
                    </option>
                </c:forEach>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email" tabindex="3" value="${requestScope['usuario'].email}" />
        <c:forEach var="usuario" items="${email}">
            <option value="${usuario.email}"/>
            ${usuario.email}
            </option>
        </c:forEach>
    </div>

    <div class="row">
        <div class="col-md-3">
            <label for="ddd">DDD:</label>
            <input type="text" name="ddd" id="ddd" class="form-control input-lg" placeholder="DDD" tabindex="4" value="${requestScope['usuario'].telefone.ddd}" maxlength="2" />
            <c:forEach var="telefone" items="${ddd}">
                <option value="${telefone.ddd}"/>
                ${telefone.ddd}
                </option>
            </c:forEach>
        </div>

        <div class="col-md-9">
            <div class="form-group">
                <label for="telefone">Telefone:</label>
                <input type="text" name="telefone" id="telefone" class="form-control input-lg" placeholder="Telefone" tabindex="5" value="${requestScope['usuario'].telefone.numero}" maxlength="9" />
                <c:forEach var="usuario" items="${ddd}">
                <option value="${telefone.numero}"/>
                ${telefone.numero}
                </option>
            </c:forEach>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="logradouro">Logradouro:</label>
        <input type="text" name="logradouro" id="logradouro" class="form-control input-lg" placeholder="Endereço" tabindex="6" value="${requestScope['usuario'].endereco.logradouro}" />
        <c:forEach var="usuario" items="${endereco}">
            <option value="${endereco.logradouro}"/>
            ${endereco.logradouro}
                </option>
            </c:forEach>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="bairro">Bairro:</label>
                <input type="text" name="bairro" id="bairro" class="form-control input-lg" placeholder="Bairro" tabindex="7" value="${requestScope['usuario'].endereco.bairro}" />
                <c:forEach var="usuario" items="${bairro}">
                    <option value="${endereco.bairro}"/>
                    ${endereco.bairro}
                </option>
            </c:forEach>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="cidade">Cidade:</label>
                <input type="text" name="cidade" id="cidade" class="form-control input-lg" placeholder="Cidade" tabindex="8" value="${requestScope['usuario'].endereco.cidade}" />
                <c:forEach var="usuario" items="${bairro}">
                    <option value="${endereco.cidade}"/>
                ${endereco.cidade}
                </option>
            </c:forEach>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="estado">Estado:</label>
                <input type="text" name="estado" id="estado" class="form-control input-lg" placeholder="Estado" tabindex="8" value="${requestScope['usuario'].endereco.estado}" />
                <c:forEach var="usuario" items="${cidade}">
                        <option value="${endereco.cidade}"/>
                    ${endereco.cidade}
                </option>
            </c:forEach>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
                <label for="cep">CEP:</label>
                <input type="number" name="cep" id="cep" class="form-control input-lg" placeholder="CEP" tabindex="9" value="${requestScope['usuario'].endereco.cep}" maxlength="8" />
                <c:forEach var="usuario" items="${bairro}">
                    <option value="${endereco.cidade}"/>
                ${endereco.cidade}
                </option>
            </c:forEach>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="senha">Nova senha:</label>
        <input type="password" name="senha" id="senha" class="form-control input-lg" placeholder="Nova Senha" tabindex="10" />
        <c:forEach var="usuario" items="${senha}">
            <option value="${usuario.senha}"/>
            ${usuario.senha}
                </option>
            </c:forEach>
    </div>

    <hr>
    <div class="row">
        <div class="col-xs-12 col-md-6"><button class="btn btn-success btn-block btn-lg" type="submit" tabindex="11">Confirmar</button></div>
        <div class="col-xs-12 col-md-6"><a class="btn btn-warning btn-block btn-lg" href="HomeUsuarioServlet" tabindex="12">Cancelar</a></div>
    </div>
</form>