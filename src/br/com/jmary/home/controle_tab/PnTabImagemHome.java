/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jmary.home.controle_tab;

import br.com.jmary.home.imagens.Imagens_Internas;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author pc
 */
public class PnTabImagemHome extends javax.swing.JPanel {

    /**
     * Creates new form PnTabImagemHome
     */
    public PnTabImagemHome() {
        initComponents();
        inicio();
    }
    
    public PnTabImagemHome( String str ) {
        initComponents();
        inicioMod( str );
    }
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            
            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
            ImageIcon icon = new ImageIcon( clazzHome.getResource("jmlogo2.png") );
            
            Image image = null;
            try {  
                image = icon.getImage();//ImageIO.read(f);  
                int widith = image.getWidth(icon.getImageObserver() );
                int height = image.getHeight(icon.getImageObserver() );
                //279, 174
                jLabel1.setIcon(new ImageIcon(image.getScaledInstance(
                    widith, height, Image.SCALE_DEFAULT)));

            } catch (Exception ex) { System.out.println( "c2222 "); ex.printStackTrace();  }
            
                        
        } catch( Exception e ){ } } }.start();
                                    
    }
    
    private void inicioMod( String str ){
        
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            try {  
                
                Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
                ImageIcon icon = new ImageIcon( clazzHome.getResource( str ) );
            
                Image image = null;
            
                image = icon.getImage();//ImageIO.read(f);  
                
                jLabel1.setIcon(new ImageIcon(image.getScaledInstance(
                    this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));

            } catch (Exception ex) { inicio();  }
            
                        
        //} catch( Exception e ){ } } }.start();
                                    
    }
            

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jmary/home/imagens/jmlogo2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
