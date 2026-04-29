package study.day0429;

import java.util.*;

public class BST {
    static int MAXSIZE = 10_000_000;
    static int MAXITER = 1000;

    static int[] init() {
        Random random = new Random();
        int[] arr = new int[MAXSIZE];

        for (int i = 0; i < MAXSIZE; i++) {
            arr[i] = random.nextInt();
        }

        return arr;
    }

    static void sort(int[] arr) {
        long start = System.nanoTime();

        Arrays.sort(arr);

        long end = System.nanoTime();
        double durationMs = (end - start) / 1_000_000.0;

        System.out.println("배열 정렬 소요 시간 : " + durationMs + " ms");
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == target) {
                return middle;
            }

            if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    static void searchTime(int[] arr) {
        Random random = new Random();

        // JVM 워밍업
        for (int i = 0; i < 10_000; i++) {
            int target = arr[random.nextInt(MAXSIZE)];
            linearSearch(arr, target);
            binarySearch(arr, target);
        }

        long linearStart = System.nanoTime();

        for (int i = 0; i < MAXITER; i++) {
            int target = arr[random.nextInt(MAXSIZE)];
            linearSearch(arr, target);
        }

        long linearEnd = System.nanoTime();

        long binaryStart = System.nanoTime();

        for (int i = 0; i < MAXITER; i++) {
            int target = arr[random.nextInt(MAXSIZE)];
            binarySearch(arr, target);
        }

        long binaryEnd = System.nanoTime();

        double linearTotalMs = (linearEnd - linearStart) / 1_000_000.0;
        double binaryTotalMs = (binaryEnd - binaryStart) / 1_000_000.0;

        System.out.println("[LinearSearch] 총 소요 시간 = " + linearTotalMs + " ms");
        System.out.println("[LinearSearch] 평균 소요 시간 = " + linearTotalMs / MAXITER + " ms");

        System.out.println("[BinarySearch] 총 소요 시간 = " + binaryTotalMs + " ms");
        System.out.println("[BinarySearch] 평균 소요 시간 = " + binaryTotalMs / MAXITER + " ms");
    }

    public static void main(String[] args) {
        int[] arr = init();

        sort(arr);

        searchTime(arr);
    }
}