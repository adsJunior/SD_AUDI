/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producao;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
/**
 *
 * @author André
 */
public class Estoque {
    
    private boolean cheio = false, producao=true;
    private int tempo_producao, velocidade,
            Capacidade, Quantidade;
    JProgressBar Barra;
    JLabel Status;
    
    public Estoque(int Capacidade, int tempo_producao, JProgressBar Barra, JLabel Status){
        this.Capacidade = Capacidade;
        this.tempo_producao = tempo_producao;
        this.Barra = Barra;
        this.setQuantidade(0);
        this.Status = Status;
        this.velocidade = telas.Simulador.getvelocidade();
    }
    public void setvelocidade(){
        this.velocidade = telas.Simulador.getvelocidade();
    }
    public void setvelocidade(int velocidade){
        this.velocidade = velocidade;
    }
    public int getCapacidade(){
        return Capacidade;
    }
    public int getQuantidade(){
        return Quantidade;
    }
    public boolean isCheio(){
        return cheio;
    }
    
    public void setQuantidade(int Quantidade){
        this.Quantidade = Quantidade;
        Barra.setValue(Quantidade);
        if (this.Quantidade == Capacidade) Status.setText("Parado!");
    }
    
    public synchronized void get(int quant){
        while(quant > Quantidade){
            try{
                wait();
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(null, 
                        "Exception " + e + " caught");
            }
        }
        notifyAll();
        this.setQuantidade(Quantidade - quant);
        Status.setText("Produzindo.");
    }
    public void restart(){
        try{
            sleep(tempo_producao * 1000/velocidade);
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null, 
                        "Exception " + e + " caught");
        }
    }
    public synchronized void put(){
        boolean cheio = false;
        while(Status.getText().compareTo("Parado!")==0){
            try{
                wait();
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(null, 
                        "Exception " + e + " caught");
            }
            cheio = true;
        }if(cheio) this.restart();
        this.setQuantidade(Quantidade + 1);
        notifyAll();
    }
}
