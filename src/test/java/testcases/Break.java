package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import Action.BreakAction;
import Action.LoginAction;
import utils.WebTestBase;

public class Break extends WebTestBase {

	static String Screenname = " <b> Break </b>";

	@Test(priority = 1)
	public void AddBreakValidationCheck() {
		test = getTest(Screenname + " : Validation message on Add Break Screen");
		BreakAction breakaction = new BreakAction(driver);
		new LoginAction(driver).logoutLogin();
		breakaction.GoToBreakTab();
		breakaction.ValidationMessageCheck();
	}

	@Test(priority = 2)
	public void AddBreak() {
		test = getTest(Screenname + " :  Add Break");
		BreakAction breakaction = new BreakAction(driver);
		new LoginAction(driver).logoutLogin();
		breakaction.GoToBreakTab();
		breakaction.AddBreak();

	}

	@Test(enabled = true, priority = 3)
	public void SearchBreak() {
		test = getTest("Searchbreak");
		BreakAction breakaction = new BreakAction(driver);
		new LoginAction(driver).logoutLogin();
		breakaction.GoToBreakTab();
		breakaction.SearchBreak();

	}

	@Test(priority = 4)
	public void EditBreak() {
		test = getTest(Screenname + " : Edit Break");
		BreakAction breakaction = new BreakAction(driver);
		new LoginAction(driver).logoutLogin();
		breakaction.GoToBreakTab();
		breakaction.EditBreak();
	}

	
	  @Test(priority = 5) 
	  public void ActiveInActiveDelete() { 
	  test = getTest(Screenname + " Edit Break");
	  BreakAction breakaction = new BreakAction(driver); new
	  LoginAction(driver).logoutLogin(); 
	  breakaction.GoToBreakTab();
	  breakaction.ActiveInActiveAndDelete(); }
	 

}
