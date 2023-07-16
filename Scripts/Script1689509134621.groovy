import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Cenário 1 - Usuário tenta realizar login informando dados inválidos

WebUI.openBrowser('https://www.saucedemo.com/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Login/input_login'))

WebUI.setText(findTestObject('Login/input_login'), 'logininvalid')

WebUI.click(findTestObject('Login/input_password'))

WebUI.setText(findTestObject('Login/input_password'), 'passwordinvalid')

WebUI.click(findTestObject('Login/button_acesso'))

WebUI.verifyTextPresent('Epic sadface: Username and password do not match any user in this service', true)

WebUI.delay(1)

// Cenário 2 - Usuário realiza login com sucesso

WebUI.click(findTestObject('Login/input_login'))

WebUI.setText(findTestObject('Login/input_login'), 'standard_user')

WebUI.click(findTestObject('Login/input_password'))

WebUI.setText(findTestObject('Login/input_password'), 'secret_sauce')

WebUI.click(findTestObject('Login/button_acesso'))

WebUI.delay(1)

// Cenário 3 - Usuário seleciona itens para o carrinho

WebUI.mouseOver(findTestObject('Object Repository/Home/button_add_to_cart_bolt_tshirt'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Home/button_add_to_cart_bolt_tshirt'))

WebUI.mouseOver(findTestObject('Object Repository/Home/button_add_cart_fleece_jacket'))

WebUI.click(findTestObject('Object Repository/Home/button_add_cart_fleece_jacket'))

WebUI.mouseOver(findTestObject('Object Repository/Home/button_add_cart_bike_light'))

WebUI.click(findTestObject('Object Repository/Home/button_add_cart_bike_light'))


// Cenário 4 - Usuário visualiza itens no carrinho

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Object Repository/Home/button_carrinho'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Home/button_carrinho'))

// Cenário 5 - Usuário preenche informações para prosseguir com a compra

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Object Repository/Cart/button_checkout'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Cart/button_checkout'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Checkout/input_first_name'))

WebUI.setText(findTestObject('Object Repository/Checkout/input_first_name'), 'Igor')

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Object Repository/Checkout/input_last_name'))

WebUI.click(findTestObject('Object Repository/Checkout/input_last_name'))

WebUI.setText(findTestObject('Object Repository/Checkout/input_last_name'), 'Galdino')

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Object Repository/Checkout/input_zip_postal_code'))

WebUI.click(findTestObject('Object Repository/Checkout/input_zip_postal_code'))

WebUI.setText(findTestObject('Object Repository/Checkout/input_zip_postal_code'), '08391-712')

WebUI.scrollToElement(findTestObject('Object Repository/Checkout/button_continue'), 0)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Object Repository/Checkout/button_continue'))

WebUI.click(findTestObject('Object Repository/Checkout/button_continue'))

// Cenário 6 - Usuário finaliza compra com sucesso

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Object Repository/Checkout Finish/button_finish'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Checkout Finish/button_finish'))

WebUI.verifyTextPresent('Thank you for your order!', true)

WebUI.verifyTextPresent('Your order has been dispatched, and will arrive just as fast as the pony can get there!', true)

// Cenário 7 - Usuário volta para a tela home

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Object Repository/Checkout Finish/button_back_home'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Checkout Finish/button_back_home'))

// Cenário 8 - Usuário realiza logout do sistema

WebUI.scrollToElement(findTestObject('Object Repository/Home/button_open_menu'), 0)

WebUI.mouseOver(findTestObject('Object Repository/Home/button_open_menu'))

WebUI.click(findTestObject('Object Repository/Home/button_open_menu'))

WebUI.mouseOver(findTestObject('Object Repository/Home/button_logout'))

WebUI.click(findTestObject('Object Repository/Home/button_logout'))

WebUI.closeBrowser()

