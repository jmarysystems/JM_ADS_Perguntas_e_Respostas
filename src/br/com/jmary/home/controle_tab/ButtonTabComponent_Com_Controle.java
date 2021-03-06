/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jmary.home.controle_tab;

import br.com.jmary.home.Home;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author AnaMariana
 */
public class ButtonTabComponent_Com_Controle extends JPanel {
    private final JTabbedPane tabFrame2;
    
    Home Home;
    
    public ButtonTabComponent_Com_Controle(final JTabbedPane tab, String nomeTab, ImageIcon icon, Home Home ) {
        //unset default FlowLayout' gaps
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        if (tab == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.tabFrame2 = tab;
        setOpaque(false);
                    
        JLabel lbIcone = new JLabel();
        lbIcone.setIcon( icon );
        add( lbIcone );
                    
        //make JLabel read titles from JTabbedPane
        JLabel lbTituloTab = new JLabel() {
            @Override
            public String getText() {
                int i = tab.indexOfTabComponent(ButtonTabComponent_Com_Controle.this);
                if (i != -1) {
                    return tab.getTitleAt(i);
                }
                return null;
            }
        };
        
        add(lbTituloTab);
        //add more space between the label and the button
        lbTituloTab.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        //tab button
        JButton button = new ButtonTabComponent_Com_Controle.TabButton( nomeTab );
        add(button);
        //add more space to the top of the component
        setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));     
        
        this.setBorder(null);
        
        this.Home = Home;
    }
    
    private class TabButton extends JButton implements ActionListener {
        public TabButton( String titulo ) {
            int size = 17;
            setPreferredSize(new Dimension(size, size));
            setToolTipText("Fechar " + titulo);
            //Make the button looks the same for all Laf's
            setUI(new BasicButtonUI());
            //Make it transparent
            setContentAreaFilled(false);
            //No need to be focusable
            setFocusable(false);
            setBorder(BorderFactory.createEtchedBorder());
            setBorderPainted(false);
            //Making nice rollover effect
            //we use the same listener for all buttons
            addMouseListener(buttonMouseListener);
            setRolloverEnabled(true);
            //Close the proper tab by clicking the button
            addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = tabFrame2.indexOfTabComponent(ButtonTabComponent_Com_Controle.this);
            String fechouQual = tabFrame2.getTitleAt(i); 
            if (i != -1) {
                tabFrame2.remove(i);
                
                switch ( fechouQual ) {
                    case "Home":
                        break;
                    case "Acordo Ortogr??fico": 
                        tabFrame2.setSelectedIndex( 0 ); 
                        break;  
                }
                //System.out.println( i + " - " + fechouQual);
            }
            //Home.ControleTabs.qtdComponentes-=1;
        }
        
        //we don't want to update UI for this button
        @Override
        public void updateUI() {
        }

        //paint the cross
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            //shift the image for pressed buttons
            if (getModel().isPressed()) {
                g2.translate(1, 1);
            }
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            if (getModel().isRollover()) {
                g2.setColor(Color.MAGENTA);
            }
            int delta = 6;
            g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
            g2.dispose();
        }
    }
    
    private final static MouseListener buttonMouseListener = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            //Home.tocarSon.tocar( 51 );
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };
    
}
