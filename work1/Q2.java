package work1;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
	/*	
		6- Kullan�c�dan bir isim yazmas�n� isteyin, ad�n uzunlu�u 3 olmal�d�r. Ard�ndan, ad�n ayn� karakterlere sahip olup olmad���n� kontrol edin.
		Eger ayn� karakterlere sahipse 
		"isim ayni karakterlere sahiptir." yazdirin.
		Eger ayni kaakterlere sahip degilse
		"Dizenin benzersiz karakterleri var" yazdirin. 
		Ternary kullanin.
   */

		Scanner scan=new Scanner(System.in);
		System.out.println("uc harfli isim gir");
		String isim=scan.next().toLowerCase();
		
		if (isim.charAt(0)==isim.charAt(1)||isim.charAt(0)==isim.charAt(2)) {
			System.out.println("isim ayni karakterlere sahiptir");
		}else {
			System.out.println("Dizenin benzersiz karakterleri var");
		}
		
	//	isim.charAt(0)==isim.charAt(1)&&isim.charAt(0)==isim.charAt(2)
	}

}
