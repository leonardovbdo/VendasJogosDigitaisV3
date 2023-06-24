package threads;

import model.JogoDigital;
import utils.Encriptador;

import javax.crypto.spec.SecretKeySpec;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class AtualizarPrecoJogo extends Thread {

    private SecretKeySpec secretKeySpec;
    private String dadosEncrpitados;

    private final JogoDigital jogo;
    private boolean ligado;
    private final DecimalFormat df = new DecimalFormat("0.00");

    public AtualizarPrecoJogo(JogoDigital jogo) {
        this.jogo = jogo;
        this.ligado = true;
    }

    /*
    * Método run da thread que será responsável para utilizar os métodos que definem
    * valores aleatórios para os atributos dos objetos com base nas regras definidas
    * na classe JogoDigital. Pelo fato de todos os métodos executados terem complexidade
    * O(1), o método run também terá complexidade O(1).
    * */
    @Override
    public void run() {
        while (ligado) {
            try {
                jogo.setPrecoAleatorio();
                jogo.setPromocaoAleatoria();
                jogo.setUnidadesVendidasAleatoria();
                jogo.setAvaliacoesPositivasAleatoria();

                // variável String 'dados' com o toString contendo as informações do objeto jogo da thread
                String dados = jogo.toString();

                /*
                * Variável 'dadosEncriptados' da thread irá usar o mecanismo de encriptação para encriptar
                * os dados do objeto jogo com base na chave definida na classe main durante a criação da thread
                */
                this.dadosEncrpitados = Encriptador.encriptar(dados, getSecretKeySpec());

                Thread.sleep(10000); // Espera 10 segundos
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public SecretKeySpec getSecretKeySpec() {
        return secretKeySpec;
    }

    public void setSecretKeySpec(SecretKeySpec secretKeySpec) {
        this.secretKeySpec = secretKeySpec;
    }

    // retorna a variável dos dados que foram encriptados durante o trabalho da thread
    public String toStringEncriptado() {
        return this.dadosEncrpitados;
    }

    public JogoDigital getJogo() {
        return this.jogo;
    }

    public void desligar() {
        this.ligado =  false;
    }

}