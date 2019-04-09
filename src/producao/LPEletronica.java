/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producao;

import javax.swing.JOptionPane;

/**
 *
 * @author André
 */
public class LPEletronica extends Thread {
    
    private Estoque estoque;
    private int velocidade, tempo_producao = 7;
    public LPEletronica(Estoque estoque, int velocidade){
        super();
        this.estoque = estoque;
        this.velocidade = velocidade;
    }
    
    @Override
    public void run(){
        while(telas.Simulador.Controle){
            try{
                sleep(tempo_producao * 1000/velocidade);
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(null, 
                            "Exception " + e + " caught");
            }
            estoque.put();
        }
    }
}
