import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try{
            UsuarioDao dao = new UsuarioDao();
//            if(dao.adicionarUsuario(new Usuario("maria@gmail.com", "Maria"))){
//                System.out.println("Salvo");
//            }else{
//                System.out.println("Falha ao adicionar");
//            }
//            System.out.println(dao.listarUsuarios());
            System.out.println(dao.buscarPorEmail("pedro@gmail.com"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}