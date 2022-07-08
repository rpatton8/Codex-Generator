package ryan.codexgenerator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalPoint {

    public BigDecimal x;
    public BigDecimal y;

    private boolean inMM = true;
    private BigDecimal thousand = new BigDecimal("1000");
    private BigDecimal mmPerInch = new BigDecimal("25.4");
    private static final MathContext mc = new MathContext(16, RoundingMode.HALF_UP);

    public BigDecimalPoint() {
        this.x = new BigDecimal(0);
        this.y = new BigDecimal(0);
    }

    public BigDecimalPoint(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public BigDecimal getX() {
        if (inMM) return x.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
        return x.setScale(4, RoundingMode.HALF_UP);
    }

    public BigDecimal getY() {
        if (inMM) return y.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
        return y.setScale(4, RoundingMode.HALF_UP);
    }

}