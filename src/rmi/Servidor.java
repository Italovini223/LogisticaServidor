package rmi;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
/**
 *
 * @author Cris
 */
public class Servidor {
    public static void main(String[] args) {
        try{
            Registry conexao = LocateRegistry.createRegistry(1100);
            System.out.println("Servidor Iniciado!");
            Interface servico = new InterfaceImplementacao();
            System.out.println("Serviço pronto!");
            conexao.bind("chave",servico);
        }catch(RemoteException e){
            System.out.println("Erro na criação do serviço: "+ e.getMessage());
        }catch(AlreadyBoundException e){
            System.out.println("Erro na resposta do serviço: "+ e.getMessage());
        }
    }
}
