package controller;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.ProdutosModel;

public interface InterfaceProdutos extends Remote {
    public boolean inserir(ProdutosModel produto)throws RemoteException;
    public boolean editar(ProdutosModel produto) throws RemoteException;
    public boolean excluir (ProdutosModel produto)throws RemoteException;
    public ProdutosModel pesquisar(ProdutosModel produto) throws RemoteException;
    public ArrayList<ProdutosModel> listar() throws RemoteException;

}