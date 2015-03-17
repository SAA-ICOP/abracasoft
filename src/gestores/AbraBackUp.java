/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Este gestor funciona bien, habría que idear la forma de no necesitar crear el directorio backup.

Lo métodos los dejé así nomás para darles libertad de recibir o no algún dato adicional para crear la base de
datos (podrían decirle al usuario que agregue el nombre del archivo u otra cosa

Creo que si mysqldump y mysql son agregados a las "variables del entorno" pueden utilizarse sin mencionar toda 
la ruta de ubicación del archivo.

*/
package gestores;

/**
 *
 * @author Pablo
 */

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class AbraBackUp {
    private int BUFFER = 10485760;  
    //para guardar en memmoria
    private StringBuffer temp = null;
    //para guardar el archivo SQL
    private FileWriter  fichero = null;
    private PrintWriter pw = null;
    
    /*
    * Crea un backup en "C:\backup\abracasoftDB+fecha.sql",
    esta previsto que sea solo uno por dia y si se ejecuta dos veces 
    pisa al anterior
    */    
    public boolean CrearBackup(){ 
        boolean ok=false;
        Date hoy = new Date();
        DateFormat formato = DateFormat.getDateInstance(DateFormat.LONG);
        String fecha = formato.format(hoy);
                
    //    System.out.println(fecha);
   
        try{       
        //sentencia para crear el BackUp, en mi computadora tuve que poner la ruta completa donde se encuentra
        //instalado el archivo "mysqldump", el ejemplo de donde lo extraje solo decÃ­a "mysqldump".
             Process run = Runtime.getRuntime().exec(
            "C:\\Archivos de programa\\MySQL\\MySQL Server 5.0\\bin\\mysqldump --host=localhost --port=3306 --user=root --password=admin --complete-insert --extended-insert --skip-quote-names --skip-comments --skip-triggers abracasoftdb"); //--compact (le quite esto ultimo y anda mejor la restauracion, asi que listo el pollo, compact queda afuera

         //se guarda en memoria el backup
            InputStream in = run.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            temp = new StringBuffer();
            int count;
/**/            temp.append("SET FOREIGN_KEY_CHECKS = 0;\n");
            char[] cbuf = new char[BUFFER];
            while ((count = br.read(cbuf, 0, BUFFER)) != -1)
                temp.append(cbuf, 0, count);
/**/            temp.append("SET FOREIGN_KEY_CHECKS = 1;");
            br.close();
            in.close();        
        // se crea y escribe el archivo SQL
            fichero = new FileWriter("c:\\backup\\" + "abracasoftDB " + fecha + ".sql");
            pw = new PrintWriter(fichero);                                                    
            pw.println(temp.toString());  
            ok=true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        } finally {
            try {           
                if (null != fichero)
                    fichero.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }   
        return ok; 
        
    //Para invocar este mÃ©todo habrÃ­a que hacerlo mediante un "new AbraBackUp().CrearBackup();"
    }
    
    public boolean RestaurarBackup (String fecha){ // "S" es el nombre del archivo a restaurar;
        boolean ok=false;
        try {
            /*NOTE: String s is the mysql file name including the .sql in its name*/
            /*NOTE: Getting path to the Jar file being executed*/
            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
            CodeSource codeSource = AbraBackUp.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();

            /*NOTE: Creating Database Constraints*/
             String dbName = "abracasoftdb";
             String dbUser = "root";
             String dbPass = "admin";
             String nombreCorrecto = "abracasoftdb " + fecha +".sql";
            /*NOTE: Creating Path Constraints for restoring*/
          //  String restorePath = jarDir + "\\backup" + "\\" + s;
             String restorePath="c:\\backup\\" + nombreCorrecto;

            /*NOTE: Used to create a cmd command*/
            /*NOTE: Do not create a single large string, this will cause buffer locking, use string array*/
            String[] executeCmd = new String[]{"C:\\Archivos de programa\\MySQL\\MySQL Server 5.0\\bin\\mysql", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + restorePath};

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "El backup de fecha: " + fecha + " correctamente restaurado");
                ok=true;
            } else {
                JOptionPane.showMessageDialog(null, "Error at restoring");
            }
            
        } catch (URISyntaxException | IOException | InterruptedException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
        }
        return ok;
    }
}

/*

SET FOREIGN_KEY_CHECKS = 0; <- esto sirve para evitar problemas al actualizar la base de datos, va al principio


SET FOREIGN_KEY_CHECKS = 1; <- esto va al final

*/

//drop schema abracasoftdb; <- para eliminar base de datos.
