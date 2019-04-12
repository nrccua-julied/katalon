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

TestingURL = 'https://myoptions.org'

WebUI.navigateToUrl(TestingURL)

url = WebUI.getUrl()

println(url)


WebUI.click(findTestObject('Login/LoginLink'))

WebUI.delay(3)


WebUI.setText(findTestObject('Login/input_Username'), 'julieadmittedly1@gmail.com')

WebUI.setEncryptedText(findTestObject('Login/input_Password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.click(findTestObject('Login/button_Login'))

WebUI.delay(3)

CurrentURL= WebUI.getUrl()

WebUI.verifyMatch(CurrentURL, TestingURL+'/home', true)

