class Q029_GFG {
    public double power(double b, int e) {
        if (e == 0) {
            return 1.0;
        }

        if (e < 0) {
            b = 1 / b;
            e = -e;
        }

        double halfPower = power(b, e / 2);

        if (e % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return b * halfPower * halfPower;
        }
    }
}
