package q7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long count;
	static int[] A, B, C, D;
	static int[] arr_1;
	static int[] arr_2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		B = new int[n];
		C = new int[n];
		D = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		arr_1 = new int[n * n];
		arr_2 = new int[n * n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr_1[i * n + j] = A[i] + B[j];
				arr_2[i * n + j] = C[i] + D[j];
			}
		}

		Arrays.sort(arr_1);
		Arrays.sort(arr_2);

		for (int i = 0; i < n * n; i++) {
			int num = arr_1[i];
			int target = (-1) * num;

			int first = 0;
			int last = n * n;
			int mid;
			int lb;
			while (first < last) {
				mid = (first + last) / 2;

				if (target > arr_2[mid]) {
					first = mid + 1;
				} else {
					last = mid;
				}
			}
			lb = last;

			first = 0;
			last = n * n;
			int ub;

			while (first < last) {
				mid = (first + last) / 2;

				if (target >= arr_2[mid]) {
					first = mid + 1;
				} else {
					last = mid;
				}
			}
			ub = last;

			count += ub - lb;

		}
		System.out.println(count);

	}
}
