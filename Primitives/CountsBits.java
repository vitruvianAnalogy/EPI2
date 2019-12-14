public class CountsBits{

	public static short countBits(int x){
		short numBits = 0;//why is short used
		//do right shift until 0 is left
		while(x!=0){
			//AND operation with 1 means, we are 
			//checking the least significant bit
			//because 1 is 1 in binary and decimal
			//and AND operation tells us whether
			//least significant bit is 0 or 1, because
			//AND operation with 1 returns the original
			//value. It is idempotent
			numBits += (x&1);
			x>>>=1; //This is what logical right shift in java is like
			//Logical shift is different from arithmetic shift
			//arithmetic shift preserves the sign bit
			//so for instance if 1001 is arithmetic right shifted
			//it becomes 1100
		}
		return numBits;
	}
}