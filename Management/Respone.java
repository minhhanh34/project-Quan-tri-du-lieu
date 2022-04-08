package Management;

import java.util.Scanner;

public class Respone {
	public static int getRespone(int floor, int tail) {
		Scanner sc = new Scanner(System.in);
		int respone = -1;
		do {
			System.out.println("\nLựa chọn: ");
			respone = sc.nextInt();
			if(respone < floor || respone > tail)
				System.err.println("Lựa chọn không hợp lệ! Chọn lại.");
		} while (respone < floor || respone > tail);
		return respone;
	}
}
