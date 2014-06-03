public class CheckBinaryExpression{

	public static Result checkBinaryExpression(double num){
		StringBuffer sb = new StringBuffer();
		sb.append(".");
		while(sb.length()<=32&&num!=0){
			double r = num*2;
			if(r>=1){
				sb.append("1");
				num = r-1;
			}
			else{
				sb.append("0");
				num = r;
			}
			System.out.println(num);
		}
		if(num==0)
			return new Result(true, sb.toString());
		return new Result(false, sb.toString());
	}	

	public static void main(String[] args){
		double num = 0.625;
		if(checkBinaryExpression(num).result)
			System.out.println("true");
		else
			System.out.println("false");
	}

	public static class Result{
		boolean result;
		String binaryForm;
		Result(boolean r, String b){
			result = r;
			binaryForm = b;
		}
	}
}