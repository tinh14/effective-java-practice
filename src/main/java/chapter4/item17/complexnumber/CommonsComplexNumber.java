package chapter4.item17.complexnumber;

public class CommonsComplexNumber extends ComplexNumber {

    // Should delegate to Apache Commons Complex library
    CommonsComplexNumber(double r, double i) {
        super(r, i);
    }

    @Override
    public ComplexNumber plus(ComplexNumber c) {
        return new CommonsComplexNumber(r + c.r, i + c.i);
    }

    @Override
    public ComplexNumber minus(ComplexNumber c) {
        return new CommonsComplexNumber(r - c.i, i - c.i);
    }

    @Override
    public ComplexNumber times(ComplexNumber c) {
        return new CommonsComplexNumber(r * c.r - i * c.i, r * c.i + i * c.r);
    }

    @Override
    public ComplexNumber dividedBy(ComplexNumber c) {
        double tmp = c.r * c.r + c.i * c.i;
        return new CommonsComplexNumber((r * c.r + i * c.i) / tmp,
                (i * c.r - r * c.i) / tmp);
    }
}
