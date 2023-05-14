package main;

import model.JogoDigital;
import model.Nomes;
import threads.AtualizarPrecoJogo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Leonardo
 */
public class Main {

    public static Scanner entrada = new Scanner(System.in);
    public static ArrayList<JogoDigital> jogos = new ArrayList<>();
    public static ArrayList<AtualizarPrecoJogo> threads = new ArrayList<>();
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            JogoDigital jogo = new JogoDigital(Nomes.getNomeById(i));
            jogos.add(jogo);
            AtualizarPrecoJogo atualizarPrecoJogo = new AtualizarPrecoJogo(jogo);
            threads.add(atualizarPrecoJogo);
            atualizarPrecoJogo.start();
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("----------------BEM-VINDO-À-NOSSA-LOJA---------------");
        System.out.println("-----------------------------------------------------\n");

        menu();
    }

    public static void listarLeituras() {
        for (int i = 0; i < 20; i++) {
            System.out.println(
                    jogos.get(i)
            );
        }
    }

    public static void gerarJogosNomes() {
        System.out.println("\n##### SEGUE ABAIXO A LISTA COM O NOME DOS JOGOS EM NOSSA LOJA #####\n");
        for (JogoDigital jogo : jogos) {
            System.out.println(jogo.getNome());
        }
    }

    public static void encontrarMaiorDiferencaAvaliacao(ArrayList<JogoDigital> jogos) {
        int n = jogos.size();
        double maiorDiferenca = 0;
        int indexJogoMaiorPorcentagem = 0;
        int indexJogoMenorPorcentagem = 0;
        double menorPorcentagem = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    if (i != j && i != k && j != k) {

                        double porcentagemI = 100 * ((double) jogos.get(i).getAvaliacoesPositivas() / jogos.get(i).getUnidadesVendidas());
                        double porcentagemJ = 100 * ((double) jogos.get(j).getAvaliacoesPositivas() / jogos.get(j).getUnidadesVendidas());
                        double porcentagemK = 100 * ((double) jogos.get(k).getAvaliacoesPositivas() / jogos.get(k).getUnidadesVendidas());

                        double diferencaIJ = Math.abs(porcentagemI - porcentagemJ);
                        double diferencaIK = Math.abs(porcentagemI - porcentagemK);
                        double diferencaJK = Math.abs(porcentagemJ - porcentagemK);

                        double maiorDif = Math.max(diferencaIJ, Math.max(diferencaIK, diferencaJK));

                        if (maiorDif > maiorDiferenca) {
                            maiorDiferenca = maiorDif;
                            indexJogoMaiorPorcentagem = porcentagemI > porcentagemJ ? i : j;
                            indexJogoMaiorPorcentagem = porcentagemK > porcentagemI && porcentagemK > porcentagemJ ? k : indexJogoMaiorPorcentagem;
                        }

                        double menorDif = Math.min(porcentagemI, Math.min(porcentagemJ, porcentagemK));
                        if (menorDif < menorPorcentagem) {
                            menorPorcentagem = menorDif;
                            indexJogoMenorPorcentagem = porcentagemI < porcentagemJ ? i : j;
                            indexJogoMenorPorcentagem = porcentagemK < porcentagemI && porcentagemK < porcentagemJ ? k : indexJogoMenorPorcentagem;
                        }
                    }
                }
            }
        }

        System.out.println("Jogo com maior porcentagem de avaliações positivas: " + jogos.get(indexJogoMaiorPorcentagem).getNome());
        System.out.println("Jogo com menor porcentagem de avaliações positivas: " + jogos.get(indexJogoMenorPorcentagem).getNome());
        System.out.println("Maior diferença entre as porcentagens de avaliações positivas dos jogos: " + maiorDiferenca);
    }

    public static void ordenarLeituras(ArrayList<JogoDigital> jogos) {

        for (int i = 0; i < jogos.size(); i++) {
            for (int j = i + 1; j < jogos.size(); j++) {
                if (jogos.get(i).getPrecoAtual() > jogos.get(j).getPrecoAtual()) {
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

    public static void monitorarPrecosPrincipal() {
        boolean encontrouDiferenca = false;
        for (JogoDigital jogo : jogos) {
            if (jogo.recebeuDiminuicaoSignificativa() && jogo.getPrecoAntigo() != 0) {
                encontrouDiferenca = true;
                System.out.println("\nO jogo " + jogo.getNome() + " sofreu uma alteração significativa em seu preço!" +
                        "\nPreço anterior: R$" + df.format(jogo.getPrecoAntigo()) +
                        "\nPreço atual: R$" + df.format(jogo.getPrecoAtual()));
            }
        }
        if (!encontrouDiferenca) {
            System.out.println("\nNão houve alguma redução significativa nos preços dos jogos...");
        }
    }

    public static void menu() throws InterruptedException {

        char opcao;
        boolean ligado = true;
        do {
            System.out.println("\n##### SELECIONE QUAL FUNÇÃO DESEJA REALIZAR #####");
            System.out.println("\n[A] - IMPRIMIR A LISTA DE JOGOS");
            System.out.println("[B] - IMPRIMIR A LISTA COM OS VALORES DOS JOGOS");
            System.out.println("[C] - IMPRIMIR A LISTA DE JOGOS DE ORDENADA DE FORMA CRESCENTE");
            System.out.println("[D] - CALCULAR A MAIOR DIFERÊNÇA ENTRE PORCENTAGENS DE AVALIAÇÕES POSITIVAS");
            System.out.println("[P] - EXIBIR MONITORAMENTO PELO PROGRAMA PRINCIPAL");
            System.out.println("[S] - SAIR");
            System.out.print("Sua escolha: ");
            opcao = entrada.nextLine().charAt(0);
            char opcaoUpperCase = Character.toUpperCase(opcao);

            switch (opcaoUpperCase) {
                case 'A':
                    gerarJogosNomes();
                    break;
                case 'B':
                    listarLeituras();
                    break;
                case 'C':
                    ordenarLeituras(jogos);
                    break;
                case 'D':
                    encontrarMaiorDiferencaAvaliacao(jogos);
                    break;
                case 'P':
                    monitorarPrecosPrincipal();
                    break;
                case 'S':
                    System.out.println("\nAguarde, o sistema está sendo desligado...");
                    ligado = false;
                    entrada.close();
                    break;
            }

        } while (ligado);
        encerrarThreads();
    }

    public static void encerrarThreads() {
        for (AtualizarPrecoJogo thread : threads) {
            thread.desligar();
        }
    }
}