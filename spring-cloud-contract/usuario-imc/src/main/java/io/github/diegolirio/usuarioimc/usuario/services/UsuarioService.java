package io.github.diegolirio.usuarioimc.usuario.services;

import io.github.diegolirio.usuarioimc.usuario.domain.ClassificationType;
import io.github.diegolirio.usuarioimc.usuario.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        usuario.setImc(usuario.getPeso() / (usuario.getAltura() * usuario.getAltura()));
        usuario.setClassification(getClassification(usuario.getImc()));
        return this.usuarioRepository.save(usuario);
    }

    private ClassificationType getClassification(Float imc) {
        if(imc < 18.5) {
            return ClassificationType.MAGREZA;
        }
        if(imc >= 18.5 && imc < 25) {
            return ClassificationType.NORMAL;
        }
        if(imc >= 25 && imc < 30) {
            return ClassificationType.SOBREPESO;
        }
        if(imc >= 30 && imc < 40) {
            return ClassificationType.OBESIDADE;
        }
        return ClassificationType.OBESIDADE_GRAVE;
    }

}
