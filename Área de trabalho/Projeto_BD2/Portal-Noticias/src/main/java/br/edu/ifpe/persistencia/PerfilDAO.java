package br.edu.ifpe.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.edu.ifpe.entidades.Perfil;
import java.util.List;

public class PerfilDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();

    public void salvar(Perfil perfil) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(perfil);
        em.getTransaction().commit();
        em.close();
    }

    public Perfil buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Perfil perfil = em.find(Perfil.class, id);
        em.close();
        return perfil;
    }

    public List<Perfil> listar() {
        EntityManager em = emf.createEntityManager();
        List<Perfil> perfis = em.createQuery("FROM Perfil", Perfil.class).getResultList();
        em.close();
        return perfis;
    }

    public void atualizar(Perfil perfil) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(perfil);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Perfil perfil = em.find(Perfil.class, id);
        if (perfil != null) {
            em.remove(perfil);
        }
        em.getTransaction().commit();
        em.close();
    }
}
