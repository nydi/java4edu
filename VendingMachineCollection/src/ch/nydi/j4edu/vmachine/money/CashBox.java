package ch.nydi.j4edu.vmachine.money;

public class CashBox {

    /**
     * Simple array to count the coin types.
     */
    private final int[] coins;

    public CashBox() {
        // init with 5 coins of each type
        coins = new int[6];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = 5;
        }
    }

    public Coin[] withdraw(Double amount) {
        if (!canWithdraw(amount)) return null;

        // calculate coins to withdraw
        final int[] coinsToWithdraw = new int[6];
        int valency = 5;

        while ((0.05d < Math.abs(amount)) && (0 <= valency)) {
            final Coin currentCoin = Coin.getByValency(valency);
            final int countOfCurrentCoin = numberOfCoins(currentCoin, amount);

            if (0 == countOfCurrentCoin) {
                valency--;
                continue;
            }

            amount = amount % (countOfCurrentCoin * currentCoin.getValue());

            coins[valency] -= countOfCurrentCoin;
            // update cash box
            coinsToWithdraw[valency] = countOfCurrentCoin;
            valency--;
        }

        // cash out coins of coinsToWithdraw
        int numberOfCoins = 0;

        for (int i = 0; i < coinsToWithdraw.length; i++) {
            numberOfCoins += coinsToWithdraw[i];
        }

        final Coin[] coinsOutOfCashBox = new Coin[numberOfCoins];

        int coinsOutOfCashBoxCounter = 0;

        for (final Coin coin : Coin.values()) {
            for (int i = 0; i < coinsToWithdraw[coin.getValency()]; i++) {
                coinsOutOfCashBox[coinsOutOfCashBoxCounter] = coin;
                coinsOutOfCashBoxCounter++;
            }
        }

        return coinsOutOfCashBox;
    }

    public boolean canWithdraw(Double amount) {
        // check total amount
        if (amount > getCashBoxAmount()) return false;

        // calculate amount of each coin value to pay the amount, after walktrough all coins
        // the amount should 0
        int valency = 5;
        while ((0.05d < Math.abs(amount)) && (0 <= valency)) {
            amount = checkCoinSplitting(amount, Coin.getByValency(valency));
            valency--;
        }

        // check amount < 0.05 to hook expected calculation errors caused by double data type
        if (0.05d < Math.abs(amount)) return false;

        return true;
    }

    /**
     * Calculates the amount after payout a part amount with a specific coin value.
     * 
     * @param amount
     * @param coin
     * @return
     */
    private Double checkCoinSplitting(final Double amount, final Coin coin) {
        final int countOfCurrentCoin = numberOfCoins(coin, amount);
        // if one of the values is zero, so we can't pay with this coin value
        if ((0 == countOfCurrentCoin) || (0 == coins[coin.getValency()])) return amount;

        return amount % (Math.min(countOfCurrentCoin, coins[coin.getValency()]) * coin.getValue());
    }

    /**
     * Divide the value with coin value and returns the floor of the division.
     * 
     * @param coin
     * @param value
     * @return
     */
    private int numberOfCoins(final Coin coin, final double value) {
        return (int) Math.floor(value / coin.getValue());
    }

    public void deposit(final Coin[] coinsToDeposit) {
        for (final Coin coin : coinsToDeposit) {
            coins[coin.getValency()]++;
        }
    }

    public Double getCashBoxAmount() {
        // summation of coins by valency and count
        double amount = 0.0d;
        for (final Coin coin : Coin.values()) {
            amount = amount + (coins[coin.getValency()] * coin.getValue());
        }
        return amount;
    }
}
