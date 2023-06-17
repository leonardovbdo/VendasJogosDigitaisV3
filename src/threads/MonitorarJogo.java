package threads;

import model.JogoDigital;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MonitorarJogo extends Thread {

    private final ArrayList<JogoDigital> jogos;
    private boolean ligado;
    private boolean monitorando;

    private final DecimalFormat df = new DecimalFormat("0.00");

    public MonitorarJogo(ArrayList<JogoDigital> jogos) {
        this.jogos = jogos;
        this.ligado = true;
        this.monitorando = false;
    }

    /*
    * Método da thread que será executado enquanto 'ligado' for verdadeiro.
    * Primeiro será realizada uma verificação se 'monitorando' é verdadeiro e depois
    * a thread terá acesso ao tamanho da lista de jogos passada no programa principal
    * e usará esse valor na variável 'n' que será usada pelo loop aninhado que ir[a
    * comparar todas as combinações possíveis de jogos da lista em busca de chegar a todas as diferenças
    * de porcentagem de avaliações positivas entre os jogos comparados. Se uma diferença for maior do que
    * a maior diferença atual, ela é atualizada juntamente com o índice do jogo correspondente. Se uma diferença
    * for menor do que a menor diferença atual, ela também será atualizada, juntamente com o índice do jogo
    * corerespondente. Após o loop aninhado, são exibidas as informações sobre o jogo com a maior porcentagem
    * de avaliações positivas, o jogo com menor porcentagem de avaliações positivas e a diferença entre eles.
    * A thread é pausada por 10 segundos, até repetir o processo enquanto todas as condições forem cumpridas.
    *
    * A complexidade em notação Big O desse método é de O(n^2) onde 'n' é o número de jogos na lista. Isso
    * ocorre devido ao uso de dois loops aninhados para serem feitas as combinações possíveis de jogos na lista.
    * A tentativa de melhora no nível de complexidade ocorre na remoção do terceiro loop que havia anteriormente,
    * resultado em apenas 2 loops ao invés de 3, diminuindo a complexidade de O(n^3) para O(n^2), reduzindo o número
    * de comparações realizadas.
    */

    @Override
    public void run() {
        while (ligado) {
            if (monitorando) {
                try {
                    int n = jogos.size();
                    double maiorDiferenca = 0;
                    int indexJogoMaiorPorcentagem = 0;
                    int indexJogoMenorPorcentagem = 0;
                    double menorDiferenca = Double.MAX_VALUE;

                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {

                            double porcentagemI = jogos.get(i).getPorcentagemAvaliacoesPositivas();
                            double porcentagemJ = jogos.get(j).getPorcentagemAvaliacoesPositivas();

                            double maiorDif = Math.abs(porcentagemI - porcentagemJ);
                            double menorDif = Math.min(porcentagemI, porcentagemJ);

                            if (maiorDif > maiorDiferenca) {
                                maiorDiferenca = maiorDif;
                                indexJogoMaiorPorcentagem = porcentagemI > porcentagemJ ? i : j;
                            }

                            if (menorDif < menorDiferenca) {
                                menorDiferenca = menorDif;
                                indexJogoMenorPorcentagem = porcentagemI < porcentagemJ ? i : j;
                            }
                        }
                    }

                    System.out.println("\nJogo com maior porcentagem de avaliações positivas: " + jogos.get(indexJogoMaiorPorcentagem).getNome() + " porcentagem: " + df.format(jogos.get(indexJogoMaiorPorcentagem).getPorcentagemAvaliacoesPositivas()) + "%");
                    System.out.println("Jogo com menor porcentagem de avaliações positivas: " + jogos.get(indexJogoMenorPorcentagem).getNome() + " porcentagem: " + df.format(jogos.get(indexJogoMenorPorcentagem).getPorcentagemAvaliacoesPositivas()) + "%");
                    System.out.println("Maior diferença entre as porcentagens de avaliações positivas dos jogos: " + df.format(maiorDiferenca));
                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public void monitorar() {
        this.monitorando = true;
    }

    public void pararMonitorar() {
        this.monitorando = false;
    }

    public void desligar() {
        this.ligado = false;
    }
}
