package aricelio.grupopesquisa.br.DomainModel;

/**
 * Created by aricelio on 01/04/15.
 */
public class Pessoa {

    private Long id;
    private String nome;
    private int telefone;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return    nome     + "\n"
                + telefone + "\n"
                + email    + "\n" ;
    }
}
