package problems;

public class Palindrome {
	
	public boolean isPal(int x){
		
		if(x < 10)
			return true;
		
		int temp = x;
		int RHS = 0, LHS = 0;
		int digit, lastDigit;
		int digitCount = 0;
		boolean switchToLHS = false;
		
  		while(temp > 0){
			digit = temp%10;
			lastDigit = temp/10;
			if(digit != 0){
				// have we reached the left end of the number
				if(lastDigit == 0){
					if(RHS != LHS && switchToLHS){
						return false;
					}
				}
				else{
					if(RHS != 0){
						if(!switchToLHS)
							switchToLHS = true;
						else
							LHS = 0;
					}
				}
			}
			// digit is 0
			else{
				if(temp == x) // 0 in rightmost digit means no palindrome
					return false;
				else{
					if(switchToLHS)
						LHS++;
					else
						RHS++;
				}
			}
			temp/=10;
			digitCount++;
		}
		
  		int leftDigit = x/(int)Math.pow(10, digitCount-1);
  		int rightDigit = x%10;
  		
  		// compare outer digits
		if(leftDigit != rightDigit)
			return false;
		
		int zeroCount = LHS; // same as RHS
		
		int truncated = (x - leftDigit*(int)Math.pow(10, digitCount - 1))/(int)Math.pow(10, zeroCount+1);
		
		return isPal(truncated);
		
	}

}
