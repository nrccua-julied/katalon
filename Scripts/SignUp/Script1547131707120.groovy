import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://development2.myoptions.org')

url = WebUI.getUrl()

println(url)

//Creating a local variable to store the email address + the nanotime of system
String TimeStampEmailAddress = "nrccua.test+" + System.nanoTime() + "@gmail.com";

// print the email address out for reference if needed, prints in console
System.out.println(TimeStampEmailAddress);

//set the local variable to a global variable for the timestamp email email address
GlobalVariable.G_TimeStampEmailAddress = TimeStampEmailAddress



WebUI.click(findTestObject('Object Repository/Page_myOptions/a_Sign Up'))

'Wait for SignUp modal to be present'
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_myOptions/input_First Name_first_name'), 100)

//String emailname = 'email27@email.com'

WebUI.setText(findTestObject('Object Repository/Page_myOptions/input_First Name_first_name'), 'fname')

WebUI.setText(findTestObject('Object Repository/Page_myOptions/input_Last Name_last_name'), 'lname')

WebUI.setText(findTestObject('Object Repository/Page_myOptions/input_Your email_email'), TimeStampEmailAddress)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_myOptions/input_Create password_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.setText(findTestObject('Page_myOptions/input_Your date of birth_month'), '01')

WebUI.setText(findTestObject('Page_myOptions/input_Your date of birth_day'), '01')

WebUI.setText(findTestObject('Page_myOptions/input_Your date of birth_year'), '1990')

WebUI.click(findTestObject('Object Repository/Page_myOptions/button_Join for Free'))

url = WebUI.getUrl()

println(url)

WebUI.verifyElementPresent(findTestObject('Page_myOptions/div_Email or username exists'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('Page_myOptions/div_First Name and Last Name non_numeric'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('Page_myOptions/div_First and Last Name Required'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_myOptions/div_Email is required'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_myOptions/div_Password is required'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_myOptions/div_Invalid date of birth.'), 1, FailureHandling.OPTIONAL)

WebUI.closeBrowser()

//get data
def data = findTestData('Data Files/Database Results')

// Get specific data (column, row) as a variable
String record = data.getValue(1, 1)

//print my variable
println(record)
println (TimeStampEmailAddress)
WebUI.verifyMatch(TimeStampEmailAddress, record, false)

