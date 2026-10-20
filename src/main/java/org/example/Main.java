package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Produto> ArrayProduto = new ArrayList<>(); //Criamos uma Lista para armazenar onjetos

        int numCadastro,id,operacao;
        String nome;
        Double preco,reajuste;



        System.out.print("Informe a quantidade de produtos que serão cadastrado :");
        numCadastro = sc.nextInt();
        System.out.println();

        // Loop para cadastrar os produtos com validação de ID único
        for (int i = 0; i < numCadastro; i++){
            System.out.printf("PRODUTO #%d %n",(i + 1));
            System.out.print("ID: ");
            id = sc.nextInt();
            // Valida se o ID já existe; se sim, obriga o usuário a digitar outro
            while (Produto.verificarCodigo(ArrayProduto,id)){
                System.out.println("CÓDIGO JÁ CADASTRADO, TENTE NOVAMENTE!!");
                System.out.print("ID: ");
                id = sc.nextInt();
                sc.nextLine();
            }
            sc.nextLine();

            System.out.print("NOME: ");
            nome = sc.nextLine();

            System.out.print("PREÇO: ");
            preco = sc.nextDouble();
            sc.nextLine();

            Produto produto = new Produto(id, preco, nome);
            ArrayProduto.add(produto);
            System.out.println();

        }

        // Loop infinito (while true) para permitir múltiplos reajustes de preços
        while (true) {
            System.out.print("Informe o código do produto que vai receber o reajuste:");
            id = sc.nextInt();

            // Valida se o código realmente existe na lista; se não existir, repete a leitura
            while (!Produto.verificarCodigo(ArrayProduto,id)){
                System.out.println("CÓDIGO NÃO ENCONTRADO, TENTE NOVAMENTE!!");
                System.out.print("ID: ");
                id = sc.nextInt();
            }
            sc.nextLine();

            System.out.print("Digite 1 - DESCONTO e 2 - REAJUSTE: ");
            operacao = sc.nextInt();

            System.out.print("Informe o valor do ajuste: ");
            reajuste = sc.nextDouble();
            sc.nextLine();

            // Chama o método estático para aplicar a alteração de preço
            Produto.aplicarAjuste(ArrayProduto, reajuste, id, operacao);
            System.out.println();

            System.out.print("Deseja fazer outro reajuste? (Sim/Não): ");
            String resp = sc.nextLine();
            // Interrompe o loop caso o usuário responda "Não"
            if (resp.equalsIgnoreCase("Não") || resp.equalsIgnoreCase("Nao")) {
                break;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("\n--- LISTA DE PRODUTOS ---");

        // Percorre a lista exibindo cada produto (o Java chama o toString() automaticamente)
        for (Produto p : ArrayProduto) {
            System.out.println(p);
        }

    }
}
