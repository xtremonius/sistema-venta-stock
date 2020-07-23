package Datos;

import java.sql.Connection;
import java.sql.DriverManager;




public class Conexion {
	
	private static Connection cn = null;
	
	public static Connection getConexion() {
		
		try {
			if( cn == null) {
				//JOptionPane.showMessageDialog(null, "Entrando en la lectura del archivo properties");
				Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
				//ResourceBundle rb = ResourceBundle.getBundle("jdbc", Locale.getDefault());
				/*String driver = rb.getString("driver");
				String url = rb.getString("url");
				String pwd = rb.getString("pwd");
				String usr = rb.getString("usr");*/
				IniFile iniF = new IniFile();
				if(iniF.leerArchivo()) {
					String driver = iniF.getDriver();
					String url = iniF.getUrl();
					String pwd = iniF.getPwd();
					String usr = iniF.getUsr();
					Class.forName(driver);
					cn = DriverManager.getConnection(url, usr, pwd);
					
				}else {
					System.exit(0);
				}
				
				//String driver = ("com.mysql.cj.jdbc.Driver");
				//String url = ("jdbc:mysql://localhost:3306/ventas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				//String pwd = ("");
				//String usr = ("root");
				//System.out.println("********************************************************");
				//System.out.println(driver);
				
			
				
			}
			
			return cn;
		
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			throw new RuntimeException("Error al crear la conexion ",ex);
		}
		
	}
	
	
	

static class MiShDwnHook extends Thread {
	
	public void run() {
		
		try {
			Connection con = Conexion.getConexion();
			con.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
	

}



