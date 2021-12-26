package work1;

import java.util.Iterator;

public class Q7 {

	public static void main(String[] args) {
		
		
		String  str="javacilar coook afilli arkadaslar";
	
		birKereYazdir(str);
	}	
	public static void birKereYazdir(String str) {
	    String sonuc = "";  //string default degeri "" atadik cunku isleme etki etmemeli.
	    for (int i = 0; i < str.length(); i++) {
	        if (!sonuc.contains(str.substring(i, i + 1))) {//sonuç metni str'nin
	            sonuc += str.substring(i, i + 1);
	        }
	    }
	    System.out.println(sonuc);
		
	
	}
}
