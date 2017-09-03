package goods;

import java.io.IOException;
import java.util.HashMap;

public class testMap {
	
	
	String uriAPI = "";
	HashMap<String, Object> testpost(String uriAPI1) throws IOException {
		 
		  return null;
		 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] in={1,4,2,6,5,7,8};
		int sc=3;
		in[in.length-1]=sc;
		for (int i =in.length-1; i >0; i--) {
			if(in[i]<in[i-1]){
				int t=in[i];
				in[i]=in[i-1];
				in[i-1]=t;
			}
		}
		
		for (int i = 0; i < in.length-1; i++) {
			System.out.println(in[i]);
		}
	}

}
