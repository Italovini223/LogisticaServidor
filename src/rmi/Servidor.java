package rmi;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

import interfaces.InterfaceCaminhoes;
import interfaces.InterfaceProdutos;
import interfaces.InterfaceProdutosPedido;
import interfaces.InterfaceClientes;
import interfaces.InterfacePedidos;
import interfaces.InterfaceEntregas;
import interfaces.InterfaceMotoristas;

import controllers.ProdutosController;
import controllers.ProdutosPedidoCotroller;
import controllers.ClientesController;
import controllers.PedidosController;
import controllers.EntregasController;
import controllers.MotoristasController;
import controllers.CaminhoesController;

public class Servidor {
    public static void main(String[] args) {
        try{
            System.setProperty("java.rmi.server.hostname", "192.168.1.20");

            Registry conexao = LocateRegistry.createRegistry(3333);
            System.out.println("Servidor Iniciado!");

            InterfaceProdutos servicoProdutos = new ProdutosController();
            InterfaceProdutosPedido servicoProdutosPedido = new ProdutosPedidoCotroller();
            InterfaceClientes servicoClientes = new ClientesController();
            InterfacePedidos servicoPedidos = new PedidosController();
            InterfaceEntregas servicoEntregas = new EntregasController();
            InterfaceMotoristas servicoMotoristas = new MotoristasController();
            InterfaceCaminhoes servicoCaminhoes = new CaminhoesController();
            
            conexao.bind("produtos", servicoProdutos);
            conexao.bind("produtosPedido", servicoProdutosPedido);
            conexao.bind("clientes", servicoClientes);
            conexao.bind("pedidos", servicoPedidos);
            conexao.bind("entregas", servicoEntregas);
            conexao.bind("motoristas", servicoMotoristas);
            conexao.bind("caminhoes", servicoCaminhoes);

            System.out.println("Serviços registrados e prontos para uso na porta 3333.");
            
        }catch(RemoteException e){
            System.out.println("Erro na criação do serviço: "+ e.getMessage());
        }catch(AlreadyBoundException e){
            System.out.println("Erro na resposta do serviço: "+ e.getMessage());
        }
    }
}
