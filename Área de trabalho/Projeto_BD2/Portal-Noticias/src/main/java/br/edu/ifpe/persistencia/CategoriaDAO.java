package br.edu.ifpe.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.edu.ifpe.entidades.Categoria;
import java.util.List;

public class CategoriaDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();

    public void salvar(Categoria categoria) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
        em.close();
    }

    public Categoria buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Categoria categoria = em.find(Categoria.class, id);
        em.close();
        return categoria;
    }

    public List<Categoria> listar() {
        EntityManager em = emf.createEntityManager();
        List<Categoria> categorias = em.createQuery("FROM Categoria", Categoria.class).getResultList();
        em.close();
        return categorias;
    }

    public void atualizar(Categoria categoria) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Categoria categoria = em.find(Categoria.class, id);
        if (categoria != null) {
            em.remove(categoria);
        }
        em.getTransaction().commit();
        em.close();
    }
}
