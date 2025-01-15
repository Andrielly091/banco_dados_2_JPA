package br.edu.ifpe.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.edu.ifpe.entidades.Noticia;
import java.util.List;

public class NoticiaDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();

    public void salvar(Noticia noticia) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(noticia);
        em.getTransaction().commit();
        em.close();
    }

    public Noticia buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Noticia noticia = em.find(Noticia.class, id);
        em.close();
        return noticia;
    }

    public List<Noticia> listar() {
        EntityManager em = emf.createEntityManager();
        List<Noticia> noticias = em.createQuery("FROM Noticia", Noticia.class).getResultList();
        em.close();
        return noticias;
    }

    public void atualizar(Noticia noticia) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(noticia);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Noticia noticia = em.find(Noticia.class, id);
        if (noticia != null) {
            em.remove(noticia);
        }
        em.getTransaction().commit();
        em.close();
    }
}
