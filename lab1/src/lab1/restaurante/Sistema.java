package lab1.restaurante;

import java.util.LinkedList;
import java.util.Scanner;

public class Sistema {
    private LinkedList<Pedido> pedidos;
    private int contadorPedidos;
    private Scanner leitor;

    // construtor
    public Sistema() {
        pedidos = new LinkedList<>();
        leitor = new Scanner(System.in);
        contadorPedidos = 1; // pra os pedidos começarem no número 1
    }

    // método que exibe o menu principal
    public void exibirMenu() {
        int opcao = 0;
        
        while (opcao != 4) {
            System.out.println("\n==================================================");
            System.out.println("RESTAURANTE RUBRO-NEGRO - GERENCIAMENTO DE PEDIDOS");
            System.out.println("1 - Registrar Pedido");
            System.out.println("2 - Remover Pedido");
            System.out.println("3 - Listar Pedidos");
            System.out.println("4 - Sair");
            System.out.println("==================================================");
            System.out.print("Escolha uma opção: ");

            opcao = leitor.nextInt();
            leitor.nextLine(); // pra limpar o enter que vem depois

            switch (opcao) {
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    removerPedido();
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // método para registrar um novo pedido
    private void registrarPedido() {
        System.out.print("Nome do cliente: ");
        String nomeCliente = leitor.nextLine();

        // criando um novo pedido com id automático
        Pedido pedido = new Pedido(contadorPedidos, nomeCliente);

        boolean adicionandoItens = true;
        while (adicionandoItens == true) {
            System.out.print("Nome do item: ");
            String nomeItem = leitor.nextLine();
            System.out.print("Preço do item: ");
            double precoItem = leitor.nextDouble();
            leitor.nextLine();

            // cria o item e adiciona ao pedido
            Item item = new Item(nomeItem, precoItem);
            pedido.adicionarItem(item);

            // questiona se deseja adicionar mais itens
            System.out.print("Deseja adiconar mais itens? (S - Sim, N - Não): ");
            String resposta = leitor.nextLine();
            if (resposta.equals("N")) {
                adicionandoItens = false;
            }
        }

        pedidos.add(pedido);

        // incrementando o contador pra o id do próximo pedido
        contadorPedidos++;

        // nota de confirmação do pedido
        System.out.println("\n==================================================");
        System.out.println("       RESTAURANTE RUBRO-NEGRO - DESDE 1895       \n"
			        		+ "O restaurante do chef mais querido do Brasil, De \n"
			        		+ "Arrascaeta, e casa dos famosos 63kg de alcatra limpinha\n");
        System.out.println("==================================================");
        System.out.println("Pedido N°: " + pedido.getIdPedido());
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("--------------------------------------------------");
        System.out.println("Itens:");
        for (Item item : pedido.getItens()) {
            System.out.println("- " + item.getNomeItem() + " R$ " + item.getPrecoItem());
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Total: R$ " + pedido.calcularTotal());
        System.out.println("==================================================");
        System.out.println(" Obrigado pela preferência! Mengooooo! ");
        System.out.println("==================================================\n");
    }

    // método para remover um pedido
    private void removerPedido() {
        System.out.print("Digite o número do pedido pra ser removido: ");
        int id = leitor.nextInt();
        leitor.nextLine();

        Pedido pedidoParaRemover = null;

        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == id) {
                pedidoParaRemover = pedido;
                break;
            }
        }

        if (pedidoParaRemover != null) { // checagem pra ver se existe pedido com o id inserido
            pedidos.remove(pedidoParaRemover);
            System.out.println("Pedido com id " + id + " removido com sucesso.");
        } else {
            System.out.println("Não existe pedido com o id inserido.");
        }
    }

    // método para listar todos os pedidos
    private void listarPedidos() {
        System.out.println("\n==================================================");
        System.out.println("                 LISTA DE PEDIDOS                 ");
        for (Pedido pedido : pedidos) { // loop para percorrer cada pedido
            System.out.println("Pedido N°: " + pedido.getIdPedido());
            System.out.println("Cliente: " + pedido.getNomeCliente());
            System.out.println("Itens:");
            for (Item item : pedido.getItens()) { // loop para percorrer cada item de um pedido
                System.out.println("- " + item.getNomeItem() + " R$ " + item.getPrecoItem());
            }
            System.out.println("Total: R$ " + pedido.calcularTotal());
            System.out.println("--------------------------------------------------");
        }
    }

    // método main
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.exibirMenu();
    }
}