package lab1.restaurante;

import java.util.LinkedList;

public class Pedido {

    // atributos
    private int idPedido;
    private String nomeCliente;
    private LinkedList<Item> itens; // como consiste basicamente em inserção, achei bom a LinkeList

    // construtor
    public Pedido(int idPedido, String nomeCliente) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.itens = new LinkedList<>();
    }

    // método para adicionr um item na lista de itens do pedido
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    // método para calcular o valor total do pedido
    public double calcularTotal() {
        double valorPedido = 0;
        for (Item item : itens) {
            valorPedido += item.getPrecoItem();
        }
        return valorPedido;
    }

    // getters
    public int getIdPedido() {
        return idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LinkedList<Item> getItens() {
        return itens;
    }
}