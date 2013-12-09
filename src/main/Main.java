package main;

public class Main {
	public static void main(String[] args) {
		String tex = "Tex";
		String teX = "TeX";
		String ted = "Ted";
		int cmp1 = tex.compareTo(teX);
		int cmp2 = teX.compareTo(tex);
		int cmp3 = ted.compareTo(teX);
		int cmp4 = ted.compareTo(tex);
		System.out.println("Tex compare TeX: " + cmp1);
		System.out.println("TeX compare Tex: " + cmp2);
		System.out.println("Ted compare TeX: " + cmp3);
		System.out.println("Ted compare Tex: " + cmp4);
		
	}
}