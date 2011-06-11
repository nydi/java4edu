/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.money;

/**
 * @author Daniel Nydegger
 */
public class CoinBuffer {

    /**
     * Simple array to count the coin types.
     */
    private int[] coins;

    public CoinBuffer() {
        coins = new int[6];
    }

    public Double getBufferdAmount() {
        // summation of coins by valency and count
        double amount = 0.0d;
        for (final Coin coin : Coin.values()) {
            amount = amount + (coins[coin.getValency()] * coin.getValue());
        }
        return amount;
    }

    public void addCoin(final Coin coin) {
        coins[coin.getValency()]++;
    }

    public Coin[] flush() {
        int numberOfCoins = 0;

        for (int i = 0; i < coins.length; i++) {
            numberOfCoins += coins[i];
        }

        final Coin[] coinsOutOfBuffer = new Coin[numberOfCoins];

        // iterate over the coin values and fill the coinsOutOfBuffer array
        int coinsOutOfBufferCounter = 0;
        for (final Coin coin : Coin.values()) {
            for (int i = 0; i < coins[coin.getValency()]; i++) {
                coinsOutOfBuffer[coinsOutOfBufferCounter] = coin;
                coinsOutOfBufferCounter++;
            }
        }
        // reset coin buffer
        coins = new int[6];

        return coinsOutOfBuffer;
    }
}
