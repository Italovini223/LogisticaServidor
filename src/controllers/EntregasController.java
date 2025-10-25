package controllers;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import util.Conexao;
import model.EntregasModel;
import interfaces.InterfaceEntregas;

public class EntregasController extends UnicastRemoteObject implements InterfaceEntregas{
  public EntregasController()throws RemoteException{}

  @Override
  public boolean inserir(model.EntregasModel entrega) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "INSERT INTO entregas(id_motorista, id_caminhao, status, created_at, updated_at) VALUES (?,?,?,?,?)";
    try {
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, entrega.getIdMotorista());
      sentenca.setInt(2, entrega.getIdCaminhao());
      sentenca.setString(3, entrega.getStatus());
      sentenca.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
      sentenca.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));

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
  public boolean editar(model.EntregasModel entrega) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "UPDATE entregas SET id_motorista = ?, id_caminhao = ?, status = ?, updated_at = ? WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, entrega.getIdMotorista());
      sentenca.setInt(2, entrega.getIdCaminhao());
      sentenca.setString(3, entrega.getStatus());
      sentenca.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
      sentenca.setInt(5, entrega.getIdEntrega());

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
  public boolean excluir (model.EntregasModel entrega)throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "DELETE FROM entregas WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, entrega.getIdEntrega());

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
  public model.EntregasModel pesquisar(model.EntregasModel entrega) throws RemoteException {
    EntregasModel retorno = null;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM entregas WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, entrega.getIdEntrega());
      ResultSet rs = sentenca.executeQuery();
      if(rs.next()){
        retorno = new EntregasModel();
        retorno.setIdEntrega(rs.getInt("id"));
        retorno.setIdMotorista(rs.getInt("id_motorista"));
        retorno.setIdCaminhao(rs.getInt("id_caminhao"));
        retorno.setStatus(rs.getString("status"));
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
  public ArrayList<model.EntregasModel> listar() throws RemoteException {
    ArrayList<EntregasModel> retorno = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM entregas";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      ResultSet rs = sentenca.executeQuery();

      while(rs.next()){
        EntregasModel entrega = new EntregasModel();
        entrega.setIdEntrega(rs.getInt("id"));
        entrega.setIdMotorista(rs.getInt("id_motorista"));
        entrega.setIdCaminhao(rs.getInt("id_caminhao"));
        entrega.setStatus(rs.getString("status"));
        entrega.setCreatedAt(rs.getTimestamp("created_at"));
        entrega.setUpdatedAt(rs.getTimestamp("updated_at"));
        retorno.add(entrega);
      }
      
    }catch(SQLException e){
      System.out.println("Erro ao listar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public ArrayList<model.EntregasModel> listarPorMotorista(int idMotorista) throws RemoteException {
    ArrayList<EntregasModel> retorno = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM entregas WHERE id_motorista = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, idMotorista);
      ResultSet rs = sentenca.executeQuery();
      while(rs.next()){
        EntregasModel entrega = new EntregasModel();
        entrega.setIdEntrega(rs.getInt("id"));
        entrega.setIdMotorista(rs.getInt("id_motorista"));
        entrega.setIdCaminhao(rs.getInt("id_caminhao"));
        entrega.setStatus(rs.getString("status"));
        entrega.setCreatedAt(rs.getTimestamp("created_at"));
        entrega.setUpdatedAt(rs.getTimestamp("updated_at"));
        retorno.add(entrega);
      }
    }catch(SQLException e){
      System.out.println("Erro ao listar por motorista: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public ArrayList<model.EntregasModel> listarPorCaminhao(int idCaminhao) throws RemoteException {
    ArrayList<EntregasModel> retorno = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM entregas WHERE id_caminhao = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, idCaminhao);
      ResultSet rs = sentenca.executeQuery();
      while(rs.next()){
        EntregasModel entrega = new EntregasModel();
        entrega.setIdEntrega(rs.getInt("id"));
        entrega.setIdMotorista(rs.getInt("id_motorista"));
        entrega.setIdCaminhao(rs.getInt("id_caminhao"));
        entrega.setStatus(rs.getString("status"));
        entrega.setCreatedAt(rs.getTimestamp("created_at"));
        entrega.setUpdatedAt(rs.getTimestamp("updated_at"));
        retorno.add(entrega);
      }
    }catch(SQLException e){
      System.out.println("Erro ao listar por caminhao: " + e.getMessage()); 
    }
    c.desconectar();
    return retorno;
  }
  
}
