import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class SortListTest {

    @Test
    public void fileReadingError(){

        assertThatExceptionOfType(IOException .class).isThrownBy(() -> {  });

    }


}