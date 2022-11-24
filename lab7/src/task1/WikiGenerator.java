package task1;

import task1.document.TextSegment;

import java.util.List;

/**
 * Uses visitors to parse documents and provide dokuwiki and markdown outputs.
 */
public class WikiGenerator {

    private final List<TextSegment> textSegments;

    public WikiGenerator(List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

    public StringBuilder getDokuWikiDocument() {
        DocumentVisitor visitor = new DokuWikiVisitor();
        for (TextSegment text : textSegments) {
            text.accept(visitor);
        }
        return visitor.getDocument();
    }

    public StringBuilder getMarkdownDocument() {
        DocumentVisitor visitor = new MarkDownVisitor();
        for (TextSegment text : textSegments) {
            text.accept(visitor);
        }
        return visitor.getDocument();
    }
}