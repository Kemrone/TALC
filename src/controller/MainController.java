package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import model.Fichier;
import model.FichierHtml;
import model.TEAMSProcessor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    private Label depotId;
    @FXML
    private Label fichierId;
    @FXML
    private Label dateId;
    @FXML
    private Label heureMinId;
    @FXML
    private Label heureMaxId;
    @FXML
    private VBox dragTarget;
    
    private static List<File> files;
    
    
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
    
    
    @FXML
    public void handleDragFile(DragEvent event) {
    	if(event.getDragboard().hasFiles()) {
    		event.acceptTransferModes(TransferMode.ANY);
    	}
    }    

    
    @FXML
    public void handleFile(DragEvent event) throws FileNotFoundException {
    	Dragboard db = event.getDragboard();
    	
    	files = event.getDragboard().getFiles();
    	
    	if (db.hasFiles()) {
    	//fichierId.setText(db.getFiles().toString());		   		 
    	File selectedFile = files.get(0);
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	fichierId.setText(selectedFile.getName());
    	dateId.setText(sdf.format(selectedFile.lastModified()));
    	}
    	
    }
    	public void valider(ActionEvent event) {
    		File selectedFile = files.get(0);
    		
    		var t = new TEAMSProcessor(selectedFile,"19/01/2021 Ã? 10:15:00", "19/01/2021 Ã? 11:45:00");
    		Fichier fich = new Fichier();
    		fich.setT(new FichierHtml());
    		System.out.println(fich.generateFile(t));
    	}
    	
    	
}


	


	
    
    
    
    
    

