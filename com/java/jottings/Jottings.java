package com.java.jottings;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/** 
 * Jottings is notepad like product 
 * @author Kumaran
 *
 */
public class Jottings extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * declaring a variables
	 */
	int fileToOpen ;
	int fileToSave ;
	JFileChooser fileOpen ;
	JFileChooser fileSave ;

	/**
	 * constructor to initiate, starts the Jottings (notepad) program  
	 */
	Jottings(){

		/**
		 * Setting a menu bar
		 */
		MenuBar menuBar = new MenuBar() ;
		final JTextArea textArea = new JTextArea() ;
		setMenuBar(menuBar) ;

		/**
		 * Setting the menu items with menu bar items
		 */
		Menu file = new Menu("File") ; // Menubar Item option
		menuBar.add(file) ;

		// menu options in File menu bar item
		MenuItem newOption = new MenuItem("New") ;
		MenuItem openOption = new MenuItem( "Open" ) ;
		MenuItem saveOption = new MenuItem("Save") ;
		MenuItem exitOption = new MenuItem( "Exit" ) ;

		file.add( newOption ) ;
		file.add( openOption ) ;
		file.add( saveOption ) ;
		file.add( exitOption ) ;

		getContentPane().add( textArea ) ;

		/**
		 * Action Listener Event for when clicking New option menu item
		 */
		newOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("") ;
			}
		});

		/**
		 * Action Listener Event for when clicking Open option menu item
		 */
		openOption.addActionListener(new ActionListener() {

			private Scanner scan;

			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
				if( fileToOpen == JFileChooser.APPROVE_OPTION ){
					textArea.setText("");
					try{
						scan = new Scanner( new FileReader( fileOpen.getSelectedFile().getPath() ) );
						while ( scan.hasNext() )
							textArea.append( scan.nextLine() ) ;

					} catch( Exception ex ){
						System.out.println( ex.getMessage() ) ;
					}
				}
			}
		});

		/**
		 * Action Listener Event for when clicking Save option menu item 
		 */
		saveOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
				if( fileToSave == JFileChooser.APPROVE_OPTION ){
					try{
						// Writing the file and save into the selected location path
						BufferedWriter out = new BufferedWriter( new FileWriter( fileSave.getSelectedFile().getPath() ) ) ;
						out.write( textArea.getText() ) ;
						out.close() ;

					} catch( Exception ex ){

						System.out.println( ex.getMessage() ) ;

					}
				}
			}
		});
		
		/**
		 * Action Listener Event for when clicking Exit option menu item
		 */
		exitOption.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0) ;
			}
		});

	}

	/**
	 * Open file functionality
	 */
	public void openFile(){

		JFileChooser open = new JFileChooser() ;
		int option = open.showOpenDialog(this) ;
		fileToOpen = option ;
		fileOpen = open ;

	}

	/**
	 * Save file functionality
	 */
	public void saveFile(){

		JFileChooser save = new JFileChooser() ;
		int option = save.showSaveDialog(this) ;
		fileToSave = option ;
		fileSave = save ;

	}

}
