package test;

public class calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum=0;
		for(int i=3; i<=179; i+=4) {
			double v = Math.tan((double)i/180*Math.PI)*
					Math.tan(((double)i+4)/180*Math.PI);
			double v1 = Math.tan(((double)i+4)/180*Math.PI)*
					Math.tan(((double)i+8)/180*Math.PI);
			System.out.println(v1-v);
		}
	    
	}

}
