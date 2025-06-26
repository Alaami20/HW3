package view;
/*
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import control.Hospital;


public class Main implements Serializable {

		/**
	 * 
	 */
	/*private static final long serialVersionUID = 21L;
		public static Hospital libr;//library field
		public static void main(String args[]) throws UnsupportedAudioFileException, LineUnavailableException
		{
			try
			{
				Hospital lib = loadingLibr();
				System.out.println(lib + "---------------");
				if(lib == null){
					lib = Hospital.getInstance();
				}
			
			libr = lib;
			LoginFrame login = new LoginFrame();
			login.setVisible(true);

		
		//in case the file is not found
			}catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"File not found");
		}
		//in case there was a problem loading data from file
		catch(IOException eio)
		{
			JOptionPane.showMessageDialog(null,"Sound Problems");
		}


	}
	public static void save() throws IOException
	{
		String filename = "Hospital.ser";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		//trying to save the data
		try
		{
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(Main.libr);
			out.close();
			JOptionPane.showMessageDialog(null,"Saving file was succesed", "Data Save successe", JOptionPane.INFORMATION_MESSAGE);
		}

		//general exceptions
		catch (Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Saving file was failed ", "Save Error", JOptionPane.ERROR_MESSAGE);
		}
	}//end of save method


	@SuppressWarnings("resource")
	public static Hospital loadingLibr() throws IOException  {
		Hospital libr=null;
		String filename = "Factory.ser";
		FileInputStream fis = null;
		ObjectInputStream in = null;

		try
		{
			System.out.println("faaaaaaaaaaaaaaaaaaaaaat");
			fis = new FileInputStream(filename);
			in = new ObjectInputStream (fis);
			libr=(Hospital)in.readObject();
			return libr;
		}

		//in case the file is not found
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"File wasn't found, creating new Library:", "Missing file", JOptionPane.ERROR_MESSAGE);
			return libr;

		}

		//in case there was a problem loading data from file
		catch(IOException eio)
		{
			JOptionPane.showMessageDialog(null,"system wasn't able to read from file.. creating new Library", "Read File Error", JOptionPane.INFORMATION_MESSAGE);
			return libr;
		}

		//genreal exceptions
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return libr;
		}
	}
}*/


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import control.Hospital;

public class Main implements Serializable {

    private static final long serialVersionUID = 21L;
    public static Hospital libr;  // Hospital field

    public static void main(String args[]) throws UnsupportedAudioFileException, LineUnavailableException {
        try {
            // Load the Hospital instance from the file
            Hospital lib = loadingLibr();
            if (lib == null) {
                // If loading fails or the file doesn't exist, create a new instance
                lib = Hospital.getInstance();
            } else {
                // If loaded successfully, set the singleton instance
                Hospital.setInstance(lib);
            }

            libr = lib;  // Assign to the static variable

            // Show the login frame
            LoginFrame login = new LoginFrame();
            login.setVisible(true);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException eio) {
            JOptionPane.showMessageDialog(null, "Sound Problems");
        }
    }

    public static void save() throws IOException {
        String filename = "Hospital.ser";
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {

            out.writeObject(Main.libr);
            System.out.println("Hospital instance saved successfully.");
            JOptionPane.showMessageDialog(null, "Saving file was successful", "Data Save success", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Saving file failed", "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Hospital loadingLibr() throws IOException {
        Hospital libr = null;
        String filename = "Hospital.ser";  // Corrected filename to match the save method
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fis)) {

            libr = (Hospital) in.readObject();
            System.out.println("Hospital instance loaded successfully.");
            return libr;

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File wasn't found, creating new Hospital", "Missing file", JOptionPane.ERROR_MESSAGE);
            return null;

        } catch (IOException | ClassNotFoundException eio) {
            JOptionPane.showMessageDialog(null, "System wasn't able to read from file.. creating new Hospital", "Read File Error", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
}

