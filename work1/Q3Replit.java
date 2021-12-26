package work1;

import java.util.Scanner;

public class Q3Replit {

	public static void main(String[] args) {
		/*
		 * Bir String icerisinde yinelenen karakterleri döndüren bir kod yazýniz.(mülakat Sorusu)

		Input :

		String str=“Javaisalsoeasy”

		Output: a s
		 */
/*
		String str="Javaisalsoeasy";
		
		char bos=' ';
		
		
		for (int i = 0; i < str.length()-1; i++) {
			
			for (int j = i+1; j < str.length()-1; j++) {
				if (str.charAt(i)==str.charAt(j)) {
					System.out.print(str.charAt(i));
				}
				
			}
		
		
		}
			*/
		
		 	
			/*
			 * Kullanýcýnýn girdiði sayýyý tersine çeviren bir java programý yazýnýz. (Mulakat Sorusu)

		Input :1238

		Output :Girilen Numananin Tersi: 8321
			
		
		Scanner scan=new Scanner(System.in);
		System.out.print("sayi giriniz : ");
		int sayi=scan.nextInt();
		
		for (int i = 0; i < sayi; i++) {
			System.out.print(sayi%10);
            sayi/=10;
		}
		
		
		/*
		while (sayi!=0) {
			System.out.print(sayi%10);
            sayi/=10;
		}
		
		*/ 
		
		
		  char karakter;
		  
	        for(karakter= 'a'; karakter <= 'z'; ++karakter)
	            System.out.print(karakter + " ");
	    } 		
		
		
	}


