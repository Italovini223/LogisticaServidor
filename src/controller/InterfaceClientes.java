package controller;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.ClientesModel;

public interface InterfaceClientes extends Remote {
    public boolean inserir(ClientesModel cliente)throws RemoteException;
    public boolean editar(ClientesModel cliente) throws RemoteException;
    public boolean excluir (ClientesModel cliente)throws RemoteException;
    public ClientesModel pesquisar(ClientesModel cliente) throws RemoteException;
    public ArrayList<ClientesModel> listar() throws RemoteException;
}
