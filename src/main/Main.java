package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.JogoDigital;

/**
 *
 * @author Leonardo
 */
public class Main {

    public static Scanner entrada = new Scanner(System.in);
    public static ArrayList<JogoDigital> jogos;

    public static void main(String[] args) throws InterruptedException {

        jogos = new ArrayList<JogoDigital>();
        JogoDigital jogoDigital1 = new JogoDigital("Age of Mythology");
        JogoDigital jogoDigital2 = new JogoDigital("Counter Strike: Global Offensive");
        JogoDigital jogoDigital3 = new JogoDigital("Cuphead");
        JogoDigital jogoDigital4 = new JogoDigital("Dark Souls III");
        JogoDigital jogoDigital5 = new JogoDigital("Dead Cells");
        JogoDigital jogoDigital6 = new JogoDigital("Elden Ring");
        JogoDigital jogoDigital7 = new JogoDigital("Fallout 4");
        JogoDigital jogoDigital8 = new JogoDigital("Grand Theft Auto V");
        JogoDigital jogoDigital9 = new JogoDigital("Hollow Knight");
        JogoDigital jogoDigital10 = new JogoDigital("Hotline Miami");
        JogoDigital jogoDigital11 = new JogoDigital("Mortal Kombat X");
        JogoDigital jogoDigital12 = new JogoDigital("Pathologic 2");
        JogoDigital jogoDigital13 = new JogoDigital("Plants vs. Zombies");
        JogoDigital jogoDigital14 = new JogoDigital("PlayerUnknown's Battlegrounds");
        JogoDigital jogoDigital15 = new JogoDigital("Resident Evil 2 Remake");
        JogoDigital jogoDigital16 = new JogoDigital("Sekiro: Shadows Die Twice");
        JogoDigital jogoDigital17 = new JogoDigital("Subnautica");
        JogoDigital jogoDigital18 = new JogoDigital("Sunset Overdrive");
        JogoDigital jogoDigital19 = new JogoDigital("Terraria");
        JogoDigital jogoDigital20 = new JogoDigital("The Witcher 3: Wild Hunt");

        jogos.add(jogoDigital1);
        jogos.add(jogoDigital2);
        jogos.add(jogoDigital3);
        jogos.add(jogoDigital4);
        jogos.add(jogoDigital5);
        jogos.add(jogoDigital6);
        jogos.add(jogoDigital7);
        jogos.add(jogoDigital8);
        jogos.add(jogoDigital9);
        jogos.add(jogoDigital10);
        jogos.add(jogoDigital11);
        jogos.add(jogoDigital12);
        jogos.add(jogoDigital13);
        jogos.add(jogoDigital14);
        jogos.add(jogoDigital15);
        jogos.add(jogoDigital16);
        jogos.add(jogoDigital17);
        jogos.add(jogoDigital18);
        jogos.add(jogoDigital19);
        jogos.add(jogoDigital20);

        menu();
    }

    public static void gerarModelosAleatorios() {
        for (int i = 0; i < jogos.size(); i++) {
            jogos.get(i).setPrecoAleatorio();
            jogos.get(i).setPromocaoAleatoria();
            jogos.get(i).setUnidadesVendidasAleatoria();
            jogos.get(i).setAvaliacoesPositivasAleatoria();
        }
    }

    public static void gerarLeituras() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(
                    jogos.get((int) (Math.random() * jogos.size()))
            );
        }
    }

    public static void gerarJogosNomes() throws InterruptedException {
        System.out.println("\n##### SEGUE ABAIXO A LISTA COM O NOME DOS JOGOS EM NOSSA LOJA #####\n");
        for (JogoDigital jogo : jogos) {
            System.out.println(jogo.getNome());
        }
    }

    public static void ordenarLeituras(ArrayList<JogoDigital> jogos) throws InterruptedException {

        for (int i = 0; i < jogos.size(); i++) {
            for (int j = i + 1; j < jogos.size(); j++) {
                if (jogos.get(i).getPreco() > jogos.get(j).getPreco()) {
                    JogoDigital temp = jogos.get(i);
                    jogos.set(i, jogos.get(j));
                    jogos.set(j, temp);
                }
            }
            jogos.get(i).setId(i + 1);
        }

        for (JogoDigital jogo : jogos) {
            System.out.println(jogo);
        }
    }

    public static void menu() throws InterruptedException {

        System.out.println("-----------------------------------------------------");
        System.out.println("----------------BEM-VINDO À NOSSA LOJA---------------");
        System.out.println("-----------------------------------------------------\n");
        gerarModelosAleatorios();

        char opcao;
        boolean ligado = true;
        do {
            System.out.println("\n##### SELECIONE QUAL FUNÇÃO DESEJA REALIZAR #####");
            System.out.println("\n[A] - IMPRIMIR A LISTA DE JOGOS");
            System.out.println("[B] - IMPRIMIR A LISTA COM OS VALORES DOS JOGOS");
            System.out.println("[C] - IMPRIMIR A LISTA DE JOGOS DE ORDENADA DE FORMA CRESCENTE");
            opcao = entrada.nextLine().charAt(0);
            char opcaoUpperCase = Character.toUpperCase(opcao);

            switch (opcaoUpperCase) {
                case 'A':
                    gerarJogosNomes();
                    break;
                case 'B':
                    gerarLeituras();
                    break;
                case 'C':
                    ordenarLeituras(jogos);
                    break;
            }

        } while (ligado);
    }
}
