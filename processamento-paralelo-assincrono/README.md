# Simulação de Download Paralelo

## Descrição

Neste projeto, implementamos uma simulação de downloads paralelos utilizando **multithreading**. O objetivo é demonstrar como executar múltiplas tarefas simultaneamente para otimizar o tempo de resposta e processamento.

Em vez de realmente baixar arquivos, simulamos o processo determinando o tamanho de cada URL fornecida. Cada "download" leva exatamente **1 segundo** para ser concluído, independentemente do tamanho da URL.

Esse projeto é útil para entender como trabalhar com **execução paralela**, **sincronização de dados** e **gerenciamento de threads**.

---

## Requisitos

Para implementar essa solução, seguimos os seguintes requisitos:

- Definir uma lista de URLs que serão "baixadas".
- Criar uma função para simular o "download" de cada URL.
- Implementar **execução paralela** para processar várias URLs ao mesmo tempo.
- Exibir o tamanho de cada URL na **ordem em que foram inseridas**.
- Mostrar o tempo total de execução.

---

## Entrada

O programa recebe como entrada uma **lista de URLs**, sendo **uma URL por linha**.  
O usuário pode inserir quantas URLs desejar e uma **linha vazia** indica o fim da entrada.

**Exemplo de entrada:**

https://exemplo.com https://outrosite.com.br https://sitequalquer.org

Após inserir todas as URLs, pressionando **Enter** em uma linha vazia, o programa inicia os "downloads" simultaneamente.

---

## Saída

A saída do programa apresenta:

- **Mensagem inicial informando que os downloads começaram**.
- **O tamanho de cada URL processada**.
- **O tempo total de execução (equivalente ao número de URLs inseridas)**.

**Exemplo de saída esperada:**

Iniciando downloads... Arq1: 20 Arq2: 25 Arq3: 30 Tempo total: 3
