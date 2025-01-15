package br.edu.ifpe.entidades;

import javax.persistence.*;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double valor;
    
    @ManyToOne(fetch = FetchType.EAGER)  // Eager Loading
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;  // Chave estrangeira

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
