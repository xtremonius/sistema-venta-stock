package Datos;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.ini4j.*;

public class IniFile {
	
	private String usr;
	private String pwd;
	private String driver;
	private String url;
	private String filename;
	private File file;
	private Wini ini;
	
	
	
	public IniFile() {
		
	}

	public String getUsr() {
		return usr;
	}

	public String getPwd() {
		return pwd;
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getFilename() {
		return filename;
	}

	public File getFile() {
		return file;
	}

	public Wini getIni() {
		return ini;
	}

	private void setUsr(String usr) {
		this.usr = usr;
	}

	private void setPwd(String pwd) {
		this.pwd = pwd;
	}

	private void setDriver(String driver) {
		this.driver = driver;
	}

	private void setUrl(String url) {
		this.url = url;
	}

	private void setFilename(String filename) {
		this.filename = filename;
	}

	private void setFile(File file) {
		this.file = file;
	}

	private void setIni(Wini ini) {
		this.ini = ini;
	}

	public boolean leerArchivo() {
		try {
			this.setFilename("./src/Files/jdbc.ini");
			
			//ClassLoader classLoader = new IniFile().getClass().getClassLoader();
			this.setFile(new File(filename));
			
			
			
			//Wini ini = new Wini(new File("C:\\Users\\monseñor mudini\\eclipse-workspace\\Punto de venta\\src\\Files\\jdbc.ini"));
			this.setIni(new Wini(file));
			this.setUsr(ini.get("database", "usr"));
			this.setPwd(ini.get("database", "pwd"));
			this.setDriver(ini.get("database", "driver"));
			this.setUrl(ini.get("database", "url"));
			
			
			return true;


		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el archivo ini.", "", JOptionPane.ERROR_MESSAGE);
			return false;
			
			
		}
	}




	

}
