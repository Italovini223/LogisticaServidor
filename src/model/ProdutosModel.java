package model;
import java.io.Serializable;

public class ProdutosModel implements Serializable{
  private int idProduto;
  private String nome;
  private double preco;
  private int estoque;
  private int codigo;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;

  public int getIdProduto() {
    return idProduto;
  }
  public void setIdProduto(int idProduto) {
    this.idProduto = idProduto;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public double getPreco() {
    return preco;
  }
  public void setPreco(double preco) {
    this.preco = preco;
  }
  public int getEstoque() {
    return estoque;
  }
  public void setEstoque(int estoque){
    this.estoque = estoque;
  }
  public int getCodigo() {
    return codigo;
  }
  public void setCodigo(int codigo) {
    this.codigo = codigo;
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