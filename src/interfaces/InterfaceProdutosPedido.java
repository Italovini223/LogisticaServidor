package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.ProdutosPedidoModel;

public interface InterfaceProdutosPedido extends Remote {
  public boolean inserir(ProdutosPedidoModel produtoPedido)throws RemoteException;
  public boolean editar(ProdutosPedidoModel produtoPedido) throws RemoteException;
  public boolean excluir (ProdutosPedidoModel produtoPedido)throws RemoteException;
  public model.ProdutosPedidoModel pesquisar(ProdutosPedidoModel produtoPedido) throws RemoteException;
  public ArrayList<model.ProdutosPedidoModel> listarPorPedido(int idPedido) throws RemoteException;
}
