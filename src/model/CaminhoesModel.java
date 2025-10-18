package model;
import java.io.Serializable;

public class CaminhoesModel implements Serializable {
  private int idCaminhao;
  private String placa;
  private String modelo;
  private int ano;
  private String status;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;

  public int getIdCaminhao() {
    return idCaminhao;
  }
  public void setIdCaminhao(int idCaminhao) {
    this.idCaminhao = idCaminhao;
  }

  public String getPlaca() {
    return placa;
  }
  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getModelo() {
    return modelo;
  }
  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getAno() {
    return ano;
  }
  public void setAno(int ano) {
    this.ano = ano;
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
