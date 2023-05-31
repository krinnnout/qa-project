package hh;

import com.codeborne.selenide.Selenide;
import core.BaseTest;
import org.junit.jupiter.api.Test;

public class HhResumeTest extends BaseTest {
    private static final String URL = "https://hh.ru/resume/108c0d2a00013390050039ed1f543141315951?query=qa&hhtmFrom=resume_search_result";

    @Test
    public void checkResumeAttributesHashMap(){
        HhResumePage hhResumePage = new HhResumePage(URL);
        boolean b = hhResumePage.isReadyToRelocate();
    }
}
