# Gerenciador de Usuários - Padrão Singleton

## Descrição

O Singleton é uma abordagem de design de software que visa assegurar a existência de apenas uma instância de uma classe e fornecer um ponto centralizado para acessá-la. Isso é especialmente benéfico em contextos nos quais é desejável manter uma única ocorrência de uma classe responsável pelo controle de um recurso compartilhado, como configurações, conexões de banco de dados ou caches.

Neste desafio, você deve criar um sistema de gerenciamento de usuários que permita adicionar e listar usuários. A implementação do padrão Singleton é opcional, permitindo que você escolha a melhor abordagem para resolver o problema.

## Especificações do Desafio

1. Crie uma classe `User` com os seguintes atributos:

   - `id` (inteiro)
   - `name` (string)

2. Implemente uma classe `UserManager` que siga o padrão Singleton. Esta classe deve possuir as seguintes funcionalidades:

   - Adicionar um novo usuário ao sistema, recebendo o nome como entrada.
   - Listar todos os usuários cadastrados.

3. No programa principal (`main`), siga as etapas abaixo:
   - Solicite ao usuário a quantidade de usuários que deseja cadastrar.
   - Peça ao usuário para informar os nomes dos usuários, um por linha.
   - Após receber os nomes e cadastrar os usuários, liste os usuários cadastrados.

## Entrada

- Um número inteiro representando a quantidade de usuários que o usuário deseja cadastrar.
- Para cada usuário a ser cadastrado, uma string contendo o nome do usuário.

## Saída

- Uma lista com os nomes dos usuários cadastrados.
