package br.edu.ifpe.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String conteudo;
    
    @ManyToOne(fetch = FetchType.EAGER)  // Eager Loading
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;  // Chave estrangeira

    @ManyToMany(fetch = FetchType.LAZY)  // Lazy Loading
    @JoinTable(
        name = "Noticia_Categoria",
        joinColumns = @JoinColumn(name = "noticia_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;  // Lista de categorias

    @ManyToMany(fetch = FetchType.LAZY)  // Lazy Loading
    @JoinTable(
        name = "Noticia_Tag",
        joinColumns = @JoinColumn(name = "noticia_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;  // Lista de tags

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public Perfil getPerfil() { return perfil; }
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }

    public List<Categoria> getCategorias() { return categorias; }
    public void setCategorias(List<Categoria> categorias) { this.categorias = categorias; }

    public List<Tag> getTags() { return tags; }
    public void setTags(List<Tag> tags) { this.tags = tags; }
}
