package br.com.sefaz.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsuarioDao {
	private static final String PERSISTENCE_UNIT = "sefaz";

	public Usuario autenticar(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM Usuario WHERE email = :paramEmail AND senha = :paramSenha");
		query.setParameter("paramEmail", usuario.getEmail());
		query.setParameter("paramSenha", usuario.getSenha());
		List<Usuario> registros = query.getResultList();
		Usuario obj = null;
		if (!registros.isEmpty()) {
			obj = (Usuario) registros.get(0);
		}
		manager.close();
		factory.close();
		return obj;
	}

	public boolean verificarExistencia(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM Usuario WHERE email = :paramEmail ");
		query.setParameter("paramEmail", usuario.getEmail());
		List<Usuario> registros = query.getResultList();
		Usuario obj = null;
		if (!registros.isEmpty()) {
			obj = (Usuario) registros.get(0);
		}
		manager.close();
		factory.close();
		return obj != null;
	}

	public void salvar(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	public List<Usuario> listar(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		Query query = null;
		String nome = usuario != null ? usuario.getNome() : "";
		String email = usuario != null ? usuario.getEmail() : "";
		if (!nome.equals("") && email.equals("")) {
			query = manager.createQuery("FROM Usuario WHERE nome LIKE :paramNome ORDER BY nome");
			query.setParameter("paramNome", "%" + nome + "%");
		} else if (nome.equals("") && !email.equals("")) {
			query = manager.createQuery("FROM Usuario WHERE email LIKE :paramEmail ORDER BY email");
			query.setParameter("paramEmail", "%" + email + "%");
		} else if (!nome.equals("") && !email.equals("")) {
			query = manager
					.createQuery("FROM Usuario WHERE codigo LIKE :paramNome AND email LIKE :paramEmail ORDER BY email");
			query.setParameter("paramNome", "%" + nome + "%");
			query.setParameter("paramEmail", "%" + email + "%");
		} else {
			query = manager.createQuery("FROM Usuario ORDER BY nome");
		}
		List<Usuario> lista = query.getResultList();
		manager.close();
		factory.close();
		return lista;
	}

	public Usuario buscarPorId(int id) {
		Usuario obj = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		obj = manager.find(Usuario.class, id);
		manager.close();
		factory.close();
		return obj;
	}

	public void alterar(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	public void remover(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		Usuario usuario = manager.find(Usuario.class, id);
		manager.getTransaction().begin();
		manager.remove(usuario);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
