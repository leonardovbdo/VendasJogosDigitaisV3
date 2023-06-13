package threads;

import model.JogoDigital;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MonitorarJogo extends Thread {

    private final ArrayList<JogoDigital> jogos;
    private final boolean ligado;

    private final DecimalFormat df = new DecimalFormat("0.00");

    public MonitorarJogo(ArrayList<JogoDigital> jogos) {
        this.jogos = jogos;
        this.ligado = true;
    }

    @Override
    public void run() {
        while (ligado) {

            try {
                int n = jogos.size();
                double maiorDiferenca = 0;
                int indexJogoMaiorPorcentagem = 0;
                int indexJogoMenorPorcentagem = 0;
                double menorDiferenca = Double.MAX_VALUE;

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
                                if (menorDif < menorDiferenca) {
                                    menorDiferenca = menorDif;
                                    indexJogoMenorPorcentagem = porcentagemI < porcentagemJ ? i : j;
                                    indexJogoMenorPorcentagem = porcentagemK < porcentagemI && porcentagemK < porcentagemJ ? k : indexJogoMenorPorcentagem;
                                }
                            }
                        }
                    }
                }

                System.out.println("Jogo com maior porcentagem de avaliações positivas: " + jogos.get(indexJogoMaiorPorcentagem).getNome() + " porcentagem: " + df.format(jogos.get(indexJogoMaiorPorcentagem).getPorcentagemAvaliacoesPositivas()) + "%");
                System.out.println("Jogo com menor porcentagem de avaliações positivas: " + jogos.get(indexJogoMenorPorcentagem).getNome() + " porcentagem: " + df.format(jogos.get(indexJogoMenorPorcentagem).getPorcentagemAvaliacoesPositivas()) + "%");
                System.out.println("Maior diferença entre as porcentagens de avaliações positivas dos jogos: " + df.format(maiorDiferenca));
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }

        }
    }
}
