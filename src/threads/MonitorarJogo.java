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
}
