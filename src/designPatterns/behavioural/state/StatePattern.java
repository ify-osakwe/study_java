package designPatterns.behavioural.state;

abstract class RemoteControl {
    public abstract void pressSwitch(TV context);
}

class On extends RemoteControl {

    @Override
    public void pressSwitch(TV context) {
        System.out.println("I am already On. Going to be off now");
        context.setState(new Off());
    }
}

class Off extends RemoteControl {

    @Override
    public void pressSwitch(TV context) {
        System.out.println("I am already off. Going to be On now");
        context.setState(new On());
    }
}

class TV {
    private RemoteControl state;

    public TV(RemoteControl state) {
        this.state = state;
    }

    public RemoteControl getState() {
        return state;
    }

    public void setState(RemoteControl state) {
        this.state = state;
    }

    public void pressButton() {
        state.pressSwitch(this);
    }
}

public class StatePattern {
    public static void main(String[] args) {
        Off initialState = new Off();
        TV tv = new TV(initialState);

        tv.pressButton();
        tv.pressButton();
    }
}
