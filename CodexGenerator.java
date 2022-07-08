package ryan.codexgenerator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.LinkedList;

public class CodexGenerator {

    private BigDecimal ring7radius = new BigDecimal(2500);
    private BigDecimal ring6radius = new BigDecimal(2420);
    private BigDecimal ring5radius = new BigDecimal(2000);
    private BigDecimal ring4radius = new BigDecimal(1920);
    private BigDecimal ring3radius = new BigDecimal(1500);
    private BigDecimal ring2radius = new BigDecimal(1420);
    private BigDecimal ring1radius = new BigDecimal(540);

    private BigDecimal innerCircle5radius = new BigDecimal(450);
    private BigDecimal innerCircle4radius = new BigDecimal(360);
    private BigDecimal innerCircle3radius = new BigDecimal(270);
    private BigDecimal innerCircle2radius = new BigDecimal(180);
    private BigDecimal innerCircle1radius = new BigDecimal(90);

    private BigDecimal backRing2radius = new BigDecimal(1420);
    private BigDecimal backRing2circumference;

    private BigDecimal backCircle0OuterRadius = new BigDecimal(210);
    private BigDecimal backCircle0InnerRadius = new BigDecimal(130);

    private BigDecimal numSections = new BigDecimal(22);
    private BigDecimal numBackSections = new BigDecimal(9);

    private BigDecimal wallWidth = new BigDecimal(80);
    private BigDecimal zThickness = new BigDecimal(280);
    private BigDecimal zDepth = new BigDecimal(80);
    private BigDecimal zOffset = zThickness.subtract(zDepth);

    private boolean inMM = true;
    private BigDecimal thousand = new BigDecimal("1000");
    private BigDecimal mmPerInch = new BigDecimal("25.4");

    private BigDecimal d360 = new BigDecimal(360);
    private BigDecimal two = new BigDecimal(2);
    private MathContext mc = new MathContext(16, RoundingMode.HALF_UP);
    private BigDecimal twoPi = new BigDecimal(2 * Math.PI, mc);
    private BigDecimal degreeSectionOffset = d360.divide(numSections, mc);
    private BigDecimal degreeBackSectionOffset = d360.divide(numBackSections, mc);

    private BigDecimal ring7circumference;
    private BigDecimal ring6circumference;
    private BigDecimal ring5circumference;
    private BigDecimal ring4circumference;
    private BigDecimal ring3circumference;
    private BigDecimal ring2circumference;
    private BigDecimal ring1circumference;

    private BigDecimal ring7degreeOffset;
    private BigDecimal ring7sinOffset;
    private BigDecimal ring7cosOffset;
    private BigDecimalPoint outerRing7topLeft = new BigDecimalPoint();
    private BigDecimalPoint outerRing7topRight = new BigDecimalPoint();
    private BigDecimalPoint outerRing7bottomLeft = new BigDecimalPoint();
    private BigDecimalPoint outerRing7bottomRight = new BigDecimalPoint();
    private BigDecimalPoint outerRing7leftTop = new BigDecimalPoint();
    private BigDecimalPoint outerRing7leftBottom = new BigDecimalPoint();
    private BigDecimalPoint outerRing7rightTop = new BigDecimalPoint();
    private BigDecimalPoint outerRing7rightBottom = new BigDecimalPoint();
    private BigDecimalPoint outerRing7topMiddle = new BigDecimalPoint();
    private BigDecimalPoint outerRing7bottomMiddle = new BigDecimalPoint();
    private BigDecimalPoint outerRing7leftMiddle = new BigDecimalPoint();
    private BigDecimalPoint outerRing7rightMiddle = new BigDecimalPoint();

    private BigDecimal ring6degreeOffset;
    private BigDecimal ring6sinOffset;
    private BigDecimal ring6cosOffset;
    private BigDecimalPoint innerRing6topLeft = new BigDecimalPoint();
    private BigDecimalPoint innerRing6topRight = new BigDecimalPoint();
    private BigDecimalPoint innerRing6bottomLeft = new BigDecimalPoint();
    private BigDecimalPoint innerRing6bottomRight = new BigDecimalPoint();
    private BigDecimalPoint innerRing6leftTop = new BigDecimalPoint();
    private BigDecimalPoint innerRing6leftBottom = new BigDecimalPoint();
    private BigDecimalPoint innerRing6rightTop = new BigDecimalPoint();
    private BigDecimalPoint innerRing6rightBottom = new BigDecimalPoint();
    private BigDecimalPoint innerRing6topMiddle = new BigDecimalPoint();
    private BigDecimalPoint innerRing6bottomMiddle = new BigDecimalPoint();
    private BigDecimalPoint innerRing6leftMiddle = new BigDecimalPoint();
    private BigDecimalPoint innerRing6rightMiddle = new BigDecimalPoint();

    private BigDecimal ring5degreeOffsetOuter;
    private BigDecimal ring5sinOffsetOuter;
    private BigDecimal ring5cosOffsetOuter;
    private BigDecimal ring5degreeOffsetMiddle;
    private BigDecimal ring5sinOffsetMiddle;
    private BigDecimal ring5cosOffsetMiddle;
    private BigDecimalPoint outerRing5topLeft = new BigDecimalPoint();
    private BigDecimalPoint outerRing5topRight = new BigDecimalPoint();
    private BigDecimalPoint outerRing5bottomLeft = new BigDecimalPoint();
    private BigDecimalPoint outerRing5bottomRight = new BigDecimalPoint();
    private BigDecimalPoint outerRing5leftTop = new BigDecimalPoint();
    private BigDecimalPoint outerRing5leftBottom = new BigDecimalPoint();
    private BigDecimalPoint outerRing5rightTop = new BigDecimalPoint();
    private BigDecimalPoint outerRing5rightBottom = new BigDecimalPoint();
    private BigDecimalPoint outerRing5topLeftMiddle = new BigDecimalPoint();
    private BigDecimalPoint outerRing5topRightMiddle = new BigDecimalPoint();
    private BigDecimalPoint outerRing5bottomLeftMiddle = new BigDecimalPoint();
    private BigDecimalPoint outerRing5bottomRightMiddle = new BigDecimalPoint();

    private BigDecimal ring5degreeOffsetInner;
    private BigDecimal ring5sinOffsetInner;
    private BigDecimal ring5cosOffsetInner;
    private BigDecimalPoint innerRing5topLeft = new BigDecimalPoint();
    private BigDecimalPoint innerRing5topRight = new BigDecimalPoint();
    private BigDecimalPoint innerRing5bottomLeft = new BigDecimalPoint();
    private BigDecimalPoint innerRing5bottomRight = new BigDecimalPoint();
    private BigDecimalPoint innerRing5leftTop = new BigDecimalPoint();
    private BigDecimalPoint innerRing5leftBottom = new BigDecimalPoint();
    private BigDecimalPoint innerRing5rightTop = new BigDecimalPoint();
    private BigDecimalPoint innerRing5rightBottom = new BigDecimalPoint();
    private BigDecimalPoint innerRing5topMiddle = new BigDecimalPoint();
    private BigDecimalPoint innerRing5bottomMiddle = new BigDecimalPoint();
    private BigDecimalPoint innerRing5leftMiddle = new BigDecimalPoint();
    private BigDecimalPoint innerRing5rightMiddle = new BigDecimalPoint();

    private BigDecimal ring4degreeOffset;
    private List<List<BigDecimalPoint>> ring4;

    private BigDecimal ring3degreeOffset;
    private List<List<BigDecimalPoint>> ring3;

    private BigDecimal ring2degreeOffset;
    private List<List<BigDecimalPoint>> ring2;

    private BigDecimal ring1degreeOffset;
    private List<List<BigDecimalPoint>> ring1;

    private BigDecimal backRing4degreeOffset;
    private List<List<BigDecimalPoint>> backRing4;

    private BigDecimal backRing3degreeOffset;
    private List<List<BigDecimalPoint>> backRing3;

    private BigDecimal backRing2degreeOffset;
    private List<BigDecimalPoint> backRing2;

    private BigDecimal backRing2degreeOffsetMiddleStart;
    private List<BigDecimalPoint> backRing2Middle;

    private BigDecimal backRingLineSlopeZero = new BigDecimal(0);
    private BigDecimal backRingLineSlopePos = new BigDecimal(Math.sqrt(3), mc);
    private BigDecimal backRingLineSlopeNeg = backRingLineSlopePos.negate();

    private BigDecimalLine backRingLine3to6middle = new BigDecimalLine();
    private BigDecimalLine backRingLine6to9middle = new BigDecimalLine();
    private BigDecimalLine backRingLine9to3middle = new BigDecimalLine();
    private BigDecimalLine backRingLine1to2middle = new BigDecimalLine();
    private BigDecimalLine backRingLine2to4middle = new BigDecimalLine();
    private BigDecimalLine backRingLine4to8middle = new BigDecimalLine();
    private BigDecimalLine backRingLine8to7middle = new BigDecimalLine();
    private BigDecimalLine backRingLine7to5middle = new BigDecimalLine();
    private BigDecimalLine backRingLine5to1middle = new BigDecimalLine();
    private BigDecimalLine backRingLine3to6top = new BigDecimalLine();
    private BigDecimalLine backRingLine6to9top = new BigDecimalLine();
    private BigDecimalLine backRingLine9to3top = new BigDecimalLine();
    private BigDecimalLine backRingLine1to2top = new BigDecimalLine();
    private BigDecimalLine backRingLine2to4top = new BigDecimalLine();
    private BigDecimalLine backRingLine4to8top = new BigDecimalLine();
    private BigDecimalLine backRingLine8to7top = new BigDecimalLine();
    private BigDecimalLine backRingLine7to5top = new BigDecimalLine();
    private BigDecimalLine backRingLine5to1top = new BigDecimalLine();
    private BigDecimalLine backRingLine3to6bottom = new BigDecimalLine();
    private BigDecimalLine backRingLine6to9bottom = new BigDecimalLine();
    private BigDecimalLine backRingLine9to3bottom = new BigDecimalLine();
    private BigDecimalLine backRingLine1to2bottom = new BigDecimalLine();
    private BigDecimalLine backRingLine2to4bottom = new BigDecimalLine();
    private BigDecimalLine backRingLine4to8bottom = new BigDecimalLine();
    private BigDecimalLine backRingLine8to7bottom = new BigDecimalLine();
    private BigDecimalLine backRingLine7to5bottom = new BigDecimalLine();
    private BigDecimalLine backRingLine5to1bottom = new BigDecimalLine();

    private BigDecimalCircle backRingCircle = new BigDecimalCircle(new BigDecimal(1420));
    private BigDecimalCircle backRingMiddleCircle = new BigDecimalCircle(new BigDecimal(210));

    private List<BigDecimalPoint> backRing3pointCurvedSection1to2;
    private List<BigDecimalPoint> backRing3pointCurvedSection7to8;
    private List<BigDecimalPoint> backRing3pointStraightSection3;
    private List<BigDecimalPoint> backRing3pointStraightSection4;
    private List<BigDecimalPoint> backRing3pointStraightSection5;
    private List<BigDecimalPoint> backRing3pointStraightSection6;
    private List<BigDecimalPoint> backRing3pointStraightSectionBelowZero;

    private List<BigDecimalPoint> backRing4pointCurvedSection2to3;
    private List<BigDecimalPoint> backRing4pointCurvedSection3to4;
    private List<BigDecimalPoint> backRing4pointCurvedSection5to6;
    private List<BigDecimalPoint> backRing4pointCurvedSection6to7;
    private List<BigDecimalPoint> backRing4pointCurvedSection8to9;
    private List<BigDecimalPoint> backRing4pointCurvedSection9to1;
    private List<BigDecimalPoint> backRing4pointCurvedSectionBelowZero;
    private List<BigDecimalPoint> backRing4pointStraightSection1to2;
    private List<BigDecimalPoint> backRing4pointStraightSection7to8;

    private List<BigDecimalPoint> backRing5pointCurvedSection4to5;
    private List<BigDecimalPoint> backRing5pointStraightSectionLeft;
    private List<BigDecimalPoint> backRing5pointStraightSectionRight;

    private List<BigDecimalPoint> backRing6pointCurvedSectionAboveZero;

    private void printValues() {

        System.out.println("");

        System.out.println("Ring 7 circumference = " + ring7circumference);
        System.out.println("Ring 7 degree offset = " + ring7degreeOffset);
        System.out.println("Ring 7 sin offset = " + ring7sinOffset);
        System.out.println("Ring 7 cos offset = " + ring7cosOffset);

        System.out.println("");

        System.out.println("Ring 7 outer top-left = (" + outerRing7topLeft.x+ ", " + outerRing7topLeft.y + ")");
        System.out.println("Ring 7 outer top-right = (" + outerRing7topRight.x+ ", " + outerRing7topRight.y + ")");
        System.out.println("Ring 7 outer bottom-left = (" + outerRing7bottomLeft.x+ ", " + outerRing7bottomLeft.y + ")");
        System.out.println("Ring 7 outer bottom-right = (" + outerRing7bottomRight.x+ ", " + outerRing7bottomRight.y + ")");
        System.out.println("Ring 7 outer left-top = (" + outerRing7leftTop.x+ ", " + outerRing7leftTop.y + ")");
        System.out.println("Ring 7 outer left-bottom = (" + outerRing7leftBottom.x+ ", " + outerRing7leftBottom.y + ")");
        System.out.println("Ring 7 outer right-top = (" + outerRing7rightTop.x+ ", " + outerRing7rightTop.y + ")");
        System.out.println("Ring 7 outer right-bottom = (" + outerRing7rightBottom.x+ ", " + outerRing7rightBottom.y + ")");
        System.out.println("Ring 7 outer top-middle = (" + outerRing7topMiddle.x+ ", " + outerRing7topMiddle.y + ")");
        System.out.println("Ring 7 outer bottom-middle = (" + outerRing7bottomMiddle.x+ ", " + outerRing7bottomMiddle.y + ")");
        System.out.println("Ring 7 outer left-middle = (" + outerRing7leftMiddle.x+ ", " + outerRing7leftMiddle.y + ")");
        System.out.println("Ring 7 outer right-middle = (" + outerRing7rightMiddle.x+ ", " + outerRing7rightMiddle.y + ")");

        System.out.println("");

        System.out.println("Ring 6 circumference = " + ring6circumference);
        System.out.println("Ring 6 degree offset = " + ring6degreeOffset);
        System.out.println("Ring 6 sin offset = " + ring6sinOffset);
        System.out.println("Ring 6 cos offset = " + ring6cosOffset);

        System.out.println("");

        System.out.println("Ring 6 inner top-left = (" + innerRing6topLeft.x+ ", " + innerRing6topLeft.y + ")");
        System.out.println("Ring 6 inner top-right = (" + innerRing6topRight.x+ ", " + innerRing6topRight.y + ")");
        System.out.println("Ring 6 inner bottom-left = (" + innerRing6bottomLeft.x+ ", " + innerRing6bottomLeft.y + ")");
        System.out.println("Ring 6 inner bottom-right = (" + innerRing6bottomRight.x+ ", " + innerRing6bottomRight.y + ")");
        System.out.println("Ring 6 inner left-top = (" + innerRing6leftTop.x+ ", " + innerRing6leftTop.y + ")");
        System.out.println("Ring 6 inner left-bottom = (" + innerRing6leftBottom.x+ ", " + innerRing6leftBottom.y + ")");
        System.out.println("Ring 6 inner right-top = (" + innerRing6rightTop.x+ ", " + innerRing6rightTop.y + ")");
        System.out.println("Ring 6 inner right-bottom = (" + innerRing6rightBottom.x+ ", " + innerRing6rightBottom.y + ")");
        System.out.println("Ring 6 inner top-middle = (" + innerRing6topMiddle.x+ ", " + innerRing6topMiddle.y + ")");
        System.out.println("Ring 6 inner bottom-middle = (" + innerRing6bottomMiddle.x+ ", " + innerRing6bottomMiddle.y + ")");
        System.out.println("Ring 6 inner left-middle = (" + innerRing6leftMiddle.x+ ", " + innerRing6leftMiddle.y + ")");
        System.out.println("Ring 6 inner right-middle = (" + innerRing6rightMiddle.x+ ", " + innerRing6rightMiddle.y + ")");

        System.out.println("");

        System.out.println("Ring 5 circumference = " + ring5circumference);
        System.out.println("Ring 5 degree offset outer = " + ring5degreeOffsetOuter);
        System.out.println("Ring 5 degree offset inner = " + ring5degreeOffsetInner);
        System.out.println("Ring 5 degree offset middle = " + ring5degreeOffsetMiddle);
        System.out.println("Ring 5 sin offset outer = " + ring5sinOffsetOuter);
        System.out.println("Ring 5 cos offset outer = " + ring5cosOffsetOuter);
        System.out.println("Ring 5 sin offset inner = " + ring5sinOffsetInner);
        System.out.println("Ring 5 cos offset inner = " + ring5cosOffsetInner);
        System.out.println("Ring 5 sin offset middle = " + ring5sinOffsetMiddle);
        System.out.println("Ring 5 cos offset middle = " + ring5cosOffsetMiddle);

        System.out.println("");

        System.out.println("Ring 5 outer top-left x = (" + outerRing5topLeft.x + ", " + outerRing5topLeft.y + ")");
        System.out.println("Ring 5 outer top-right x = (" + outerRing5topRight.x + ", " + outerRing5topRight.y + ")");
        System.out.println("Ring 5 outer bottom-left x = (" + outerRing5bottomLeft.x + ", " + outerRing5bottomLeft.y + ")");
        System.out.println("Ring 5 outer bottom-right x = (" + outerRing5bottomRight.x + ", " + outerRing5bottomRight.y + ")");
        System.out.println("Ring 5 outer left-top x = (" + outerRing5leftTop.x + ", " + outerRing5leftTop.y + ")");
        System.out.println("Ring 5 outer left-bottom x = (" + outerRing5leftBottom.x + ", " + outerRing5leftBottom.y + ")");
        System.out.println("Ring 5 outer right-top x = (" + outerRing5rightTop.x + ", " + outerRing5rightTop.y + ")");
        System.out.println("Ring 5 outer right-bottom x = (" + outerRing5rightBottom.x + ", " + outerRing5rightBottom.y + ")");
        System.out.println("Ring 5 outer top-left-middle x = (" + outerRing5topLeftMiddle.x + ", " + outerRing5topLeftMiddle.y + ")");
        System.out.println("Ring 5 outer top-right-middle x = (" + outerRing5topRightMiddle.x + ", " + outerRing5topRightMiddle.y + ")");
        System.out.println("Ring 5 outer bottom-left-middle x = (" + outerRing5bottomLeftMiddle.x + ", " + outerRing5bottomLeftMiddle.y + ")");
        System.out.println("Ring 5 outer bottom-right-middle x = (" + outerRing5bottomRightMiddle.x + ", " + outerRing5bottomRightMiddle.y + ")");

        System.out.println("");

        System.out.println("Ring 5 inner top-left x = (" + innerRing5topLeft.x + ", " + innerRing5topLeft.y + ")");
        System.out.println("Ring 5 inner top-right x = (" + innerRing5topRight.x + ", " + innerRing5topRight.y + ")");
        System.out.println("Ring 5 inner bottom-left x = (" + innerRing5bottomLeft.x + ", " + innerRing5bottomLeft.y + ")");
        System.out.println("Ring 5 inner bottom-right x = (" + innerRing5bottomRight.x + ", " + innerRing5bottomRight.y + ")");
        System.out.println("Ring 5 inner left-top x = (" + innerRing5leftTop.x + ", " + innerRing5leftTop.y + ")");
        System.out.println("Ring 5 inner left-bottom x = (" + innerRing5leftBottom.x + ", " + innerRing5leftBottom.y + ")");
        System.out.println("Ring 5 inner right-top x = (" + innerRing5rightTop.x + ", " + innerRing5rightTop.y + ")");
        System.out.println("Ring 5 inner right-bottom x = (" + innerRing5rightBottom.x + ", " + innerRing5rightBottom.y + ")");
        System.out.println("Ring 5 inner top-middle x = (" + innerRing5topMiddle.x + ", " + innerRing5topMiddle.y + ")");
        System.out.println("Ring 5 inner bottom-middle x = (" + innerRing5bottomMiddle.x + ", " + innerRing5bottomMiddle.y + ")");
        System.out.println("Ring 5 inner left-middle x = (" + innerRing5leftMiddle.x + ", " + innerRing5leftMiddle.y + ")");
        System.out.println("Ring 5 inner right-middle x = (" + innerRing5rightMiddle.x + ", " + innerRing5rightMiddle.y + ")");

        System.out.println("");

        System.out.println("Rings 1 to 4 degrees per section = " + degreeSectionOffset);

        System.out.println("");

        System.out.println("Ring 4 circumference = " + ring4circumference);
        System.out.println("Ring 4 degree offset = " + ring4degreeOffset);

        System.out.println("");

        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Ring 4 section " + (i+1) + " point " + (j+1) + " = (" + ring4.get(i).get(j).x + ", " + ring4.get(i).get(j).y + ")");
            }
        }

        System.out.println("");

        System.out.println("Ring 3 circumference = " + ring3circumference);
        System.out.println("Ring 3 degree offset = " + ring3degreeOffset);

        System.out.println("");

        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Ring 3 section " + (i+1) + " point " + (j+1) + " = (" + ring3.get(i).get(j).x + ", " + ring3.get(i).get(j).y + ")");
            }
        }

        System.out.println("");

        System.out.println("Ring 2 circumference = " + ring2circumference);
        System.out.println("Ring 2 degree offset = " + ring2degreeOffset);

        System.out.println("");

        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Ring 2 section " + (i+1) + " point " + (j+1) + " = (" + ring2.get(i).get(j).x + ", " + ring2.get(i).get(j).y + ")");
            }
        }

        System.out.println("");

        System.out.println("Ring 1 circumference = " + ring1circumference);
        System.out.println("Ring 1 degree offset = " + ring1degreeOffset);

        System.out.println("");

        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Ring 1 section " + (i+1) + " point " + (j+1) + " = (" + ring1.get(i).get(j).x + ", " + ring1.get(i).get(j).y + ")");
            }
        }

        System.out.println("");

        System.out.println("Back Rings 3 and 4 degrees per section = " + degreeBackSectionOffset);

        System.out.println("");

        System.out.println("Back Ring 4 circumference = " + ring4circumference);
        System.out.println("Back Ring 4 degree offset = " + backRing4degreeOffset);

        System.out.println("");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Back Ring 4 section " + (i+1) + " point " + (j+1) + " = (" + backRing4.get(i).get(j).x + ", " + backRing4.get(i).get(j).y + ")");
            }
        }

        System.out.println("");

        System.out.println("Back Ring 3 circumference = " + ring3circumference);
        System.out.println("Back Ring 3 degree offset = " + backRing3degreeOffset);

        System.out.println("");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Back Ring 3 section " + (i+1) + " point " + (j+1) + " = (" + backRing3.get(i).get(j).x + ", " + backRing3.get(i).get(j).y + ")");
            }
        }

        System.out.println("");

        System.out.println("Back Ring 2 circumference = " + backRing2circumference);
        System.out.println("Back Ring 2 degree offset = " + backRing2degreeOffset);

        System.out.println("");

        for (int i = 0; i < 9; i++) {
            System.out.println("Back Ring 2 point " + (i+1) + " = (" + backRing2.get(i).x + ", " + backRing2.get(i).y + ")");
        }

        System.out.println("");

        for (int i = 0; i < 9; i++) {
            System.out.println("Back Ring 2 middle point " + (i+1) + " = (" + backRing2Middle.get(i).x + ", " + backRing2Middle.get(i).y + ")");
        }

        System.out.println("");

        System.out.println("Back Ring Line Zero Slope = " + backRingLineSlopeZero);
        System.out.println("Back Ring Line Pos Slope = " + backRingLineSlopePos);
        System.out.println("Back Ring Line Neg Slope = " + backRingLineSlopeNeg);

        System.out.println("");

        System.out.println("Back Ring 4-point Curved Section 2to3 point 1 = (" + backRingCircle.getIntersectionPoints(backRingLine9to3top).get(0).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine9to3top).get(0).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 2to3 point 2 = (" + backRingCircle.getIntersectionPoints(backRingLine2to4bottom).get(0).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine2to4bottom).get(0).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 3to4 point 1 = (" + backRingCircle.getIntersectionPoints(backRingLine2to4bottom).get(1).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine2to4bottom).get(1).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 3to4 point 2 = (" + backRingCircle.getIntersectionPoints(backRingLine3to6bottom).get(0).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine3to6bottom).get(0).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 5to6 point 1 = (" + backRingCircle.getIntersectionPoints(backRingLine7to5bottom).get(0).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine7to5bottom).get(0).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 5to6 point 2 = (" + backRingCircle.getIntersectionPoints(backRingLine3to6bottom).get(1).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine3to6bottom).get(1).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 6to7 point 1 = (" + backRingCircle.getIntersectionPoints(backRingLine7to5bottom).get(1).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine7to5bottom).get(1).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 6to7 point 2 = (" + backRingCircle.getIntersectionPoints(backRingLine6to9top).get(1).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine6to9top).get(1).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 8to9 point 1 = (" + backRingCircle.getIntersectionPoints(backRingLine4to8top).get(1).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine4to8top).get(1).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 8to9 point 2 = (" + backRingCircle.getIntersectionPoints(backRingLine6to9top).get(0).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine6to9top).get(0).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 9to1 point 1 = (" + backRingCircle.getIntersectionPoints(backRingLine9to3top).get(1).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine9to3top).get(1).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section 9to1 point 2 = (" + backRingCircle.getIntersectionPoints(backRingLine5to1top).get(0).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine5to1top).get(0).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section BelowZero point 1 = (" + backRingMiddleCircle.getIntersectionPoints(backRingLine4to8top).get(0).getX() + ", " + backRingMiddleCircle.getIntersectionPoints(backRingLine4to8top).get(0).getY() + ")");
        System.out.println("Back Ring 4-point Curved Section BelowZero point 2 = (" + backRingMiddleCircle.getIntersectionPoints(backRingLine5to1top).get(1).getX() + ", " + backRingMiddleCircle.getIntersectionPoints(backRingLine5to1top).get(1).getY() + ")");
        System.out.println("Back Ring 5-point Curved Section 4to5 point 1 = (" + backRingCircle.getIntersectionPoints(backRingLine4to8bottom).get(0).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine4to8bottom).get(0).getY() + ")");
        System.out.println("Back Ring 5-point Curved Section 4to5 point 2 = (" + backRingCircle.getIntersectionPoints(backRingLine5to1bottom).get(1).getX() + ", " + backRingCircle.getIntersectionPoints(backRingLine5to1bottom).get(1).getY() + ")");
        System.out.println("Back Ring 6-point Curved Section AboveZero point 1 = (" + backRingMiddleCircle.getIntersectionPoints(backRingLine4to8top).get(0).getX() + ", " + backRingMiddleCircle.getIntersectionPoints(backRingLine4to8top).get(0).getY() + ")");
        System.out.println("Back Ring 6-point Curved Section AboveZero point 2 = (" + backRingMiddleCircle.getIntersectionPoints(backRingLine5to1top).get(1).getX() + ", " + backRingMiddleCircle.getIntersectionPoints(backRingLine5to1top).get(1).getY() + ")");

        System.out.println("");

    }

    private void printScript() {

        if (inMM) {
            wallWidth = wallWidth.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
            zThickness = zThickness.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
            zDepth = zDepth.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
            zOffset = zOffset.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
            innerCircle5radius = innerCircle5radius.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
            innerCircle4radius = innerCircle4radius.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
            innerCircle3radius = innerCircle3radius.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
            innerCircle2radius = innerCircle2radius.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
            innerCircle1radius = innerCircle1radius.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
            ring2radius = ring2radius.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
            backCircle0InnerRadius = backCircle0InnerRadius.divide(thousand, mc).multiply(mmPerInch).setScale(4, RoundingMode.HALF_UP);
        }

        System.out.println("import Part\n" +
                "import Draft\n" +
                "import FreeCAD as App\n" +
                "from FreeCAD import Vector\n" +
                "from FreeCAD import Base\n" +
                "import BOPTools.JoinFeatures\n" +
                "doc = App.newDocument()\n" +
                "\n" +
                "v1 = Vector(" + outerRing5topLeft.getX() + ", " + outerRing5topLeft.getY() + ", 0)\n" +
                "v2 = Vector(" + outerRing7topLeft.getX() + ", " + outerRing7topLeft.getY() + ", 0)\n" +
                "v3 = Vector(" + outerRing7topRight.getX() + ", " + outerRing7topRight.getY() + ", 0)\n" +
                "v4 = Vector(" + outerRing5topRight.getX() + ", " + outerRing5topRight.getY() + ", 0)\n" +
                "v5 = Vector(" + outerRing5rightTop.getX() + ", " + outerRing5rightTop.getY() + ", 0)\n" +
                "v6 = Vector(" + outerRing7rightTop.getX() + ", " + outerRing7rightTop.getY() + ", 0)\n" +
                "v7 = Vector(" + outerRing7rightBottom.getX() + ", " + outerRing7rightBottom.getY() + ", 0)\n" +
                "v8 = Vector(" + outerRing5rightBottom.getX() + ", " + outerRing5rightBottom.getY() + ", 0)\n" +
                "v9 = Vector(" + outerRing5bottomRight.getX() + ", " + outerRing5bottomRight.getY() + ", 0)\n" +
                "v10 = Vector(" + outerRing7bottomRight.getX() + ", " + outerRing7bottomRight.getY() + ", 0)\n" +
                "v11 = Vector(" + outerRing7bottomLeft.getX() + ", " + outerRing7bottomLeft.getY() + ", 0)\n" +
                "v12 = Vector(" + outerRing5bottomLeft.getX() + ", " + outerRing5bottomLeft.getY() + ", 0)\n" +
                "v13 = Vector(" + outerRing5leftBottom.getX() + ", " + outerRing5leftBottom.getY() + ", 0)\n" +
                "v14 = Vector(" + outerRing7leftBottom.getX() + ", " + outerRing7leftBottom.getY() + ", 0)\n" +
                "v15 = Vector(" + outerRing7leftTop.getX() + ", " + outerRing7leftTop.getY() + ", 0)\n" +
                "v16 = Vector(" + outerRing5leftTop.getX() + ", " + outerRing5leftTop.getY() + ", 0)\n" +
                "\n" +
                "L1 = Part.LineSegment(v1, v2)\n" +
                "L2 = Part.LineSegment(v3, v4)\n" +
                "L3 = Part.LineSegment(v5, v6)\n" +
                "L4 = Part.LineSegment(v7, v8)\n" +
                "L5 = Part.LineSegment(v9, v10)\n" +
                "L6 = Part.LineSegment(v11, v12)\n" +
                "L7 = Part.LineSegment(v13, v14)\n" +
                "L8 = Part.LineSegment(v15, v16)\n" +
                "\n" +
                "vc1 = Vector(" + outerRing7topMiddle.getX() + ", " + outerRing7topMiddle.getY() + ", 0)\n" +
                "vc2 = Vector(" + outerRing5topRightMiddle.getX() + ", " + outerRing5topRightMiddle.getY() + ", 0)\n" +
                "vc3 = Vector(" + outerRing7rightMiddle.getX() + ", " + outerRing7rightMiddle.getY() + ", 0)\n" +
                "vc4 = Vector(" + outerRing5bottomRightMiddle.getX() + ", " + outerRing5bottomRightMiddle.getY() + ", 0)\n" +
                "vc5 = Vector(" + outerRing7bottomMiddle.getX() + ", " + outerRing7bottomMiddle.getY() + ", 0)\n" +
                "vc6 = Vector(" + outerRing5bottomLeftMiddle.getX() + ", " + outerRing5bottomLeftMiddle.getY() + ", 0)\n" +
                "vc7 = Vector(" + outerRing7leftMiddle.getX() + ", " + outerRing7leftMiddle.getY() + ", 0)\n" +
                "vc8 = Vector(" + outerRing5topLeftMiddle.getX() + ", " + outerRing5topLeftMiddle.getY() + ", 0)\n" +
                "\n" +
                "C1 = Part.Arc(v2, vc1, v3)\n" +
                "C2 = Part.Arc(v4, vc2, v5)\n" +
                "C3 = Part.Arc(v6, vc3, v7)\n" +
                "C4 = Part.Arc(v8, vc4, v9)\n" +
                "C5 = Part.Arc(v10, vc5, v11)\n" +
                "C6 = Part.Arc(v12, vc6, v13)\n" +
                "C7 = Part.Arc(v14, vc7, v15)\n" +
                "C8 = Part.Arc(v16, vc8, v1)\n" +
                "\n" +
                "S1 = Part.Shape([L1, C1, L2, C2, L3, C3, L4, C4, L5, C5, L6, C6, L7, C7, L8, C8])\n" +
                "W1 = Part.Wire(S1.Edges)\n" +
                "F1 = Part.Face(W1)\n" +
                "P1 = F1.extrude(Vector(0, 0, " + zThickness + "))\n" +
                "Part.show(P1)\n" +
                "\n" +
                "v17 = Vector(" + innerRing5topLeft.getX() + ", " + innerRing5topLeft.getY() + ", 0)\n" +
                "v18 = Vector(" + innerRing6topLeft.getX() + ", " + innerRing6topLeft.getY() + ", 0)\n" +
                "v19 = Vector(" + innerRing6topRight.getX() + ", " + innerRing6topRight.getY() + ", 0)\n" +
                "v20 = Vector(" + innerRing5topRight.getX() + ", " + innerRing5topRight.getY() + ", 0)\n" +
                "\n" +
                "L9 = Part.LineSegment(v17, v18)\n" +
                "L10 = Part.LineSegment(v19, v20)\n" +
                "\n" +
                "vc9 = Vector(" + innerRing5topMiddle.getX() + ", " + innerRing5topMiddle.getY() + ", 0)\n" +
                "vc10 = Vector(" + innerRing6topMiddle.getX() + ", " + innerRing6topMiddle.getY() + ", 0)\n" +
                "\n" +
                "C9 = Part.Arc(v17, vc9, v20)\n" +
                "C10 = Part.Arc(v18, vc10, v19)\n" +
                "\n" +
                "S2 = Part.Shape([L9, C9, L10, C10])\n" +
                "W2 = Part.Wire(S2.Edges)\n" +
                "F2 = Part.Face(W2)\n" +
                "P2 = F2.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P2)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut1\")\n" +
                "App.activeDocument().Cut1.Base = App.activeDocument().Shape\n" +
                "App.activeDocument().Cut1.Tool = App.activeDocument().Shape001\n" +
                "App.ActiveDocument.recompute()\n" +
                "\n" +
                "v21 = Vector(" + innerRing5rightTop.getX() + ", " + innerRing5rightTop.getY() + ", 0)\n" +
                "v22 = Vector(" + innerRing6rightTop.getX() + ", " + innerRing6rightTop.getY() + ", 0)\n" +
                "v23 = Vector(" + innerRing6rightBottom.getX() + ", " + innerRing6rightBottom.getY() + ", 0)\n" +
                "v24 = Vector(" + innerRing5rightBottom.getX() + ", " + innerRing5rightBottom.getY() + ", 0)\n" +
                "\n" +
                "L11 = Part.LineSegment(v21, v22)\n" +
                "L12 = Part.LineSegment(v23, v24)\n" +
                "\n" +
                "vc11 = Vector(" + innerRing5rightMiddle.getX() + ", " + innerRing5rightMiddle.getY() + ", 0)\n" +
                "vc12 = Vector(" + innerRing6rightMiddle.getX() + ", " + innerRing6rightMiddle.getY() + ", 0)\n" +
                "\n" +
                "C11 = Part.Arc(v21, vc11, v24)\n" +
                "C12 = Part.Arc(v22, vc12, v23)\n" +
                "\n" +
                "S3 = Part.Shape([L11, C11, L12, C12])\n" +
                "W3 = Part.Wire(S3.Edges)\n" +
                "F3 = Part.Face(W3)\n" +
                "P3 = F3.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P3)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut2\")\n" +
                "App.activeDocument().Cut2.Base = App.activeDocument().Cut1\n" +
                "App.activeDocument().Cut2.Tool = App.activeDocument().Shape002\n" +
                "App.ActiveDocument.recompute()\n" +
                "\n" +
                "v25 = Vector(" + innerRing5bottomRight.getX() + ", " + innerRing5bottomRight.getY() + ", 0)\n" +
                "v26 = Vector(" + innerRing6bottomRight.getX() + ", " + innerRing6bottomRight.getY() + ", 0)\n" +
                "v27 = Vector(" + innerRing6bottomLeft.getX() + ", " + innerRing6bottomLeft.getY() + ", 0)\n" +
                "v28 = Vector(" + innerRing5bottomLeft.getX() + ", " + innerRing5bottomLeft.getY() + ", 0)\n" +
                "\n" +
                "L13 = Part.LineSegment(v25, v26)\n" +
                "L14 = Part.LineSegment(v27, v28)\n" +
                "\n" +
                "vc13 = Vector(" + innerRing5bottomMiddle.getX() + ", " + innerRing5bottomMiddle.getY() + ", 0)\n" +
                "vc14 = Vector(" + innerRing6bottomMiddle.getX() + ", " + innerRing6bottomMiddle.getY() + ", 0)\n" +
                "\n" +
                "C13 = Part.Arc(v25, vc13, v28)\n" +
                "C14 = Part.Arc(v26, vc14, v27)\n" +
                "\n" +
                "S4 = Part.Shape([L13, C13, L14, C14])\n" +
                "W4 = Part.Wire(S4.Edges)\n" +
                "F4 = Part.Face(W4)\n" +
                "P4 = F4.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P4)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut3\")\n" +
                "App.activeDocument().Cut3.Base = App.activeDocument().Cut2\n" +
                "App.activeDocument().Cut3.Tool = App.activeDocument().Shape003\n" +
                "App.ActiveDocument.recompute()\n" +
                "\n" +
                "v29 = Vector(" + innerRing5leftBottom.getX() + ", " + innerRing5leftBottom.getY() + ", 0)\n" +
                "v30 = Vector(" + innerRing6leftBottom.getX() + ", " + innerRing6leftBottom.getY() + ", 0)\n" +
                "v31 = Vector(" + innerRing6leftTop.getX() + ", " + innerRing6leftTop.getY() + ", 0)\n" +
                "v32 = Vector(" + innerRing5leftTop.getX() + ", " + innerRing5leftTop.getY() + ", 0)\n" +
                "\n" +
                "L15 = Part.LineSegment(v29, v30)\n" +
                "L16 = Part.LineSegment(v31, v32)\n" +
                "\n" +
                "vc15 = Vector(" + innerRing5leftMiddle.getX() + ", " + innerRing5leftMiddle.getY() + ", 0)\n" +
                "vc16 = Vector(" + innerRing6leftMiddle.getX() + ", " + innerRing6leftMiddle.getY() + ", 0)\n" +
                "\n" +
                "C15 = Part.Arc(v29, vc15, v32)\n" +
                "C16 = Part.Arc(v30, vc16, v31)\n" +
                "\n" +
                "S5 = Part.Shape([L15, C15, L16, C16])\n" +
                "W5 = Part.Wire(S5.Edges)\n" +
                "F5 = Part.Face(W5)\n" +
                "P5 = F5.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P5)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut4\")\n" +
                "App.activeDocument().Cut4.Base = App.activeDocument().Cut3\n" +
                "App.activeDocument().Cut4.Tool = App.activeDocument().Shape004\n" +
                "App.ActiveDocument.recompute()\n" +
                "\n" +
                "v33 = Vector(" + innerRing5topLeft.getX() + ", " + innerRing5topLeft.getY() + ", " + zOffset + ")\n" +
                "v34 = Vector(" + innerRing6topLeft.getX() + ", " + innerRing6topLeft.getY() + ", " + zOffset + ")\n" +
                "v35 = Vector(" + innerRing6topRight.getX() + ", " + innerRing6topRight.getY() + ", " + zOffset + ")\n" +
                "v36 = Vector(" + innerRing5topRight.getX() + ", " + innerRing5topRight.getY() + ", " + zOffset + ")\n" +
                "\n" +
                "L17 = Part.LineSegment(v33, v34)\n" +
                "L18 = Part.LineSegment(v35, v36)\n" +
                "\n" +
                "vc17 = Vector(" + innerRing5topMiddle.getX() + ", " + innerRing5topMiddle.getY() + ", " + zOffset + ")\n" +
                "vc18 = Vector(" + innerRing6topMiddle.getX() + ", " + innerRing6topMiddle.getY() + ", " + zOffset + ")\n" +
                "\n" +
                "C17 = Part.Arc(v33, vc17, v36)\n" +
                "C18 = Part.Arc(v34, vc18, v35)\n" +
                "\n" +
                "S6 = Part.Shape([L17, C17, L18, C18])\n" +
                "W6 = Part.Wire(S6.Edges)\n" +
                "F6 = Part.Face(W6)\n" +
                "P6 = F6.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P6)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut5\")\n" +
                "App.activeDocument().Cut5.Base = App.activeDocument().Cut4\n" +
                "App.activeDocument().Cut5.Tool = App.activeDocument().Shape005\n" +
                "App.ActiveDocument.recompute()\n" +
                "\n" +
                "v37 = Vector(" + innerRing5rightTop.getX() + ", " + innerRing5rightTop.getY() + ", " + zOffset + ")\n" +
                "v38 = Vector(" + innerRing6rightTop.getX() + ", " + innerRing6rightTop.getY() + ", " + zOffset + ")\n" +
                "v39 = Vector(" + innerRing6rightBottom.getX() + ", " + innerRing6rightBottom.getY() + ", " + zOffset + ")\n" +
                "v40 = Vector(" + innerRing5rightBottom.getX() + ", " + innerRing5rightBottom.getY() + ", " + zOffset + ")\n" +
                "\n" +
                "L19 = Part.LineSegment(v37, v38)\n" +
                "L20 = Part.LineSegment(v39, v40)\n" +
                "\n" +
                "vc19 = Vector(" + innerRing5rightMiddle.getX() + ", " + innerRing5rightMiddle.getY() + ", " + zOffset + ")\n" +
                "vc20 = Vector(" + innerRing6rightMiddle.getX() + ", " + innerRing6rightMiddle.getY() + ", " + zOffset + ")\n" +
                "\n" +
                "C19 = Part.Arc(v37, vc19, v40)\n" +
                "C20 = Part.Arc(v38, vc20, v39)\n" +
                "\n" +
                "S7 = Part.Shape([L19, C19, L20, C20])\n" +
                "W7 = Part.Wire(S7.Edges)\n" +
                "F7 = Part.Face(W7)\n" +
                "P7 = F7.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P7)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut6\")\n" +
                "App.activeDocument().Cut6.Base = App.activeDocument().Cut5\n" +
                "App.activeDocument().Cut6.Tool = App.activeDocument().Shape006\n" +
                "App.ActiveDocument.recompute()\n" +
                "\n" +
                "v41 = Vector(" + innerRing5bottomRight.getX() + ", " + innerRing5bottomRight.getY() + ", " + zOffset + ")\n" +
                "v42 = Vector(" + innerRing6bottomRight.getX() + ", " + innerRing6bottomRight.getY() + ", " + zOffset + ")\n" +
                "v43 = Vector(" + innerRing6bottomLeft.getX() + ", " + innerRing6bottomLeft.getY() + ", " + zOffset + ")\n" +
                "v44 = Vector(" + innerRing5bottomLeft.getX() + ", " + innerRing5bottomLeft.getY() + ", " + zOffset + ")\n" +
                "\n" +
                "L21 = Part.LineSegment(v41, v42)\n" +
                "L22 = Part.LineSegment(v43, v44)\n" +
                "\n" +
                "vc21 = Vector(" + innerRing5bottomMiddle.getX() + ", " + innerRing5bottomMiddle.getY() + ", " + zOffset + ")\n" +
                "vc22 = Vector(" + innerRing6bottomMiddle.getX() + ", " + innerRing6bottomMiddle.getY() + ", " + zOffset + ")\n" +
                "\n" +
                "C21 = Part.Arc(v41, vc21, v44)\n" +
                "C22 = Part.Arc(v42, vc22, v43)\n" +
                "\n" +
                "S8 = Part.Shape([L21, C21, L22, C22])\n" +
                "W8 = Part.Wire(S8.Edges)\n" +
                "F8 = Part.Face(W8)\n" +
                "P8 = F8.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P8)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut7\")\n" +
                "App.activeDocument().Cut7.Base = App.activeDocument().Cut6\n" +
                "App.activeDocument().Cut7.Tool = App.activeDocument().Shape007\n" +
                "App.ActiveDocument.recompute()\n" +
                "\n" +
                "v45 = Vector(" + innerRing5leftBottom.getX() + ", " + innerRing5leftBottom.getY() + ", " + zOffset + ")\n" +
                "v46 = Vector(" + innerRing6leftBottom.getX() + ", " + innerRing6leftBottom.getY() + ", " + zOffset + ")\n" +
                "v47 = Vector(" + innerRing6leftTop.getX() + ", " + innerRing6leftTop.getY() + ", " + zOffset + ")\n" +
                "v48 = Vector(" + innerRing5leftTop.getX() + ", " + innerRing5leftTop.getY() + ", " + zOffset + ")\n" +
                "\n" +
                "L23 = Part.LineSegment(v45, v46)\n" +
                "L24 = Part.LineSegment(v47, v48)\n" +
                "\n" +
                "vc23 = Vector(" + innerRing5leftMiddle.getX() + ", " + innerRing5leftMiddle.getY() + ", " + zOffset + ")\n" +
                "vc24 = Vector(" + innerRing6leftMiddle.getX() + ", " + innerRing6leftMiddle.getY() + ", " + zOffset + ")\n" +
                "\n" +
                "C23 = Part.Arc(v45, vc23, v48)\n" +
                "C24 = Part.Arc(v46, vc24, v47)\n" +
                "\n" +
                "S9 = Part.Shape([L23, C23, L24, C24])\n" +
                "W9 = Part.Wire(S9.Edges)\n" +
                "F9 = Part.Face(W9)\n" +
                "P9 = F9.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P9)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut8\")\n" +
                "App.activeDocument().Cut8.Base = App.activeDocument().Cut7\n" +
                "App.activeDocument().Cut8.Tool = App.activeDocument().Shape008\n" +
                "App.ActiveDocument.recompute()\n");

        int partIndex = 10;
        int vectorIndex = 49;
        int lineIndex = 25;
        int vcIndex = 25;
        int curveIndex = 25;
        int cutIndex = 9;

        for (int i = 0; i < 22; i++) {
            System.out.println("v" + vectorIndex + " = Vector(" + ring3.get(i).get(0).getX() + ", " + ring3.get(i).get(0).getY() + ", " + zOffset + ")");
            vectorIndex++;
            System.out.println("v" + vectorIndex + " = Vector(" + ring4.get(i).get(0).getX() + ", " + ring4.get(i).get(0).getY() + ", " + zOffset + ")");
            vectorIndex++;
            System.out.println("v" + vectorIndex + " = Vector(" + ring4.get(i).get(2).getX() + ", " + ring4.get(i).get(2).getY() + ", " + zOffset + ")");
            vectorIndex++;
            System.out.println("v" + vectorIndex + " = Vector(" + ring3.get(i).get(2).getX() + ", " + ring3.get(i).get(2).getY() + ", " + zOffset + ")");
            vectorIndex++;
            System.out.println("");
            System.out.println("L" + lineIndex + " = Part.LineSegment(v" + (vectorIndex-4) + ", v" + (vectorIndex-3) + ")");
            lineIndex++;
            System.out.println("L" + lineIndex + " = Part.LineSegment(v" + (vectorIndex-2) + ", v" + (vectorIndex-1) + ")");
            lineIndex++;
            System.out.println("");
            System.out.println("vc" + vcIndex + " = Vector(" + ring3.get(i).get(1).getX() + ", " + ring3.get(i).get(1).getY() + ", " + zOffset + ")");
            vcIndex++;
            System.out.println("vc" + vcIndex + " = Vector(" + ring4.get(i).get(1).getX() + ", " + ring4.get(i).get(1).getY() + ", " + zOffset + ")");
            vcIndex++;
            System.out.println("");
            System.out.println("C" + curveIndex + " = Part.Arc(v" + (vectorIndex-4) + ", vc" + (vcIndex-2) + ", v" + (vectorIndex-1) + ")");
            curveIndex++;
            System.out.println("C" + curveIndex + " = Part.Arc(v" + (vectorIndex-3) + ", vc" + (vcIndex-1) + ", v" + (vectorIndex-2) + ")");
            curveIndex++;
            System.out.println("");
            System.out.println("S" + partIndex + " = Part.Shape([L" + (lineIndex-2) + ", C" + (curveIndex-2) + ", L" + (lineIndex-1) + ", C" + (curveIndex-1) + "])");
            System.out.println("W" + partIndex + " = Part.Wire(S" + partIndex + ".Edges)");
            System.out.println("F" + partIndex + " = Part.Face(W" + partIndex + ")");
            System.out.println("P" + partIndex + " = F" + partIndex + ".extrude(Vector(0, 0, " + zDepth + "))");
            System.out.println("Part.show(P" + partIndex + ")");
            partIndex++;
            System.out.println("");
            System.out.println("App.activeDocument().addObject(\"Part::Cut\",\"Cut" + cutIndex + "\")");
            System.out.println("App.activeDocument().Cut" + cutIndex + ".Base = App.activeDocument().Cut" + (cutIndex-1));
            if (cutIndex < 10) System.out.println("App.activeDocument().Cut" + cutIndex + ".Tool = App.activeDocument().Shape00" + cutIndex);
            if (cutIndex >= 10) System.out.println("App.activeDocument().Cut" + cutIndex + ".Tool = App.activeDocument().Shape0" + cutIndex);
            System.out.println("App.ActiveDocument.recompute()");
            cutIndex++;
            System.out.println("");
        }

        for (int i = 0; i < 22; i++) {
            System.out.println("v" + vectorIndex + " = Vector(" + ring1.get(i).get(0).getX() + ", " + ring1.get(i).get(0).getY() + ", " + zOffset + ")");
            vectorIndex++;
            System.out.println("v" + vectorIndex + " = Vector(" + ring2.get(i).get(0).getX() + ", " + ring2.get(i).get(0).getY() + ", " + zOffset + ")");
            vectorIndex++;
            System.out.println("v" + vectorIndex + " = Vector(" + ring2.get(i).get(2).getX() + ", " + ring2.get(i).get(2).getY() + ", " + zOffset + ")");
            vectorIndex++;
            System.out.println("v" + vectorIndex + " = Vector(" + ring1.get(i).get(2).getX() + ", " + ring1.get(i).get(2).getY() + ", " + zOffset + ")");
            vectorIndex++;
            System.out.println("");
            System.out.println("L" + lineIndex + " = Part.LineSegment(v" + (vectorIndex-4) + ", v" + (vectorIndex-3) + ")");
            lineIndex++;
            System.out.println("L" + lineIndex + " = Part.LineSegment(v" + (vectorIndex-2) + ", v" + (vectorIndex-1) + ")");
            lineIndex++;
            System.out.println("");
            System.out.println("vc" + vcIndex + " = Vector(" + ring1.get(i).get(1).getX() + ", " + ring1.get(i).get(1).getY() + ", " + zOffset + ")");
            vcIndex++;
            System.out.println("vc" + vcIndex + " = Vector(" + ring2.get(i).get(1).getX() + ", " + ring2.get(i).get(1).getY() + ", " + zOffset + ")");
            vcIndex++;
            System.out.println("");
            System.out.println("C" + curveIndex + " = Part.Arc(v" + (vectorIndex-4) + ", vc" + (vcIndex-2) + ", v" + (vectorIndex-1) + ")");
            curveIndex++;
            System.out.println("C" + curveIndex + " = Part.Arc(v" + (vectorIndex-3) + ", vc" + (vcIndex-1) + ", v" + (vectorIndex-2) + ")");
            curveIndex++;
            System.out.println("");
            System.out.println("S" + partIndex + " = Part.Shape([L" + (lineIndex-2) + ", C" + (curveIndex-2) + ", L" + (lineIndex-1) + ", C" + (curveIndex-1) + "])");
            System.out.println("W" + partIndex + " = Part.Wire(S" + partIndex + ".Edges)");
            System.out.println("F" + partIndex + " = Part.Face(W" + partIndex + ")");
            System.out.println("P" + partIndex + " = F" + partIndex + ".extrude(Vector(0, 0, " + zDepth + "))");
            System.out.println("Part.show(P" + partIndex + ")");
            partIndex++;
            System.out.println("");
            System.out.println("App.activeDocument().addObject(\"Part::Cut\",\"Cut" + cutIndex + "\")");
            System.out.println("App.activeDocument().Cut" + cutIndex + ".Base = App.activeDocument().Cut" + (cutIndex-1));
            if (cutIndex < 10) System.out.println("App.activeDocument().Cut" + cutIndex + ".Tool = App.activeDocument().Shape00" + cutIndex);
            if (cutIndex >= 10) System.out.println("App.activeDocument().Cut" + cutIndex + ".Tool = App.activeDocument().Shape0" + cutIndex);
            System.out.println("App.ActiveDocument.recompute()");
            cutIndex++;
            System.out.println("");
        }

        for (int i = 0; i < 9; i++) {
            System.out.println("v" + vectorIndex + " = Vector(" + backRing3.get(i).get(0).getX() + ", " + backRing3.get(i).get(0).getY() + ", 0)");
            vectorIndex++;
            System.out.println("v" + vectorIndex + " = Vector(" + backRing4.get(i).get(0).getX() + ", " + backRing4.get(i).get(0).getY() + ", 0)");
            vectorIndex++;
            System.out.println("v" + vectorIndex + " = Vector(" + backRing4.get(i).get(2).getX() + ", " + backRing4.get(i).get(2).getY() + ", 0)");
            vectorIndex++;
            System.out.println("v" + vectorIndex + " = Vector(" + backRing3.get(i).get(2).getX() + ", " + backRing3.get(i).get(2).getY() + ", 0)");
            vectorIndex++;
            System.out.println("");
            System.out.println("L" + lineIndex + " = Part.LineSegment(v" + (vectorIndex-4) + ", v" + (vectorIndex-3) + ")");
            lineIndex++;
            System.out.println("L" + lineIndex + " = Part.LineSegment(v" + (vectorIndex-2) + ", v" + (vectorIndex-1) + ")");
            lineIndex++;
            System.out.println("");
            System.out.println("vc" + vcIndex + " = Vector(" + backRing3.get(i).get(1).getX() + ", " + backRing3.get(i).get(1).getY() + ", 0)");
            vcIndex++;
            System.out.println("vc" + vcIndex + " = Vector(" + backRing4.get(i).get(1).getX() + ", " + backRing4.get(i).get(1).getY() + ", 0)");
            vcIndex++;
            System.out.println("");
            System.out.println("C" + curveIndex + " = Part.Arc(v" + (vectorIndex-4) + ", vc" + (vcIndex-2) + ", v" + (vectorIndex-1) + ")");
            curveIndex++;
            System.out.println("C" + curveIndex + " = Part.Arc(v" + (vectorIndex-3) + ", vc" + (vcIndex-1) + ", v" + (vectorIndex-2) + ")");
            curveIndex++;
            System.out.println("");
            System.out.println("S" + partIndex + " = Part.Shape([L" + (lineIndex-2) + ", C" + (curveIndex-2) + ", L" + (lineIndex-1) + ", C" + (curveIndex-1) + "])");
            System.out.println("W" + partIndex + " = Part.Wire(S" + partIndex + ".Edges)");
            System.out.println("F" + partIndex + " = Part.Face(W" + partIndex + ")");
            System.out.println("P" + partIndex + " = F" + partIndex + ".extrude(Vector(0, 0, " + zDepth + "))");
            System.out.println("Part.show(P" + partIndex + ")");
            partIndex++;
            System.out.println("");
            System.out.println("App.activeDocument().addObject(\"Part::Cut\",\"Cut" + cutIndex + "\")");
            System.out.println("App.activeDocument().Cut" + cutIndex + ".Base = App.activeDocument().Cut" + (cutIndex-1));
            if (cutIndex < 10) System.out.println("App.activeDocument().Cut" + cutIndex + ".Tool = App.activeDocument().Shape00" + cutIndex);
            if (cutIndex >= 10) System.out.println("App.activeDocument().Cut" + cutIndex + ".Tool = App.activeDocument().Shape0" + cutIndex);
            System.out.println("App.ActiveDocument.recompute()");
            cutIndex++;
            System.out.println("");
        }

        System.out.println("App.ActiveDocument.addObject(\"Part::Cylinder\",\"Cylinder1\")\n" +
                "App.ActiveDocument.Cylinder1.Radius=" + innerCircle5radius + "\n" +
                "App.ActiveDocument.Cylinder1.Height=" + zDepth + "\n" +
                "App.ActiveDocument.Cylinder1.Placement=Base.Placement(Base.Vector(0, 0, " + zOffset + "), Base.Rotation(0,0,0,1))\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut62\")\n" +
                "App.activeDocument().Cut62.Base = App.activeDocument().Cut61\n" +
                "App.activeDocument().Cut62.Tool = App.activeDocument().Cylinder1\n" +
                "App.ActiveDocument.recompute()\n" +
                "\n" +
                "App.ActiveDocument.addObject(\"Part::Cylinder\",\"Cylinder2\")\n" +
                "App.ActiveDocument.Cylinder2.Radius=" + innerCircle4radius + "\n" +
                "App.ActiveDocument.Cylinder2.Height=" + zDepth + "\n" +
                "App.ActiveDocument.Cylinder2.Placement=Base.Placement(Base.Vector(0, 0, " + zOffset + "), Base.Rotation(0,0,0,1))\n" +
                "\n" +
                "j = BOPTools.JoinFeatures.makeConnect(name = 'Connect')\n" +
                "j.Objects = [App.ActiveDocument.Cut62, App.ActiveDocument.Cylinder2]\n" +
                "j.Proxy.execute(j)\n" +
                "j.purgeTouched()\n" +
                "for obj in j.ViewObject.Proxy.claimChildren():\n" +
                "\tobj.ViewObject.hide()\n" +
                "\n" +
                "App.ActiveDocument.addObject(\"Part::Cylinder\",\"Cylinder3\")\n" +
                "App.ActiveDocument.Cylinder3.Radius=" + innerCircle3radius + "\n" +
                "App.ActiveDocument.Cylinder3.Height=" + zDepth + "\n" +
                "App.ActiveDocument.Cylinder3.Placement=Base.Placement(Base.Vector(0, 0, " + zOffset + "), Base.Rotation(0,0,0,1))\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut63\")\n" +
                "App.activeDocument().Cut63.Base = App.activeDocument().Connect\n" +
                "App.activeDocument().Cut63.Tool = App.activeDocument(). Cylinder3\n" +
                "App.ActiveDocument.recompute()\n" +
                "\n" +
                "App.ActiveDocument.addObject(\"Part::Cylinder\",\"Cylinder4\")\n" +
                "App.ActiveDocument.Cylinder4.Radius=" + innerCircle2radius + "\n" +
                "App.ActiveDocument.Cylinder4.Height=" + zDepth + "\n" +
                "App.ActiveDocument.Cylinder4.Placement=Base.Placement(Base.Vector(0, 0, " + zOffset + "), Base.Rotation(0,0,0,1))\n" +
                "\n" +
                "j = BOPTools.JoinFeatures.makeConnect(name = 'Connect2')\n" +
                "j.Objects = [App.ActiveDocument.Cut63, App.ActiveDocument.Cylinder4]\n" +
                "j.Proxy.execute(j)\n" +
                "j.purgeTouched()\n" +
                "for obj in j.ViewObject.Proxy.claimChildren():\n" +
                "\tobj.ViewObject.hide()\n" +
                "\n" +
                "App.ActiveDocument.addObject(\"Part::Cylinder\",\"Cylinder5\")\n" +
                "App.ActiveDocument.Cylinder5.Radius=" + innerCircle1radius + "\n" +
                "App.ActiveDocument.Cylinder5.Height=" + zDepth + "\n" +
                "App.ActiveDocument.Cylinder5.Placement=Base.Placement(Base.Vector(0, 0, " + zOffset + "), Base.Rotation(0,0,0,1))\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut64\")\n" +
                "App.activeDocument().Cut64.Base = App.activeDocument().Connect2\n" +
                "App.activeDocument().Cut64.Tool = App.activeDocument().Cylinder5\n" +
                "App.ActiveDocument.recompute()\n");

        // 3-Point Curved
        System.out.println("v261 = Vector(" + backRing3pointCurvedSection1to2.get(0).getX() + ", " + backRing3pointCurvedSection1to2.get(0).getY() + ", 0)\n" +
                "v262 = Vector(" + backRing3pointCurvedSection1to2.get(1).getX() + ", " + backRing3pointCurvedSection1to2.get(1).getY() + ", 0)\n" +
                "\n" +
                "L131 = Part.LineSegment(v261, v262)\n" +
                "\n" +
                "vc131 = Vector(" + backRing3pointCurvedSection1to2.get(2).getX() + ", " + backRing3pointCurvedSection1to2.get(2).getY() + ", 0)\n" +
                "\n" +
                "C131 = Part.Arc(v261, vc131, v262)\n" +
                "\n" +
                "S63 = Part.Shape([L131, C131])\n" +
                "W63 = Part.Wire(S63.Edges)\n" +
                "F63 = Part.Face(W63)\n" +
                "P63 = F63.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P63)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut65\")\n" +
                "App.activeDocument().Cut65.Base = App.activeDocument().Cut64\n" +
                "App.activeDocument().Cut65.Tool = App.activeDocument().Shape062\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v263 = Vector(" + backRing3pointCurvedSection7to8.get(0).getX() + ", " + backRing3pointCurvedSection7to8.get(0).getY() + ", 0)\n" +
                "v264 = Vector(" + backRing3pointCurvedSection7to8.get(1).getX() + ", " + backRing3pointCurvedSection7to8.get(1).getY() + ", 0)\n" +
                "\n" +
                "L132 = Part.LineSegment(v263, v264)\n" +
                "\n" +
                "vc132 = Vector(" + backRing3pointCurvedSection7to8.get(2).getX() + ", " + backRing3pointCurvedSection7to8.get(2).getY() + ", 0)\n" +
                "\n" +
                "C132 = Part.Arc(v263, vc132, v264)\n" +
                "\n" +
                "S64 = Part.Shape([L132, C132])\n" +
                "W64 = Part.Wire(S64.Edges)\n" +
                "F64 = Part.Face(W64)\n" +
                "P64 = F64.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P64)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut66\")\n" +
                "App.activeDocument().Cut66.Base = App.activeDocument().Cut65\n" +
                "App.activeDocument().Cut66.Tool = App.activeDocument().Shape063\n" +
                "App.ActiveDocument.recompute()\n");

        // 3-Point Straight
        System.out.println("v265 = Vector(" + backRing3pointStraightSection3.get(0).getX() + ", " + backRing3pointStraightSection3.get(0).getY() + ", 0)\n" +
                "v266 = Vector(" + backRing3pointStraightSection3.get(1).getX() + ", " + backRing3pointStraightSection3.get(1).getY() + ", 0)\n" +
                "v267 = Vector(" + backRing3pointStraightSection3.get(2).getX() + ", " + backRing3pointStraightSection3.get(2).getY() + ", 0)\n" +
                "\n" +
                "L133 = Part.LineSegment(v265, v266)\n" +
                "L134 = Part.LineSegment(v266, v267)\n" +
                "L135 = Part.LineSegment(v267, v265)\n" +
                "\n" +
                "S65 = Part.Shape([L133, L134, L135])\n" +
                "W65 = Part.Wire(S65.Edges)\n" +
                "F65 = Part.Face(W65)\n" +
                "P65 = F65.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P65)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut67\")\n" +
                "App.activeDocument().Cut67.Base = App.activeDocument().Cut66\n" +
                "App.activeDocument().Cut67.Tool = App.activeDocument().Shape064\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v268 = Vector(" + backRing3pointStraightSection4.get(0).getX() + ", " + backRing3pointStraightSection4.get(0).getY() + ", 0)\n" +
                "v269 = Vector(" + backRing3pointStraightSection4.get(1).getX() + ", " + backRing3pointStraightSection4.get(1).getY() + ", 0)\n" +
                "v270 = Vector(" + backRing3pointStraightSection4.get(2).getX() + ", " + backRing3pointStraightSection4.get(2).getY() + ", 0)\n" +
                "\n" +
                "L136 = Part.LineSegment(v268, v269)\n" +
                "L137 = Part.LineSegment(v269, v270)\n" +
                "L138 = Part.LineSegment(v270, v268)\n" +
                "\n" +
                "S66 = Part.Shape([L136, L137, L138])\n" +
                "W66 = Part.Wire(S66.Edges)\n" +
                "F66 = Part.Face(W66)\n" +
                "P66 = F66.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P66)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut68\")\n" +
                "App.activeDocument().Cut68.Base = App.activeDocument().Cut67\n" +
                "App.activeDocument().Cut68.Tool = App.activeDocument().Shape065\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v271 = Vector(" + backRing3pointStraightSection5.get(0).getX() + ", " + backRing3pointStraightSection5.get(0).getY() + ", 0)\n" +
                "v272 = Vector(" + backRing3pointStraightSection5.get(1).getX() + ", " + backRing3pointStraightSection5.get(1).getY() + ", 0)\n" +
                "v273 = Vector(" + backRing3pointStraightSection5.get(2).getX() + ", " + backRing3pointStraightSection5.get(2).getY() + ", 0)\n" +
                "\n" +
                "L139 = Part.LineSegment(v271, v272)\n" +
                "L140 = Part.LineSegment(v272, v273)\n" +
                "L141 = Part.LineSegment(v273, v271)\n" +
                "\n" +
                "S67 = Part.Shape([L139, L140, L141])\n" +
                "W67 = Part.Wire(S67.Edges)\n" +
                "F67 = Part.Face(W67)\n" +
                "P67 = F67.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P67)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut69\")\n" +
                "App.activeDocument().Cut69.Base = App.activeDocument().Cut68\n" +
                "App.activeDocument().Cut69.Tool = App.activeDocument().Shape066\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v274 = Vector(" + backRing3pointStraightSection6.get(0).getX() + ", " + backRing3pointStraightSection6.get(0).getY() + ", 0)\n" +
                "v275 = Vector(" + backRing3pointStraightSection6.get(1).getX() + ", " + backRing3pointStraightSection6.get(1).getY() + ", 0)\n" +
                "v276 = Vector(" + backRing3pointStraightSection6.get(2).getX() + ", " + backRing3pointStraightSection6.get(2).getY() + ", 0)\n" +
                "\n" +
                "L142 = Part.LineSegment(v274, v275)\n" +
                "L143 = Part.LineSegment(v275, v276)\n" +
                "L144 = Part.LineSegment(v276, v274)\n" +
                "\n" +
                "S68 = Part.Shape([L142, L143, L144])\n" +
                "W68 = Part.Wire(S68.Edges)\n" +
                "F68 = Part.Face(W68)\n" +
                "P68 = F68.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P68)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut70\")\n" +
                "App.activeDocument().Cut70.Base = App.activeDocument().Cut69\n" +
                "App.activeDocument().Cut70.Tool = App.activeDocument().Shape067\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v277 = Vector(" + backRing3pointStraightSectionBelowZero.get(0).getX() + ", " + backRing3pointStraightSectionBelowZero.get(0).getY() + ", 0)\n" +
                "v278 = Vector(" + backRing3pointStraightSectionBelowZero.get(1).getX() + ", " + backRing3pointStraightSectionBelowZero.get(1).getY() + ", 0)\n" +
                "v279 = Vector(" + backRing3pointStraightSectionBelowZero.get(2).getX() + ", " + backRing3pointStraightSectionBelowZero.get(2).getY() + ", 0)\n" +
                "\n" +
                "L145 = Part.LineSegment(v277, v278)\n" +
                "L146 = Part.LineSegment(v278, v279)\n" +
                "L147 = Part.LineSegment(v279, v277)\n" +
                "\n" +
                "S69 = Part.Shape([L145, L146, L147])\n" +
                "W69 = Part.Wire(S69.Edges)\n" +
                "F69 = Part.Face(W69)\n" +
                "P69 = F69.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P69)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut71\")\n" +
                "App.activeDocument().Cut71.Base = App.activeDocument().Cut70\n" +
                "App.activeDocument().Cut71.Tool = App.activeDocument().Shape068\n" +
                "App.ActiveDocument.recompute()\n");

        // 4-Point Curved
        System.out.println("v280 = Vector(" + backRing4pointCurvedSection2to3.get(0).getX() + ", " + backRing4pointCurvedSection2to3.get(0).getY() + ", 0)\n" +
                "v281 = Vector(" + backRing4pointCurvedSection2to3.get(1).getX() + ", " + backRing4pointCurvedSection2to3.get(1).getY() + ", 0)\n" +
                "v282 = Vector(" + backRing4pointCurvedSection2to3.get(2).getX() + ", " + backRing4pointCurvedSection2to3.get(2).getY() + ", 0)\n" +
                "\n" +
                "L148 = Part.LineSegment(v280, v282)\n" +
                "L149 = Part.LineSegment(v281, v282)\n" +
                "\n" +
                "vc133 = Vector(" + backRing4pointCurvedSection2to3.get(3).getX() + ", " + backRing4pointCurvedSection2to3.get(3).getY() + ", 0)\n" +
                "\n" +
                "C133 = Part.Arc(v280, vc133, v281)\n" +
                "\n" +
                "S70 = Part.Shape([L148, L149, C133])\n" +
                "W70 = Part.Wire(S70.Edges)\n" +
                "F70 = Part.Face(W70)\n" +
                "P70 = F70.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P70)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut72\")\n" +
                "App.activeDocument().Cut72.Base = App.activeDocument().Cut71\n" +
                "App.activeDocument().Cut72.Tool = App.activeDocument().Shape069\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v283 = Vector(" + backRing4pointCurvedSection3to4.get(0).getX() + ", " + backRing4pointCurvedSection3to4.get(0).getY() + ", 0)\n" +
                "v284 = Vector(" + backRing4pointCurvedSection3to4.get(1).getX() + ", " + backRing4pointCurvedSection3to4.get(1).getY() + ", 0)\n" +
                "v285 = Vector(" + backRing4pointCurvedSection3to4.get(2).getX() + ", " + backRing4pointCurvedSection3to4.get(2).getY() + ", 0)\n" +
                "\n" +
                "L150 = Part.LineSegment(v283, v285)\n" +
                "L151 = Part.LineSegment(v284, v285)\n" +
                "\n" +
                "vc134 = Vector(" + backRing4pointCurvedSection3to4.get(3).getX() + ", " + backRing4pointCurvedSection3to4.get(3).getY() + ", 0)\n" +
                "\n" +
                "C134 = Part.Arc(v283, vc134, v284)\n" +
                "\n" +
                "S71 = Part.Shape([L150, L151, C134])\n" +
                "W71 = Part.Wire(S71.Edges)\n" +
                "F71 = Part.Face(W71)\n" +
                "P71 = F71.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P71)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut73\")\n" +
                "App.activeDocument().Cut73.Base = App.activeDocument().Cut72\n" +
                "App.activeDocument().Cut73.Tool = App.activeDocument().Shape070\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v286 = Vector(" + backRing4pointCurvedSection5to6.get(0).getX() + ", " + backRing4pointCurvedSection5to6.get(0).getY() + ", 0)\n" +
                "v287 = Vector(" + backRing4pointCurvedSection5to6.get(1).getX() + ", " + backRing4pointCurvedSection5to6.get(1).getY() + ", 0)\n" +
                "v288 = Vector(" + backRing4pointCurvedSection5to6.get(2).getX() + ", " + backRing4pointCurvedSection5to6.get(2).getY() + ", 0)\n" +
                "\n" +
                "L152 = Part.LineSegment(v286, v288)\n" +
                "L153 = Part.LineSegment(v287, v288)\n" +
                "\n" +
                "vc135 = Vector(" + backRing4pointCurvedSection5to6.get(3).getX() + ", " + backRing4pointCurvedSection5to6.get(3).getY() + ", 0)\n" +
                "\n" +
                "C135 = Part.Arc(v286, vc135, v287)\n" +
                "\n" +
                "S72 = Part.Shape([L152, L153, C135])\n" +
                "W72 = Part.Wire(S72.Edges)\n" +
                "F72 = Part.Face(W72)\n" +
                "P72 = F72.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P72)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut74\")\n" +
                "App.activeDocument().Cut74.Base = App.activeDocument().Cut73\n" +
                "App.activeDocument().Cut74.Tool = App.activeDocument().Shape071\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v289 = Vector(" + backRing4pointCurvedSection6to7.get(0).getX() + ", " + backRing4pointCurvedSection6to7.get(0).getY() + ", 0)\n" +
                "v290 = Vector(" + backRing4pointCurvedSection6to7.get(1).getX() + ", " + backRing4pointCurvedSection6to7.get(1).getY() + ", 0)\n" +
                "v291 = Vector(" + backRing4pointCurvedSection6to7.get(2).getX() + ", " + backRing4pointCurvedSection6to7.get(2).getY() + ", 0)\n" +
                "\n" +
                "L154 = Part.LineSegment(v289, v291)\n" +
                "L155 = Part.LineSegment(v290, v291)\n" +
                "\n" +
                "vc136 = Vector(" + backRing4pointCurvedSection6to7.get(3).getX() + ", " + backRing4pointCurvedSection6to7.get(3).getY() + ", 0)\n" +
                "\n" +
                "C136 = Part.Arc(v289, vc136, v290)\n" +
                "\n" +
                "S73 = Part.Shape([L154, L155, C136])\n" +
                "W73 = Part.Wire(S73.Edges)\n" +
                "F73 = Part.Face(W73)\n" +
                "P73 = F73.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P73)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut75\")\n" +
                "App.activeDocument().Cut75.Base = App.activeDocument().Cut74\n" +
                "App.activeDocument().Cut75.Tool = App.activeDocument().Shape072\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v292 = Vector(" + backRing4pointCurvedSection8to9.get(0).getX() + ", " + backRing4pointCurvedSection8to9.get(0).getY() + ", 0)\n" +
                "v293 = Vector(" + backRing4pointCurvedSection8to9.get(1).getX() + ", " + backRing4pointCurvedSection8to9.get(1).getY() + ", 0)\n" +
                "v294 = Vector(" + backRing4pointCurvedSection8to9.get(2).getX() + ", " + backRing4pointCurvedSection8to9.get(2).getY() + ", 0)\n" +
                "\n" +
                "L156 = Part.LineSegment(v292, v294)\n" +
                "L157 = Part.LineSegment(v293, v294)\n" +
                "\n" +
                "vc137 = Vector(" + backRing4pointCurvedSection8to9.get(3).getX() + ", " + backRing4pointCurvedSection8to9.get(3).getY() + ", 0)\n" +
                "\n" +
                "C137 = Part.Arc(v292, vc137, v293)\n" +
                "\n" +
                "S74 = Part.Shape([L156, L157, C137])\n" +
                "W74 = Part.Wire(S74.Edges)\n" +
                "F74 = Part.Face(W74)\n" +
                "P74 = F74.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P74)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut76\")\n" +
                "App.activeDocument().Cut76.Base = App.activeDocument().Cut75\n" +
                "App.activeDocument().Cut76.Tool = App.activeDocument().Shape073\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v295 = Vector(" + backRing4pointCurvedSection9to1.get(0).getX() + ", " + backRing4pointCurvedSection9to1.get(0).getY() + ", 0)\n" +
                "v296 = Vector(" + backRing4pointCurvedSection9to1.get(1).getX() + ", " + backRing4pointCurvedSection9to1.get(1).getY() + ", 0)\n" +
                "v297 = Vector(" + backRing4pointCurvedSection9to1.get(2).getX() + ", " + backRing4pointCurvedSection9to1.get(2).getY() + ", 0)\n" +
                "\n" +
                "L158 = Part.LineSegment(v295, v297)\n" +
                "L159 = Part.LineSegment(v296, v297)\n" +
                "\n" +
                "vc138 = Vector(" + backRing4pointCurvedSection9to1.get(3).getX() + ", " + backRing4pointCurvedSection9to1.get(3).getY() + ", 0)\n" +
                "\n" +
                "C138 = Part.Arc(v295, vc138, v296)\n" +
                "\n" +
                "S75 = Part.Shape([L158, L159, C138])\n" +
                "W75 = Part.Wire(S75.Edges)\n" +
                "F75 = Part.Face(W75)\n" +
                "P75 = F75.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P75)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut77\")\n" +
                "App.activeDocument().Cut77.Base = App.activeDocument().Cut76\n" +
                "App.activeDocument().Cut77.Tool = App.activeDocument().Shape074\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v298 = Vector(" + backRing4pointCurvedSectionBelowZero.get(0).getX() + ", " + backRing4pointCurvedSectionBelowZero.get(0).getY() + ", 0)\n" +
                "v299 = Vector(" + backRing4pointCurvedSectionBelowZero.get(1).getX() + ", " + backRing4pointCurvedSectionBelowZero.get(1).getY() + ", 0)\n" +
                "v300 = Vector(" + backRing4pointCurvedSectionBelowZero.get(2).getX() + ", " + backRing4pointCurvedSectionBelowZero.get(2).getY() + ", 0)\n" +
                "\n" +
                "L160 = Part.LineSegment(v298, v299)\n" +
                "L161 = Part.LineSegment(v298, v300)\n" +
                "\n" +
                "vc139 = Vector(" + backRing4pointCurvedSectionBelowZero.get(3).getX() + ", " + backRing4pointCurvedSectionBelowZero.get(3).getY() + ", 0)\n" +
                "\n" +
                "C139 = Part.Arc(v299, vc139, v300)\n" +
                "\n" +
                "S76 = Part.Shape([L160, L161, C139])\n" +
                "W76 = Part.Wire(S76.Edges)\n" +
                "F76 = Part.Face(W76)\n" +
                "P76 = F76.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P76)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut78\")\n" +
                "App.activeDocument().Cut78.Base = App.activeDocument().Cut77\n" +
                "App.activeDocument().Cut78.Tool = App.activeDocument().Shape075\n" +
                "App.ActiveDocument.recompute()\n");

        // 4-Point Straight
        System.out.println("v301 = Vector(" + backRing4pointStraightSection1to2.get(0).getX() + ", " + backRing4pointStraightSection1to2.get(0).getY() + ", 0)\n" +
                "v302 = Vector(" + backRing4pointStraightSection1to2.get(1).getX() + ", " + backRing4pointStraightSection1to2.get(1).getY() + ", 0)\n" +
                "v303 = Vector(" + backRing4pointStraightSection1to2.get(2).getX() + ", " + backRing4pointStraightSection1to2.get(2).getY() + ", 0)\n" +
                "v304 = Vector(" + backRing4pointStraightSection1to2.get(3).getX() + ", " + backRing4pointStraightSection1to2.get(3).getY() + ", 0)\n" +
                "\n" +
                "L162 = Part.LineSegment(v301, v302)\n" +
                "L163 = Part.LineSegment(v302, v303)\n" +
                "L164 = Part.LineSegment(v303, v304)\n" +
                "L165 = Part.LineSegment(v304, v301)\n" +
                "\n" +
                "S77 = Part.Shape([L162, L163, L164, L165])\n" +
                "W77 = Part.Wire(S77.Edges)\n" +
                "F77 = Part.Face(W77)\n" +
                "P77 = F77.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P77)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut79\")\n" +
                "App.activeDocument().Cut79.Base = App.activeDocument().Cut78\n" +
                "App.activeDocument().Cut79.Tool = App.activeDocument().Shape076\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v305 = Vector(" + backRing4pointStraightSection7to8.get(0).getX() + ", " + backRing4pointStraightSection7to8.get(0).getY() + ", 0)\n" +
                "v306 = Vector(" + backRing4pointStraightSection7to8.get(1).getX() + ", " + backRing4pointStraightSection7to8.get(1).getY() + ", 0)\n" +
                "v307 = Vector(" + backRing4pointStraightSection7to8.get(2).getX() + ", " + backRing4pointStraightSection7to8.get(2).getY() + ", 0)\n" +
                "v308 = Vector(" + backRing4pointStraightSection7to8.get(3).getX() + ", " + backRing4pointStraightSection7to8.get(3).getY() + ", 0)\n" +
                "\n" +
                "L166 = Part.LineSegment(v305, v306)\n" +
                "L167 = Part.LineSegment(v306, v307)\n" +
                "L168 = Part.LineSegment(v307, v308)\n" +
                "L169 = Part.LineSegment(v308, v305)\n" +
                "\n" +
                "S78 = Part.Shape([L166, L167, L168, L169])\n" +
                "W78 = Part.Wire(S78.Edges)\n" +
                "F78 = Part.Face(W78)\n" +
                "P78 = F78.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P78)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut80\")\n" +
                "App.activeDocument().Cut80.Base = App.activeDocument().Cut79\n" +
                "App.activeDocument().Cut80.Tool = App.activeDocument().Shape077\n" +
                "App.ActiveDocument.recompute()\n");

        // 5-Point Curved
        System.out.println("v309 = Vector(" + backRing5pointCurvedSection4to5.get(0).getX() + ", " + backRing5pointCurvedSection4to5.get(0).getY() + ", 0)\n" +
                "v310 = Vector(" + backRing5pointCurvedSection4to5.get(1).getX() + ", " + backRing5pointCurvedSection4to5.get(1).getY() + ", 0)\n" +
                "v311 = Vector(" + backRing5pointCurvedSection4to5.get(2).getX() + ", " + backRing5pointCurvedSection4to5.get(2).getY() + ", 0)\n" +
                "v312 = Vector(" + backRing5pointCurvedSection4to5.get(3).getX() + ", " + backRing5pointCurvedSection4to5.get(3).getY() + ", 0)\n" +
                "\n" +
                "L170 = Part.LineSegment(v309, v310)\n" +
                "L171 = Part.LineSegment(v310, v311)\n" +
                "L172 = Part.LineSegment(v311, v312)\n" +
                "\n" +
                "vc140 = Vector(" + backRing5pointCurvedSection4to5.get(4).getX() + ", " + backRing5pointCurvedSection4to5.get(4).getY() + ", 0)\n" +
                "\n" +
                "C140 = Part.Arc(v309, vc140, v310)\n" +
                "\n" +
                "S79 = Part.Shape([L170, L171, L172, C140])\n" +
                "W79 = Part.Wire(S79.Edges)\n" +
                "F79 = Part.Face(W79)\n" +
                "P79 = F79.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P79)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut81\")\n" +
                "App.activeDocument().Cut81.Base = App.activeDocument().Cut80\n" +
                "App.activeDocument().Cut81.Tool = App.activeDocument().Shape078\n" +
                "App.ActiveDocument.recompute()\n");

        // 5-Point Straight
        System.out.println("v313 = Vector(" + backRing5pointStraightSectionLeft.get(0).getX() + ", " + backRing5pointStraightSectionLeft.get(0).getY() + ", 0)\n" +
                "v314 = Vector(" + backRing5pointStraightSectionLeft.get(1).getX() + ", " + backRing5pointStraightSectionLeft.get(1).getY() + ", 0)\n" +
                "v315 = Vector(" + backRing5pointStraightSectionLeft.get(2).getX() + ", " + backRing5pointStraightSectionLeft.get(2).getY() + ", 0)\n" +
                "v316 = Vector(" + backRing5pointStraightSectionLeft.get(3).getX() + ", " + backRing5pointStraightSectionLeft.get(3).getY() + ", 0)\n" +
                "v317 = Vector(" + backRing5pointStraightSectionLeft.get(4).getX() + ", " + backRing5pointStraightSectionLeft.get(4).getY() + ", 0)\n" +
                "\n" +
                "L173 = Part.LineSegment(v313, v314)\n" +
                "L174 = Part.LineSegment(v314, v315)\n" +
                "L175 = Part.LineSegment(v315, v316)\n" +
                "L176 = Part.LineSegment(v316, v317)\n" +
                "L177 = Part.LineSegment(v317, v313)\n" +
                "\n" +
                "S80 = Part.Shape([L173, L174, L175, L176, L177])\n" +
                "W80 = Part.Wire(S80.Edges)\n" +
                "F80 = Part.Face(W80)\n" +
                "P80 = F80.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P80)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut82\")\n" +
                "App.activeDocument().Cut82.Base = App.activeDocument().Cut81\n" +
                "App.activeDocument().Cut82.Tool = App.activeDocument().Shape079\n" +
                "App.ActiveDocument.recompute()\n");
        System.out.println("v318 = Vector(" + backRing5pointStraightSectionRight.get(0).getX() + ", " + backRing5pointStraightSectionRight.get(0).getY() + ", 0)\n" +
                "v319 = Vector(" + backRing5pointStraightSectionRight.get(1).getX() + ", " + backRing5pointStraightSectionRight.get(1).getY() + ", 0)\n" +
                "v320 = Vector(" + backRing5pointStraightSectionRight.get(2).getX() + ", " + backRing5pointStraightSectionRight.get(2).getY() + ", 0)\n" +
                "v321 = Vector(" + backRing5pointStraightSectionRight.get(3).getX() + ", " + backRing5pointStraightSectionRight.get(3).getY() + ", 0)\n" +
                "v322 = Vector(" + backRing5pointStraightSectionRight.get(4).getX() + ", " + backRing5pointStraightSectionRight.get(4).getY() + ", 0)\n" +
                "\n" +
                "L178 = Part.LineSegment(v318, v319)\n" +
                "L179 = Part.LineSegment(v319, v320)\n" +
                "L180 = Part.LineSegment(v320, v321)\n" +
                "L181 = Part.LineSegment(v321, v322)\n" +
                "L182 = Part.LineSegment(v322, v318)\n" +
                "\n" +
                "S81 = Part.Shape([L178, L179, L180, L181, L182])\n" +
                "W81 = Part.Wire(S81.Edges)\n" +
                "F81 = Part.Face(W81)\n" +
                "P81 = F81.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P81)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut83\")\n" +
                "App.activeDocument().Cut83.Base = App.activeDocument().Cut82\n" +
                "App.activeDocument().Cut83.Tool = App.activeDocument().Shape080\n" +
                "App.ActiveDocument.recompute()\n");

        // 6-Point Curved
        System.out.println("v323 = Vector(" + backRing6pointCurvedSectionAboveZero.get(0).getX() + ", " + backRing6pointCurvedSectionAboveZero.get(0).getY() + ", 0)\n" +
                "v324 = Vector(" + backRing6pointCurvedSectionAboveZero.get(1).getX() + ", " + backRing6pointCurvedSectionAboveZero.get(1).getY() + ", 0)\n" +
                "v325 = Vector(" + backRing6pointCurvedSectionAboveZero.get(2).getX() + ", " + backRing6pointCurvedSectionAboveZero.get(2).getY() + ", 0)\n" +
                "v326 = Vector(" + backRing6pointCurvedSectionAboveZero.get(3).getX() + ", " + backRing6pointCurvedSectionAboveZero.get(3).getY() + ", 0)\n" +
                "v327 = Vector(" + backRing6pointCurvedSectionAboveZero.get(4).getX() + ", " + backRing6pointCurvedSectionAboveZero.get(4).getY() + ", 0)\n" +
                "\n" +
                "L183 = Part.LineSegment(v323, v324)\n" +
                "L184 = Part.LineSegment(v324, v326)\n" +
                "L185 = Part.LineSegment(v323, v325)\n" +
                "L186 = Part.LineSegment(v325, v327)\n" +
                "\n" +
                "vc141 = Vector(" + backRing6pointCurvedSectionAboveZero.get(5).getX() + ", " + backRing6pointCurvedSectionAboveZero.get(5).getY() + ", 0)\n" +
                "\n" +
                "C141 = Part.Arc(v326, vc141, v327)\n" +
                "\n" +
                "S82 = Part.Shape([L184, L183, L185, L186, C141])\n" +
                "W82 = Part.Wire(S82.Edges)\n" +
                "F82 = Part.Face(W82)\n" +
                "P82 = F82.extrude(Vector(0, 0, " + zDepth + "))\n" +
                "Part.show(P82)\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut84\")\n" +
                "App.activeDocument().Cut84.Base = App.activeDocument().Cut83\n" +
                "App.activeDocument().Cut84.Tool = App.activeDocument().Shape081\n" +
                "App.ActiveDocument.recompute()\n");

        System.out.println("App.ActiveDocument.addObject(\"Part::Cylinder\",\"Cylinder6\")\n" +
                "App.ActiveDocument.Cylinder6.Radius=" + backCircle0InnerRadius + "\n" +
                "App.ActiveDocument.Cylinder6.Height=" + zDepth + "\n" +
                "App.ActiveDocument.Cylinder6.Placement=Base.Placement(Base.Vector(0, 0, 0), Base.Rotation(0,0,0,1))\n" +
                "\n" +
                "App.activeDocument().addObject(\"Part::Cut\",\"Cut85\")\n" +
                "App.activeDocument().Cut85.Base = App.activeDocument().Cut84\n" +
                "App.activeDocument().Cut85.Tool = App.activeDocument().Cylinder6\n" +
                "App.ActiveDocument.recompute()\n");

        System.out.println("Gui.activeDocument().activeView().viewIsometric()\n" +
                "Gui.SendMsgToActiveView(\"ViewFit\")");

    }

    private void calculateDegreeOffsets() {

        ring7circumference = ring7radius.multiply(twoPi);
        ring7degreeOffset = ring7circumference.divide(numSections, mc).add(wallWidth).divide(ring7circumference, mc).multiply(d360).divide(two, mc);
        ring6circumference = ring6radius.multiply(twoPi);
        ring6degreeOffset = ring6circumference.divide(numSections, mc).subtract(wallWidth).divide(ring6circumference, mc).multiply(d360).divide(two, mc);
        ring5circumference = ring5radius.multiply(twoPi);
        ring5degreeOffsetOuter = ring5circumference.divide(numSections, mc).add(wallWidth).divide(ring5circumference, mc).multiply(d360).divide(two, mc);
        ring5degreeOffsetInner = ring5circumference.divide(numSections, mc).subtract(wallWidth).divide(ring5circumference, mc).multiply(d360).divide(two, mc);
        ring5degreeOffsetMiddle = new BigDecimal(45);
        ring4circumference = ring4radius.multiply(twoPi);
        ring4degreeOffset = ring4circumference.divide(numSections, mc).subtract(wallWidth).divide(ring4circumference, mc).multiply(d360).divide(two, mc);
        ring3circumference = ring3radius.multiply(twoPi);
        ring3degreeOffset = ring3circumference.divide(numSections, mc).subtract(wallWidth).divide(ring3circumference, mc).multiply(d360).divide(two, mc);
        ring2circumference = ring2radius.multiply(twoPi);
        ring2degreeOffset = ring2circumference.divide(numSections, mc).subtract(wallWidth).divide(ring2circumference, mc).multiply(d360).divide(two, mc);
        ring1circumference = ring1radius.multiply(twoPi);
        ring1degreeOffset = ring1circumference.divide(numSections, mc).subtract(wallWidth).divide(ring1circumference, mc).multiply(d360).divide(two, mc);
        backRing4degreeOffset = ring4circumference.divide(numBackSections, mc).subtract(wallWidth).divide(ring4circumference, mc).multiply(d360).divide(two, mc);
        backRing3degreeOffset = ring3circumference.divide(numBackSections, mc).subtract(wallWidth).divide(ring3circumference, mc).multiply(d360).divide(two, mc);
        backRing2circumference = backRing2radius.multiply(twoPi);
        backRing2degreeOffset = new BigDecimal(40);
        backRing2degreeOffsetMiddleStart = new BigDecimal(20);

    }

    private void calculateSinCosOffsets() {

        ring7sinOffset = new BigDecimal(Math.sin(Math.toRadians(ring7degreeOffset.doubleValue())), mc);
        ring7cosOffset = new BigDecimal(Math.cos(Math.toRadians(ring7degreeOffset.doubleValue())), mc);
        ring6sinOffset = new BigDecimal(Math.sin(Math.toRadians(ring6degreeOffset.doubleValue())), mc);
        ring6cosOffset = new BigDecimal(Math.cos(Math.toRadians(ring6degreeOffset.doubleValue())), mc);
        ring5sinOffsetOuter = new BigDecimal(Math.sin(Math.toRadians(ring5degreeOffsetOuter.doubleValue())), mc);
        ring5cosOffsetOuter = new BigDecimal(Math.cos(Math.toRadians(ring5degreeOffsetOuter.doubleValue())), mc);
        ring5sinOffsetInner = new BigDecimal(Math.sin(Math.toRadians(ring5degreeOffsetInner.doubleValue())), mc);
        ring5cosOffsetInner = new BigDecimal(Math.cos(Math.toRadians(ring5degreeOffsetInner.doubleValue())), mc);
        ring5sinOffsetMiddle = new BigDecimal(Math.sin(Math.toRadians(ring5degreeOffsetMiddle.doubleValue())), mc);
        ring5cosOffsetMiddle = new BigDecimal(Math.cos(Math.toRadians(ring5degreeOffsetMiddle.doubleValue())), mc);

    }

    private void calculateRing7Points() {

        outerRing7topLeft.x = ring7radius.multiply(ring7sinOffset).negate();
        outerRing7topLeft.y = ring7radius.multiply(ring7cosOffset);
        outerRing7topRight.x = ring7radius.multiply(ring7sinOffset);
        outerRing7topRight.y = ring7radius.multiply(ring7cosOffset);
        outerRing7bottomLeft.x = ring7radius.multiply(ring7sinOffset).negate();
        outerRing7bottomLeft.y = ring7radius.multiply(ring7cosOffset).negate();
        outerRing7bottomRight.x = ring7radius.multiply(ring7sinOffset);
        outerRing7bottomRight.y = ring7radius.multiply(ring7cosOffset).negate();

        outerRing7leftTop.x = ring7radius.multiply(ring7cosOffset).negate();
        outerRing7leftTop.y = ring7radius.multiply(ring7sinOffset);
        outerRing7leftBottom.x = ring7radius.multiply(ring7cosOffset).negate();
        outerRing7leftBottom.y = ring7radius.multiply(ring7sinOffset).negate();
        outerRing7rightTop.x = ring7radius.multiply(ring7cosOffset);
        outerRing7rightTop.y = ring7radius.multiply(ring7sinOffset);
        outerRing7rightBottom.x = ring7radius.multiply(ring7cosOffset);
        outerRing7rightBottom.y = ring7radius.multiply(ring7sinOffset).negate();

        outerRing7topMiddle.x = new BigDecimal(0);
        outerRing7topMiddle.y = ring7radius;
        outerRing7bottomMiddle.x = new BigDecimal(0);
        outerRing7bottomMiddle.y = ring7radius.negate();
        outerRing7leftMiddle.x = ring7radius.negate();
        outerRing7leftMiddle.y = new BigDecimal(0);
        outerRing7rightMiddle.x = ring7radius;
        outerRing7rightMiddle.y = new BigDecimal(0);

    }

    private void calculateRing6Points() {

        innerRing6topLeft.x = ring6radius.multiply(ring6sinOffset).negate();
        innerRing6topLeft.y = ring6radius.multiply(ring6cosOffset);
        innerRing6topRight.x = ring6radius.multiply(ring6sinOffset);
        innerRing6topRight.y = ring6radius.multiply(ring6cosOffset);
        innerRing6bottomLeft.x = ring6radius.multiply(ring6sinOffset).negate();
        innerRing6bottomLeft.y = ring6radius.multiply(ring6cosOffset).negate();
        innerRing6bottomRight.x = ring6radius.multiply(ring6sinOffset);
        innerRing6bottomRight.y = ring6radius.multiply(ring6cosOffset).negate();

        innerRing6leftTop.x = ring6radius.multiply(ring6cosOffset).negate();
        innerRing6leftTop.y = ring6radius.multiply(ring6sinOffset);
        innerRing6leftBottom.x = ring6radius.multiply(ring6cosOffset).negate();
        innerRing6leftBottom.y = ring6radius.multiply(ring6sinOffset).negate();
        innerRing6rightTop.x = ring6radius.multiply(ring6cosOffset);
        innerRing6rightTop.y = ring6radius.multiply(ring6sinOffset);
        innerRing6rightBottom.x = ring6radius.multiply(ring6cosOffset);
        innerRing6rightBottom.y = ring6radius.multiply(ring6sinOffset).negate();

        innerRing6topMiddle.x = new BigDecimal(0);
        innerRing6topMiddle.y = ring6radius;
        innerRing6bottomMiddle.x = new BigDecimal(0);
        innerRing6bottomMiddle.y = ring6radius.negate();
        innerRing6leftMiddle.x = ring6radius.negate();
        innerRing6leftMiddle.y = new BigDecimal(0);
        innerRing6rightMiddle.x = ring6radius;
        innerRing6rightMiddle.y = new BigDecimal(0);

    }

    private void calculateRing5OuterPoints() {

        outerRing5topLeft.x = ring5radius.multiply(ring5sinOffsetOuter).negate();
        outerRing5topLeft.y = ring5radius.multiply(ring5cosOffsetOuter);
        outerRing5topRight.x = ring5radius.multiply(ring5sinOffsetOuter);
        outerRing5topRight.y = ring5radius.multiply(ring5cosOffsetOuter);
        outerRing5bottomLeft.x = ring5radius.multiply(ring5sinOffsetOuter).negate();
        outerRing5bottomLeft.y = ring5radius.multiply(ring5cosOffsetOuter).negate();
        outerRing5bottomRight.x = ring5radius.multiply(ring5sinOffsetOuter);
        outerRing5bottomRight.y = ring5radius.multiply(ring5cosOffsetOuter).negate();

        outerRing5leftTop.x = ring5radius.multiply(ring5cosOffsetOuter).negate();
        outerRing5leftTop.y = ring5radius.multiply(ring5sinOffsetOuter);
        outerRing5leftBottom.x = ring5radius.multiply(ring5cosOffsetOuter).negate();
        outerRing5leftBottom.y = ring5radius.multiply(ring5sinOffsetOuter).negate();
        outerRing5rightTop.x = ring5radius.multiply(ring5cosOffsetOuter);
        outerRing5rightTop.y = ring5radius.multiply(ring5sinOffsetOuter);
        outerRing5rightBottom.x = ring5radius.multiply(ring5cosOffsetOuter);
        outerRing5rightBottom.y = ring5radius.multiply(ring5sinOffsetOuter).negate();

        outerRing5topLeftMiddle.x = ring5radius.multiply(ring5cosOffsetMiddle).negate();
        outerRing5topLeftMiddle.y = ring5radius.multiply(ring5sinOffsetMiddle);
        outerRing5topRightMiddle.x = ring5radius.multiply(ring5cosOffsetMiddle);
        outerRing5topRightMiddle.y = ring5radius.multiply(ring5sinOffsetMiddle);
        outerRing5bottomLeftMiddle.x = ring5radius.multiply(ring5cosOffsetMiddle).negate();
        outerRing5bottomLeftMiddle.y = ring5radius.multiply(ring5sinOffsetMiddle).negate();
        outerRing5bottomRightMiddle.x = ring5radius.multiply(ring5cosOffsetMiddle);
        outerRing5bottomRightMiddle.y = ring5radius.multiply(ring5sinOffsetMiddle).negate();

    }

    private void calculateRing5InnerPoints() {

        innerRing5topLeft.x = ring5radius.multiply(ring5sinOffsetInner).negate();
        innerRing5topLeft.y = ring5radius.multiply(ring5cosOffsetInner);
        innerRing5topRight.x = ring5radius.multiply(ring5sinOffsetInner);
        innerRing5topRight.y = ring5radius.multiply(ring5cosOffsetInner);
        innerRing5bottomLeft.x = ring5radius.multiply(ring5sinOffsetInner).negate();
        innerRing5bottomLeft.y = ring5radius.multiply(ring5cosOffsetInner).negate();
        innerRing5bottomRight.x = ring5radius.multiply(ring5sinOffsetInner);
        innerRing5bottomRight.y = ring5radius.multiply(ring5cosOffsetInner).negate();

        innerRing5leftTop.x = ring5radius.multiply(ring5cosOffsetInner).negate();
        innerRing5leftTop.y = ring5radius.multiply(ring5sinOffsetInner);
        innerRing5leftBottom.x = ring5radius.multiply(ring5cosOffsetInner).negate();
        innerRing5leftBottom.y = ring5radius.multiply(ring5sinOffsetInner).negate();
        innerRing5rightTop.x = ring5radius.multiply(ring5cosOffsetInner);
        innerRing5rightTop.y = ring5radius.multiply(ring5sinOffsetInner);
        innerRing5rightBottom.x = ring5radius.multiply(ring5cosOffsetInner);
        innerRing5rightBottom.y = ring5radius.multiply(ring5sinOffsetInner).negate();

        innerRing5topMiddle.x = new BigDecimal(0);
        innerRing5topMiddle.y = ring5radius;
        innerRing5bottomMiddle.x = new BigDecimal(0);
        innerRing5bottomMiddle.y = ring5radius.negate();
        innerRing5leftMiddle.x = ring5radius.negate();
        innerRing5leftMiddle.y = new BigDecimal(0);
        innerRing5rightMiddle.x = ring5radius;
        innerRing5rightMiddle.y = new BigDecimal(0);

    }

    private void calculateRing4Points() {

        ring4 = new LinkedList<>();

        for (int i = 0; i < 22; i++) {

            List<BigDecimalPoint> section = new LinkedList<>();

            for (int j = 0; j < 3; j++) {

                BigDecimal degreeOffset, sinOffset, cosOffset, x, y;

                if (j == 0) {
                    degreeOffset = ring4degreeOffset.add(degreeSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring4radius.multiply(sinOffset).negate();
                    y = ring4radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 1) {
                    degreeOffset = degreeSectionOffset.multiply(new BigDecimal(i));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring4radius.multiply(sinOffset).negate();
                    y = ring4radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 2) {
                    degreeOffset = ring4degreeOffset.negate().add(degreeSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring4radius.multiply(sinOffset).negate();
                    y = ring4radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

            }

            ring4.add(section);

        }

    }

    private void calculateRing3Points() {

        ring3 = new LinkedList<>();

        for (int i = 0; i < 22; i++) {

            List<BigDecimalPoint> section = new LinkedList<>();

            for (int j = 0; j < 3; j++) {

                BigDecimal degreeOffset, sinOffset, cosOffset, x, y;

                if (j == 0) {
                    degreeOffset = ring3degreeOffset.add(degreeSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring3radius.multiply(sinOffset).negate();
                    y = ring3radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 1) {
                    degreeOffset = degreeSectionOffset.multiply(new BigDecimal(i));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring3radius.multiply(sinOffset).negate();
                    y = ring3radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 2) {
                    degreeOffset = ring3degreeOffset.negate().add(degreeSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring3radius.multiply(sinOffset).negate();
                    y = ring3radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

            }

            ring3.add(section);

        }

    }

    private void calculateRing2Points() {

        ring2 = new LinkedList<>();

        for (int i = 0; i < 22; i++) {

            List<BigDecimalPoint> section = new LinkedList<>();

            for (int j = 0; j < 3; j++) {

                BigDecimal degreeOffset, sinOffset, cosOffset, x, y;

                if (j == 0) {
                    degreeOffset = ring2degreeOffset.add(degreeSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring2radius.multiply(sinOffset).negate();
                    y = ring2radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 1) {
                    degreeOffset = degreeSectionOffset.multiply(new BigDecimal(i));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring2radius.multiply(sinOffset).negate();
                    y = ring2radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 2) {
                    degreeOffset = ring2degreeOffset.negate().add(degreeSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring2radius.multiply(sinOffset).negate();
                    y = ring2radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

            }

            ring2.add(section);

        }

    }

    private void calculateRing1Points() {

        ring1 = new LinkedList<>();

        for (int i = 0; i < 22; i++) {

            List<BigDecimalPoint> section = new LinkedList<>();

            for (int j = 0; j < 3; j++) {

                BigDecimal degreeOffset, sinOffset, cosOffset, x, y;

                if (j == 0) {
                    degreeOffset = ring1degreeOffset.add(degreeSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring1radius.multiply(sinOffset).negate();
                    y = ring1radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 1) {
                    degreeOffset = degreeSectionOffset.multiply(new BigDecimal(i));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring1radius.multiply(sinOffset).negate();
                    y = ring1radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 2) {
                    degreeOffset = ring1degreeOffset.negate().add(degreeSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring1radius.multiply(sinOffset).negate();
                    y = ring1radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

            }

            ring1.add(section);

        }

    }

    private void calculateBackRing4Points() {

        backRing4 = new LinkedList<>();

        for (int i = 0; i < 9; i++) {

            List<BigDecimalPoint> section = new LinkedList<>();

            for (int j = 0; j < 3; j++) {

                BigDecimal degreeOffset, sinOffset, cosOffset, x, y;

                if (j == 0) {
                    degreeOffset = backRing4degreeOffset.add(degreeBackSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring4radius.multiply(sinOffset).negate();
                    y = ring4radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 1) {
                    degreeOffset = degreeBackSectionOffset.multiply(new BigDecimal(i));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring4radius.multiply(sinOffset).negate();
                    y = ring4radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 2) {
                    degreeOffset = backRing4degreeOffset.negate().add(degreeBackSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring4radius.multiply(sinOffset).negate();
                    y = ring4radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

            }

            backRing4.add(section);

        }

    }

    private void calculateBackRing3Points() {

        backRing3 = new LinkedList<>();

        for (int i = 0; i < 9; i++) {

            List<BigDecimalPoint> section = new LinkedList<>();

            for (int j = 0; j < 3; j++) {

                BigDecimal degreeOffset, sinOffset, cosOffset, x, y;

                if (j == 0) {
                    degreeOffset = backRing3degreeOffset.add(degreeBackSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring3radius.multiply(sinOffset).negate();
                    y = ring3radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 1) {
                    degreeOffset = degreeBackSectionOffset.multiply(new BigDecimal(i));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring3radius.multiply(sinOffset).negate();
                    y = ring3radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

                if (j == 2) {
                    degreeOffset = backRing3degreeOffset.negate().add(degreeBackSectionOffset.multiply(new BigDecimal(i)));
                    sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
                    cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
                    x = ring3radius.multiply(sinOffset).negate();
                    y = ring3radius.multiply(cosOffset);
                    section.add(new BigDecimalPoint(x, y));
                }

            }

            backRing3.add(section);

        }

    }

    private void calculateBackRing2Points() {

        backRing2 = new LinkedList<>();

        for (int i = 0; i < 9; i++) {

            BigDecimal degreeOffset, sinOffset, cosOffset, x, y;
            degreeOffset = backRing2degreeOffset.multiply(new BigDecimal(i)).negate();
            sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
            cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
            x = backRing2radius.multiply(sinOffset).negate();
            y = backRing2radius.multiply(cosOffset);
            backRing2.add(new BigDecimalPoint(x, y));

        }

        backRing2Middle = new LinkedList<>();

        for (int i = 0; i < 9; i++) {

            BigDecimal degreeOffset, sinOffset, cosOffset, x, y;
            degreeOffset = backRing2degreeOffsetMiddleStart.add(backRing2degreeOffset.multiply(new BigDecimal(i+1)).negate());
            sinOffset = new BigDecimal(Math.sin(Math.toRadians(degreeOffset.doubleValue())), mc);
            cosOffset = new BigDecimal(Math.cos(Math.toRadians(degreeOffset.doubleValue())), mc);
            x = backRing2radius.multiply(sinOffset).negate();
            y = backRing2radius.multiply(cosOffset);
            backRing2Middle.add(new BigDecimalPoint(x, y));

        }

        backRingLine3to6middle.calculateLine(backRing2.get(3), backRingLineSlopeZero);
        backRingLine6to9middle.calculateLine(backRing2.get(6), backRingLineSlopePos);
        backRingLine9to3middle.calculateLine(backRing2.get(0), backRingLineSlopeNeg);
        backRingLine1to2middle.calculateLine(backRing2.get(1), backRingLineSlopeNeg);
        backRingLine2to4middle.calculateLine(backRing2.get(2), backRingLineSlopePos);
        backRingLine4to8middle.calculateLine(backRing2.get(4), backRingLineSlopeNeg);
        backRingLine8to7middle.calculateLine(backRing2.get(8), backRingLineSlopePos);
        backRingLine7to5middle.calculateLine(backRing2.get(7), backRingLineSlopeNeg);
        backRingLine5to1middle.calculateLine(backRing2.get(5), backRingLineSlopePos);

        backRingLine3to6top = backRingLine3to6middle.shiftLine(new BigDecimal(40));
        backRingLine6to9top = backRingLine6to9middle.shiftLine(new BigDecimal(80));
        backRingLine9to3top = backRingLine9to3middle.shiftLine(new BigDecimal(80));
        backRingLine1to2top = backRingLine1to2middle.shiftLine(new BigDecimal(0));
        backRingLine2to4top = backRingLine2to4middle.shiftLine(new BigDecimal(80));
        backRingLine4to8top = backRingLine4to8middle.shiftLine(new BigDecimal(80));
        backRingLine8to7top = backRingLine8to7middle.shiftLine(new BigDecimal(0));
        backRingLine7to5top = backRingLine7to5middle.shiftLine(new BigDecimal(80));
        backRingLine5to1top = backRingLine5to1middle.shiftLine(new BigDecimal(80));

        backRingLine3to6bottom = backRingLine3to6middle.shiftLine(new BigDecimal(-40));
        backRingLine6to9bottom = backRingLine6to9middle.shiftLine(new BigDecimal(-80));
        backRingLine9to3bottom = backRingLine9to3middle.shiftLine(new BigDecimal(-80));
        backRingLine1to2bottom = backRingLine1to2middle.shiftLine(new BigDecimal(-160));
        backRingLine2to4bottom = backRingLine2to4middle.shiftLine(new BigDecimal(-80));
        backRingLine4to8bottom = backRingLine4to8middle.shiftLine(new BigDecimal(-80));
        backRingLine8to7bottom = backRingLine8to7middle.shiftLine(new BigDecimal(-160));
        backRingLine7to5bottom = backRingLine7to5middle.shiftLine(new BigDecimal(-80));
        backRingLine5to1bottom = backRingLine5to1middle.shiftLine(new BigDecimal(-80));

        backRing3pointCurvedSection1to2 = new LinkedList<>();
        backRing3pointCurvedSection1to2.add(backRingCircle.getIntersectionPoints(backRingLine1to2top).get(0));
        backRing3pointCurvedSection1to2.add(backRingCircle.getIntersectionPoints(backRingLine1to2top).get(1));
        backRing3pointCurvedSection1to2.add(backRing2Middle.get(1));

        backRing3pointCurvedSection7to8 = new LinkedList<>();
        backRing3pointCurvedSection7to8.add(backRingCircle.getIntersectionPoints(backRingLine8to7top).get(0));
        backRing3pointCurvedSection7to8.add(backRingCircle.getIntersectionPoints(backRingLine8to7top).get(1));
        backRing3pointCurvedSection7to8.add(backRing2Middle.get(7));

        backRing3pointStraightSection3 = new LinkedList<>();
        backRing3pointStraightSection3.add(backRingLine9to3bottom.getIntersectionPoint(backRingLine3to6top));
        backRing3pointStraightSection3.add(backRingLine2to4bottom.getIntersectionPoint(backRingLine9to3bottom));
        backRing3pointStraightSection3.add(backRingLine2to4bottom.getIntersectionPoint(backRingLine3to6top));

        backRing3pointStraightSection4 = new LinkedList<>();
        backRing3pointStraightSection4.add(backRingLine2to4top.getIntersectionPoint(backRingLine4to8top));
        backRing3pointStraightSection4.add(backRingLine3to6bottom.getIntersectionPoint(backRingLine2to4top));
        backRing3pointStraightSection4.add(backRingLine3to6bottom.getIntersectionPoint(backRingLine4to8top));

        backRing3pointStraightSection5 = new LinkedList<>();
        backRing3pointStraightSection5.add(backRingLine7to5top.getIntersectionPoint(backRingLine5to1top));
        backRing3pointStraightSection5.add(backRingLine3to6bottom.getIntersectionPoint(backRingLine7to5top));
        backRing3pointStraightSection5.add(backRingLine3to6bottom.getIntersectionPoint(backRingLine5to1top));

        backRing3pointStraightSection6 = new LinkedList<>();
        backRing3pointStraightSection6.add(backRingLine6to9bottom.getIntersectionPoint(backRingLine3to6top));
        backRing3pointStraightSection6.add(backRingLine7to5bottom.getIntersectionPoint(backRingLine6to9bottom));
        backRing3pointStraightSection6.add(backRingLine7to5bottom.getIntersectionPoint(backRingLine3to6top));

        backRing3pointStraightSectionBelowZero = new LinkedList<>();
        backRing3pointStraightSectionBelowZero.add(backRingLine4to8bottom.getIntersectionPoint(backRingLine5to1bottom));
        backRing3pointStraightSectionBelowZero.add(backRingLine3to6top.getIntersectionPoint(backRingLine4to8bottom));
        backRing3pointStraightSectionBelowZero.add(backRingLine3to6top.getIntersectionPoint(backRingLine5to1bottom));

        backRing4pointCurvedSection2to3 = new LinkedList<>();
        backRing4pointCurvedSection2to3.add(backRingCircle.getIntersectionPoints(backRingLine9to3top).get(0));
        backRing4pointCurvedSection2to3.add(backRingCircle.getIntersectionPoints(backRingLine2to4bottom).get(0));
        backRing4pointCurvedSection2to3.add(backRingLine9to3top.getIntersectionPoint(backRingLine2to4bottom));
        backRing4pointCurvedSection2to3.add(backRing2Middle.get(2));

        backRing4pointCurvedSection3to4 = new LinkedList<>();
        backRing4pointCurvedSection3to4.add(backRingCircle.getIntersectionPoints(backRingLine2to4bottom).get(1));
        backRing4pointCurvedSection3to4.add(backRingCircle.getIntersectionPoints(backRingLine3to6bottom).get(0));
        backRing4pointCurvedSection3to4.add(backRingLine2to4bottom.getIntersectionPoint(backRingLine3to6bottom));
        backRing4pointCurvedSection3to4.add(backRing2Middle.get(3));

        backRing4pointCurvedSection5to6 = new LinkedList<>();
        backRing4pointCurvedSection5to6.add(backRingCircle.getIntersectionPoints(backRingLine7to5bottom).get(0));
        backRing4pointCurvedSection5to6.add(backRingCircle.getIntersectionPoints(backRingLine3to6bottom).get(1));
        backRing4pointCurvedSection5to6.add(backRingLine7to5bottom.getIntersectionPoint(backRingLine3to6bottom));
        backRing4pointCurvedSection5to6.add(backRing2Middle.get(5));

        backRing4pointCurvedSection6to7 = new LinkedList<>();
        backRing4pointCurvedSection6to7.add(backRingCircle.getIntersectionPoints(backRingLine7to5bottom).get(1));
        backRing4pointCurvedSection6to7.add(backRingCircle.getIntersectionPoints(backRingLine6to9top).get(1));
        backRing4pointCurvedSection6to7.add(backRingLine7to5bottom.getIntersectionPoint(backRingLine6to9top));
        backRing4pointCurvedSection6to7.add(backRing2Middle.get(6));

        backRing4pointCurvedSection8to9 = new LinkedList<>();
        backRing4pointCurvedSection8to9.add(backRingCircle.getIntersectionPoints(backRingLine4to8top).get(1));
        backRing4pointCurvedSection8to9.add(backRingCircle.getIntersectionPoints(backRingLine6to9top).get(0));
        backRing4pointCurvedSection8to9.add(backRingLine4to8top.getIntersectionPoint(backRingLine6to9top));
        backRing4pointCurvedSection8to9.add(backRing2Middle.get(8));

        backRing4pointCurvedSection9to1 = new LinkedList<>();
        backRing4pointCurvedSection9to1.add(backRingCircle.getIntersectionPoints(backRingLine9to3top).get(1));
        backRing4pointCurvedSection9to1.add(backRingCircle.getIntersectionPoints(backRingLine5to1top).get(0));
        backRing4pointCurvedSection9to1.add(backRingLine9to3top.getIntersectionPoint(backRingLine5to1top));
        backRing4pointCurvedSection9to1.add(backRing2Middle.get(0));

        backRing4pointCurvedSectionBelowZero = new LinkedList<>();
        backRing4pointCurvedSectionBelowZero.add(backRingLine5to1top.getIntersectionPoint(backRingLine4to8top));
        backRing4pointCurvedSectionBelowZero.add(backRingMiddleCircle.getIntersectionPoints(backRingLine4to8top).get(0));
        backRing4pointCurvedSectionBelowZero.add(backRingMiddleCircle.getIntersectionPoints(backRingLine5to1top).get(1));
        backRing4pointCurvedSectionBelowZero.add(new BigDecimalPoint(new BigDecimal(0), backCircle0OuterRadius.negate()));

        backRing4pointStraightSection1to2 = new LinkedList<>();
        backRing4pointStraightSection1to2.add(backRingLine1to2bottom.getIntersectionPoint(backRingLine5to1bottom));
        backRing4pointStraightSection1to2.add(backRingLine1to2bottom.getIntersectionPoint(backRingLine2to4top));
        backRing4pointStraightSection1to2.add(backRingLine9to3top.getIntersectionPoint(backRingLine2to4top));
        backRing4pointStraightSection1to2.add(backRingLine9to3top.getIntersectionPoint(backRingLine5to1bottom));

        backRing4pointStraightSection7to8 = new LinkedList<>();
        backRing4pointStraightSection7to8.add(backRingLine8to7bottom.getIntersectionPoint(backRingLine4to8bottom));
        backRing4pointStraightSection7to8.add(backRingLine8to7bottom.getIntersectionPoint(backRingLine7to5top));
        backRing4pointStraightSection7to8.add(backRingLine6to9top.getIntersectionPoint(backRingLine7to5top));
        backRing4pointStraightSection7to8.add(backRingLine6to9top.getIntersectionPoint(backRingLine4to8bottom));

        backRing5pointCurvedSection4to5 = new LinkedList<>();
        backRing5pointCurvedSection4to5.add(backRingCircle.getIntersectionPoints(backRingLine4to8bottom).get(0));
        backRing5pointCurvedSection4to5.add(backRingCircle.getIntersectionPoints(backRingLine5to1bottom).get(1));
        backRing5pointCurvedSection4to5.add(backRingLine3to6bottom.getIntersectionPoint(backRingLine4to8bottom));
        backRing5pointCurvedSection4to5.add(backRingLine3to6bottom.getIntersectionPoint(backRingLine5to1bottom));
        backRing5pointCurvedSection4to5.add(backRing2Middle.get(4));

        backRing5pointStraightSectionLeft = new LinkedList<>();
        backRing5pointStraightSectionLeft.add(backRingLine6to9bottom.getIntersectionPoint(backRingLine4to8bottom));
        backRing5pointStraightSectionLeft.add(backRingLine5to1top.getIntersectionPoint(backRingLine4to8bottom));
        backRing5pointStraightSectionLeft.add(backRingLine5to1top.getIntersectionPoint(backRingLine3to6top));
        backRing5pointStraightSectionLeft.add(backRingLine7to5top.getIntersectionPoint(backRingLine3to6top));
        backRing5pointStraightSectionLeft.add(backRingLine7to5top.getIntersectionPoint(backRingLine6to9bottom));

        backRing5pointStraightSectionRight = new LinkedList<>();
        backRing5pointStraightSectionRight.add(backRingLine9to3bottom.getIntersectionPoint(backRingLine5to1bottom));
        backRing5pointStraightSectionRight.add(backRingLine9to3bottom.getIntersectionPoint(backRingLine2to4top));
        backRing5pointStraightSectionRight.add(backRingLine3to6top.getIntersectionPoint(backRingLine2to4top));
        backRing5pointStraightSectionRight.add(backRingLine3to6top.getIntersectionPoint(backRingLine4to8top));
        backRing5pointStraightSectionRight.add(backRingLine5to1bottom.getIntersectionPoint(backRingLine4to8top));

        backRing6pointCurvedSectionAboveZero = new LinkedList<>();
        backRing6pointCurvedSectionAboveZero.add(backRingLine9to3bottom.getIntersectionPoint(backRingLine6to9bottom));
        backRing6pointCurvedSectionAboveZero.add(backRingLine9to3bottom.getIntersectionPoint(backRingLine5to1top));
        backRing6pointCurvedSectionAboveZero.add(backRingLine4to8top.getIntersectionPoint(backRingLine6to9bottom));
        backRing6pointCurvedSectionAboveZero.add(backRingMiddleCircle.getIntersectionPoints(backRingLine5to1top).get(0));
        backRing6pointCurvedSectionAboveZero.add(backRingMiddleCircle.getIntersectionPoints(backRingLine4to8top).get(1));
        backRing6pointCurvedSectionAboveZero.add(new BigDecimalPoint(new BigDecimal(0), backCircle0OuterRadius));

    }

    public static void main(String[] arguments) {

        CodexGenerator generator = new CodexGenerator();
        generator.calculateDegreeOffsets();
        generator.calculateSinCosOffsets();
        generator.calculateRing7Points();
        generator.calculateRing6Points();
        generator.calculateRing5OuterPoints();
        generator.calculateRing5InnerPoints();
        generator.calculateRing4Points();
        generator.calculateRing3Points();
        generator.calculateRing2Points();
        generator.calculateRing1Points();
        generator.calculateBackRing4Points();
        generator.calculateBackRing3Points();
        generator.calculateBackRing2Points();
        generator.printValues();
        generator.printScript();

    }

}