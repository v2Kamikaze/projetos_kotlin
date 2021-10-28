package miner

import consts.Selectors
import models.Status
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.support.ui.WebDriverWait

class AstroguideMiner(headless: Boolean = true) {

    private val webDriver: WebDriver
    private val webDriverWait: WebDriverWait
    private val driverOptions: FirefoxOptions
    private val waitTime: Long = 10000
    private val driverDir: String = "src/main/kotlin/drivers/geckodriver.exe"
    private val baseUrl: String = "https://astroguide.xyz/allastromons"


    init {
        // Definindo o diretório do driver e desativando o log do console.
        System.setProperty("webdriver.gecko.driver", driverDir)
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true")
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null")

        // Instanciado o browser e definindo o tempo de espera do navegador.
        driverOptions = FirefoxOptions()
        driverOptions.setHeadless(headless)
        webDriver = FirefoxDriver(driverOptions)
        webDriverWait = WebDriverWait(webDriver, waitTime)
    }

    fun getAstroURLs(): List<String?> {

        val listAstros: List<String?>

        try {
            webDriver.get(baseUrl)
            val astros = webDriver.findElements(By.cssSelector(Selectors.listAstro))
            listAstros = astros.map { it.getAttribute("href") }
            listAstros.forEach { println(it) }
        } catch (except: Exception) {
            except.printStackTrace()
            throw Exception("Erro ao procurar a lista de astromanos")
        }

        return listAstros
    }

    fun getAstroInfo(astroUrl: String) {

        // Aqui estarão contidas as divs que possuem os status e skills passivas de cada elemento
        // do astromano: Wood, Water, Fire, Dark e Light. Alguns não possuem todos os elementos.
        val astroElementsDivs: List<WebElement>

        // Aqui estarão os botões para selecionar as evoluções o astromano: evo1, evo2 e evo3.
        // Alguns possuem menos evoluções.
        val astroEvoButtons: List<WebElement>

        try {
            webDriver.get(astroUrl)

            astroEvoButtons = webDriver.findElements(By.cssSelector(Selectors.listEvo))

            astroEvoButtons[1].click() // Escolhendo a evolução - erro.

            astroElementsDivs = webDriver.findElements(By.cssSelector(Selectors.astroElementsDivs))

            for(astroElementDiv in astroElementsDivs) {
                var status: Status

                val hp = astroElementDiv.findElement(By.cssSelector(Selectors.hp)).text
                val atk = astroElementDiv.findElement(By.cssSelector(Selectors.hp)).text
                val def = astroElementDiv.findElement(By.cssSelector(Selectors.hp)).text
                val rec = astroElementDiv.findElement(By.cssSelector(Selectors.hp)).text
                val critDmg = astroElementDiv.findElement(By.cssSelector(Selectors.hp)).text
                val critRate = astroElementDiv.findElement(By.cssSelector(Selectors.hp)).text
                val res = astroElementDiv.findElement(By.cssSelector(Selectors.hp)).text
                val critRes = astroElementDiv.findElement(By.cssSelector(Selectors.hp)).text
                println(hp)
            }

        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("Erro ao buscar informações.")
        } finally {
            Thread.sleep(3000)
            webDriver.close()
        }

    }
}