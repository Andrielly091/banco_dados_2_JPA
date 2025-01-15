package br.edu.ifpe.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String descricao;

    @OneToOne(fetch = FetchType.EAGER)  // Eager Loading
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;  // Chave estrangeira

    @OneToMany(mappedBy = "perfil", fetch = FetchType.LAZY)  // Lazy Loading
    private List<Noticia> noticias;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Noticia> getNoticias() { return noticias; }
    public void setNoticias(List<Noticia> noticias) { this.noticias = noticias; }
}
