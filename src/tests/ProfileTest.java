package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test(priority = 0, enabled = true)
	public void profileEditTest() throws InterruptedException {

		driver.get(this.baseUrl + "guest-user/login-form");
		locPP.closeJumpDialog();
		loginP.login(email, password);
		Assert.assertEquals(notiSP.getMessageText().contains("Login Successfull"), true,
				"[Error], unexpected login message");
		driver.navigate().to(this.baseUrl + "member/profile");
		profileP.changeBasicInformations("Thomas", "Anderson", "Matrix", "+336588698", "18000", "India", "Bihar",
				"Ara");
		Assert.assertEquals(notiSP.getMessageText().contains("Setup Successful"), true,
				"[Error], unexpected setup message");
		authP.logoutUser();
		Assert.assertEquals(notiSP.getMessageText().contains("Logout Successfull!"), true,
				"[Error], unexpected logout message");
	}

	@Test(priority = 1, enabled = true)
	public void changeProfileImageTest() throws IOException {

		driver.get(baseUrl + "guest-user/login-form");
		locPP.closeJumpDialog();
		loginP.login(email, password);
		Assert.assertEquals(notiSP.getMessageText().contains("Login Successfull"), true,
				"[ERROR], unexpected login message");
		driver.navigate().to(this.baseUrl + "member/profile");
		String imgPath = new File("img/LikX.png").getCanonicalPath();
		profileP.uploadProfilePhoto(imgPath);
		Assert.assertEquals(notiSP.getMessageText().contains("Profile Image Uploaded Successfully"), true,
				"[Error], unexpected upload photo message");
		notiSP.waitMessageToDisaper();
		profileP.removeProfilePhoto();
		Assert.assertEquals(notiSP.getMessageText().contains("Profile Image Deleted Successfully"), true,
				"[Error], unexpected delete photo message");
		notiSP.waitMessageToDisaper();
		authP.logoutUser();
		Assert.assertEquals(notiSP.getMessageText().contains("Logout Successfull!"), true,
				"[Error], unexpected logout message");
	}

}
