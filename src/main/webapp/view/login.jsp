<%-- 
    Document   : login
    Created on : 24/04/2016, 17:09:10
    Author     : Eduardo
    Author     : IgorLima
--%>



        <form action="LoginServlet" method="post">

            <fieldset>
                <legend>Acesso</legend>

                <div class="form-group">
                    <input type="text" name="login" id="login" required class="form-control input-lg" placeholder="Login" />
                </div>

                <div class="form-group">
                    <input type="password" name="senha" id="senha" required class="form-control input-lg" placeholder="Senha" />
                </div>

                <div class="row">
                    <div class="col-xs-12 col-md-6">
                        <button type="submit" class="btn btn-primary btn-block btn-lg">Login</button>
                    </div>
                    <div class="col-xs-12 col-md-6">
                        <a href="RegistrarServlet" class="btn btn-primary btn-block btn-lg">Registrar-se</a>
                    </div>
                </div>

            </fieldset>

        </form>
