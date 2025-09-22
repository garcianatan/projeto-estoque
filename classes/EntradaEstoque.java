package classes;

public class EntradaEstoque {
    private String documento;
    private String dataEntrada;
    private String fornecedor;
    private int cod_produto;
    private int quantidade;
    private String tipoEntrada;
    private int usuario_id;
    

    public EntradaEstoque() {

    }

    

    public EntradaEstoque(String documento, String dataEntrada, String fornecedor, int cod_produto, int quantidade,
            String tipoEntrada, int usuario_id) {
        this.documento = documento;
        this.dataEntrada = dataEntrada;
        this.fornecedor = fornecedor;
        this.cod_produto = cod_produto;
        this.quantidade = quantidade;
        this.tipoEntrada = tipoEntrada;
        this.usuario_id = usuario_id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    
}
