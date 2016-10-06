package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;

import source.AxisFileReader;

public class TestAxisFileReader {
	private static AxisFileReader axisFileReader;
	private static String outputFilePath;
	private static InputStream inputStream;
	
	@BeforeClass
	public static void  initializeVariables() throws FileNotFoundException{
		axisFileReader = new AxisFileReader();
		outputFilePath = "D:/axisfolder/assignment1/axis2.txt";
		inputStream =  new FileInputStream("D:/axisfolder/assignment1/axis.txt");
	}
	
	@Test
	public void testAxisFileReaderSave(){
		axisFileReader.saveInputStream(inputStream, outputFilePath);
	}
}
