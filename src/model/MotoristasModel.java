package model;
import java.io.Serializable;

public class MotoristasModel implements Serializable {
  private int idMotorista;
  private String nome;
  private String endereco;
  private int numeroCarteira;
  private String status;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;

  public int getIdMotorista() {
    return idMotorista;
  }
  public void setIdMotorista(int idMotorista) {
    this.idMotorista = idMotorista;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getEndereco() {
    return endereco;
  }
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
  public int getNumeroCarteira() {
    return numeroCarteira;
  }
  public void setNumeroCarteira(int numeroCarteira) {
    this.numeroCarteira = numeroCarteira;
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
