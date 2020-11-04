/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jmary.home.controle_tab;

import java.net.URL;

/**
 *
 * @author AnaMariana
 */
public class BookInfo {
    
        public String bookName;
        public URL    bookURL;
        public String tipoNoBanco; 
        public int    idNoBanco; 
        public String bookImprimir; 
        
        public String treeRoot;
        public String treePastaNoExpande;
        public String treePastaExpande;
        public String treeNod;
        public String tree1Nod;

        public BookInfo(String nomeDeExibição, String filename, boolean booURL, String tipoNoBanco2, int idNoBanco2, String root, String pastaNoExpande, String pastaExpande, String nod, String nodTree1 ) {
            bookName = nomeDeExibição;
            if (booURL == true) {
                bookURL = getClass().getResource(filename);
            }else{ try{ bookURL = new URL(filename); }catch( Exception e ){} }
            bookImprimir = filename;
            
            tipoNoBanco = tipoNoBanco2;
            idNoBanco   = idNoBanco2;
            
            treeRoot = root;
            treePastaNoExpande = pastaNoExpande;
            treePastaExpande = pastaExpande;
            treeNod = nod;
            tree1Nod = nodTree1;
            
            if (bookURL == null) { bookURL = getClass().getResource( "/sistema_Html/erro404.html" );                
                System.err.println("Não foi possível encontrar o arquivo: "
                                   + filename);
            }
        }
        
        @Override
        public String toString() {
            return bookName;
        }

}
