package work1;

public class Q6 {

	public static void main(String[] args) {
		
		
	//	3- Bir String icerisinde yinelenen karakterleri döndüren bir kod yazýniz.(mülakat Sorusu)
	//	Input : 
	//	String str=“Javaisalsoeasy” 
	//	Output: a s

		String str="javacilar coook afilli arkadaslar";
		String str2="";
		
		
		 for (int i = 0; i < str.length(); i++) {
	            
	            for (int j = i+1; j < str.length();j++) {
	                
	                if (str.charAt(i)==str.charAt(j) && !str2.contains(str.substring(i, i+1)) ) {
	                    str2+=str.charAt(i)+" ";
	                }
	            }
	        }
System.out.println(str2);
	}


}