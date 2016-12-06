package usj.lp2.pessoas;

import java.util.Random;

public class NumerosAleatorios {
	 int[] num = new int[6];
	 
	public NumerosAleatorios(){
	int numero;
    int[] num = new int[6];
    Random r = new Random();
    for(int i=0; i<num.length; i++){
         numero = r.nextInt(60) + 1;
         for(int j=0; j<num.length; j++){
               if(numero == num[j] && j != i){
                     numero = r.nextInt(60) + 1;
               }else{
                    num[i] = numero;
               }
         	}
    	}
}
	public int[] getNum(){
		return num;
	}
}