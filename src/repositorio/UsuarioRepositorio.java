package repositorio;

import java.util.ArrayList;

import entidades.Usuario;

public class UsuarioRepositorio {

	private ArrayList<Usuario> usuarios;
	
	public UsuarioRepositorio() {
		usuarios = new ArrayList<>();
	}
	
    public void inserir(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    public void remover(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public Usuario procurarPorCpf(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }
    
    public void atualizar(Usuario usuario) {
    	Usuario usuarioAntigo = this.procurarPorCpf(usuario.getCpf());
        if (usuarioAntigo != null) {
            usuarios.remove(usuarioAntigo); // remove o antigo
            usuarios.add(usuario); // adiciona novo
        }
    }

}
