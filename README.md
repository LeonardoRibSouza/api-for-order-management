API de Gestão - XYZ Tecnologia
Este projeto é uma API RESTful desenvolvida em Java com Spring Boot para a Empresa XYZ Tecnologia. A solução visa ser o pilar inicial para um sistema completo de gestão de pedidos, começando com o gerenciamento de Clientes e Produtos.

O objetivo é fornecer uma base sólida e escalável que permita, futuramente, a implementação de funcionalidades de gerenciamento de pedidos, otimizando os processos da equipe de vendas e melhorando a comunicação.

Tecnologias Utilizadas
Java 17+

Spring Boot 3

Spring Data JPA

Hibernate

Maven

Banco de Dados (configurável, ex: H2, PostgreSQL)

Modelos de Dados
A API trabalha com duas entidades principais: Customer e Product.

Customer (Cliente)
Representa um cliente no sistema.

{
  "id": 1,
  "name": "João da Silva",
  "cpf": "123.456.789-00",
  "telephone": "(11) 98765-4321",
  "address": "Rua das Flores, 123, São Paulo - SP"
}

Product (Produto)
Representa um item disponível para venda.

{
  "id": 1,
  "name": "Notebook Gamer",
  "description": "Notebook com placa de vídeo dedicada e 16GB RAM",
  "price": 5500.00,
  "quantity": 15,
  "category": "Eletrônicos",
  "createdAt": "2024-06-27T10:00:00Z"
}

Começando
Siga os passos abaixo para executar o projeto em seu ambiente local.

Pré-requisitos
JDK 17 ou superior

Maven 3.6 ou superior

Uma instância de banco de dados (ou use o banco em memória H2, configurado por padrão no Spring Boot).

Instalação e Execução
Clone o repositório:

git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio

Configure o Banco de Dados:

Abra o arquivo src/main/resources/application.properties.

Configure as propriedades de conexão com seu banco de dados, se não for usar o H2.

# Exemplo para PostgreSQL
# spring.datasource.url=jdbc:postgresql://localhost:5432/xyz_db
# spring.datasource.username=postgres
# spring.datasource.password=sua_senha
# spring.jpa.hibernate.ddl-auto=update

Compile e execute o projeto com Maven:

mvn spring-boot:run

A API estará disponível em http://localhost:8080.

Documentação da API (Endpoints)
A seguir estão os endpoints disponíveis, divididos por recurso.

Recursos de Cliente (/customer)
Método

Endpoint

Descrição

Corpo da Requisição (Exemplo)

POST

/customer/register

Cadastra um novo cliente.

Customer (JSON)

GET

/customer/findall

Lista todos os clientes cadastrados.

N/A

GET

/customer/cpf/{numeroCpf}

Busca um cliente pelo seu CPF.

N/A

PUT

/customer/update

Atualiza os dados de um cliente.

Customer (JSON, com id existente)

DELETE

/customer/delete/{id}

Remove um cliente pelo seu ID.

N/A

Recursos de Produto (/product)
Método

Endpoint

Descrição

Corpo da Requisição (Exemplo)

POST

/product/register

Cadastra um novo produto.

Product (JSON)

GET

/product/findall

Lista todos os produtos cadastrados.

N/A

PUT

/product/update

Atualiza os dados de um produto.

Product (JSON, com id existente)

PUT

/product/update/quantity

Atualiza apenas a quantidade de um produto.

{ "id": 1, "quantity": 25 }

DELETE

/product/delete/{id}

Remove um produto pelo seu ID.

N/A

Tratamento de Erros
A API utiliza um CustomEntityResponseHandler para padronizar as respostas de erro.

404 Not Found: Retornado quando um recurso específico (como um cliente ou produto por ID) não é encontrado.

{
  "timestamp": "2024-06-27T18:30:00.000+00:00",
  "message": "No record found with id",
  "details": "uri=/customer/delete/99"
}
