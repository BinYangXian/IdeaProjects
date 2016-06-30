package usingStreamReaderAndWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class UsingStreamReaderAndWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fileInputStream=new FileInputStream("src/test.txt");
			InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
			char[] chars=new char[97];
			String str="";
//			int i;
			while (inputStreamReader.read(chars)!=-1) {
				str+=new String(chars);
			}
			System.out.println(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
