package model;
import java.io.Serializable;

public class ClientesModel implements Serializable{
  private int idCliente;
  private String nome;
  private String cpf_cnpj;
  private String endereco;
  private String status;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf_cnpj() {
    return cpf_cnpj;
  }

  public void setCpf_cnpj(String cpf_cnpj) {
    this.cpf_cnpj = cpf_cnpj;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }
  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
  

}