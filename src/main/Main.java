package main;

import java.util.ArrayList;
import java.util.Scanner;
import models.JogoDigital;

/**
 *
 * @author Leonardo
 */
public class Main {
    
    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<JogoDigital> jogos;
    
    public static void main(String[] args) throws InterruptedException{

        jogos = new ArrayList<JogoDigital>();
        JogoDigital jogoDigital1 = new JogoDigital(1, "Terraria", 19.99, false, 500000, 200000);
        JogoDigital jogoDigital2 = new JogoDigital(2, "Dark Souls III", 300.00, true, 300000, 250000);
        JogoDigital jogoDigital3 = new JogoDigital(3, "Cuphead", 36.99, false, 25000, 118000);
        JogoDigital jogoDigital4 = new JogoDigital(4, "Grand Theft Auto V", 56.99, false, 600000, 245000);
        JogoDigital jogoDigital5 = new JogoDigital(5, "Resident Evil 2 Remake", 139.99, true, 20000, 145000);
        JogoDigital jogoDigital6 = new JogoDigital(6, "Dead Cells", 47.99, false, 345000, 111000);
        JogoDigital jogoDigital7 = new JogoDigital(7, "Fallout 4", 59.99, true, 450000, 250000);
        JogoDigital jogoDigital8 = new JogoDigital(8, "Hotline Miami", 32.99, false, 100000, 90000);
        JogoDigital jogoDigital9 = new JogoDigital(9, "Hollow Knight", 46.99, false, 500000, 30000);
        JogoDigital jogoDigital10 = new JogoDigital(10, "The Witcher 3: Wild Hunt", 79.99, true, 800000, 550000);
        JogoDigital jogoDigital11 = new JogoDigital(11, "Sunset Overdrive", 38.95, false, 250000, 120000);
        JogoDigital jogoDigital12 = new JogoDigital(12, "Subnautica", 57.99, true, 300000, 210000);
        JogoDigital jogoDigital13 = new JogoDigital(13, "Mortal Kombat X", 85.99, false, 200000, 120000);
        JogoDigital jogoDigital14 = new JogoDigital(14, "Pathologic 2", 101.58, true, 100000, 60000);
        JogoDigital jogoDigital15 = new JogoDigital(15, "Age of Mythology", 55.99, false, 230000, 220000);
        JogoDigital jogoDigital16 = new JogoDigital(16, "Plants vs. Zombies", 5.94, false, 100000, 65000);
        JogoDigital jogoDigital17 = new JogoDigital(17, "Sekiro: Shadows Die Twice", 199.90, true, 200000, 120000);
        JogoDigital jogoDigital18 = new JogoDigital(18, "Counter Strike: Global Offensive", 00.00, false, 1000000, 7000000);
        JogoDigital jogoDigital19 = new JogoDigital(19, "PlayerUnknown's Battlegrounds", 00.00, false, 700000, 400000);
        JogoDigital jogoDigital20 = new JogoDigital(20, "Elden Ring", 249.90, true, 600000, 495000);


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
    
    public static void menu() throws InterruptedException {
        
        System.out.println("-----------------------------------------------------");
        System.out.println("----------------BEM-VINDO À NOSSA LOJA---------------");
        System.out.println("-----------------------------------------------------\n");
        System.out.println("Tamanho da lista de jogos: " + jogos.size());
        System.out.println("\nAbaixo virá uma sequencia de nomes aleatórios dos jogos dentro da loja...");
        System.out.println(jogos.get((int) (Math.random() * jogos.size())).getNome());
        System.out.println(jogos.get((int) (Math.random() * jogos.size())).getNome());
        System.out.println(jogos.get((int) (Math.random() * jogos.size())).getNome());
        System.out.println(jogos.get((int) (Math.random() * jogos.size())).getNome());
        System.out.println(jogos.get((int) (Math.random() * jogos.size())).getNome());
      
    }
}