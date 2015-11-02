package data;

import ui.NestButton;

/**
 * Created by julien on 10/27/15.
 */
public interface Exporters {
  default void export(NestButton[][] nests) {
    String output = "{";
    String comment = "/*\n";
    for (int i = nests.length - 1; i >= 0; i--) {
      output += "{";
      for (int i1 = 0; i1 < nests[i].length; i1++) {
        Nest nest = nests[i][i1].nest;
        if (nest.isActivated()) {
          output += nest.toString() + ",";
          comment += "X";
        } else
          comment += "-";
      }
      comment += "\n";
      output += "}, ";
    }
    output = output.replaceAll("\\{}", "");
    output = output.replaceAll(",}", "}");
    output = output.replaceAll(", ,", "");
    comment = comment.replaceAll("--------------------\n", "");
    output += "}";
    comment += "*/";
    System.out.println(comment);
    System.out.println(output);
  }
}
