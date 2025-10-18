package rmi;
/**
 *
 * @author Cris
 */
import java.io.Serializable;
public class Pessoa implements Serializable {
    private String nome;
    private int anoNasc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }
    
    
}
