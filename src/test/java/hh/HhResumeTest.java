package hh;

import core.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HhResumeTest extends BaseTest {
    private static final String URL = "https://hh.ru/resume/108c0d2a00013390050039ed1f543141315951?query=qa&hhtmFrom=resume_search_result";

    @Test
    public void checkResumeAttributesHashMap(){
        HhResumePage hhResumePage = new HhResumePage(URL);
        Map<String, Object> expectedData = new HashMap<>(){{
            put(HhResumePage.GENDER, "M");
            put(HhResumePage.AGE, 33);
            put(HhResumePage.READY_TO_RELOCATE, true);
            put(HhResumePage.READY_FOR_BUSINESS_TRIPS, true);
        }};

        Assert.assertEquals(expectedData, hhResumePage.getResumeData());
    }
}
