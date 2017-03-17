# desafio-api


<h2>Utilizado</h2>

* Banco MYSQL
* Play framework
* SO Linux
* Bootstrap
* Postman
* Eclipse

<h4>Caso o import falhe utilize e unzip o arquivo desafio-api-final.zip  </h4>

Como iniciar o servidor

1. Acesse o diretório do projeto via terminal
2. ex / cd Downloads -> cd desafio-api -> ../activator-1.3.10-minimal/bin/activator
3. se for a primeira vez que for utilizar usar primeiro os comandos (compile, eclipse) separadamente.
4. após usar o comando compile e eclipse já é possível importar o projeto dentro do eclipse
5. para rodar o servidor dentro do terminal basta usar o comando ~run

Aplicação testada e utilizada em ambiente <b>LINUX</b>

Postman utilizado para testes com os tipos de requisições (PUT,POST,GET,DELETE)

Cadastro com tela visual localhost:9000/usuario/novo

<h3> Dentro do postman utilize a requisição específica para efetuar os testes </h3>
Para cadastrar use com método POST : http://localhost:9000/usuario  <br>EX: {"nome":"Lucas Pessoas", "email":"lucas@hotmail.com", "senha":"1233333", "telefone":"819992222"}<br><br>
Para buscar use com método GET : http://localhost:9000/usuario/1<br><br>
Para Remover use com método delete: http://localhost:9000/usuario/1<br><br>
Para Atualizar use com método PUT: http://localhost:9000/usuario/1 <br>   EX: {"id":"1","nome":"Maria Pessoa", "email":"marizao@hotmail.com", "senha":"4444", "telefone":"2222"}

Pra ver todos os usuários: <br>
http://localhost:9000/usuario <br>
<br>
Buscar alguém pelo email: <br>
http://localhost:9000/api/usuarios?email=keven.santos.sz@live.com <br>
<br>







