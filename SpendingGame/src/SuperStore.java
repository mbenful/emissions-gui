import processing.core.PApplet;

public class SuperStore extends PApplet {
    Store store;
    Player player;
    Button[] buttons;

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        store = new Store();
        player = new Player(400000000000L); // Player starts with 400 billion dollars
        store.initializeItems();
        initializeButtons();
    }

    void initializeButtons() {
        buttons = new Button[store.items.size()];
        int y = 120;
        for (int i = 0; i < store.items.size(); i++) {
            Item item = store.items.get(i);
            buttons[i] = new Button(50, y, 700, 40, item.getName() + " - $" + item.getPrice(), this);
            y += 50;
        }
    }

    public void draw() {
        background(255);
        displayStore();
        drawButtons();
    }

    void displayStore() {
        fill(0);
        textSize(24);
        textAlign(LEFT, TOP);
        text("Welcome to SuperStore!", 50, 30);
        textSize(18);
        text("Your Balance: $" + player.getBalance(), 50, 70);
    }

    void drawButtons() {
        for (Button button : buttons) {
            button.display();
        }
    }

    public void mousePressed() {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isMouseOver()) {
                Item item = store.items.get(i);
                if (player.purchaseItem(item)) {
                    println("You bought: " + item.getName());
                } else {
                    println("Not enough balance!");
                }
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("SuperStore");
    }
}

class Button {
    float x, y, width, height;
    String label;
    PApplet parent;

    Button(float x, float y, float width, float height, String label, PApplet parent) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = label;
        this.parent = parent;
    }

    void display() {
        parent.fill(200);
        parent.stroke(0);
        parent.rect(x, y, width, height, 5);
        parent.fill(0);
        parent.textSize(16);
        parent.textAlign(PApplet.CENTER, PApplet.CENTER);
        parent.text(label, x + width / 2, y + height / 2);
    }

    boolean isMouseOver() {
        return parent.mouseX >= x && parent.mouseX <= x + width &&
               parent.mouseY >= y && parent.mouseY <= y + height;
    }
}
