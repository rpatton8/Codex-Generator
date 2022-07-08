package ryan.codexgenerator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.LinkedList;

public class BigDecimalCircle {

    private BigDecimal radius;
    private BigDecimal one = new BigDecimal(1);
    private BigDecimal two = new BigDecimal(2);
    private BigDecimal four = new BigDecimal(4);

    private BigDecimal thousand = new BigDecimal("1000");
    private BigDecimal mmPerInch = new BigDecimal("25.4");
    private static final MathContext mc = new MathContext(16, RoundingMode.HALF_UP);

    public BigDecimalCircle(BigDecimal radius) {
        this.radius = radius;
    }

    public List<BigDecimalPoint> getIntersectionPoints(BigDecimalLine line) {

        List<BigDecimalPoint> points = new LinkedList<>();
        BigDecimal m = line.slope;
        BigDecimal b = line.intercept;
        BigDecimal r = this.radius;
        BigDecimal x1, x2, y1, y2, discriminant;
        discriminant = two.multiply(b).multiply(m).multiply(two.multiply(b).multiply(m)).subtract(four.multiply(one.add(m.multiply(m)).multiply(b.multiply(b).subtract(r.multiply(r)))));
        x1 = (two.multiply(b).multiply(m).negate().add(new BigDecimal(Math.sqrt(discriminant.doubleValue())))).divide(two.multiply(one.add(m.multiply(m))), mc);
        x2 = (two.multiply(b).multiply(m).negate().subtract(new BigDecimal(Math.sqrt(discriminant.doubleValue())))).divide(two.multiply(one.add(m.multiply(m))), mc);
        y1 = m.multiply(x1).add(b);
        y2 = m.multiply(x2).add(b);
        points.add(new BigDecimalPoint(x1, y1));
        points.add(new BigDecimalPoint(x2, y2));
        return points;

    }

    public BigDecimal getRadius() {

        return radius.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);

    }

}