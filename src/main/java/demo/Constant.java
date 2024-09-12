package demo;

import java.io.File;

public class Constant {
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String CHROME_HEADLESS = "chrome_headless";
    public static final String FORM_URL = "https://demoqa.com/automation-practice-form";
    public static final int DEFAULT_TIMEOUT_30S = 30;
    public static final String UPLOAD_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "main" + File.separator + "resources"
            + File.separator + "testdata" + File.separator;

}
