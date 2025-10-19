package model;
import java.io.Serializable;

public class PedidosModel implements Serializable {
  private int idPedido;
  private int idCliente;
  private int idEntrega;
  private String status;
  private double valorTotal;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;

  public int getIdPedido() {
    return idPedido;
  }
  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }

  public int getIdCliente() {
    return idCliente;
  }
  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public int getIdEntrega() {
    return idEntrega;
  }
  public void setIdEntrega(int idEntrega) {
    this.idEntrega = idEntrega;
  }

  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  public double getValorTotal() {
    return valorTotal;
  }
  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
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
