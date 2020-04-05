package conexao;

import java.sql.*;

public class SingleConnection {
    // Criando a conexão com o banco de dados
    private static String banco = "jdbc:postgresql://localhost:5432/cadastroUsuarios?autoReconnect=true";
    private static String password = "postgres";
    private static String user = "admin";
    private static Connection connection = null;
    
    static{
    conectar();
}

public SingleConnection(){
conectar();
}

public static void conectar(){
    try {
        if(connection == null){
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(banco,password,user);
            connection.setAutoCommit(true);
            System.out.println("conectado");
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error ao connectar com banco de dados");
    }
    

}
    public static Connection getConnection(){
        return connection;
    }
}

