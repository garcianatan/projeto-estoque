package classes;

public class Produto {
    private int codigo;
    private String nome;
    private String desc;
    private String categoria;
    private String fornecedor;
    private double precoCusto;
    private double precoVenda;

    public Produto() {

    }

    public Produto(int codigo, String nome, String desc, String categoria, String fornecedor, double precoCusto, double precoVenda ) {
        this.codigo = codigo;
        this.nome = nome;
        this.desc = desc;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    
}
