package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test(priority = 0)
	public void profileEditTest() throws InterruptedException {

		driver.get(this.baseUrl + "guest-user/login-form");

		locPP.closeJumpDialog();

		loginP.login(email, password);

		Assert.assertEquals(notiSP.getMessageText().contains("Login Successfull"), true,
				"[ERROR], unexpected login message");

		driver.navigate().to(this.baseUrl + "member/profile");

		profileP.changeBasicInformations("Thomas", "Anderson", "Matrix", "+336588698", "18000", "India", "Bihar",
				"Ara");

		Assert.assertEquals(notiSP.getMessageText().contains("Setup Successful"), true,
				"[ERROR], unexpected setup message");

		authP.logoutUser();

		Assert.assertEquals(notiSP.getMessageText().contains("Logout Successfull!"), true,
				"[ERROR], unexpected logout message");
	}

}
