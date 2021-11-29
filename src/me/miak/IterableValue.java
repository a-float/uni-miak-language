package me.miak;

public class IterableValue extends Value {
    private Value start;
    private final Value stop;
    private Value step;
    private boolean isFinished = false;
    private final boolean goingUp;

    public IterableValue(IntValue start, IntValue stop, IntValue step) {
        super(null);
        this.start = start;
        this.stop = stop;
        this.step = step;
        this.goingUp = start.lessThan(stop).getBool();
        if(this.goingUp && this.step.lessThan(new IntValue(0)).getBool()){
            throw new RuntimeException("Invalid step value - infinite loop going down");
        }
        else if (!this.goingUp && (new IntValue(0)).lessThan(this.step).getBool()){
            throw new RuntimeException("Invalid step value - infinite loop going up");
        }
    }

    public IterableValue(IntValue start, IntValue stop) {
        super(null);
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
            if (this.goingUp && this.stop.lessThan(this.start).getBool()){
                this.isFinished = true;
            }
            else if (!this.goingUp && this.start.lessThan(this.stop).getBool()){
                this.isFinished = true;
            }
            return this.getStart();
        } else {
            return new BoolValue(false);
        }
    }
}
