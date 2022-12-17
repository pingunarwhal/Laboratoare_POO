package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// DIAGRAM CLASSES
class DiagramComponent {
    private String text = "text";
    private String color = "WHITE";
    private int height = 40;
    private int weight = 100;

    @Override
    public String toString() {
        return "[" +
                "text='" + text + '\'' +
                ", color='" + color + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", connectedComponents=" + connectedComponents +
                ']';
    }

    private List<String> connectedComponents = new ArrayList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void connectTo(String componentId) {
        connectedComponents.add(componentId);
    }

    public void removeConnection(String componentId) {
        connectedComponents.remove(componentId);
    }
}


class DiagramCanvas {
    private List<DiagramComponent> components = new ArrayList<>();

    public void addComponent(DiagramComponent diagramComponent) {
        components.add(diagramComponent);
    }

    public void removeComponent(DiagramComponent diagramComponent) {
        components.remove(diagramComponent);
    }

    public DiagramComponent getComponent(int id) {
        return components.get(id);
    }

    public void show() {
        System.out.println("Diagram:");
        components.forEach(System.out::println);
    }
}


// COMMAND CLASSES
enum CommandType {
    DRAW_RECTANGLE("draw rectangle"),
    CHANGE_COLOR("change color"),
    RESIZE("resize"),
    CONNECT("connect"),
    CHANGE_TEXT("change text");

    public final String text;

    CommandType(String text) {
        this.text = text;
    }

    public static CommandType fromString(String text) {
        for (CommandType commandType : CommandType.values()) {
            if (commandType.text.equalsIgnoreCase(text)) {
                return commandType;
            }
        }
        return null;
    }
}

interface DrawCommand {
    void execute();
    void undo();
}

class DrawRectangleCommand implements DrawCommand {
    private DiagramCanvas canvas;
    private DiagramComponent component;

    public DrawRectangleCommand(DiagramCanvas diagramCanvas) {
        this.canvas = diagramCanvas;
        this.component = new DiagramComponent();
    }

    @Override
    public void execute() {
        canvas.addComponent(this.component);
    }

    @Override
    public void undo() {
        canvas.removeComponent(this.component);
    }
}

class ResizeCommand implements DrawCommand {
    private DiagramComponent component;
    private double percent;
    private int prevWidth;
    private int prevHeight;

    public ResizeCommand(DiagramCanvas diagramCanvas, int idx, double percent) {
        this.component = diagramCanvas.getComponent(idx);
        this.percent = percent;
    }

    @Override
    public void execute() {
        this.prevWidth = this.component.getWeight();
        this.prevHeight = this.component.getHeight();
        this.component.setWeight((int) (this.prevWidth * this.percent / 100));
        this.component.setHeight((int) (this.prevHeight * this.percent / 100));
    }

    @Override
    public void undo() {
        this.component.setWeight(prevWidth);
        this.component.setWeight(prevHeight);
    }
}

class ConnectComponentsCommand implements DrawCommand {
    ArrayList<DiagramComponent> components;
    String idx1;
    String idx2;

    public ConnectComponentsCommand(DiagramCanvas diagramCanvas, String idx1, String idx2) {
        this.components = new ArrayList<>();
        this.components.add(diagramCanvas.getComponent(Integer.parseInt(idx1)));
        this.components.add(diagramCanvas.getComponent(Integer.parseInt(idx2)));
        this.idx1 = idx1;
        this.idx2 = idx2;
    }

    @Override
    public void execute() {
        this.components.get(0).connectTo(this.idx2);
        this.components.get(1).connectTo(this.idx1);
    }

    @Override
    public void undo() {
        this.components.get(0).removeConnection(this.idx2);
        this.components.get(1).removeConnection(this.idx1);
    }
}

class ChangeTextCommand implements DrawCommand {
    DiagramComponent component;
    String text;
    String textPrev;

    public ChangeTextCommand(DiagramCanvas diagramCanvas, int idx, String text) {
        this.component = diagramCanvas.getComponent(idx);
        this.text = text;
    }

    @Override
    public void execute() {
        this.textPrev = this.component.getText();
        this.component.setText(this.text);
    }

    @Override
    public void undo() {
        this.component.setText(this.textPrev);
    }
}

class ChangeColorCommand implements DrawCommand {
    DiagramComponent component;
    String colour;
    String colourPrev;

    public ChangeColorCommand(DiagramCanvas diagramCanvas, int idx, String colour) {
        this.component = diagramCanvas.getComponent(idx);
        this.colour = colour;
    }

    @Override
    public void execute() {
        this.colourPrev = this.component.getColor();
        this.component.setColor(this.colour);
    }

    @Override
    public void undo() {
        this.component.setColor(this.colourPrev);
    }
}

class Invoker {
    ArrayList<DrawCommand> todo = new ArrayList<>();
    ArrayList<DrawCommand> redo = new ArrayList<>();

    /**
     * Clear up all the used resources, start fresh :D
     */
    public void restart() {
        todo = new ArrayList<>();
        redo = new ArrayList<>();
    }

    /**
     * Executes a given command
     * @param command
     */
    public void execute(DrawCommand command) {
        todo.add(command);
        command.execute();
    }

    /**
     * Undo the latest command
     */
    public void undo() {
        todo.get(todo.size() - 1).undo();
        redo.add(todo.get(todo.size() - 1));
        todo.remove(todo.size() - 1);
    }

    /**
     * Redo command previously undone. Cannot perform a redo after an execute, only after at least one undo.
     */
    public void redo() {
        redo.get(redo.size() - 1).execute();
        todo.add(redo.get(redo.size() - 1));
        redo.remove(redo.size() - 1);
    }
}

class Client {

    private Invoker invoker;
    private DiagramCanvas diagramCanvas;

    Client() {
        invoker = new Invoker();
        diagramCanvas = new DiagramCanvas();
    }

    public void showDiagram() {
        diagramCanvas.show();
    }

    public void newDiagram() {
        diagramCanvas = new DiagramCanvas();
        invoker.restart();
    }

    public void executeAction(String commandName, String ...args) {
        DrawCommand command;
        try {
            CommandType commandType = CommandType.fromString(commandName);
            if (commandType == null) {
                throw new IllegalArgumentException();
            }
            command = getCommand(commandType, args);

        } catch(IllegalArgumentException ex) {
            System.out.println("Invalid command: " + commandName);
            System.out.println("Available commands:");
            for (CommandType type : CommandType.values()) {
                System.out.println("\t- " + type.text);
            }
            return;
        }

        invoker.execute(command);
    }

    private DrawCommand getCommand(CommandType type, String ...args) throws IllegalArgumentException {
        try {
            return switch (type) {
                case DRAW_RECTANGLE -> new DrawRectangleCommand(diagramCanvas);
                case RESIZE -> new ResizeCommand(diagramCanvas, Integer.parseInt(args[0]), Double.parseDouble(args[1]));
                case CONNECT -> new ConnectComponentsCommand(diagramCanvas, args[0], args[1]);
                case CHANGE_TEXT -> new ChangeTextCommand(diagramCanvas, Integer.parseInt(args[0]), args[1]);
                case CHANGE_COLOR -> new ChangeColorCommand(diagramCanvas, Integer.parseInt(args[0]), args[1]);
            };
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    public void undo(){
        invoker.undo();
    }

    public void redo() {
        invoker.redo();
    }
}

public class Main {
    private static String spacerSymbols = new String(new char[40]).replace("\0", "-");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();

        Client client = new Client();

        switch(taskNum) {
            case 1:
                printOutputSpacerFor("testDraw");
                testDraw(client);

                printOutputSpacerFor("testTextAndColor");
                testTextAndColor(client);

                printOutputSpacerFor("testResize");
                testResize(client);

                printOutputSpacerFor("testConnect");
                testConnect(client);

                printOutputSpacerFor("testAllCommands");
                testAllCommands(client);

                break;
            case 2:
                printOutputSpacerFor("testSimpleUndoRedo");
                testSimpleUndoRedo(client);

                printOutputSpacerFor("testComplexUndoRedo");
                testComplexUndoRedo(client);

                break;
        }

    }

    private static void printOutputSpacerFor(String test) {
        System.out.println(spacerSymbols + test + spacerSymbols);
    }

    private static void testDraw(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");

        client.showDiagram();
    }

    private static void testTextAndColor(Client client) {
        testDraw(client);
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");
        client.showDiagram();
    }

    private static void testConnect(Client client) {
        testDraw(client);
        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "3", "2");
        client.executeAction("connect", "1", "4");
        client.executeAction("draw rectangle");
        client.showDiagram();
    }

    private static void testResize(Client client) {
        testDraw(client);
        client.executeAction("resize", "0", "10");
        client.executeAction("resize", "2", "50");
        client.executeAction("resize", "4", "25");
        client.showDiagram();
    }

    private static void testAllCommands(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("resize", "0", "10");
        client.executeAction("change color", "2", "PINK");
        client.executeAction("connect", "2", "1");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "1", "Class1");
        client.executeAction("change text", "3", "Class2");

        client.showDiagram();
    }

    private static void testSimpleUndoRedo(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
    }

    private static void testComplexUndoRedo(Client client) {
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("resize", "0", "10");
        client.executeAction("change color", "2", "PINK");
        client.executeAction("connect", "2", "1");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "1", "Class1");
        client.executeAction("change color", "3", "RED");
        client.showDiagram();
        client.undo();
        client.undo();
        client.showDiagram();

        client.undo();
        client.undo();
        client.showDiagram();

        client.redo();
        client.redo();
        client.executeAction("resize", "2", "50");
        client.showDiagram();
    }
}
