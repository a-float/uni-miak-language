package me.miak;

public class IntValue extends Value {

    public IntValue(int value) {
        super(value);
    }

    @Override
    public Value add(Value other) {
        if (other instanceof IntValue) {
            return new IntValue((int) this.value + (int) other.value);
        }
        throw new RuntimeException("Invalid addition between IntValues");
    }

    @Override
    public Value pow(Value other) {
        if (other instanceof IntValue) {
            return new IntValue((int) Math.pow((int) this.getValue(), (int) other.getValue()));
        }
        throw new RuntimeException("Invalid exponent between IntValues");
    }

    @Override
    public Value unaryMinus() {
        return new IntValue(-(int) this.getValue());
    }

    @Override
    public Value subtract(Value other) {
        if (other instanceof IntValue) {
            return new IntValue((int) this.value - (int) other.value);
        }
        throw new RuntimeException("Invalid subtraction between IntValues");
    }

    @Override
    public Value mult(Value other) {
        if (other instanceof IntValue) {
            return new IntValue((int) this.value * (int) other.value);
        }
        throw new RuntimeException("Invalid multiplication between IntValues");
    }

    @Override
    public Value mod(Value other) {
        if (other instanceof IntValue) {
            int n = (int) this.getValue();
            int m = (int) other.getValue();
            return new IntValue((((n % m) + m) % m));
        }
        throw new RuntimeException("Invalid mod between IntValues");
    }

    @Override
    public Value div(Value other) {
        if (other instanceof IntValue) {
            return new IntValue((int) this.value / (int) other.value);
        }
        throw new RuntimeException("Invalid mod between IntValues");
    }
}
