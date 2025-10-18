package controller;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import model.ProdutosModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import util.Conexao;

public class ProdutosController extends UnicastRemoteObject implements InterfaceProdutos {
  public ProdutosController()throws RemoteException{}

  @Override
  public boolean inserir(ProdutosModel produto) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "INSERT INTO produtos(nome, preco, estoque, codigo, created_at, updated_at) VALUES (?,?,?,?,?,?)";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setString(1, produto.getNome());
      sentenca.setDouble(2, produto.getPreco());
      sentenca.setInt(3, produto.getEstoque());
      sentenca.setInt(4, produto.getCodigo());
      sentenca.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
      sentenca.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));

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
  public boolean editar(ProdutosModel produto) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "UPDATE produtos SET nome = ?, preco = ?, estoque = ?, Updated_at = ? WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setString(1, produto.getNome());
      sentenca.setDouble(2, produto.getPreco());
      sentenca.setInt(3, produto.getEstoque());
      sentenca.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
      sentenca.setInt(5, produto.getIdProduto());

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
  public boolean excluir(ProdutosModel produto) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "DELETE FROM produtos WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, produto.getIdProduto());

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
  public ProdutosModel pesquisar(ProdutosModel produto) throws RemoteException {
    ProdutosModel retorno = null;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM produtos WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, produto.getIdProduto());
      ResultSet rs = sentenca.executeQuery();
      if(rs.next()){
        retorno = new ProdutosModel();
        retorno.setIdProduto(rs.getInt("id"));
        retorno.setNome(rs.getString("nome"));
        retorno.setPreco(rs.getDouble("preco"));
        retorno.setEstoque(rs.getInt("estoque"));
        retorno.setCodigo(rs.getInt("codigo"));
        retorno.setCreatedAt(rs.getTimestamp("created_at"));
        retorno.setUpdatedAt(rs.getTimestamp("updated_at"));
      }
    }catch(SQLException e){
      System.out.println("Erro ao pesquisar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public ArrayList<ProdutosModel> listar() throws RemoteException {
    ArrayList<ProdutosModel> retorno = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM produtos";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      ResultSet rs = sentenca.executeQuery();
      while(rs.next()){
        ProdutosModel produto = new ProdutosModel();
        produto.setIdProduto(rs.getInt("id"));
        produto.setNome(rs.getString("nome"));
        produto.setPreco(rs.getDouble("preco"));
        produto.setEstoque(rs.getInt("estoque"));
        produto.setCodigo(rs.getInt("codigo"));
        produto.setCreatedAt(rs.getTimestamp("created_at"));
        produto.setUpdatedAt(rs.getTimestamp("updated_at"));
        retorno.add(produto);
      }
    }catch(SQLException e){
      System.out.println("Erro ao listar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

}