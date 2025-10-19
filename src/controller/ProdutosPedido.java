package controller;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import util.Conexao;
import model.ProdutosPedidoModel;

public class ProdutosPedido extends UnicastRemoteObject implements InterfaceProdutosPedido{
  public ProdutosPedido()throws RemoteException{}

  @Override
  public boolean inserir(ProdutosPedidoModel produtoPedido) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "INSERT INTO produto_pedido(id_pedido, id_produto, valor, created_at) VALUES (?,?,?,?)";
    try {
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, produtoPedido.getIdPedido());
      sentenca.setInt(2, produtoPedido.getIdProduto());
      sentenca.setDouble(3, produtoPedido.getValor());
      sentenca.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));

      if(!sentenca.execute()){
        retorno = true;
      }
    }catch(SQLException e){
      System.out.println("Erro ao inserir: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public boolean editar(ProdutosPedidoModel produtoPedido) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "UPDATE produto_pedido SET id_pedido = ?, id_produto = ?, valor = ? WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, produtoPedido.getIdPedido());
      sentenca.setInt(2, produtoPedido.getIdProduto());
      sentenca.setDouble(3, produtoPedido.getValor());
      sentenca.setInt(4, produtoPedido.getIdProdutoPedido());

      if(!sentenca.execute()){
        retorno = true;
      }
    }catch(SQLException e){
      System.out.println("Erro ao editar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public boolean excluir(ProdutosPedidoModel produtoPedido) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "DELETE FROM produto_pedido WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, produtoPedido.getIdProdutoPedido());

      if(!sentenca.execute()){
        retorno = true;
      }
    }catch(SQLException e){
      System.out.println("Erro ao excluir: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public ProdutosPedidoModel pesquisar(ProdutosPedidoModel produtoPedido) throws RemoteException {
    ProdutosPedidoModel retorno = null;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM produto_pedido WHERE id = ?";
    try {
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, produtoPedido.getIdProdutoPedido());
      ResultSet rs = sentenca.executeQuery();
      if(rs.next()){
        retorno = new ProdutosPedidoModel();
        retorno.setIdProdutoPedido(rs.getInt("id"));
        retorno.setIdPedido(rs.getInt("id_pedido"));
        retorno.setIdProduto(rs.getInt("id_produto"));
        retorno.setValor(rs.getDouble("valor"));
      }
    }catch(SQLException e){
      System.out.println("Erro ao pesquisar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public ArrayList<ProdutosPedidoModel> listarPorPedido(int idPedido) throws RemoteException {
    ArrayList<ProdutosPedidoModel> retorno = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM produto_pedido WHERE id_pedido = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, idPedido);
      ResultSet rs = sentenca.executeQuery();
      while(rs.next()){
        ProdutosPedidoModel produtoPedido = new ProdutosPedidoModel();
        produtoPedido.setIdProdutoPedido(rs.getInt("id"));
        produtoPedido.setIdPedido(rs.getInt("id_pedido"));
        produtoPedido.setIdProduto(rs.getInt("id_produto"));
        produtoPedido.setValor(rs.getDouble("valor"));
        retorno.add(produtoPedido);
      }
    }catch(SQLException e){
      System.out.println("Erro ao listar por pedido: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }
  
}
