package pl.put.poznan.transformer.rest.dto;

public class TransformationRequest {
    private String text = "This is test text";
    private String[] transforms = new String[0];

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text != null ? text : "This is test text";
    }

    public String[] getTransforms() {
        return transforms;
    }

    public void setTransforms(String[] transforms) {
        this.transforms = transforms != null ? transforms : new String[0];
    }
}
