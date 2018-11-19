
public class demo2 {
public static void main(String[] args) {
	String str1 = "sjz";//对象的引用"str1"  进入栈，没有在堆中开辟内存，在data中 存放值
	String str2 = "sjz";
	String str3 = new String("sjz");//引用进入栈，在堆中开辟内存1，
	String str4 = new String("sjz");//引用进入栈，在堆中开辟内存2，
	System.out.println(str1 == str2);//true
	System.out.println(str3 == str4);//false
	
	
	
	
}
}
