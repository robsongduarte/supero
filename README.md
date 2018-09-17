# SUPERO

## pré requisitos
* java 8 
* node 8
* mysql
* maven


## Como executar
* clone o repositórios a partit do comando `git clone https://github.com/robsongduarte/supero.git && cd supero`
* acesse o diretório `cd client` e execute o comando `npm install`
* após concluir a instalação execute o build do fronteend com o seguinte comando `npm run build`
* acesse a pasta `cd server/src/main/resources` e substitua os dados de acesso ao banco no arquivo 
*application.properties* 

- spring.datasource.url=jdbc:mysql://localhost:3306/supero
- spring.datasource.username=root
- spring.datasource.password=root

* Caso seja necessário criar a dataBaseName supero

* após configurar o banco acesse o diretório `cd server` executar o comando `mvn spring-boot:run` e acessar o endereço
*http://localhost:8080*
