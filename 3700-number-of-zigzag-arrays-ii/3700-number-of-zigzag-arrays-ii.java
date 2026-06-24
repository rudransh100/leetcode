class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int d = r - l + 1;
        int size = 2 * d;

        long[] vec = new long[size];

        // Initial state for length = 1
        for (int i = 0; i < d - 1; i++) vec[i] = 1;
        vec[d - 1] = 0;

        vec[d] = 0;
        for (int i = d + 1; i < size; i++) vec[i] = 1;

        long[][] M = new long[size][size];

        for (int i = 0; i < d; i++) {
            for (int j = i + 1; j < d; j++) {
                M[i][d + j] = 1;
            }
            for (int j = 0; j < i; j++) {
                M[d + i][j] = 1;
            }
        }

        vec = powerMultiply(M, vec, n - 1);

        long ans = 0;
        for (long x : vec) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] powerMultiply(long[][] M, long[] vec, long exp) {
        int size = vec.length;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                vec = multiplyMatrixVector(M, vec);
            }
            M = multiplyMatrix(M, M);
            exp >>= 1;
        }

        return vec;
    }

    private long[] multiplyMatrixVector(long[][] A, long[] v) {
        int n = v.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum = (sum + A[i][j] * v[j]) % MOD;
            }
            res[i] = sum;
        }

        return res;
    }

    private long[][] multiplyMatrix(long[][] A, long[][] B) {
        int n = A.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long val = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;
                    res[i][j] = (res[i][j] + val * B[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}