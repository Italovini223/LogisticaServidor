package controllers;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import model.PedidosModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import util.Conexao;
import interfaces.InterfacePedidos;

public class PedidosController extends UnicastRemoteObject implements InterfacePedidos {
  public PedidosController() throws RemoteException {}

    @Override
  public boolean inserir(PedidosModel pedido) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "INSERT INTO pedidos(id_cliente, id_entrega, status, valor_total, created_at, updated_at) VALUES (?,?,?,?,?,?)";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, pedido.getIdCliente());
      
      // Verifica se idEntrega é nulo
      if(pedido.getIdEntrega() == null) {
        sentenca.setNull(2, java.sql.Types.INTEGER);
      } else {
        sentenca.setInt(2, pedido.getIdEntrega());
      }
      
      sentenca.setString(3, pedido.getStatus());
      sentenca.setDouble(4, pedido.getValorTotal());
      sentenca.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
      sentenca.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));

      if(!sentenca.execute()){
        retorno = true;
      }
    } catch(SQLException e){
      System.out.println("Erro ao inserir: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }
  
  @Override
  public boolean editar(PedidosModel pedido) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "UPDATE pedidos SET id_cliente = ?, id_entrega = ?, status = ?, valor_total = ?, updated_at = ? WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, pedido.getIdCliente());
      
      // Verifica se idEntrega é nulo
      if(pedido.getIdEntrega() == null) {
        sentenca.setNull(2, java.sql.Types.INTEGER);
      } else {
        sentenca.setInt(2, pedido.getIdEntrega());
      }
      
      sentenca.setString(3, pedido.getStatus());
      sentenca.setDouble(4, pedido.getValorTotal());
      sentenca.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
      sentenca.setInt(6, pedido.getIdPedido());

      if(!sentenca.execute()){
        retorno = true;
      }
    } catch(SQLException e){
      System.out.println("Erro ao editar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public boolean excluir(PedidosModel pedido) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "DELETE FROM pedidos WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, pedido.getIdPedido());

      if(!sentenca.execute()){
        retorno = true;
      }
    } catch(SQLException e){
      System.out.println("Erro ao excluir: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public PedidosModel pesquisar(PedidosModel pedido) throws RemoteException {
    PedidosModel retorno = null;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM pedidos WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, pedido.getIdPedido());
      ResultSet rs = sentenca.executeQuery();

      if(rs.next()){
        retorno = new PedidosModel();
        retorno.setIdPedido(rs.getInt(""));
        retorno.setIdCliente(rs.getInt("id_cliente"));
        retorno.setIdEntrega(rs.getInt("id_entrega"));
        retorno.setStatus(rs.getString("status"));
        retorno.setValorTotal(rs.getDouble("valor_total"));
        retorno.setCreatedAt(rs.getTimestamp("created_at"));
        retorno.setUpdatedAt(rs.getTimestamp("updated_at"));
      }
    } catch(SQLException e){
      System.out.println("Erro ao pesquisar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public ArrayList<PedidosModel> listar() throws RemoteException {
    ArrayList<PedidosModel> lista = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM pedidos";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      ResultSet rs = sentenca.executeQuery();

      while(rs.next()){
        PedidosModel pedido = new PedidosModel();
        pedido.setIdPedido(rs.getInt("id"));
        pedido.setIdCliente(rs.getInt("id_cliente"));
        pedido.setIdEntrega(rs.getInt("id_entrega"));
        pedido.setStatus(rs.getString("status"));
        pedido.setValorTotal(rs.getDouble("valor_total"));
        pedido.setCreatedAt(rs.getTimestamp("created_at"));
        pedido.setUpdatedAt(rs.getTimestamp("updated_at"));
        lista.add(pedido);
      }
    } catch(SQLException e){
      System.out.println("Erro ao listar: " + e.getMessage());
    }
    c.desconectar();
    return lista;
  }

  @Override
  public ArrayList<PedidosModel> listarPorEntrega(int idEntrega) throws RemoteException {
    ArrayList<PedidosModel> lista = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM pedidos WHERE id_entrega = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, idEntrega);
      ResultSet rs = sentenca.executeQuery();

      while(rs.next()){
        PedidosModel pedido = new PedidosModel();
        pedido.setIdPedido(rs.getInt("id"));
        pedido.setIdCliente(rs.getInt("id_cliente"));
        pedido.setIdEntrega(rs.getInt("id_entrega"));
        pedido.setStatus(rs.getString("status"));
        pedido.setValorTotal(rs.getDouble("valor_total"));
        pedido.setCreatedAt(rs.getTimestamp("created_at"));
        pedido.setUpdatedAt(rs.getTimestamp("updated_at"));
        lista.add(pedido);
      }
    } catch(SQLException e){
      System.out.println("Erro ao listar por pedido: " + e.getMessage());
    }
    c.desconectar();
    return lista;
  }

  @Override
  public ArrayList<PedidosModel> listarPorCliente(int idCliente) throws RemoteException {
    ArrayList<PedidosModel> lista = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM pedidos WHERE id_cliente = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, idCliente);
      ResultSet rs = sentenca.executeQuery();

      while(rs.next()){
        PedidosModel pedido = new PedidosModel();
        pedido.setIdPedido(rs.getInt("id"));
        pedido.setIdCliente(rs.getInt("id_cliente"));
        pedido.setIdEntrega(rs.getInt("id_entrega"));
        pedido.setStatus(rs.getString("status"));
        pedido.setValorTotal(rs.getDouble("valor_total"));
        pedido.setCreatedAt(rs.getTimestamp("created_at"));
        pedido.setUpdatedAt(rs.getTimestamp("updated_at"));
        lista.add(pedido);
      }
    } catch(SQLException e){
      System.out.println("Erro ao listar por cliente: " + e.getMessage());
    }
    c.desconectar();
    return lista;
  }
}
