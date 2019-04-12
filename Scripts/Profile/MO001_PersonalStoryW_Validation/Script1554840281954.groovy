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

WebUI.maximizeWindow()


WebUI.navigateToUrl('https://development2.myoptions.org')

url = WebUI.getUrl()

println(url)

//Creating a local variable to store the email address + the nanotime of system
String TimeStampEmailAddress = ('nrccua.counselor+' + System.nanoTime()) + '@gmail.com'

// print the email address out for reference if needed, prints in console
System.out.println(TimeStampEmailAddress)

//set the local variable to a global variable for the timestamp email email address
GlobalVariable.G_TimeStampEmailAddress = TimeStampEmailAddress

WebUI.click(findTestObject('SignUp/a_Sign Up'))

'Wait for SignUp modal to be present'
WebUI.waitForElementPresent(findTestObject('SignUp/input_First Name_first_name'), 1000)

WebUI.delay(3)

//String emailname = 'email27@email.com'
WebUI.setText(findTestObject('SignUp/input_First Name_first_name'), 'fname')

WebUI.setText(findTestObject('SignUp/input_Last Name_last_name'), 'lname')

WebUI.setText(findTestObject('SignUp/input_Your email_email'), TimeStampEmailAddress)

WebUI.setEncryptedText(findTestObject('SignUp/input_Create password_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.setText(findTestObject('SignUp/input_Your date of birth_month'), '01')

WebUI.setText(findTestObject('SignUp/input_Your date of birth_day'), '01')

WebUI.setText(findTestObject('SignUp/input_Your date of birth_year'), '1990')

WebUI.click(findTestObject('SignUp/button_Join for Free'))

url = WebUI.getUrl()

println(url)

WebUI.verifyElementNotPresent(findTestObject('SignUp/div_Email or username exists'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementNotPresent(findTestObject('SignUp/div_First Name and Last Name non_numeric'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementNotPresent(findTestObject('SignUp/div_First and Last Name Required'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementNotPresent(findTestObject('SignUp/div_Email is required'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementNotPresent(findTestObject('SignUp/div_Password is required'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementNotPresent(findTestObject('SignUp/div_Invalid date of birth.'), 1, FailureHandling.OPTIONAL)

//get data
def data = findTestData('Data Files/Database Results')

// Get specific data (column, row) as a variable
String record = data.getValue(1, 1)

//print my variable
println(record)

println(TimeStampEmailAddress)

WebUI.verifyMatch(TimeStampEmailAddress, record, false)


WebUI.click(findTestObject('Welcome to myOptions/label_School Counselor'))

WebUI.delay(3)

WebUI.click(findTestObject('Account Settings/div'))

WebUI.click(findTestObject('Account Settings/Profile'))

WebUI.delay(3)

//WebUI.click(findTestObject('User Profile/img_About Me_style__image___kD'))

//WebUI.click(findTestObject('User Profile/a_Web Images'))

//WebUI.setText(findTestObject('User Profile/input_Images from Wikipedia Fl'),
  //  'myoptions')

//WebUI.click(findTestObject('User Profile/button_Search'))

//WebUI.setText(findTestObject('User Profile/input_Nothing found_search-que'),
//    'my options')

//WebUI.click(findTestObject('User Profile/button_Search'))

//WebUI.setText(findTestObject('User Profile/input_Nothing found_search-que'),
//    'owl')

//WebUI.click(findTestObject('User Profile/button_Search'))

//WebUI.click(findTestObject('User Profile/img'))

//WebUI.click(findTestObject('User Profile/a_Upload'))

WebUI.setText(findTestObject('User Profile/First Name'), 'Julie')

WebUI.setText(findTestObject('User Profile/Last Name'), 'Dixon')

WebUI.setText(findTestObject('User Profile/Address'), '123 Street')

WebUI.setText(findTestObject('User Profile/City'),  'Round Rock')

WebUI.click(findTestObject('User Profile/State'))

WebUI.click(findTestObject('User Profile/State_Alabama'))


//WebUI.click(findTestObject('Welcome to myOptions/div_state'))
//WebUI.sendKeys((null), Keys.chord(Keys.TAB,Keys.ENTER))

WebUI.setText(findTestObject('User Profile/Zip'), '78681')

WebUI.click(findTestObject('User Profile/button_Female'))

WebUI.click(findTestObject('User Profile/button_Yes'))

WebUI.setText(findTestObject('User Profile/Parent 1 First Name'), 'Test1')

WebUI.setText(findTestObject('User Profile/Parent 1 Last Name'), 'Test1Last')

WebUI.setText(findTestObject('User Profile/Parent Email'), 'test@test.com')

WebUI.setText(findTestObject('User Profile/Parent 2 First Name'), 'Test2')

WebUI.setText(findTestObject('User Profile/Parent 2 Last Name'), 'Test2Last')

WebUI.click(findTestObject('User Profile/Ethnicity_American Indian'))

WebUI.click(findTestObject('User Profile/Ethnicity_Latino'))

WebUI.sendKeys((null), Keys.chord(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,'Round Rock',Keys.DOWN,Keys.ENTER ))

//WebUI.sendKeys((null), Keys.chord('Round Rock'))

//WebUI.sendKeys((null), Keys.chord(Keys.DOWN,Keys.ENTER))

//WebUI.setText(findTestObject('User Profile/HighSchool2'), 'round rock')
//WebUI.click(findTestObject('User Profile/div_Round Rock High School'))

WebUI.setText(findTestObject('User Profile/Year'),'2020')

WebUI.click(findTestObject('User Profile/Courses_AP'))

WebUI.click(findTestObject('User Profile/Courses_GeneralCollegePrep'))

WebUI.click(findTestObject('User Profile/Courses_IB'))

WebUI.click(findTestObject('User Profile/Future_GapYearProgram'))

WebUI.click(findTestObject('User Profile/Future_ScholarshipFinancialAid'))

WebUI.click(findTestObject('User Profile/Future_TestPrep'))

WebUI.click(findTestObject('User Profile/button_Add an activity'))

WebUI.click(findTestObject('User Profile/Activity_Add'))

WebUI.click(findTestObject('User Profile/Activity_ArtDesign'))

WebUI.click(findTestObject('User Profile/Activity_CheckButton'))

WebUI.click(findTestObject('User Profile/Activity_Dropdown'))

WebUI.click(findTestObject('User Profile/Activity_BandOrchestra'))

WebUI.click(findTestObject('User Profile/Activity_CheckButton'))

WebUI.click(findTestObject('User Profile/Activity_BandOrchestra_dropdown'))

WebUI.click(findTestObject('User Profile/Activity_BusinessEntrepreneur'))

WebUI.click(findTestObject('User Profile/Activity_CheckButton'))

WebUI.click(findTestObject('User Profile/Military_EnlistAfterHighSchool'))

WebUI.click(findTestObject('User Profile/Military_MilitaryReserves'))

WebUI.click(findTestObject('User Profile/Military_AirForce'))

WebUI.click(findTestObject('User Profile/Military_Marines'))

WebUI.click(findTestObject('User Profile/Profession_Dropdown'))

WebUI.click(findTestObject('User Profile/Profession_Agriculture'))

WebUI.click(findTestObject('User Profile/Profession_Agriculture_Dropdown'))

WebUI.click(findTestObject('User Profile/Profession_Architecture'))

WebUI.click(findTestObject('User Profile/Profession_Architecture_Dropdown'))

WebUI.click(findTestObject('User Profile/Profession_ClergyReligious'))

WebUI.click(findTestObject('User Profile/Profession_ClergyReligious_Dropdown'))

WebUI.delay(3)

WebUI.click(findTestObject('User Profile/div_Design'))

WebUI.click(findTestObject('User Profile/i_ClergyReligious Order_style_'))

WebUI.click(findTestObject('User Profile/button_Save'))



