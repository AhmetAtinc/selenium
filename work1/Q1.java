package work1;



public class Q1 {

	public static void main(String[] args) {
		/*
		int array1[]= {1,2,3};
		
		int array2[]= new int[5];
		
		array2=array1;
		
		for (int i : array2) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		int array3[]=new int [3];
		
		array3=array2;
		for (int i : array3) {
			System.out.print(i+" ");
		}
	*/	
		
	//	2 kelime oluþturun: isim1 ve isim2
	    // isim1 çift sayýda karakter içeriyorsa,
	    
	    // ikinci kelimeyi ilk adýn ortasýna yerleþtirin
	    
	    // ilk kelime tek sayida karakter iceriyorsa
	    
	    // “isim1, isim2 ye eklenemiyor” yazdýrýn
	    
	    // Örneðin:
	    // isim1= mehmet
	    // isim2= ahmet
	    // Yazdýr ==> mehahmetmet
	    
	    // isim1= mehmet
	    // isim2= ahmet
	    // Yazdýr ==> isim1, isim2 ye eklenemiyor

		String isim1="mehmet";
		String isim2="ahmet";
		
		if (isim1.length()%2==0) {
			System.out.println(isim1.substring(0, isim1.length()/2)+isim2+isim1.substring(isim1.length()/2, isim1.length()));
		} else {
			System.out.println("eklenmiyor");
		}
		
		System.out.println(isim1.length()%2==0 ? isim1.substring(0, isim1.length()/2)+isim2+isim1.substring(isim1.length()/2, isim1.length()):"eklenmiyor");
		
		
	

	}

}
