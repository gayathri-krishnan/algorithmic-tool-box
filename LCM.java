import java.math.BigDecimal;
import java.util.Scanner;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  
  private static long lcm_efficient(int a, int b) {
	    if(a==0||b==0) {
	    	return 0;
	    }
	    if(a==1)
	    	return b;
	    if(b==1)
	    	return a;
	    if(b==a)
	    	return a;
	    long product = (long) a*b;
	    long gcd = gcd_efficient(a, b);
	    //System.out.println(product);
	    //System.out.println(gcd);
	    return product/gcd;
	    
	  }
  
  private static long gcd_efficient(long a, long b) {
		if(a==b) {
			return a;
		}
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}
		if(a==1||b==1) {
			return 1;
		}
		long bigger_num = a > b ? a : b;
		long smaller_num = a > b ? b : a;
		long rem = bigger_num % smaller_num;
		long a1 = smaller_num;
		long b1 = rem;

		while (rem > 0) {

			rem = a1 % b1;

			a1 = b1;
			b1= rem==0?b1:rem;

		}

		return b1;
	}

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    //System.out.println(lcm_naive(a, b));
    System.out.println(lcm_efficient(a, b));
    
    
  //Stress testing code
  		/*while(true) {
  			int a = new Random().nextInt(10000);
  			int b = new Random().nextInt(10000);
  			long rs1 = lcm_naive(a,b);
  			long rs2 = lcm_efficient(a,b);
  			if(rs1!=rs2) {
  				System.out.println("Failure");
  				break;
  			}else {
  				System.out.println("OK");
  			}
  		}*/
    
  }
}
