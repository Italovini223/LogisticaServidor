package controller;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.CaminhoesModel;

public interface InterfaceCaminhoes extends Remote {
  public boolean inserir(CaminhoesModel caminhao)throws RemoteException;
  public boolean editar(CaminhoesModel caminhao) throws RemoteException;
  public boolean excluir (CaminhoesModel caminhao)throws RemoteException;
  public CaminhoesModel pesquisar(CaminhoesModel caminhao) throws RemoteException;
  public ArrayList<CaminhoesModel> listar() throws RemoteException;
}
