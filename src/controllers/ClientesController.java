package controllers;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import model.ClientesModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import util.Conexao;
import interfaces.InterfaceClientes;

public class ClientesController extends UnicastRemoteObject implements InterfaceClientes{
  public ClientesController()throws RemoteException{}
 
  @Override
  public boolean inserir(ClientesModel cliente) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "INSERT INTO clientes(nome, cpf_cnpj, endereco, status, created_at, updated_at) VALUES (?,?,?,?,?,?)";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setString(1, cliente.getNome());
      sentenca.setString(2, cliente.getCpf_cnpj());
      sentenca.setString(3, cliente.getEndereco());
      sentenca.setString(4, cliente.getStatus());
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
  public boolean editar(ClientesModel cliente) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "UPDATE clientes SET nome = ?, cpf_cnpj = ?, endereco = ?, status = ?, updated_at = ? WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setString(1, cliente.getNome());
      sentenca.setString(2, cliente.getCpf_cnpj());
      sentenca.setString(3, cliente.getEndereco());
      sentenca.setString(4, cliente.getStatus());
      sentenca.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
      sentenca.setInt(6, cliente.getIdCliente());

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
  public boolean excluir(ClientesModel cliente) throws RemoteException {
    boolean retorno = false;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "DELETE FROM clientes WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, cliente.getIdCliente());
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
  public ClientesModel pesquisar(ClientesModel cliente) throws RemoteException {
    ClientesModel retorno = null;
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM clientes WHERE id = ?";
    try{
      PreparedStatement sentenca = c.conector.prepareStatement(sql);
      sentenca.setInt(1, cliente.getIdCliente());
      ResultSet rs = sentenca.executeQuery();
      if(rs.next()){
        retorno = new ClientesModel();
        retorno.setIdCliente(rs.getInt("id"));
        retorno.setNome(rs.getString("nome"));
        retorno.setCpf_cnpj(rs.getString("cpf_cnpj"));
        retorno.setEndereco(rs.getString("endereco"));
        retorno.setStatus(rs.getString("status"));
        retorno.setCreatedAt(rs.getTimestamp("created_at"));
        retorno.setUpdatedAt(rs.getTimestamp("updated_at"));
        retorno.setUpdatedAt(rs.getTimestamp("updated_at"));
      }
    }catch(SQLException e){
      System.out.println("Erro ao pesquisar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }

  @Override
  public ArrayList<ClientesModel> listar() throws RemoteException {
    ArrayList<ClientesModel> retorno = new ArrayList<>();
    Conexao c = new Conexao();
    c.conectar();
    String sql = "SELECT * FROM clientes";

    try{
      PreparedStatement setenca = c.conector.prepareStatement(sql);
      ResultSet result = setenca.executeQuery();
      while (result.next()) {
        ClientesModel cliente = new ClientesModel();
        cliente.setIdCliente(result.getInt("id"));
        cliente.setNome(result.getString("nome"));
        cliente.setCpf_cnpj(result.getString("cpf_cnpj"));
        cliente.setEndereco(result.getString("endereco"));
        cliente.setStatus(result.getString("status"));
        cliente.setCreatedAt(result.getTimestamp("created_at"));
        cliente.setUpdatedAt(result.getTimestamp("updated_at"));

        retorno.add(cliente);
      }
    }catch(SQLException e){
      System.out.println("Erro ao listar: " + e.getMessage());
    }
    c.desconectar();
    return retorno;
  }
}