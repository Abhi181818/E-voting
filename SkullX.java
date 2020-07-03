
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting1;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class SkullX {

    /**
     * @param args the command line arguments
     */
    
    public static final ImageIcon image(ImageIcon i){
        Image s1=i.getImage();
        //Image s2=s1.getScaledInstance(pic1.getWidth(),pic1.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i1 =new ImageIcon(s1.getScaledInstance(280, 278, Image.SCALE_SMOOTH));
        
        return i1;
    }
    
    public static void main(String[] args)throws InterruptedException{
        
        splshy splash=new splshy();
        splash.setVisible(true);
        int value=3;
        
        for(int i=0;i<=100;i++){
            Thread.sleep(20);
            splash.barr.setValue(i);
            String Key=".";
            
            if (i>=1 && i<10){
                splash.loady.setText("Starting Application");
                
                if(i==5){
                    
                    try{
                        File DefDirec=new File("");
                        String SDefDirec=DefDirec.getCanonicalPath();
                        
                        String SFile=SDefDirec+"\\Archive\\MAIN_DO_NOT_DELETE";
                        File file=new File(SFile);
                        
                        String Sfile1=SDefDirec+"\\Archive";
                        File file1=new File(Sfile1);
                        
                        String path=file1.toString();
                        
                        if(file1.exists()){
                            if(file.exists()){
                                continue;
                            } else{
                              while(!Key.equals("AbAd2X")){
                                  Key=JOptionPane.showInputDialog(null,"Enter your 'A' Code");
                                  if(Key.equals("AbAd2X")){
                                      try{
                                          BufferedImage res;
                                          res=new Robot()
                                                  .createScreenCapture(new Rectangle(Toolkit
                                                          .getDefaultToolkit()
                                                          .getScreenSize()));
                                          ImageIO.write(res,"jpeg",new File(path));
                                      } catch (AWTException | IOException ex){
                                          JOptionPane.showMessageDialog(null, ex.getMessage());
                                      }
                                  } else{
                                      JOptionPane.showMessageDialog(null,"Wrong 'A' Code");
                                  }
                              }  
                            }
                        } else{
                            file1.mkdir();
                            
                            while(!Key.equals("AbAd2X")){
                                Key=JOptionPane.showInputDialog(null,"Enter your 'A' Code");
                                
                                if(Key.equals("AbAd2X")){
                                    try{
                                        BufferedImage res;
                                        res=new Robot()
                                                .createScreenCapture(new Rectangle(Toolkit
                                                        .getDefaultToolkit()
                                                        .getScreenSize()));
                                        ImageIO.write(res,"jpeg",new File(path));
                                    } catch(AWTException | IOException ex){
                                        JOptionPane.showMessageDialog(null,ex.getMessage());
                                    }
                                } else{
                                    JOptionPane.showMessageDialog(null, "Wrong 'A' Code");
                                }
                            }
                        }
                   } catch (Exception w){
                       if(w.toString().equals("java.lang.NullPointerException")){
                           JOptionPane.showMessageDialog(null, "You Haven't Entered the 'A' Code\nContact the Developer Or try again","Error",JOptionPane.ERROR_MESSAGE);
                           System.exit(0);
                       }
                   }  
                } 
            }
            if(i>=20 && i<=30){
                
                splash.loady.setText("Checking the Database");
                
                Thread.sleep(20);
                
                if(i==30){
                    try{
                        Class.forName("java.sql.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost","root","admin");
                        Statement stmt=con.createStatement();
                        
                        String query="Use skullx";
                        stmt.executeQuery(query);
                        value=0;
                                con.close();
                                stmt.close();
                                
                    } catch(Exception e){
                        if(e.getMessage().equals("Unknown database 'skullx'")){
                            value=1;
                            try{
                                Class.forName("java.sql.Driver");
                                Connection con=DriverManager.getConnection("jdbc:mysql://localhost","root","admin");
                                Statement stmt=con.createStatement();
                                
                                String query="create database skullx;";
                                stmt.execute(query);
                                
                                con.close();
                                stmt.close();
                            } catch (Exception w){
                                JOptionPane.showMessageDialog(null, w.getMessage());
                                break;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,e.getMessage());
                            break;
                        }
                    }
                }
            }
              
             if(i>30 && i<40){
                 switch (value){
                     case 0:
                         splash.loady.setText("Checking the Database");
                         break;
                 }
             }       
             if (i>=40 && i<46){
                 splash.loady.setText("Scanning Archive");
                 Thread.sleep(20);
                 if(i==45){
                     try{
                         Class.forName("java.sql.Driver");
                         Connection con=DriverManager.getConnection("jdbc:mysql://localhost","root","admin");
                         Statement stmt=con.createStatement();
                         ResultSet rs;
                         
                         
                         String query="use skullx";
                         stmt.execute(query);
                         
                         query="show tables;";
                         
                         rs=stmt.executeQuery(query);
                         ArrayList Is=new ArrayList();
                         while(rs.next()){
                             Is.add(rs.getString(1));
                         }
                         if(Is.isEmpty()){
                             value=1;
                         }else{
                             value=0;
                         }
                         
                         con.close();
                         stmt.close();
                     }catch(Exception w){
                         JOptionPane.showMessageDialog(null,w.getMessage());
                         break;
                     }
                 }
             }
             if (i>=46&&i<60){
                 switch(value){
                     case 0:
                     splash.loady.setText("Scanning Archive");
                     break;
                     case 1:
                     splash.loady.setText("Creating Archive");
                 }
             }
             if(i>=60&&i<80){
                 
                 switch(value){
                     case 0:
                         splash.loady.setText("Checking for the Directory");
                         if(i==65){
                             try{
                                 Class.forName("java.sql.Driver");
                                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/skullx","root","admin");
                                 Statement stmt=con.createStatement();
                                 
                                 String query="select*from Location";
                                 
                                 ResultSet rs=stmt.executeQuery(query);
                                 
                                 if(rs.next()!=true){
                                     JOptionPane.showMessageDialog(null,"Default Path does not exist \nPlease add the Path now");
                                     
                                     JFileChooser browse=new JFileChooser();
                                     browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                     int a=browse.showDialog(null,"Save Directory");
                                     if(a ==JFileChooser.APPROVE_OPTION){
                                         File file=browse.getSelectedFile();
                                         
                                         
                                         String path=file.getAbsoluteFile().toString().replace("\\","/");
                                         query="insert into Location values('"+path+"');";
                                         stmt.executeUpdate(query);
                                         JOptionPane.showMessageDialog(null,"Directory Added Succesfully");
                                     }else{
                                         JOptionPane.showMessageDialog(null,"Add the Directory later from Tools Menu");
                                     }
                                 }
                                 con.close();
                                 rs.close();
                                 stmt.close();
                             }catch(Exception e){
                         }
                 }
                         break;
                         case 1:
                         if(i==65){
                             splash.loady.setText("Archives Created");
                             Thread.sleep(500);
                         }
                         if(i>65&&i<80){
                             splash.loady.setText("Welcome to the World of Electronic Voting");
                             Thread.sleep(100);
                         }
                         break;
             }
            }
             if(i>=80&&i<100){
                 splash.loady.setText("Starting Application");
             }
             if(i==100){
                 switch(value){
                     case 0:
                         secy login=new secy();
                         Thread.sleep(100);
                         login.setVisible(true);
                         splash.dispose();
                         break;
                     case 1:
                         Thread.sleep(100);
                         proceed s=new proceed();
                         s.setVisible(true);
                         splash.dispose();
                         break;
                 }
             }
        }
    }
}

        
    

