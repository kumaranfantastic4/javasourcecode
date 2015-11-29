package com.java.jottings;

import javax.swing.JFrame;

public class JottingsApp {
    
	/**
	 * Jottings Application launch
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame frame = new Jottings() ;
		frame.setTitle(" $$$ Jottings $$$ ");
		frame.setVisible( true );
		frame.setSize( 1280, 720 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setResizable( true );
		frame.setLocationRelativeTo( null );
		
	}

}
