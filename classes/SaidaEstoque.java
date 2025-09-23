package classes;

public class SaidaEstoque {
    private int documento;
    private String dataSaida;
    private int cod_produto;
    private int quantidade;
    private String tipoSaida;
    private int usuario_id;
    
    public SaidaEstoque() {
        
    }

    public SaidaEstoque(int documento, String dataSaida, int cod_produto, int quantidade, String tipoSaida,
            int usuario_id) {
        this.documento = documento;
        this.dataSaida = dataSaida;
        this.cod_produto = cod_produto;
        this.quantidade = quantidade;
        this.tipoSaida = tipoSaida;
        this.usuario_id = usuario_id;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String data_saida) {
        this.dataSaida = data_saida;
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

    public String getTipoSaida() {
        return tipoSaida;
    }

    public void setTipoSaida(String tipoSaida) {
        this.tipoSaida = tipoSaida;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

}