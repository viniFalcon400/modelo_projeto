--PROJETO MAVEN
--configuração
O projeto acessa o banco de dados mysql.
Porta: 3306

--
Observação: No projeto tem a lib do banco de dados "postgresql"
Caso queria usar o "postgresql" deve alterar a conexão do projeto nesse arquivo: modelo-projeto\src\main\resources\META-INF\persistence.xml
e refazer o build.
--

--iniciar projeto
1- Entrar na pasta raiz do projeto
2- Comando:
java -jar target/dependency/webapp-runner.jar --port 5000 target/*.war
3- Acesso o browser url: http://localhost:5000/
4- Acesso:
Usiario: admim
Senha: admin

--rest
1- retorno no formato HTML
http://localhost:5000/rest/projeto


