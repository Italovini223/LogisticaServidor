package controllers;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import model.CaminhoesModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import util.Conexao;
import interfaces.InterfaceCaminhoes;

public class CaminhoesController extends UnicastRemoteObject implements InterfaceCaminhoes {
  public CaminhoesController() throws RemoteException {}

  @Override
  public boolean inserir(CaminhoesModel caminhao) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "INSERT INTO caminhoes(placa, modelo, ano, status, created_at, updated_at) VALUES (?,?,?,?,?,?)";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setString(1, caminhao.getPlaca());
      sentenca.setString(2, caminhao.getModelo());
      sentenca.setInt(3, caminhao.getAno());
      sentenca.setString(4, caminhao.getStatus());
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
  public boolean editar(CaminhoesModel caminhao) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "UPDATE caminhoes SET placa = ?, modelo = ?, ano = ?, status = ? , updated_at = ? WHERE id_caminhao = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setString(1, caminhao.getPlaca());
      sentenca.setString(2, caminhao.getModelo());
      sentenca.setInt(3, caminhao.getAno());
      sentenca.setString(4, caminhao.getStatus());
      sentenca.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
      sentenca.setInt(6, caminhao.getIdCaminhao());

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
  public boolean excluir(CaminhoesModel caminhao) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "DELETE FROM caminhoes WHERE id_caminhao = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, caminhao.getIdCaminhao());

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
  public CaminhoesModel pesquisar(CaminhoesModel caminhao) throws RemoteException {
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM caminhoes WHERE id_caminhao = ?";
    CaminhoesModel retorno = null;
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, caminhao.getIdCaminhao());
      ResultSet rs = sentenca.executeQuery();

      if(rs.next()){
        retorno = new CaminhoesModel();
        retorno.setIdCaminhao(rs.getInt("id_caminhao"));
        retorno.setPlaca(rs.getString("placa"));
        retorno.setModelo(rs.getString("modelo"));
        retorno.setAno(rs.getInt("ano"));
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
  public ArrayList<CaminhoesModel> listar() throws RemoteException {
    ArrayList<CaminhoesModel> retorno = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM caminhoes";

    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      ResultSet result = sentenca.executeQuery();
      while(result.next()){
        CaminhoesModel ca = new CaminhoesModel();
        ca.setIdCaminhao(result.getInt("id_caminhao"));
        ca.setPlaca(result.getString("placa"));
        ca.setModelo(result.getString("modelo"));
        ca.setAno(result.getInt("ano"));
        ca.setStatus(result.getString("status"));
        ca.setCreatedAt(result.getTimestamp("created_at"));
        ca.setUpdatedAt(result.getTimestamp("updated_at"));
        retorno.add(ca);
      }
    } catch(SQLException e){
      System.out.println("Erro ao listar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }
  
}
