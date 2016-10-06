package source;

import java.net.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;

public class AxisClient {
	private final static String AXIS_OUTPUT_PATH = "D:/axisfolder/assignment1/";
	private final static String AXIS_FILE = "axis.jpg";

   public static void main(String [] args){
      //String serverName = args[0];
      //int port = Integer.parseInt(args[1]);
	   
      int port = Integer.parseInt("5005");
      String serverName ="192.168.20.246";
      
      AxisFileReader axisFileReader = new AxisFileReader();
      
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         
         
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         BufferedImage image = ImageIO.read(inFromServer);
         
        // axisFileReader.saveInputStream(inFromServer, getOutputFilePath());
         axisFileReader.saveImageStream(image, getOutputFilePath());
        // System.out.println("Server says " + in.readChar());
         client.close();
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
   
   private static String getOutputFilePath(){
	   return AXIS_OUTPUT_PATH + AXIS_FILE;
   }
}