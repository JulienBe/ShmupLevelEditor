package data;

/**
 * Created by julien on 10/27/15.
 */
public class Nest {
  private boolean activated = false;
  private final int x, y;

  public Nest(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void click() {
    activated = !activated;
  }

  public boolean isActivated() {
    return activated;
  }

  @Override
  public String toString() {
    return "Nest.T" + x;
  }
}
