// A test program for TinyJava

class RecursiveSum {
	public static void main(String[] a) {
		System.out.println(new Test().sum(10));
	}
}

class Test{
	public int sum(int num){
		int asum;
		asum = 0;
		while (num > 0){
			asum = asum + num;
			num = num - 1;
		}
		return asum;
	}
}