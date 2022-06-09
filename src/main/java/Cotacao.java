
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */
class Cotacao { 
    
    private String codEmpresa = "";
    private double valor;
    private LocalDate data = LocalDate.now(); 
    private String moeda = "";
    

    public Cotacao(String codEmpresa, String moeda, double valor) {   
        this.codEmpresa = codEmpresa;
        this.moeda = moeda;
        this.valor = valor;
    }
    
    
    public Cotacao(String codEmpresa, LocalDate data, double valor) {   
        this.codEmpresa = codEmpresa;
        this.data = data;
        this.valor = valor;
    }

    Cotacao() {
    }

     @Override
    public String toString() {
        return "Cotacao{" + "codEmpresa=" + codEmpresa + ", valor=" + valor + ", data=" + data + ", moeda=" + moeda + '}';
    }
    
    
    
    /**
     * @return the codEmpresa
     */
    public String getCodEmpresa() {
        return codEmpresa;
    }

    /**
     * @param codEmpresa the codEmpresa to set
     */
    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * @return the moeda
     */
    public String getMoeda() {
        return moeda;
    }

    /**
     * @param moeda the moeda to set
     */
    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
}
