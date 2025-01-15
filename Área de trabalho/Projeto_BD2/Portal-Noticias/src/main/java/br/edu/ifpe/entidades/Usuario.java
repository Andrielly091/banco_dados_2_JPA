package br.edu.ifpe.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)  // Lazy Loading
    private List<Pagamento> pagamentos;
    
    @OneToOne(mappedBy = "usuario", fetch = FetchType.EAGER)  // Eager Loading
    private Perfil perfil;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Pagamento> getPagamentos() { return pagamentos; }
    public void setPagamentos(List<Pagamento> pagamentos) { this.pagamentos = pagamentos; }

    public Perfil getPerfil() { return perfil; }
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }
}
