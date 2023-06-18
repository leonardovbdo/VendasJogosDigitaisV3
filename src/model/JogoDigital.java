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

    /*
    * Método que verifica se o objeto da classe JogoDigital possui um valor
    * de preço atual diferente de 0, para assim definir o preço antigo com o valor do preço atual.
    * Depois o valor do preço atual muda para algum número aleatório de 0 a 300.
    * Se a verificação mencionada anteriormente for falsa, o valor de precoAtual é diretamente definido
    * aleatóriamente de um número entre 0 a 300.
    * A complexidade do método é 0(1), pois não importa o quão grande seja o conjunto de dados, o tempo
    * permanecerá constante.
    */
    public void setPrecoAleatorio() {
        if (this.precoAtual != 0) {
            this.precoAntigo = this.precoAtual;
        }
        this.precoAtual = (double) (Math.random() * 300);
    }

    /* método que define um número inteiro aleatório de 0 a 1 para definir
    * se o atributo promocao do objeto jogo será verdadeiro ou falso
    * combase na lógica binária.
    * Complexidade de O(1).
    */
    public void setPromocaoAleatoria() {
        int resultado;
        resultado = (int) (Math.random() * 2);

        if (resultado == 0) {
            this.promocao = false;
        } else if (resultado == 1) {
            this.promocao = true;
        }
    }

    /*
    * Método que define o atributo unidadesVendidas com base em um número inteiro aleatório de
    * 0 a 100000.
    * Complexidade O(1).
    * */
    public void setUnidadesVendidasAleatoria() {
        this.unidadesVendidas = (int) (Math.random() * 100000);
    }

    /*
    * Método que define o atributo avaliacoesPositivas com base em um número inteiro aleatório
    * entre 0 e o número do atributo unidadesVendidas.
    * Complexidade O(1).
    * */
    public void setAvaliacoesPositivasAleatoria() {
        this.avaliacoesPositivas = (int) (Math.random() * this.unidadesVendidas);
    }

    public double getPorcentagemAvaliacoesPositivas() {
        return 100 * ((double) this.getAvaliacoesPositivas() / this.getUnidadesVendidas());
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