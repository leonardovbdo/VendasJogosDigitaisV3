package model;

import java.text.DecimalFormat;

/**
 *
 * @author Leonardo
 */

/*
* Classe que será usada para criar os objetos usados dentro da classe main
 */
public class JogoDigital {

    /*
    * Atributos da classe
     */
    private int id; //identificador que será usado na ordenação realizada com base no valor do preço de forma crescente
    private String nome; // nome do jogo
    private double preco; // preço do jogo
    private boolean promocao; // Se o jogo está em promoção ou não
    private int unidadesVendidas; // Unidades vendidas do jogo
    private int avaliacoesPositivas; // avaliações positivas do jogo, sempre deverá ser menor que o valor de unidades vendidas
    private DecimalFormat df = new DecimalFormat("0.00"); // formatação dos valores de variável double

    /*
    * Construtor que receberá apenas o nome ao ser criado e os demais atributos estarão "vazios"
    * só serão preenchidos após a realização dos métodos que geram valores aleatórios
     */
    public JogoDigital(String nome) {
        this.id = 0;
        this.nome = nome;
        this.preco = 0;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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
    * Gera um valor de preço aleatório para a variável double preco. Utilizando o método Math.random() 
    & Esse valor irá ser um número aleatório de 0 a 300
     */
    public void setPrecoAleatorio() {
        this.preco = (double) (Math.random() * 300);
    }

    /*
    * Gera um número inteiro aleatório de 0 a 1
    * Se o número for 0 a variável promocao será falsa
    * Se o número for 1 a variável promcao será verdadeira
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
    * Gera um número inteiro aleatório para a variável unidadesVendidas. Será um número aleatório de 0 a 100000
     */
    public void setUnidadesVendidasAleatoria() {
        this.unidadesVendidas = (int) (Math.random() * 100000);
    }

    /*
    * Gera um número inteiro aleatório para a variável avaliacoesPositivas. Será um número aleatório sempre 
    * menor que as unidadesVendidas do respectivo jogo.
     */
    public void setAvaliacoesPositivasAleatoria() {
        this.avaliacoesPositivas = (int) (Math.random() * this.unidadesVendidas);
    }

    @Override
    public String toString() {
        return "\nInformações do jogo "
                + "\nid = " + id + ", "
                + "\nnome = " + nome + ", "
                + "\npreco = " + df.format(preco) + ", "
                + "\npromocao = " + promocao + ", "
                + "\nunidadesVendidas = " + unidadesVendidas + ", "
                + "\navaliacoesPositivas = " + avaliacoesPositivas;
    }

}
