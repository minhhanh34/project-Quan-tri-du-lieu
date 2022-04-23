package Management;

import java.util.Scanner;

public class Respone {
	public static int getRespone(int floor, int ceil) {
		Scanner sc = new Scanner(System.in);
		int respone = -1;
		do {
			System.out.print("\nLựa chọn: ");
			respone = sc.nextInt();
			if(respone < floor || respone > ceil)
				System.out.println("\nLựa chọn không hợp lệ! Chọn lại.");
		} while (respone < floor || respone > ceil);
		return respone;
	}
}
