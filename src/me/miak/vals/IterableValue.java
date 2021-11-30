package me.miak.vals;

import org.antlr.v4.runtime.misc.Triple;

public class IterableValue extends Value {
    private final Value stop;
    private final boolean goingUp;
    private Value start;
    private Value step;
    private boolean isFinished = false;

    public IterableValue(Value start, Value stop, Value step) {
        super(Type.ITERABLE, new Triple<>(start, stop, step));
        if (start.getType() != Type.INT || stop.getType() != Type.INT || step.getType() != Type.INT) {
            throw new IllegalArgumentException("Invalid range arguments: not INTS");
        }
        this.start = start;
        this.stop = stop;
        this.step = step;
        this.goingUp = start.lessThan(stop).getBool();
        if (this.goingUp && this.step.lessThan(new IntValue(0)).getBool()) {
            throw new RuntimeException("Invalid step value: " + step + " - infinite loop going down");
        } else if (!this.goingUp && (new IntValue(0)).lessThan(this.step).getBool()) {
            throw new RuntimeException("Invalid step value: " + step + " - infinite loop going up");
        }
    }

    public IterableValue(Value start, Value stop) {
        super(Type.ITERABLE, null);
        if (start.getType() != Type.INT || stop.getType() != Type.INT) {
            throw new IllegalArgumentException("Invalid range arguments: not INTS");
        }
        this.start = start;
        this.stop = stop;

        this.step = (start.lessThan(stop).getBool()) ? new IntValue(1) : new IntValue(-1);
        this.goingUp = start.lessThan(stop).getBool();
    }

    public Value getStart() {
        return this.start;
    }

    public Value next() {
        if (!this.isFinished) {
            this.start = this.start.add(this.step);
            if (this.goingUp && this.stop.lessThan(this.start).getBool()) {
                this.isFinished = true;
            } else if (!this.goingUp && this.start.lessThan(this.stop).getBool()) {
                this.isFinished = true;
            }
            return this.getStart();
        } else {
            return new BoolValue(false);
        }
    }
}
