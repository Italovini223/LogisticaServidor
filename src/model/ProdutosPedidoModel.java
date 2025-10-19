package model;
import java.io.Serializable;

public class ProdutosPedidoModel implements Serializable {
  private int idProdutoPedido;
  private int idPedido;
  private int idProduto;
  private double valor;
  private java.sql.Timestamp createdAt;

  public int getIdProdutoPedido() {
    return idProdutoPedido;
  }
  public void setIdProdutoPedido(int idProdutoPedido) {
    this.idProdutoPedido = idProdutoPedido;
  }

  public int getIdPedido() {
    return idPedido;
  }
  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }

  public int getIdProduto() {
    return idProduto;
  }
  public void setIdProduto(int idProduto) {
    this.idProduto = idProduto;
  }

  public double getValor() {
    return valor;
  }
  public void setValor(double valor) {
    this.valor = valor;
  }

  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }
}
