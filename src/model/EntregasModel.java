package model;
import java.io.Serializable;

public class EntregasModel implements Serializable {
  private int idEntrega;
  private int idMotorista;
  private int idCaminhao;
  private String status;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;

  public int getIdEntrega() {
    return idEntrega;
  }
  public void setIdEntrega(int idEntrega) {
    this.idEntrega = idEntrega;
  }

  public int getIdMotorista() {
    return idMotorista;
  }
  public void setIdMotorista(int idMotorista) {
    this.idMotorista = idMotorista;
  }

  public int getIdCaminhao() {
    return idCaminhao;
  }
  public void setIdCaminhao(int idCaminhao) {
    this.idCaminhao = idCaminhao;
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
