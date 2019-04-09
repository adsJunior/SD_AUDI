/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producao;
import java.util.Date;
import javax.swing.JProgressBar;
import telas.*;
/**
 *
 * @author André
 */
public class LPMontagem extends Thread {
    
    private Estoque Estoque_Motores, Estoque_Carrocerias, Estoque_Pneus, Estoque_Bancos,
            Estoque_Eletronica;
    private JProgressBar barra_producao;
    private int velocidade;
    private int Entregues = 0;
    Auxiliar aux;
    
    public int getEntregues(){
        return Entregues;
    }
    public int getProntos(){
        return barra_producao.getValue();
    }
    public int getTotal(){
        return Entregues + barra_producao.getValue();
    }
    
    public LPMontagem(Estoque EM, Estoque EC, Estoque EP, Estoque EB, Estoque EE, JProgressBar barra,
            int v, Auxiliar aux){
        
        Estoque_Motores = EM;
        Estoque_Carrocerias = EC;
        Estoque_Pneus = EP;
        Estoque_Bancos = EB;
        Estoque_Eletronica = EE;
        barra_producao = barra;
        velocidade = v;
        this.aux = aux;
    }
    @Override
    public void run(){
        while(telas.Simulador.Controle){
            Estoque_Motores.get(1);
            Estoque_Carrocerias.get(1);
            Estoque_Pneus.get(4);
            Estoque_Bancos.get(5);
            Estoque_Eletronica.get(1);
            if(this.barra_producao.getValue()==9){
                Entregues += 10;
                aux.setEntregues(Entregues);
                this.barra_producao.setValue(0);
            }else this.barra_producao.setValue(barra_producao.getValue() + 1);
            aux.setProduzidos(this.getTotal());
            Simulador.init.ultimo = new Date(Simulador.init.proximo.getTime());
            Simulador.init.proximo = new Date(System.currentTimeMillis());
            long tmedio = (this.getTotal() - 1)*aux.getTempoMedio() +
                    velocidade*(Simulador.init.proximo.getTime() - Simulador.init.ultimo.getTime());
            tmedio = tmedio/this.getTotal();
            aux.setTempoMedio(tmedio);
            aux.setProducaoHora(3600000/(int)tmedio);
            Simulador.init.updateResultados();
        }
    }
}
