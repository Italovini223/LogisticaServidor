package rmi;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 *
 * @author Cris
 */
public class InterfaceImplementacao extends UnicastRemoteObject implements Interface{
    private int contador;
    public InterfaceImplementacao()throws RemoteException{
        //super();
        contador = 0;
    }
    @Override
    public String olaMundo()throws RemoteException{
        String retorno = "Olá, Mundo!";
        System.out.println("Servidor: "+ retorno);
        return retorno;
    }
    @Override
    public int soma (int x, int y) throws RemoteException{
        int soma = x+y;
        System.out.println("Soma - Servidor: "+ soma);
        return soma;
    }
    @Override
    public int calcularIdade(Pessoa p)throws RemoteException{
        int idade = 2025 - p.getAnoNasc();
        System.out.println("Idade - Servidor: "+ idade);
        return idade;
    }
    @Override
    public Pessoa alterarPessoa() throws RemoteException{
       Pessoa p = new Pessoa();
       p.setNome("Cris");
       p.setAnoNasc(1986);
       System.out.println("Pessoa - Servidor: "+ p.getNome());
       return p;
    }
    @Override
    public synchronized int alterarContador()throws RemoteException{
        contador++;
        System.out.println("Contador - Servidor: "+ contador);
        return contador;
    }
}
