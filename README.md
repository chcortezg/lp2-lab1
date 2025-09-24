# RESTAURANTE RUBRO-NEGRO  
### Sistema de gerenciamento de pedidos

Este projeto é um sistema simples desenvolvido em Java para gerenciamento de pedidos em um restaurante. Ele foi desenvolvido como prática laboratorial para a disciplina de Linguagem de Programação II do Bacharelado em Tecnolgia da Informação do IMD/UFRN no período 2025.2.

---

## Funcionalidades

- **Menu interativo**  
  - Implementado com while e switch-case.  

- **Registrar pedido**  
  - Solicita o nome do cliente; 
  - Gera o ID do pedido de forma sequencial;
  - Permite adicionar um ou mais itens ao pedido;  
  - Armazena o pedido em uma LinkedList;
  - Exibe uma nota de confirmação formatada, mostrando:  
    - Número do pedido,
    - Nome do cliente,
    - Itens e preços,
    - Valor total do pedido.  

- **Remover pedido**  
  - Solicita o número do pedido a ser removido;
  - Se o pedido existir, remove da lista e confirma a operação;  
  - Se não existir, exibe mensagem de erro.  

- **Listar pedidos**  
  - Exibe todos os pedidos registrados em ordem crescente de ID;
  - Mostra:  
    - Número do pedido,
    - Nome do cliente,
    - Lista de itens,
    - Valor total calculado dinamicamente.  

- **Sair**  
  - Encerra o sistema.

---

## Estrutura do projeto

- Item.java: representa os itens do pedido (nome, preço).  
- Pedido.java: representa um pedido (ID, cliente, lista de itens, cálculo do total).  
- Sistema.java: classe principal que contém: menu interativo, lista de pedidos, métodos de gerenciamento de pedidos e o método main.
