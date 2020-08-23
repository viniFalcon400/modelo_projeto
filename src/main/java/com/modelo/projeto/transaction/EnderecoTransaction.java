package com.modelo.projeto.transaction;

import com.modelo.projeto.entity.Endereco;
import com.modelo.projeto.entity.Pessoa;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.Date;
import javax.persistence.Query;

/**
 *
 * @author vcoelho
 */
public class EnderecoTransaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public Endereco insert(Endereco endereco) {
		endereco.setDataModificacao(new Date());
		entityManager.persist(endereco);
		entityManager.flush();
		entityManager.clear();
		return entityManager.find(endereco.getClass(), endereco.getId());
	}

	public Endereco update(Endereco endereco) {
		endereco.setDataModificacao(new Date());
		return entityManager.merge(endereco);
	}

	public void remover(Endereco endereco) {
		entityManager.remove(entityManager.getReference(Endereco.class, endereco.getId()));
	}

	public Endereco buscar(Long id) {
		return entityManager.find(Endereco.class, id);
	}

	public List<Endereco> todos() {
		return entityManager.createQuery("from Endereco", Endereco.class).getResultList();
	}

	public Pessoa buscarCep(Long id, String cep) {
		Query q = entityManager.createNamedQuery("Endereco.findCep");
		q.setParameter("id", id == null ? 0 : id);
		q.setParameter("cep", cep);
		List<Pessoa> list = q.getResultList();
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<Endereco> pesquisar(String cidade) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Endereco> criteriaQuery = criteriaBuilder.createQuery(Endereco.class);
		Root<Endereco> root = criteriaQuery.from(Endereco.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("cidade"), cidade + "%"));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}
