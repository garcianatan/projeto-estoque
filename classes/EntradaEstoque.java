package classes;

import java.time.LocalDate;

public class EntradaEstoque {
    private int documento;
    private LocalDate dataEntrada;
    private String fornecedor;
    private int cod_produto;
    private int quantidade;
    private String tipoEntrada;
    private int usuario_id;
    

    public EntradaEstoque() {

    }

    

    public EntradaEstoque(int documento, LocalDate dataEntrada, String fornecedor, int cod_produto, int quantidade,
            String tipoEntrada, int usuario_id) {
        this.documento = documento;
        this.dataEntrada = dataEntrada;
        this.fornecedor = fornecedor;
        this.cod_produto = cod_produto;
        this.quantidade = quantidade;
        this.tipoEntrada = tipoEntrada;
        this.usuario_id = usuario_id;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
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
