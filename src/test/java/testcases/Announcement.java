package testcases;

import org.testng.annotations.Test;

import Action.AnnouncementAction;
import Action.LoginAction;
import utils.WebTestBase;
import static reporting.ComplexReportFactory.getTest;

 // @author aanand
 
public class Announcement extends WebTestBase 
{

	static String Screenname = "<b>Announcement</b>"; 
	/* First check the validation then add Announcement, because after adding announcement , 
	 * it shows announcement popup on every screen of Talygen */
	
	@Test(priority=1)
	public void ValidationCheck()
	{
		test=getTest(Screenname + ": Validation message on Add Annoucement");
		AnnouncementAction announceaction = new AnnouncementAction(driver);
		new LoginAction(driver).logoutLogin();
		announceaction.GoToCompanySetupPage();
		announceaction.validationMessageCheck();
	}
	 
	/* All main functionality are performed in single test case because after adding announcement if we again 
	 * perform login it shows recently created announcement popup . */
	
	@Test(enabled=false)	
	public void AddSearchDeleteAnnoncement()
	{
		test= getTest(Screenname +": Add Announcement Test Cases");
		AnnouncementAction annouceaction = new AnnouncementAction(driver);
		new LoginAction(driver).logoutLogin();
		annouceaction.GoToCompanySetupPage();
		annouceaction.AddAnnouncement();
	}

	
}
