class Q089_GFG {
    public int startStation(int[] gas, int[] cost) {
        int totalGasDeficit = 0;
        int currentGasBalance = 0;
        int startingPoint = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGas = gas[i] - cost[i];
            currentGasBalance += netGas;

            if (currentGasBalance < 0) {
                totalGasDeficit += currentGasBalance;
                currentGasBalance = 0;
                startingPoint = i + 1;
            }
        }

        return (currentGasBalance + totalGasDeficit >= 0) ? startingPoint : -1;
    }

    public static void main(String[] args) {
        Q089_GFG sol = new Q089_GFG();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(sol.startStation(gas, cost)); // Expected Output: 3
    }
}
