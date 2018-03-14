package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */


import java.math.*;
import java.net.*;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	LinkedList <paroleAliene> dizionario;
	String testo;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    	testo = new String();
    	dizionario= new LinkedList<paroleAliene>();
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	testo = txtWord.getText().toLowerCase();
    	String array[] =testo.split(" ");
    	if(testo.contains("0")||testo.contains("1")||testo.contains("2")||testo.contains("3")||testo.contains("4")||testo.contains("5")||testo.contains("6")||testo.contains("7")||testo.contains("8")||testo.contains("9"))
    	{
    		txtResult.setText("Stringa alfanumerica non valida!!");
    	}
    	else {
		    	if(testo.contains(" ")) {
		    		paroleAliene parola = new paroleAliene(array[0],array[1]);
		    		for(paroleAliene p : dizionario) {
		    			if(p.getParola().compareTo(parola.getParola())==0) 
		    				if(p.getTraduzione().compareTo(array[1])!=0)
		    					p.setTraduzione(p.getTraduzione()+"-"+array[1]);
		    			}
		    		
		    		dizionario.add(parola);
		    		txtWord.clear();
		    		txtResult.setText("La traduzione di : "+parola.getParola()+" � "+parola.getTraduzione()+"\n");
		    	}
		    	else
		    	{
		    		
		    		for(paroleAliene p : dizionario) {
		    			if(p.getParola().compareTo(testo)==0) {
		    				System.out.println("ciao");
		    				
		    				txtResult.setText("La traduzione di : "+p.getParola()+" � "+p.getTraduzione()+"\n");
		    				return;
		    			}
		    		}
		    		txtResult.setText("La traduzione di : "+testo+" non � presente ");
		    	}
    	}
    	    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }
    
}
