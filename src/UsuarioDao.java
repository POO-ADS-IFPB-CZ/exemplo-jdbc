import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Usuario> listarUsuarios() throws SQLException, IOException,
            ClassNotFoundException {
        try(Connection connection = new ConFactory().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM usuario ORDER BY email");
            ResultSet rs = stmt.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()){
                String email = rs.getString("email");
                String nome = rs.getString("nome");
                usuarios.add(new Usuario(email, nome));
            }
            return usuarios;
        }
    }

    public Usuario buscarPorEmail(String email) throws SQLException, IOException,
            ClassNotFoundException {
        try(Connection connection = new ConFactory().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM usuario WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String email1 = rs.getString("email");
                String nome = rs.getString("nome");
                return new Usuario(email1, nome);
            }
            return null;
        }
    }
}
