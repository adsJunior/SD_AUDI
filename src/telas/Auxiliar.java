/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author DTI
 */
public class Auxiliar {

    private int Veiculos_Entregues, Veiculos_Produzidos, Producao_Hora;
    private long Tempo_Medio;
    
    public void setEntregues(int Veiculos_Entregues){
        this.Veiculos_Entregues = Veiculos_Entregues;
    }
    public void setProduzidos(int Veiculos_Produzidos){
        this.Veiculos_Produzidos = Veiculos_Produzidos;
    }
    public void setTempoMedio(long Tempo_Medio){
        this.Tempo_Medio = Tempo_Medio;
    }
    public void setProducaoHora(int Producao_Hora){
        this.Producao_Hora = Producao_Hora;
    }
    public Auxiliar(int Veiculos_Entregues, int Veiculos_Produzidos,
            long Tempo_Medio, int Producao_Hora){
        this.setEntregues(Veiculos_Entregues);
        this.setProduzidos(Veiculos_Produzidos);
        this.setProducaoHora(Producao_Hora);
        this.setTempoMedio(Tempo_Medio);
    }
    
    public int getEntregues(){
        return Veiculos_Entregues;
    }
    public int getProduzidos(){
        return Veiculos_Produzidos;
    }
    public long getTempoMedio(){
        return Tempo_Medio;
    }
    public int getProducaoHora(){
        return Producao_Hora;
    }
    public String columnName(int index){
        switch(index){
        case 0:
            return "Veículos Entregues";
        case 1:
            return "Veículos Produzidos";
        case 2:
            return "Tempo médio";
        case 3:
            return "Produção/Hora";
        }
        return null;
    }
    public Object getRow(int index){
        switch(index){
        case 0:
            return Veiculos_Entregues;
        case 1:
            return Veiculos_Produzidos;
        case 2:
            return Tempo_Medio;
        case 3:
            return Producao_Hora;
        }
        return null;
    }
}
