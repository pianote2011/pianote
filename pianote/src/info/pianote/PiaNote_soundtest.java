package info.pianote;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.sound.midi.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PiaNote_soundtest {
	
	public static void  achtelviertelgebunden (MidiChannel[] mc ,int note) {
		
	
		
		mc[1].allNotesOff();
		
		mc[1].noteOn(note,60);
		try {
			Thread.sleep(600);
			mc[1].allNotesOff();
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	
	 
	public static void  viertel (MidiChannel[] mc ,int note) {
		
		if (note==1000){ //pause
			try {
				Thread.sleep(400);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		}
		
		mc[1].allNotesOff();
		
		mc[1].noteOn(note,60);
		try {
			Thread.sleep(400);
			mc[1].allNotesOff();
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	
		
	public static void  achtel (MidiChannel[] mc ,int note) {
		
		if (note==1000){ //pause
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}		
		}
		mc[1].allNotesOff();	
		mc[1].noteOn(note,60);
		
		try {
			Thread.sleep(200);
			mc[1].allNotesOff();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
		
		public static void  partymode (MidiChannel[] mc) {
		
			//strophe 1----------------------------------------------------
			viertel(mc,67); //g
			achtel(mc,62); //d
			achtel(mc,63); //es
			viertel(mc,65);//f
			achtel(mc,63);//es
			achtel(mc,62);//d
			viertel(mc,60);//c 
			achtel(mc,60);//c
			achtel(mc,63);//es
			viertel(mc,67); //g
			achtel(mc,65);//f
			achtel(mc,63); //es
			achtelviertelgebunden(mc,62);//d
			achtel(mc,63); //es
			viertel(mc,65);//f
			viertel(mc,67); //g
			viertel(mc,63);//es
			viertel(mc,60);//c 
			viertel(mc,60);//c	
			//strophe 2----------------------------------------------------
			achtel(mc,1000);//pause 
			viertel(mc,65); //f
			achtel(mc,68);//as
			viertel(mc,72);//c
			achtel(mc,70);//b
			achtel(mc,68);//as
			achtelviertelgebunden(mc,67);//g
			achtel(mc,63);//es
			viertel(mc,67);//g
			achtel(mc,65);//f
			achtel(mc,63); //es
			viertel(mc,62); //d
			achtel(mc,62); //d
			achtel(mc,63); //es
			viertel(mc,65);//f
			viertel(mc,67); //g
			viertel(mc,63);//es
			viertel(mc,60);//c 
			viertel(mc,60);//c
			
			
			
		
		
	}
                
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MidiUnavailableException {        
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open(); 
		final MidiChannel[] mc = synth.getChannels();

		Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
		for(int i=0;i<instr.length;i++){
			System.out.println(instr[i]);
		}
		mc[1].programChange(0,9);
		
		

		JFrame frame = new JFrame("Test1");                
		//button C
		final JPanel pane = new JPanel();                         
		JButton buttonC = new JButton("C");            
		frame.getContentPane().add(pane);                   
		pane.add(buttonC);
		
		//button D     
		JButton buttonD = new JButton("D");            
		frame.getContentPane().add(pane);                   
		pane.add(buttonD);
		
		//button E                
		JButton buttonE = new JButton("E");            
		frame.getContentPane().add(pane);                   
		pane.add(buttonE);
		
		// button F                        
		JButton buttonF = new JButton("F");            
		frame.getContentPane().add(pane);                   
		pane.add(buttonF);
		               
		//button G
		JButton buttonG = new JButton("G");            
		frame.getContentPane().add(pane);                   
		pane.add(buttonG);
		
		//button A                        
		JButton buttonA = new JButton("A");            
		frame.getContentPane().add(pane);                   
		pane.add(buttonA);
		
		//buttonH                        
		JButton buttonH = new JButton("H");            
		frame.getContentPane().add(pane);                   
		pane.add(buttonH);
		
		//buttonC                       
		JButton buttonC1 = new JButton("C");            
		frame.getContentPane().add(pane);                   
		pane.add(buttonC1);
		
		// buttonaus alloff                   
		JButton buttonaus = new JButton("Allesaus");            
		frame.getContentPane().add(pane);                   
		pane.add(buttonaus);
		
		  
		
		// button4 dreiklang                        
		JButton button4 = new JButton("C-Dur Dreiklang");            
		frame.getContentPane().add(pane);                   
		pane.add(button4);
		
		// button5 tetris                       
		JButton button5 = new JButton("Partymode");            
		frame.getContentPane().add(pane);                   
		pane.add(button5);
		
		
		
		
		frame.pack();                                       
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();  
		
		
		
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    
				mc[1].allNotesOff();
				mc[1].noteOn(60,60);
			}
		}); 
		
		buttonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    
				mc[1].allNotesOff();
				mc[1].noteOn(62,60);
			}
		});
		
		buttonE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    
				mc[1].allNotesOff();
				mc[1].noteOn(64,60);
			}
		});
		
		buttonF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    
				mc[1].allNotesOff();
				mc[1].noteOn(65,60);
			}
		});
		
		
		buttonG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    
				mc[1].allNotesOff();
				mc[1].noteOn(67,60);
			}
		});
		
		buttonA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    
				mc[1].allNotesOff();
				mc[1].noteOn(69,60);
			}
		});
		
		buttonH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    
				mc[1].allNotesOff();
				mc[1].noteOn(71,60);
			}
		});
		
		buttonC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    
				mc[1].allNotesOff();
				mc[1].noteOn(72,60);
			}
		});
		
		
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    
				
				mc[1].allNotesOff();
				mc[1].allNotesOff();
				mc[1].allNotesOff();
			
				mc[1].noteOn(60,60);
				mc[1].noteOn(64,60);
				mc[1].noteOn(67,60);
			}	
		});
		
			

		
		

		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				
				partymode (mc);
			}
		});
		
		
		
		buttonaus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
					
				mc[1].allNotesOff();
			}		
			});
		
	    
	     	
		

	
	}}
	



	 // END OF THE MAIN METHOD  




