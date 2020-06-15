package io.github.diegolirio.usuarioimc.usuario.services;

import io.github.diegolirio.usuarioimc.usuario.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UsuarioRepository extends CrudRepository<Usuario, Long> {


}
