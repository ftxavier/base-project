package org.gradle.example.simple.dao;

import org.gradle.example.simple.model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao extends AbstractDao<Usuario, Long> {

	public Usuario findByLogin(String login) {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", login));
		return (Usuario) criteria.uniqueResult();
	}
}
