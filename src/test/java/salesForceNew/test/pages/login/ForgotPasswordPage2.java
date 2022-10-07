package salesForceNew.test.pages.login;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import salesForceNew.test.pages.base.BasePage;

public class ForgotPasswordPage2 extends BasePage {

	@FindBy(xpath = "//h1[text() = 'Check Your Email']")
	WebElement chkEmailMsg;

	public ForgotPasswordPage2(WebDriver driver) {
		super(driver);
	}

	public String get_SendEmail_Msg() {
		String msg = null;
		waitUntilVisible(chkEmailMsg, "Forgot Password page email sent msg.");
		if (chkEmailMsg.isDisplayed()) {
			msg = chkEmailMsg.getText();
			return msg;
		} else {
			return msg;
		}
	}

	public void Waituntill_chkEmailMsg_visible() {
		waitUntilVisible(chkEmailMsg, "Forgot Password page email sent msg.");
	}

}
