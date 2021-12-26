package work1;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
	/*	
		6- Kullanýcýdan bir isim yazmasýný isteyin, adýn uzunluðu 3 olmalýdýr. Ardýndan, adýn ayný karakterlere sahip olup olmadýðýný kontrol edin.
		Eger ayný karakterlere sahipse 
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
