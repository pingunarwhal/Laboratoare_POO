package task2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * Counter for java files of a given directory using java.nio API
 */
public class JavaFilesVisitor extends SimpleFileVisitor<Path> {

    private ArrayList<Path> javaFiles = new ArrayList<>();

    public final ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }

    /**
     * Add to javaFiles all the Java related files: the ones with .java and .class extensions.
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".java")) {
            javaFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }

    public static void main(String[] args) {

        Path startingDir = Paths.get("./lab7/src");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();

        /*
         * The walkFileTree methods does a depth-first traversal of a directory, starting from startingDir.
         * When it reaches a file, the visitFile method is invoked on the currently visited file.
         */
        try {
            Files.walkFileTree(startingDir, filesVisitor);
            ArrayList<Path> javaFiles = filesVisitor.getJavaFiles();

            System.out.println(javaFiles.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}