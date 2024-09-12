package demo.pages;

import demo.element.BaseElement;
import demo.element.DropDownBox;
import demo.element.UserInfo;

import java.util.Objects;

public class UserFormPage extends BasePage{
    public BaseElement txtFirstName = BaseElement.id("firstName");
    public BaseElement txtLastName = BaseElement.id("lastName");
    public BaseElement txtEmail = BaseElement.id("userEmail");
    public BaseElement txtPhoneNumber = BaseElement.id("userNumber");
    public BaseElement txtDOB = BaseElement.id("dateOfBirthInput");
    public BaseElement txtAddress = BaseElement.id("currentAddress");

    public BaseElement txtSubject = BaseElement.cssSelector("#subjectsInput");

    public BaseElement rdGender(String name) {
        return BaseElement.xpath(String.format("//input[@value='%s']", name));
    }
    public BaseElement checkBoxHobbies(String hobby) {
        return BaseElement.xpath(String.format("//label[.='%s']/../input", hobby));
    }
    DropDownBox ddbState = DropDownBox.xpath("//div[@id='state']", "//div[contains(@id,'react-select-3-option')]");
    DropDownBox ddbCity = DropDownBox.xpath("//div[@id='city']", "//div[contains(@id,'react-select-4-option')]");
    BaseElement btnUpload = BaseElement.id("uploadPicture");
    BaseElement btnSubmit = BaseElement.id("submit");
    public BaseElement successMsg = BaseElement.xpath("//div[contains(@class,'modal-title')]");

    public void fillForm(UserInfo oFilter) {
        if (Objects.nonNull(oFilter.getFirstName())) {
            txtFirstName.type(oFilter.getFirstName());
        }
        if (Objects.nonNull(oFilter.getLastName())) {
            txtLastName.type(oFilter.getLastName());
        }
        if (Objects.nonNull(oFilter.getEmail())) {
            txtEmail.type(oFilter.getEmail());
        }
        if (Objects.nonNull(oFilter.getGender())) {
            rdGender(oFilter.getGender()).clickByJS();
        }
        if (Objects.nonNull(oFilter.getMobile())) {
            txtPhoneNumber.type(oFilter.getMobile());
        }
        if (Objects.nonNull(oFilter.getDob())) {
            txtDOB.clearAndType(oFilter.getDob());
        }
        if (Objects.nonNull(oFilter.getSubject())) {
            txtSubject.type(oFilter.getSubject());
        }
        if (Objects.nonNull(oFilter.getHobby())) {
            checkBoxHobbies(oFilter.getHobby()).clickByJS();
        }
        if (Objects.nonNull(oFilter.getPicture())) {
            btnUpload.type(oFilter.getPicture());
        }
        if (Objects.nonNull(oFilter.getAddress())) {
            txtAddress.type(oFilter.getAddress());
        }

        if (Objects.nonNull(oFilter.getState())) {
            ddbState.scrollToThisControl(true);
            ddbState.selectByVisibleText(oFilter.getState());
        }
        if (Objects.nonNull(oFilter.getCity())) {
            ddbState.scrollToThisControl(true);
            ddbCity.selectByVisibleText(oFilter.getCity());
        }
        sleep(1);
        btnSubmit.click();
        sleep(2);
    }

}
