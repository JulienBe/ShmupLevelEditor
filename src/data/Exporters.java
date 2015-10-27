package data;

import ui.NestButton;

/**
 * Created by julien on 10/27/15.
 */
public interface Exporters {
  default void export(NestButton[][] nests) {
    for (int i = 0; i < nests.length; i++) {
      for (int i1 = 0; i1 < nests[i].length; i1++) {
        nests[i][i1].toString();
      }
    }
  }
}
