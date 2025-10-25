package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection conector;
    public void conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://0.tcp.sa.ngrok.io:12189/sistemasdistribuidoslogistica";
            String usuario = "admin";
            String senha = "admin";
            conector = DriverManager.getConnection(url, usuario, senha);
        }catch(ClassNotFoundException e){
            System.out.println("Erro no Driver: "+ e.getMessage());
        }catch(SQLException e){
            System.out.println("Erro na conexão com banco!"+ e.getMessage());
        }
    }
    public void desconectar(){
        try{
            conector.close();
        }catch(SQLException e){
            System.out.println("Erro na conexão com banco!"+ e.getMessage());
        }
    }
}
