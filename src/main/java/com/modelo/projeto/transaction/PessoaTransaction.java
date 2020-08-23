package com.modelo.projeto.transaction;

import com.modelo.projeto.entity.Endereco;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.modelo.projeto.entity.Pessoa;
import java.util.Date;
import javax.persistence.Query;

/**
 *
 * @author vcoelho
 */
public class PessoaTransaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public Pessoa insert(Pessoa pessoa) {
		pessoa.setDataModificacao(new Date());
		entityManager.persist(pessoa);
		entityManager.flush();
		entityManager.clear();
		return entityManager.find(pessoa.getClass(), pessoa.getId());
	}

	public Pessoa update(Pessoa pessoa) {
		pessoa.setDataModificacao(new Date());
		return entityManager.merge(pessoa);
	}

	public void remover(Pessoa pessoa) {
		entityManager.remove(entityManager.getReference(Pessoa.class, pessoa.getId()));
	}

	public Pessoa buscar(Long id) {
		return entityManager.find(Pessoa.class, id);
	}

	public Pessoa buscarCpf(Long id, String cpf) {
		Query q = entityManager.createNamedQuery("Pessoa.findCpf");
		q.setParameter("id", id == null ? 0 : id);
		q.setParameter("cpf", cpf);
		List<Pessoa> list = q.getResultList();
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<Pessoa> todos() {
		return entityManager.createQuery("from Pessoa", Pessoa.class).getResultList();
	}

	public List<Pessoa> pesquisar(String termo) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteriaQuery = criteriaBuilder.createQuery(Pessoa.class);
		Root<Pessoa> root = criteriaQuery.from(Pessoa.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("nome"), termo + "%"));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}
