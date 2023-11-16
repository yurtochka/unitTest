package sem2;

import static org.assertj.core.api.Assertions.*;
public class main {
    public static void main(String[] args) {
        assertThat(lecture2.pow(2,0)).isEqualTo(1);
        assertThat(lecture2.pow(2,1)).isEqualTo(2);
        assertThat(lecture2.pow(2,10)).isEqualTo(1024);

    }
}
