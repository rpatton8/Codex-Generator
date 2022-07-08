package ryan.codexgenerator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalLine {

    public BigDecimal slope;
    public BigDecimal intercept;
    private static final MathContext mc = new MathContext(16, RoundingMode.HALF_UP);

    public BigDecimalLine() {
        this.slope = new BigDecimal(0);
        this.intercept = new BigDecimal(0);
    }

    public void calculateLine(BigDecimalPoint point, BigDecimal slope) {
        this.slope = slope;
        this.intercept = (point.y).subtract(slope.multiply(point.x));
    }

    public BigDecimalLine shiftLine(BigDecimal shift) {
        BigDecimalLine line = new BigDecimalLine();
        line.slope = this.slope;
        line.intercept = this.intercept.add(shift);
        return line;
    }

    public BigDecimalPoint getIntersectionPoint(BigDecimalLine line) {

        BigDecimal m1 = this.slope;
        BigDecimal b1 = this.intercept;
        BigDecimal m2 = line.slope;
        BigDecimal b2 = line.intercept;
        BigDecimal x = (b2.subtract(b1).divide((m1.subtract(m2)), mc));
        BigDecimal y = m1.multiply(x).add(b1);
        BigDecimalPoint point = new BigDecimalPoint(x, y);
        return point;

    }

}