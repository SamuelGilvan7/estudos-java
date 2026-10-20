package org.example;

import java.util.List;

public class Produto {

    private int codigo;
    private String nome;
    private Double preco;

    public Produto(){

    }

    public Produto(int codigo, Double preco, String nome) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    // Método de instância: aplica um aumento percentual no preço do produto atual
    public void atualizarPrecoAumento(Double porcentagem){
        this.preco += getPreco() * (porcentagem / 100);
    }
    // Método de instância: aplica um desconto percentual no preço do produto atual
    public void atualizarPrecoDesconto(Double porcentagem){
        this.preco -= getPreco() * (porcentagem / 100);
    }

    // Método estático: percorre a lista para verificar se um código de produto já existe
    public static Boolean verificarCodigo(List<Produto> list, int codigo){
        for (Produto product : list){
            if(product.getCodigo() == codigo ){
                return true;
            }
        }
        return false;
    }

    // Método estático: busca o produto pelo ID na lista e aplica desconto (1) ou aumento (2)
    public static void aplicarAjuste(List<Produto> list, double porcentagem, int id, int operacao ) {
        for (Produto produto : list){
            if(produto.getCodigo() == id){
                if (operacao == 1){
                    produto.atualizarPrecoDesconto(porcentagem);
                }else {
                    produto.atualizarPrecoAumento(porcentagem);
                }

            }
        }
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %.2f", getCodigo(), getNome(), getPreco());
    }
}
