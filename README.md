# api-validador-cpf
Implementação de um serviço Rest que verifica se o número de CPF informado é válido.

Pré-requisitos: 

Ambiente com JDK 1.8 
Apache Maven 3.3.X 

Clone o projeto e execute:

mvn clean compile exe:java

e valide o CPF:
curl http://localhost:8080/myapp/myresource/validarcpf\?number\=72594535753 -> true
curl http://localhost:8080/myapp/myresource/validarcpf\?number\=72594535700 -> false
