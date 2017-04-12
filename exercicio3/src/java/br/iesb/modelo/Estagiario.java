
package br.iesb.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_estagiario")
public class Estagiario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_estagiario", nullable = false)
    private int idEstagiario;
    
    @Column(name="tx_nome",  nullable = false)
    private String txNome;
    
    @Column(name="tx_curso", nullable = false)
    private String txCurso;
    
    @Column(name="nfValorBolsa", nullable = false)
    private double nfValorBolsa;
    
    @Column(name="nfValorTicketRefeicao", nullable = false)
    private double nfValorTicketRefeicao;
    
    @Column(name="niCargaHoraria", nullable = false)
    private int niCargaHoraria;
    
    @Column(name="niAnosExperiencia", nullable = false)
    private int niAnosExperiencia;
    
    @Column(name="niDuracaoEstagio", nullable = false)
    private int niDuracaoEstagio; // tempo em meses 

    public Estagiario() {
    }

    public Estagiario(int idEstagiario, String txNome, String txCurso, double nfValorBolsa, double nfValorTicketRefeicao, int niCargaHoraria, int niDuracaoEstagio) {
        this.idEstagiario = idEstagiario;
        this.txNome = txNome;
        this.txCurso = txCurso;
        this.nfValorBolsa = nfValorBolsa;
        this.nfValorTicketRefeicao = nfValorTicketRefeicao;
        this.niCargaHoraria = niCargaHoraria;
        this.niDuracaoEstagio = niDuracaoEstagio;
    }

    public int getNiDuracaoEstagio() {
        return niDuracaoEstagio;
    }

    public void setNiDuracaoEstagio(int niDuracaoEstagio) {
        this.niDuracaoEstagio = niDuracaoEstagio;
    }

    public int getIdEstagiario() {
        return idEstagiario;
    }

    public void setIdEstagiario(int idEstagiario) {
        this.idEstagiario = idEstagiario;
    }

    public String getTxNome() {
        return txNome;
    }

    public void setTxNome(String txNome) {
        this.txNome = txNome;
    }

    public String getTxCurso() {
        return txCurso;
    }

    public void setTxCurso(String txCurso) {
        this.txCurso = txCurso;
    }

    public double getNfValorBolsa() {
        return nfValorBolsa;
    }

    public void setNfValorBolsa(double nfValorBolsa) {
        this.nfValorBolsa = nfValorBolsa;
    }

    public double getNfValorTicketRefeicao() {
        return nfValorTicketRefeicao;
    }

    public void setNfValorTicketRefeicao(double nfValorTicketRefeicao) {
        this.nfValorTicketRefeicao = nfValorTicketRefeicao;
    }

    public int getNiCargaHoraria() {
        return niCargaHoraria;
    }

    public void setNiCargaHoraria(int niCargaHoraria) {
        this.niCargaHoraria = niCargaHoraria;
    }

    public int getNiAnosExperiencia() {
        return niAnosExperiencia;
    }

    public void setNiAnosExperiencia(int niAnosExperiencia) {
        this.niAnosExperiencia = niAnosExperiencia;
    }

   
    
}
