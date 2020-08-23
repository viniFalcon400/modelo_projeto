package com.modelo.projeto.transaction;

import com.modelo.projeto.entity.Pessoa;
import com.modelo.projeto.entity.Usuario;
import com.modelo.projeto.entity.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author vcoelho
 */
public class UsuarioTransaction implements Serializable {

	@Inject
	private EntityManager entityManager;

	public Usuario buscaUsuario(String nome, String senha) {
		try {
			Query q = entityManager.createQuery("Select u From Usuario u Where u.nomeUsuario = :nome and u.senha = :senha");
			q.setParameter("nome", nome);
			q.setParameter("senha", senha);
			return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuario insert(Usuario usuario) {
		entityManager.persist(usuario);
		entityManager.flush();
		entityManager.clear();
		return entityManager.find(usuario.getClass(), usuario.getId());
	}

	public Usuario update(Usuario usuario) {
		return entityManager.merge(usuario);
	}

	public void remover(Usuario usuario) {
		entityManager.remove(entityManager.getReference(Usuario.class, usuario.getId()));
	}

	public Usuario buscar(Long id) {
		return entityManager.find(Usuario.class, id);
	}
	
	public List<Usuario> todos() {
		return entityManager.createQuery("from Usuario", Usuario.class).getResultList();
	}
}
