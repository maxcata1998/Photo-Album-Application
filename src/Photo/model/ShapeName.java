package Photo.model;

public enum ShapeName {
  rectangle("rectangle"),
  oval("oval");
  public final String value;

  ShapeName(String value) {
    this.value = value;
  }
  public String getValue() {
    return this.value;
  }
}
