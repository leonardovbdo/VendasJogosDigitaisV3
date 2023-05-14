package threads;

import model.JogoDigital;
import java.text.DecimalFormat;

/**
 *
 * @author Leonardo
 */
public class AtualizarPrecoJogo extends Thread {

    private final JogoDigital jogo;
    private boolean ligado;
    private final DecimalFormat df = new DecimalFormat("0.00");

    public AtualizarPrecoJogo(JogoDigital jogo) {
        this.jogo = jogo;
        this.ligado = true;
    }

    @Override
    public void run() {
        while (ligado) {
            try {
                jogo.setPrecoAleatorio();
                jogo.setPromocaoAleatoria();
                jogo.setUnidadesVendidasAleatoria();
                jogo.setAvaliacoesPositivasAleatoria();
                Thread.sleep(10000); // Espera 10 segundos
            } catch (InterruptedException ignored) {

            }
        }
    }

    public JogoDigital getJogo() {
        return this.jogo;
    }

    public void desligar() {
        this.ligado =  false;
    }

}