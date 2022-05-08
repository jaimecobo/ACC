public class Poligono {

	public static void main (String [] args){
	int x = 5;
	int p = x;
	int b = x;
	int zz = 1;
	p = p-1;
	while (p > 0){
		for (int i = 0 ; i < p; i++){
			System.out.print(' ');
		}
		System.out.println('*');
		int zzz = 1;
		if (zz > 1)
		for (int j = 0; j < zzz; j++)
			System.out.print('2');
		p--;
		zz++;
		zzz = zzz + 2;
	}
	for (int n = 0; n < b; n++)
			System.out.print("* ");
		
			System.out.println();
			System.out.println();
			
		int pp = -1;

		for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8 - i; j++) {
                    System.out.print(" "); 
		}
                System.out.print("*");
				if (i>1){
		for (int k = 0; k < pp; k++) 
                    System.out.print("/");
			
		
				}else
			System.out.print(" ");
		
		if (i>0)
			System.out.println('*');
		else 
			System.out.println();
		pp = pp + 2;

		}
		for (int n = 0; n < 17; n++)
			System.out.print("*");
    }
}
	