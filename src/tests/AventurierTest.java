
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class AventurierTest {
  int coordx, coordy;
  String[] directions;
  String[][] matrixCarte;
  Aventurier av;

  @Before
  public void beforeTest() {
    coordx = 0;
    coordy = 0;
    directions = new String[]{"E","E","S","S","O","O","N","N","S"};
    matrixCarte = new String[][]{{"","",""},{"","#",""},{"","",""}};

    av = new Aventurier(coordx,coordy,directions,matrixCarte);
  }

  @Test
  public void testMove1time() {
    assertThat(av.move1time("S",av), equalTo("au Sud"));
    assertThat(av.move1time("N",av), equalTo("au Nord"));
    assertThat(av.move1time("O",av), equalTo("à l\'Ouest"));
    assertThat(av.move1time("E",av), equalTo("à l\'Est"));
  }

  @After
  public void afterTest() {
    av = null;
  }
}
