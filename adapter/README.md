# Conversor de Moedas com Adapter

## Descrição

O padrão de projeto Adapter é um padrão estrutural que permite que objetos com interfaces incompatíveis trabalhem juntos. Ele atua como um intermediário, adaptando a interface de uma classe para outra interface esperada pelo cliente.

Neste desafio, implementamos um conversor de moedas que permite converter valores monetários de dólares americanos (USD) para euros (EUR). O sistema original apenas suportava a conversão de USD para libras esterlinas (GBP). Utilizando o padrão Adapter, adaptamos o sistema antigo para fornecer a nova funcionalidade de conversão direta para EUR, realizando uma conversão intermediária para GBP.

## Entrada

- Um valor em dólares americanos (USD) do tipo `Double`.

## Saída

- O valor convertido para euros (EUR) do tipo `Double`, utilizando o adaptador.

## Taxas de Conversão

- Conversão direta: **1 USD = 0.85 EUR**
- Conversão intermediária:
  - **1 USD = 0.80 GBP**
  - **1 GBP = 1.0625 EUR**
