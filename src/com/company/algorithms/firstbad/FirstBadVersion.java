package com.company.algorithms.firstbad;

public class FirstBadVersion extends VersionControl {
    public static void main(String[] args) {
        FirstBadVersion processor = new FirstBadVersion();
        System.out.println("BAD version is: " + VersionControl.BAD_VERSION);
        processor.print(1);
        processor.print(2);
        processor.print(4);
        processor.print(5);
        processor.print(7);
        processor.print(10);
        processor.print(100);
        processor.print(1000000000);
    }

    private void print(int i) {
        System.out.println("version: " + i + ", first bad: " + firstBadVersion(i));
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int hi = n;
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}