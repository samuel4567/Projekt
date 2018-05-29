package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import Calendar.Controller;
import data.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	public int login(String username,String passwd) throws IOException {
		File file=new File("csv.csv");
		file.createNewFile();
		String csvFilename = "csv.csv";
	CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilename));
	//	CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
/*
		String[] row = null;
		while((row = csvReader.readNext()) != null) {
			System.out.println(row[0]
			          + " # " + row[1]
			          + " #  " + row[2]);
		}
		*/
		String [] a =new String[4];
		a[0]="haha";
		a[1]="lol";
		a[2]="gg";
		a[3]="bb";
		System.out.println(a);
		csvWriter.writeNext(a);
		csvWriter.close();

		
		return 0;
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			login("a","b");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
