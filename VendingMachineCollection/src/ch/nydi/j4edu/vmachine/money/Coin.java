package ch.nydi.j4edu.vmachine.money;

public enum Coin {

    RP_10(0.1d, 0), RP_20(0.2d, 1), RP_50(0.5d, 2), FR_1(1d, 3), FR_2(2d, 4), FR_5(5d, 5);

    private final Double value;
    private final Integer valency;

    private Coin(final Double value, final Integer valency) {
        this.value = value;
        this.valency = valency;
    }

    public Double getValue() {
        return value;
    }

    public Integer getValency() {
        return valency;
    }

    /**
     * Parses a coin from a string value. Valid tokens: 5.0, 2.0, 1.0, 0.5, 0.2 and 0.1.
     * 
     * @param value
     *            coin value or null if the token is invalid
     * @return
     */
    public static Coin parse(final String value) {
        if ("5.0".equals(value))
            return FR_5;
        else if ("2.0".equals(value))
            return FR_2;
        else if ("1.0".equals(value))
            return FR_1;
        else if ("0.5".equals(value))
            return RP_50;
        else if ("0.2".equals(value))
            return RP_20;
        else if ("0.1".equals(value))
            return RP_10;
        else
            return null;
    }

    public static Coin getByValency(final Integer valency) {
        if (5 == valency)
            return FR_5;
        else if (4 == valency)
            return FR_2;
        else if (3 == valency)
            return FR_1;
        else if (2 == valency)
            return RP_50;
        else if (1 == valency)
            return RP_20;
        else if (0 == valency)
            return RP_10;
        else
            return null;
    }
}
