package work1;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		
		/*
		 * 2- Kullanýcýya Adý, Soyadý ve kredi kartý numaralarýný sorarak verilen formata ceviren java kodunu yaziniz.
		Input : 
		John White
		1234234534561478
		Output : Name : 
		J* W**
		CCN : ** ** **** 1478
		• Ilk Harfler Buyuk harf ile baslamalidir. 

		 */
		
		Scanner scan=new Scanner(System.in);
		System.out.println("isim  gir");
		String ad=scan.nextLine();
		System.out.println("soyad gir");
		String soyad=scan.nextLine();
		System.out.println("sifre gir");
		String sifre=scan.nextLine();
		
		System.out.println(ad.toUpperCase().charAt(0)+ad.replaceAll("\\w", "*")+soyad.toUpperCase().charAt(0)+soyad.replaceAll("\\w", "*"));
		System.out.println(sifre.substring(0,2).replaceAll("\\d", "*")+" "+sifre.substring(2, 4).replaceAll("\\d", "*")+" "+sifre.substring(4, 8).replaceAll("\\d", "*")+" "+sifre);
		
		
		int toplam=0;
		
		for (int i = 0; i <= 100; i++) {
			toplam+=i;
		}
		
		
		System.out.println(toplam);
		
	}

}
