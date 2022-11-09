package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

interface Task {
    void execute();
}

class OutTask implements Task {

    String messageF;

    public OutTask(String message) {
        messageF = message;
    }

    public void execute() {
        System.out.println(messageF);
    }
}

class RandomOutTask implements Task {

    static Random randomNum = new Random(12345);

    int randomInt;

    public RandomOutTask() {
        randomInt = randomNum.nextInt();
    }

    public void execute() {
        System.out.println(randomInt);
    }
}

class CounterOutTask implements Task {

    static int counter = 0;

    public void execute() {
        counter++;
        System.out.println(counter);
    }
}

interface Container {
    Task pop();

    void push(Task task);

    int size();

    boolean isEmpty();

    void transferFrom(Container container);

    ArrayList<Task> getTasks();
}

class Queue implements Container {

    ArrayList<Task> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    @Override
    public Task pop() {
        return queue.remove(0);
    }

    @Override
    public void push(Task task) {
        queue.add(task);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            queue.add(container.pop());
        }
    }

    @Override
    public ArrayList<Task> getTasks() {
        return queue;
    }
}

class Stack implements Container {

    static ArrayList<Task> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    @Override
    public Task pop() {
        return stack.remove(stack.size() - 1);
    }

    @Override
    public void push(Task task) {
        stack.add(task);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            stack.add(container.pop());
        }
    }

    @Override
    public ArrayList<Task> getTasks() {
        return stack;
    }
}

interface Minus {
    void minus(float val);
}

interface Plus {
    void plus(float val);
}

interface Mult {
    void mult(float val);
}

interface Div {
    void div(float val);
}

class Operation implements Minus, Plus, Mult, Div {

    private float value;

    public Operation(float value) {
        this.value = value;
    }

    public float getNumber() {
        return value;
    }

    @Override
    public void minus(float val) {
        this.value -= val;
    }

    @Override
    public void plus(float val) {
        this.value += val;
    }

    @Override
    public void mult(float val) {
        this.value *= val;
    }

    @Override
    public void div(float val) {
        if (val == 0) {
            System.out.println("Division by zero is not possible");
            return;
        }
        this.value /= val;
    }
}

class Song {
    private String name;
    private int id;
    private String composer;

    public Song(String name, int id, String composer) {
        this.name = name;
        this.id = id;
        this.composer = composer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    @Override
    public String toString() {
        return "Song{name=" + name + ", id=" + id + ", composer=" + composer + "}";
    }
}

abstract class Album {
    ArrayList<Song> songs = new ArrayList<>();

    abstract void addSong(Song song);

    void removeSong (Song song) {
        songs.remove(song);
    }

    @Override
    public String toString() {
        return "Album{songs=" + songs.toString() + "}";
    }
}

class Prime {
    static boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(int n) {
        int copy = n;
        int rev = 0;
        while(n > 0){
            rev=(rev * 10) + n % 10;
            n = n / 10;
        }
        if (copy == rev) {
            return true;
        }
        return false;
    }
}

class DangerousAlbum extends Album {
    @Override
    void addSong(Song song) {
        if (Prime.isPrime(song.getId())) {
            songs.add(song);
        }
    }
}

class ThrillerAlbum extends Album {

    @Override
    void addSong(Song song) {
        if (song.getId() % 2 == 0 && song.getComposer().equals("Michael Jackson")) {
            songs.add(song);
        }
    }
}

class BadAlbum extends Album {

    @Override
    void addSong(Song song) {
        if (Prime.isPalindrome(song.getId()) && song.getName().length() == 3) {
            songs.add(song);
        }
    }
}

public class Main {
    private static final int TASK_NO = 6;
    private static Task[] taskList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();

        // TODO UNCOMMENT BELLOW LINES TO TEST TASK 1 and TASK 2

        taskList = new Task[TASK_NO];
        taskList[0] = new OutTask("First message task");
        taskList[1] = new RandomOutTask();
        taskList[2] = new CounterOutTask();
        taskList[3] = new OutTask("Second message task");
        taskList[4] = new CounterOutTask();
        taskList[5] = new RandomOutTask();



        switch(taskNum) {
            case 1:
                // TODO UNCOMMENT BELLOW LINES TO TEST TASK 1

                for (Task task : taskList) {
                    task.execute();
                }

                break;

            case 2:
                // TODO UNCOMMENT BELLOW LINES TO TEST TASK 2

                System.out.println("----> Queue");
                Queue q = new Queue();
                for(Task task : taskList) {
                    q.push(task);
                }
                q.pop();
                q.pop();
                for (Task task : q.getTasks()) {
                    task.execute();
                }

                System.out.println("----> Stack");
                Stack s = new Stack();
                for(Task task : taskList) {
                    s.push(task);
                }
                s.pop();
                s.pop();
                for (Task task : s.getTasks()) {
                    task.execute();
                }

                System.out.println("----> Testare metoda transferFrom");
                q.transferFrom(s);

                for (Task task : q.getTasks()) {
                    task.execute();
                }

                System.out.println(s.isEmpty());


                break;

            case 3:
                // TODO UNCOMMENT BELLOW LINES TO TEST TASK 3

                Operation op = new Operation(13);
                op.div(0);
                op.div(1);
                System.out.println(op.getNumber());
                op.mult(2);
                System.out.println(op.getNumber());
                op.minus(3);
                System.out.println(op.getNumber());
                op.plus(7);
                System.out.println(op.getNumber());

                break;

            case 4:
                // TODO UNCOMMENT BELLOW LINES TO TEST TASK 4

                Song song1 = new Song("Bad", 101, "Michael Jackson");
                Song song2 = new Song("Dangerous", 19, "Michael Jackson");
                Song song3 = new Song("Heal the world", 53, "Composer");
                Song song4 = new Song("Thriller", 82, "Michael Jackson" );
                Song song5 = new Song("Beat it", 83, "Michel Jakson");
                Song song6 = new Song("Smooth Criminal", 77, "Composer");

                DangerousAlbum dangerous = new DangerousAlbum();
                dangerous.addSong(song2);
                dangerous.addSong(song3);
                dangerous.addSong(song6);
                System.out.println(dangerous);

                ThrillerAlbum thriller = new ThrillerAlbum();
                thriller.addSong(song4);
                thriller.addSong(song6);
                thriller.addSong(song5);
                System.out.println(thriller);

                BadAlbum bad = new BadAlbum();
                bad.addSong(song1);
                bad.addSong(song6);
                System.out.println(bad);

                break;

        }

    }
}