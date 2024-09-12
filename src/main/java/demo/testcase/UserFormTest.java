package demo.testcase;

import demo.BaseCase;
import demo.Constant;
import demo.element.UserInfo;
import demo.pages.UserFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserFormTest extends BaseCase {
    UserFormPage page;
    String picture = Constant.UPLOAD_FILE_PATH + "picture1.png";

    @Test(groups = "test")
    public void Verify_submit_form_success_with_valid_info() {
        page = new UserFormPage();
        System.out.println("Step 1: Enter data into form fields");
        UserInfo newUserInfo = UserInfo.builder()
                .firstName("Auto").lastName("Test").email("autoTest@yopmail.com").gender("Male")
                .mobile("0366832450")
                .subject("Demo").hobby("Sports").picture(picture).address("Tan Binh").state("NCR").city("Delhi").build();
        page.fillForm(newUserInfo);

        System.out.println("Step 2: Verify success message displays");
        String actualMsg = page.successMsg.getText();
        String expectedMsg = "Thanks for submitting the form";
        Assert.assertEquals(actualMsg, expectedMsg, String.format("Expected message is %s but found %s", expectedMsg, actualMsg));
    }

    @Test(groups = "test")
    public void Verify_failed_to_submit_form_with_one_field_missing() {
        page = new UserFormPage();
        System.out.println("Step 1: Enter data into all form fields except for First Name ");
        UserInfo newUserInfo = UserInfo.builder()
                .lastName("Test").email("autoTest@yopmail.com").gender("Male")
                .mobile("0366832450")
                .subject("Demo").hobby("Sports").picture(picture).address("Tan Binh").state("NCR").city("Delhi").build();
        page.fillForm(newUserInfo);

        System.out.println("Step 2: Verify the border color of First name text box is Red");
        String actualColor = page.txtFirstName.getCssValue("border-color");
        String expectedColor = "rgb(220, 53, 69)";
        Assert.assertEquals(actualColor, expectedColor, String.format("Expected color is %s but found %s", expectedColor, actualColor));
    }
}
