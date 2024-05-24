﻿# Projeto JavaSpringBoot
# Por que fiz esse projeto?
- Fazendo parte de um treinamento de Java/Spring, onde aprendi mais como usar a ferramenta Springboot. Além de ser um desafio pessoal que eu gostei bastante de correr atrás para saber mais sobre essa ferramenta. Utilizando o Maven, sendo a primeira vez que cheguei a tocar em si, feito totalmente do zero. Onde tive só utilizando Node e Dotnet.
# O que é o Projeto?
- Criei esse projetinho básico, um sistema de gestão de informações de frete, onde cada cliente armazena um conjunto de informações como ID, CEP, Endereço, Cubagem ou Peso do Frete e etc. A partir de uma API Rest criada e utilizando do Java/Springboot com as operações de:
 - Cadastrar Frete
 - Buscar Frete (recebendo o ID)
 - Atualizar os Dados do Frete
 - Remover Frete
- Os dados sendo armazenados no banco de dados firebase.
# Como foi feito?
- Utilizando a Arquitetura em Camadas, onde organiza o código com Controller, Entity, Repository, Como por exemplo:
 - Controller (ClienteController): Aqui, é definido uma API REST que gerencia os objetos do Cliente utilizando do springboot para passar os métodos POST, GET, PUT, DELETE.
 - Entity (Cliente): Nessa classe Cliente é basicamente para receber ou conceder os parametros de dados, não tendo uma lógica de negócios, abenas uma estrutura de dados para uso
 - Repository (ClienteRepository): Aqui de forma resumida, é onde faz a chamada do banco e aplica os metodos de criação, atualização e etc, diretamente no firebase.
 - Index.HTML: Por fim, no index.html onde é feita toda a parte visual do projeto e a validação de dados utilizando javascript. 
