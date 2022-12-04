import javafx.scene.control.Button;

public abstract class UIButton extends Event{
    public Button button;

    /**
     * Constructor for UIButton - every UIButton must initialize a JavaFx Button
     */
    public UIButton() {
        button = new Button();
    }


}
