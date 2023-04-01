package models;

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

    public JogoDigital(int id, String nome, double preco, boolean promocao, int unidadesVendidas, int avaliacoesPositivas) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.promocao = promocao;
        this.unidadesVendidas = unidadesVendidas;
        this.avaliacoesPositivas = avaliacoesPositivas;
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

}