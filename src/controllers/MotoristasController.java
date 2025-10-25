package controllers;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import model.MotoristasModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.InterfaceMotoristas;

import java.sql.ResultSet;
import util.Conexao;

public class MotoristasController extends UnicastRemoteObject implements InterfaceMotoristas{
  public MotoristasController()throws RemoteException{}

  @Override
  public boolean inserir(MotoristasModel motorista) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "INSERT INTO motoristas(nome, endereco, numero_carteira, status, created_at, updated_at) VALUES (?,?,?,?,?,?)";
    try {
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setString(1, motorista.getNome());
      sentenca.setString(2, motorista.getEndereco());
      sentenca.setInt(3, motorista.getNumeroCarteira());
      sentenca.setString(4, motorista.getStatus());
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
  public boolean editar(MotoristasModel motorista) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "UPDATE motorista SET nome = ?, endereco = ?, numero_carteira = ?, status = ?, updated_at = ? WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setString(1, motorista.getNome());
      sentenca.setString(2, motorista.getEndereco());
      sentenca.setInt(3, motorista.getNumeroCarteira());
      sentenca.setString(4, motorista.getStatus());
      sentenca.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
      sentenca.setInt(6, motorista.getIdMotorista());

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
  public boolean excluir(MotoristasModel motorista) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "DELETE FROM motoristas WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, motorista.getIdMotorista());

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
  public MotoristasModel pesquisar(MotoristasModel motorista) throws RemoteException {
    MotoristasModel retorno = null;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM motoristas WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, motorista.getIdMotorista());
      ResultSet rs = sentenca.executeQuery();

      if(rs.next()){
        retorno = new MotoristasModel();
        retorno.setIdMotorista(rs.getInt("id"));
        retorno.setNome(rs.getString("nome"));
        retorno.setEndereco(rs.getString("endereco"));
        retorno.setNumeroCarteira(rs.getInt("numero_carteira"));
        retorno.setStatus(rs.getString("status"));
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
  public ArrayList<MotoristasModel> listar() throws RemoteException {
    ArrayList<MotoristasModel> retorno = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM motoristas";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      ResultSet rs = sentenca.executeQuery();
      while(rs.next()){
        MotoristasModel motorista = new MotoristasModel();
        motorista.setIdMotorista(rs.getInt("id"));
        motorista.setNome(rs.getString("nome"));
        motorista.setEndereco(rs.getString("endereco"));
        motorista.setNumeroCarteira(rs.getInt("numero_carteira"));
        motorista.setStatus(rs.getString("status"));
        motorista.setCreatedAt(rs.getTimestamp("created_at"));
        motorista.setUpdatedAt(rs.getTimestamp("updated_at"));
        retorno.add(motorista);
      }
    }catch(SQLException e){
      System.out.println("Erro ao listar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }
}
