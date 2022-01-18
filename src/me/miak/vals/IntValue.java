package me.miak.vals;

public class IntValue extends Value {

    public IntValue(int value) {
        super(Type.INT, value);
    }

    public Boolean getBool() {
        return (int) this.getValue() > 0;
    }

    @Override
    public Value add(Value other) {
        if (other.getType() == Type.INT) {
            return new IntValue((int) this.getValue() + (int) other.getValue());
        }
        else if (other.getType() == Type.STRING) {
            return new StringValue(this.getValue().toString() + other.getValue().toString());
        }
        throw new RuntimeException("Invalid addition between IntValues");
    }

    @Override
    public Value pow(Value other) {
        if (other.getType() == Type.INT) {
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
        if (other.getType() == Type.INT) {
            return new IntValue((int) this.getValue() - (int) other.getValue());
        }
        throw new RuntimeException("Invalid subtraction between IntValues");
    }

    @Override
    public Value mult(Value other) {
        if (other.getType() == Type.INT) {
            return new IntValue((int) this.getValue() * (int) other.getValue());
        }
        throw new RuntimeException("Invalid multiplication between IntValues");
    }

    @Override
    public Value mod(Value other) {
        if (other.getType() == Type.INT) {
            int n = (int) this.getValue();
            int m = (int) other.getValue();
            return new IntValue((((n % m) + m) % m));
        }
        throw new RuntimeException("Invalid mod between IntValues");
    }

    @Override
    public Value div(Value other) {
        if (other.getType() == Type.INT) {
            return new IntValue((int) this.getValue() / (int) other.getValue());
        }
        throw new RuntimeException("Invalid div between IntValues");
    }

    @Override
    public Value lessThan(Value other) {
        if (other.getType() == Type.INT) {
            return new BoolValue((int) this.getValue() < (int) other.getValue());
        }
        throw new RuntimeException("Invalid lessThan between IntValues");
    }

    @Override
    public Value lessOrEqualThan(Value other) {
        if (other.getType() == Type.INT) {
            return new BoolValue((int) this.getValue() <= (int) other.getValue());
        }
        throw new RuntimeException("Invalid lessOrEqualThan between IntValues");
    }

    @Override
    public Value moreOrEqualThan(Value other) {
        if (other.getType() == Type.INT) {
            return new BoolValue((int) this.getValue() >= (int) other.getValue());
        }
        throw new RuntimeException("Invalid moreOrEqualThan between IntValues");
    }
}
