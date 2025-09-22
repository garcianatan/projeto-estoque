package classes;

public class Usuario {
    private String nome;
    private int id;
    private String cargo;
    private String email;
    private String Senha;

    public Usuario() {
    }

    public Usuario(String nome, int id, String cargo, String email, String senha) {
        this.nome = nome;
        this.id = id;
        this.cargo = cargo;
        this.email = email;
        Senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    
    
}
