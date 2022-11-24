package task1.document;

import task1.DocumentVisitor;

public class UrlSegment extends TextSegment{
    private String url;
    private String description;

    public UrlSegment(String url, String description) {
        super(url + description);
        this.url = url;
        this.description = description;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
