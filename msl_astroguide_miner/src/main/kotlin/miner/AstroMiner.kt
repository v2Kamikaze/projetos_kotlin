package miner

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.support.ui.WebDriverWait

class AstroguideMiner(headless: Boolean = false) {

    private val baseUrl: String = "https://astroguide.xyz/allastromons"
    private val webDriver: WebDriver
    private val webDriverWait: WebDriverWait
    private val driverOptions: FirefoxOptions
    private val waitTime: Long = 10000
    private val driverDir: String = "src/main/kotlin/drivers/geckodriver.exe"

    init {
        // Definindo o diretório do driver e desativando o log do console.
        System.setProperty("webdriver.gecko.driver", driverDir)
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true")
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null")

        // Instanciado o browser e definindo o tempo de espera do navegador.
        webDriver = FirefoxDriver()
        driverOptions = FirefoxOptions()
        driverOptions.setHeadless(headless)
        webDriverWait = WebDriverWait(webDriver, waitTime)
    }

    fun getAstroURLs(): List<String?> {
        // Retorna uma lista contendo as urls para a página de cada astromano.
        val listAstros: List<String?>

        try {
            webDriver.get(baseUrl)
            val astros = webDriver.findElements(By.cssSelector("li.allastromons__Item-we4yky-1 > a"))
            listAstros = astros.map { it.getAttribute("href") }
            listAstros.forEach { println(it) }
        } catch (except: Exception) {
            println(except.stackTrace)
            throw Exception("Erro ao procurar a lista de astromanos")
        }

        return listAstros

    }


    fun getAstroInfo(astroUrl: String) {
        val selectorListEvo = ".astromonFamily__Tabs-sjkebb-2"
        val selectorLeaderSkillName = "div.abilityPanel__AbilityHeader-sz1ae3-5.fINNK > div.abilityPanel__Name-sz1ae3-3.jrCHVG > strong"
        val selectorLeaderSkillDesc = "div.abilityPanel__AbilityBody-sz1ae3-6.eKizlG > div.abilityPanel__Body-sz1ae3-2.iiZEoY > div"
        val selectorLeaderSkillType = "div.abilityPanel__AbilityHeader-sz1ae3-5.fINNK > div.abilityPanel__Subtitle-sz1ae3-4.tZjDe > em"

        val evo1Name: String
        val evo2Name: String
        val evo3Name: String
        val leaderSkillName: String
        val leaderSkillDesc: String
        val leaderSkillType: String

        try {
            webDriver.get(astroUrl)
            val astroEvoButtons = webDriver.findElement(By.cssSelector(selectorListEvo)).findElements(By.tagName("li"))

            evo1Name = astroEvoButtons[0].text.substring(0, astroEvoButtons[0].text.indexOf(" ("))
            evo2Name = astroEvoButtons[1].text.substring(0, astroEvoButtons[1].text.indexOf(" ("))
            evo3Name = astroEvoButtons[2].text.substring(0, astroEvoButtons[2].text.indexOf(" ("))
            leaderSkillName = webDriver.findElement(By.cssSelector(selectorLeaderSkillName)).text
            leaderSkillDesc = webDriver.findElement(By.cssSelector(selectorLeaderSkillDesc)).text
            leaderSkillType = webDriver.findElement(By.cssSelector(selectorLeaderSkillType)).text


            println("$evo1Name\t$evo2Name\t$evo3Name")
            println("$leaderSkillName\n$leaderSkillDesc\n$leaderSkillType")



        } catch (except: Exception) {
            println(except.stackTrace)
            throw Exception("Erro ao procurar informações do astromano")
        } finally {
            webDriver.close()
        }
    }

}