package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList= new ArrayList<>();
    }

    public void adicionarItem(String nome,double preco, int quantidade){
            itemList.add(new Item(nome,preco,quantidade));
    }

    public void removerItem(String nome){
        List<Item> itemParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()){
            for(Item i: itemList) {
                if(i.getNome().equalsIgnoreCase(nome)){
                    itemParaRemover.add(i);
                }
            }
            itemList.removeAll(itemParaRemover);
        }else {
            System.out.println("Alista está vazia!");
        }
    }

    public double calcularValorTotal(){
        double somaDosItens = 0d;
        if(!itemList.isEmpty()){
            for(Item i: itemList){
                double valorItem = i.getPreco() * i.getQuantidade();
                somaDosItens += valorItem;
            }
            return somaDosItens;
        }else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public void exibirItens(){
        if(!itemList.isEmpty()){
            System.out.println(itemList);
        }else {
            System.out.println("Alista está vazia!");
        }

    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itemList=" + itemList +
                '}';
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();


        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("Caderno");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.printf("O valor total da compra é = %.2f", carrinhoDeCompras.calcularValorTotal());
    }


}
