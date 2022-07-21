package ex220318;

import java.util.Random;
import java.util.Scanner;

public class Util {

	public String nameCheck(String n) {

		Scanner sc = new Scanner(System.in);
		String name = "";

		while (true) {
			System.out.print(n + "를 입력하세요 : ");
			name = sc.nextLine();
			if ("".equals(name)) {
				System.out.println("다시 입력하세요");
			} else {
				break;
			}
		}
		return name;
	}

	public int inCheck(String sub) {
		Scanner sc = new Scanner(System.in);
		int jumsu = 0;
		System.out.print(sub + "점수 > ");
		if (sc.hasNextInt()) {
			jumsu = sc.nextInt();
			if (jumsu > 100 || 0 > jumsu) {
				System.out.println("0~100까지만 입력");
			}
		}
		return jumsu;
	}
	public int menuCheck(String sub) {
		Scanner sc = new Scanner(System.in);
		int jumsu = 0;
		while (true) {
			System.out.print(sub + " > ");
			if (sc.hasNextInt()) {
				jumsu = sc.nextInt();
				sc.nextLine();
				break;
			} else {
				System.out.println(sub +"은 숫자만 입력 가능합니다");
			}			
		}
		return jumsu;
	}
	
	public long moneyCheck(String sub) {
		Scanner sc = new Scanner(System.in);
		long jumsu = 0;
		while (true) {
			System.out.print(sub + " > ");
			if (sc.hasNextLong()) {
				jumsu = sc.nextLong();
				sc.nextLine();
				break;
			} else {
				System.out.println(sub +" 숫자만 입력하세요");
			}			
		}
		return jumsu;
	}

	public int tot(int kor, int eng, int mat) {
		int tot = 0;
		tot = kor + eng + mat;
		return tot;
	}

	public float ave(int tot, int a) {
		float ave = (float) tot / a;
		return ave;
	}

	public String grade(float ave) {
		String a;
		if (ave > 90) {
			a = "A";
		} else if (ave > 80) {
			a = "B";
		} else if (ave > 70) {
			a = "C";
		} else if (ave > 60) {
			a = "D";
		} else {
			a = "F";
		}
		return a;
	}
	
	public int rdnum() {
		Random random = new Random();
        random.setSeed(System.nanoTime());

		int min = 50, max=100;
		return random.nextInt(max - min + 1) + min;
	}
	
	public int rdbank() {
		Random random = new Random();
        random.setSeed(System.nanoTime());

		int min = 10000, max=10000000;
		return random.nextInt(max - min + 1) + min;
	}
}
