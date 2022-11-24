package task1;

import task1.document.BoldTextSegment;
import task1.document.ItalicTextSegment;
import task1.document.PlainTextSegment;
import task1.document.UrlSegment;

public class DokuWikiVisitor implements DocumentVisitor {
    StringBuilder doc = new StringBuilder();

    @Override
    public void visit(ItalicTextSegment text) {
        StringBuilder newText = new StringBuilder();
        newText.append("//" + text.getContent() + "//");
        this.doc.append(newText);
    }

    @Override
    public void visit(BoldTextSegment text) {
        StringBuilder newText = new StringBuilder();
        newText.append("**" + text.getContent() + "**");
        this.doc.append(newText);
    }

    @Override
    public void visit(UrlSegment text) {
        StringBuilder newText = new StringBuilder();
        newText.append("[[" + text.getUrl() + "|" + text.getDescription() + "]]");
        this.doc.append(newText);
    }

    @Override
    public void visit(PlainTextSegment text) {
        StringBuilder newText = new StringBuilder();
        newText.append(text.getContent());
        this.doc.append(newText);
    }

    @Override
    public StringBuilder getDocument() {
        return this.doc;
    }
}
