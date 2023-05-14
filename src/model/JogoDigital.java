package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class JogoDigital {

    private int id; //identificador que será usado na ordenação realizada com base no valor do preço de forma crescente
    private String nome; // nome do jogo
    private double precoAtual; // preço atual do jogo
    private double precoAntigo; // preço antigo do jogo
    private boolean promocao; // Se o jogo está em promoção ou não
    private int unidadesVendidas; // Unidades vendidas do jogo
    private int avaliacoesPositivas; // avaliações positivas do jogo, sempre deverá ser menor que o valor de unidades vendidas
    private final DecimalFormat df = new DecimalFormat("0.00"); // formatação dos valores de variável double

    public JogoDigital(String nome) {
        this.id = 0;
        this.nome = nome;
        this.precoAtual = 0;
        this.precoAntigo = 0;
        this.promocao = false;
        this.unidadesVendidas = 0;
        this.avaliacoesPositivas = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(double precoAtual) {
        this.precoAtual = precoAtual;
    }

    public double getPrecoAntigo() {
        return precoAntigo;
    }

    public void setPrecoAntigo(double precoAntigo) {
        this.precoAntigo = precoAntigo;
    }

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public int getAvaliacoesPositivas() {
        return avaliacoesPositivas;
    }

    public void setAvaliacoesPositivas(int avaliacoesPositivas) {
        this.avaliacoesPositivas = avaliacoesPositivas;
    }

    public void setPrecoAleatorio() {
        if (this.precoAtual != 0) {
            this.precoAntigo = this.precoAtual;
        }
        this.precoAtual = (double) (Math.random() * 300);
    }

    public void setPromocaoAleatoria() {
        int resultado;
        resultado = (int) (Math.random() * 2);

        if (resultado == 0) {
            this.promocao = false;
        } else if (resultado == 1) {
            this.promocao = true;
        }
    }

    public void setUnidadesVendidasAleatoria() {
        this.unidadesVendidas = (int) (Math.random() * 100000);
    }

    public void setAvaliacoesPositivasAleatoria() {
        this.avaliacoesPositivas = (int) (Math.random() * this.unidadesVendidas);
    }

    public boolean recebeuDiminuicaoSignificativa() {
        double diminuicaoPercentual = ((this.precoAntigo - this.precoAtual) / this.precoAntigo) * 100;
        return diminuicaoPercentual > 50.0;
    }

    @Override
    public String toString() {
        return "\nInformações do jogo "
                + "\nId = " + id + ", "
                + "\nNome = " + nome + ", "
                + "\nPreco = R$" + df.format(precoAtual) + ", "
                + "\nPromocao = " + (promocao ? "Sim" : "Não") + ", " // Se promoção for true, o resultado será 'Sim'
                + "\nUnidades vendidas = " + unidadesVendidas + ", "
                + "\nAvaliacoes positivas = " + avaliacoesPositivas;
    }

}