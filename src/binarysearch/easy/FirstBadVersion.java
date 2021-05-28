package binarysearch.easy;

public class FirstBadVersion {
    private boolean isBadVersion(int version) { return false; }

    public int firstBadVersion(int n) {
        return firstBadVersion(n, 1, n);
    }

    private int firstBadVersion(int n, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low)/2;

            if (isBadVersion(mid) && (mid == 1 || !isBadVersion(mid - 1)))
                return mid;
            else if (isBadVersion(mid))
                return firstBadVersion(n, low, mid - 1);
            else
                return firstBadVersion(n, mid + 1, high);
        }

        return -1;
    }
}
