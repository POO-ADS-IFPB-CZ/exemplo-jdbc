import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {

    public boolean adicionarUsuario(Usuario usuario) throws SQLException, IOException,
            ClassNotFoundException {
        try(Connection connection = new ConFactory().getConnection()){
            PreparedStatement stmt = connection
                .prepareStatement("INSERT INTO usuario (email, nome) VALUES (?,?)");
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getNome());
            return stmt.executeUpdate() > 0;
        }
    }

}
