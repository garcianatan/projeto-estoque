package classes;

public class Fornecedor {
    private String nome;
    private String documento;
    private String telefone;
    private String email;
    private String Endereco;

    public Fornecedor() {
    }

    public Fornecedor(String nome, String documento, String telefone, String email, String endereco) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
        Endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    
    

    
}
