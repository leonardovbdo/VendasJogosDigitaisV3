package model;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class JogoDigital {

    private int id;
    private String nome;
    private double preco;
    private boolean promocao;
    private int unidadesVendidas;
    private int avaliacoesPositivas;
    private List<JogoDigital> jogosDigitais;
    private DecimalFormat df = new DecimalFormat("0.00");

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
    
    public void setPrecoAleatorio() {
        this.preco = (double) (Math.random() * 300);
    } 
    
    public void setPromocaoAleatoria() {
        int resultado;
        resultado = (int) (Math.random() * 2);
        
        if (resultado == 0) {
            this.promocao = false;
        } else if (resultado == 1){
            this.promocao = true;
        }
    }
    
    public void setUnidadesVendidasAleatoria() {
        this.unidadesVendidas = (int) (Math.random() * 100000);
    }
    
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
