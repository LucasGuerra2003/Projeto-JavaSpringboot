# Projeto JavaSpringBoot
## Motivação do Projeto
Este projeto foi desenvolvido como parte de um treinamento em Java/Spring, com o objetivo de aprofundar o conhecimento na utilização da ferramenta Spring Boot. Além disso, representou um desafio pessoal significativo, explorando mais a fundo essa tecnologia. Utilizando o Maven pela primeira vez, este projeto foi construído do zero, sendo uma experiência única para alguém habituado apenas com Node.js e Dotnet.
## Descrição do Projeto
O projeto consiste em um sistema básico de gestão de informações de frete, no qual cada cliente armazena um conjunto de dados, como ID, CEP, endereço, cubagem ou peso do frete, entre outros. Foi desenvolvida uma API REST utilizando Java/Spring Boot para as seguintes operações:
- Cadastro de Frete
- Consulta de Frete (por ID)
- Atualização dos Dados do Frete
- Remoção de Frete
Os dados são armazenados em um banco de dados Firebase.
## Implementação
O projeto segue uma arquitetura em camadas, organizando o código em Controller, Entity e Repository:
- **Controller (ClienteController):** Define uma API REST para gerenciar objetos de Cliente, utilizando Spring Boot para implementar métodos POST, GET, PUT e DELETE.
- **Entity (Cliente):** Esta classe é responsável por representar os dados do cliente, sem conter lógica de negócios, servindo apenas como estrutura de dados.
- **Repository (ClienteRepository):** Nesta camada, são realizadas as chamadas ao banco de dados e aplicados métodos de criação, atualização, etc., diretamente no Firebase.
- **Index.HTML:** Por fim, o index.html é responsável pela interface visual do projeto, bem como pela validação de dados utilizando JavaScript.
