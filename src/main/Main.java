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
        JogoDigital jogoDigital1 = new JogoDigital(1, "Terraria");
        JogoDigital jogoDigital2 = new JogoDigital(2, "Dark Souls III");
        JogoDigital jogoDigital3 = new JogoDigital(3, "Cuphead");
        JogoDigital jogoDigital4 = new JogoDigital(4, "Grand Theft Auto V");
        JogoDigital jogoDigital5 = new JogoDigital(5, "Resident Evil 2 Remake");
        JogoDigital jogoDigital6 = new JogoDigital(6, "Dead Cells");
        JogoDigital jogoDigital7 = new JogoDigital(7, "Fallout 4");
        JogoDigital jogoDigital8 = new JogoDigital(8, "Hotline Miami");
        JogoDigital jogoDigital9 = new JogoDigital(9, "Hollow Knight");
        JogoDigital jogoDigital10 = new JogoDigital(10, "The Witcher 3: Wild Hunt");
        JogoDigital jogoDigital11 = new JogoDigital(11, "Sunset Overdrive");
        JogoDigital jogoDigital12 = new JogoDigital(12, "Subnautica");
        JogoDigital jogoDigital13 = new JogoDigital(13, "Mortal Kombat X");
        JogoDigital jogoDigital14 = new JogoDigital(14, "Pathologic 2");
        JogoDigital jogoDigital15 = new JogoDigital(15, "Age of Mythology");
        JogoDigital jogoDigital16 = new JogoDigital(16, "Plants vs. Zombies");
        JogoDigital jogoDigital17 = new JogoDigital(17, "Sekiro: Shadows Die Twice");
        JogoDigital jogoDigital18 = new JogoDigital(18, "Counter Strike: Global Offensive");
        JogoDigital jogoDigital19 = new JogoDigital(19, "PlayerUnknown's Battlegrounds");
        JogoDigital jogoDigital20 = new JogoDigital(20, "Elden Ring");

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
        for (int i = 0; i < jogos.size(); i++){
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
    
    public static void ordenarLeituras(ArrayList<JogoDigital> jogos) throws InterruptedException {
        
        for (int i = 0; i < jogos.size(); i++) {
            for (int j = i + 1; j < jogos.size(); j++) {
                if (jogos.get(i).getPreco() < jogos.get(j).getPreco()) {
                    JogoDigital temp = jogos.get(i);
                    jogos.set(i, jogos.get(j));
                    jogos.set(j, temp);
                }
            }
        }
        
        for(JogoDigital jogo: jogos){
            System.out.println(jogo);
        }
    }

    public static void menu() throws InterruptedException {

        System.out.println("-----------------------------------------------------");
        System.out.println("----------------BEM-VINDO À NOSSA LOJA---------------");
        System.out.println("-----------------------------------------------------\n");
        System.out.println("Tamanho da lista de jogos: " + jogos.size());
        System.out.println("\nAbaixo virá uma sequencia de nomes aleatórios dos jogos dentro da loja...");

        gerarModelosAleatorios();
        
        gerarLeituras();
        
        ordenarLeituras(jogos);

    }
}
