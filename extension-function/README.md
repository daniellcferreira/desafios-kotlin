# Gerador de Slug para Livros

## Descrição

As **Extension Functions** (Funções de Extensão) são um recurso poderoso que permite adicionar métodos a classes existentes sem modificar o código-fonte original. Neste desafio, o objetivo é criar uma função de extensão `generateSlug()` para a classe `String`, que transforma um texto em um formato amigável para URLs (slug). Isso será útil para um sistema de gerenciamento de livros de uma biblioteca digital.

## Entrada

O programa recebe duas entradas:

1. **Título do livro** (String)
2. **Nome do autor** (String)

## Saída

O programa gera um **slug** combinando o título e o nome do autor no seguinte formato:

```
Slug gerado para o livro:
nome-livro-separado-por-ifens_nome-autor-separado-por-ifens
```

O slug é criado removendo espaços e caracteres especiais, substituindo-os por traços (`-`).

## Exemplo de Uso

### Entrada:

```
O Senhor dos Anéis
J. R. R. Tolkien
```

### Saída:

```
Slug gerado para o livro:
o-senhor-dos-aneis_j-r-r-tolkien
```

## Benefícios do Uso de Slugs

- URLs mais amigáveis para SEO.
- Facilita a indexação em bancos de dados.
- Evita problemas com caracteres especiais em URLs.

## Implementação Sugerida

A função `generateSlug()` deve:

1. Converter a string para minúsculas.
2. Remover acentos e caracteres especiais.
3. Substituir espaços por traços (`-`).
4. Garantir que não haja traços repetidos ou no início/fim do slug.
