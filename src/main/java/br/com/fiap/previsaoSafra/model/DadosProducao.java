package br.com.fiap.previsaoSafra.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class DadosProducao {
    @Id
    @SequenceGenerator(name = "dados_producao_seq", sequenceName = "dados_producao_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dados_producao_seq")
    private Long id;

    @ManyToOne
    private Colheita colheita;

    private LocalDate dataColheita;
    private Integer qtdProduzida;
    private List<String> listaFertilizantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colheita getColheita() {
        return colheita;
    }

    public void setColheita(Colheita colheita) {
        this.colheita = colheita;
    }

    public LocalDate getDataColheita() {
        return dataColheita;
    }

    public void setDataColheita(LocalDate dataColheita) {
        this.dataColheita = dataColheita;
    }

    public Integer getQtdProduzida() {
        return qtdProduzida;
    }

    public void setQtdProduzida(Integer qtdProduzida) {
        this.qtdProduzida = qtdProduzida;
    }

    public List<String> getListaFertilizantes() {
        return listaFertilizantes;
    }

    public void setListaFertilizantes(List<String> listaFertilizantes) {
        this.listaFertilizantes = listaFertilizantes;
    }
}
