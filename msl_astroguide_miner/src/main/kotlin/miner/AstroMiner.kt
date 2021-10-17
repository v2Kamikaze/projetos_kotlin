package miner

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.support.ui.WebDriverWait

class AstroguideMiner {


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

        driverOptions = FirefoxOptions()
        driverOptions.setHeadless(true)
        webDriver = FirefoxDriver(driverOptions)
        webDriverWait = WebDriverWait(webDriver, waitTime)
    }

    companion object {
        private const val baseUrl: String = "https://astroguide.xyz/allastromons"
        private const val selectorListAstro = "li.allastromons__Item-we4yky-1 > a"
        private const val selectorListEvo = ".astromonFamily__Tabs-sjkebb-2"
        private const val selectorLeaderSkillName = "div.abilityPanel__AbilityHeader-sz1ae3-5.fINNK > div.abilityPanel__Name-sz1ae3-3.jrCHVG > strong"
        private const val selectorLeaderSkillDesc = "div.abilityPanel__AbilityBody-sz1ae3-6.eKizlG > div.abilityPanel__Body-sz1ae3-2.iiZEoY > div"
        private const val selectorLeaderSkillType = "div.abilityPanel__AbilityHeader-sz1ae3-5.fINNK > div.abilityPanel__Subtitle-sz1ae3-4.tZjDe > em"
        private const val selectorPrimarySkillName = "div:nth-child(2) > div > div.abilityPanel__AbilityHeader-sz1ae3-5.fINNK > div.abilityPanel__Name-sz1ae3-3.jrCHVG > strong"
        private const val selectorPrimarySkillDesc = "div:nth-child(2) > div > div.abilityPanel__AbilityBody-sz1ae3-6.eKizlG > div.abilityPanel__Body-sz1ae3-2.iiZEoY > div > span"
        private const val selectorPrimarySkillType = "div:nth-child(2) > div > div.abilityPanel__AbilityHeader-sz1ae3-5.fINNK > div.abilityPanel__Subtitle-sz1ae3-4.tZjDe > em"
        private const val selectorSecondarySkillName = "div:nth-child(3) > div > div.abilityPanel__AbilityHeader-sz1ae3-5.fINNK > div.abilityPanel__Name-sz1ae3-3.jrCHVG > strong"
        private const val selectorSecondarySkillDesc = "div:nth-child(3) > div > div.abilityPanel__AbilityBody-sz1ae3-6.eKizlG > div.abilityPanel__Body-sz1ae3-2.iiZEoY > div > span"
        private const val selectorSecondarySkillType = "div:nth-child(3) > div > div.abilityPanel__AbilityHeader-sz1ae3-5.fINNK > div.abilityPanel__Subtitle-sz1ae3-4.tZjDe > em"
        private const val selectorHp = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div.responsiveGrid__Column-z3xzr7-1.astromonSinglePanel__StyledColumn-sc-3fe6ip-1.gAQgNu.DGAHQ > div > div:nth-child(2) > table:nth-child(1) > tbody > tr:nth-child(1) > td"
        private const val selectorAttack = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div.responsiveGrid__Column-z3xzr7-1.astromonSinglePanel__StyledColumn-sc-3fe6ip-1.gAQgNu.DGAHQ > div > div:nth-child(2) > table:nth-child(1) > tbody > tr:nth-child(2) > td"
        private const val selectorDef = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div.responsiveGrid__Column-z3xzr7-1.astromonSinglePanel__StyledColumn-sc-3fe6ip-1.gAQgNu.DGAHQ > div > div:nth-child(2) > table:nth-child(1) > tbody > tr:nth-child(3) > td"
        private const val selectorRec = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div.responsiveGrid__Column-z3xzr7-1.astromonSinglePanel__StyledColumn-sc-3fe6ip-1.gAQgNu.DGAHQ > div > div:nth-child(2) > table:nth-child(1) > tbody > tr:nth-child(4) > td"
        private const val selectorCritDmg = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div.responsiveGrid__Column-z3xzr7-1.astromonSinglePanel__StyledColumn-sc-3fe6ip-1.gAQgNu.DGAHQ > div > div:nth-child(2) > table:nth-child(2) > tbody > tr:nth-child(1) > td"
        private const val selectorCritRate = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div.responsiveGrid__Column-z3xzr7-1.astromonSinglePanel__StyledColumn-sc-3fe6ip-1.gAQgNu.DGAHQ > div > div:nth-child(2) > table:nth-child(2) > tbody > tr:nth-child(2) > td"
        private const val selectorRes = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div.responsiveGrid__Column-z3xzr7-1.astromonSinglePanel__StyledColumn-sc-3fe6ip-1.gAQgNu.DGAHQ > div > div:nth-child(2) > table:nth-child(2) > tbody > tr:nth-child(3) > td"
        private const val selectorCritRes = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div.responsiveGrid__Column-z3xzr7-1.astromonSinglePanel__StyledColumn-sc-3fe6ip-1.gAQgNu.DGAHQ > div > div:nth-child(2) > table:nth-child(2) > tbody > tr:nth-child(4) > td"
        private const val selectorPrimarySkillPassiveName = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div:nth-child(3) > div > div.abilityPanel__AbilityHeader-sz1ae3-5.fINNK > div.abilityPanel__Name-sz1ae3-3.jrCHVG > strong"
        private const val selectorPrimarySkillPassiveDesc = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div:nth-child(3) > div > div.abilityPanel__AbilityBody-sz1ae3-6.eKizlG > div.abilityPanel__Body-sz1ae3-2.iiZEoY > div"
        private const val selectorSecondarySkillPassiveName = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div:nth-child(4) > div > div.abilityPanel__AbilityHeader-sz1ae3-5.fINNK > div.abilityPanel__Name-sz1ae3-3.jrCHVG > strong"
        private const val selectorSecondarySkillPassiveDesc = "li:nth-child(1) > div.responsiveGrid__Row-z3xzr7-0.astromonSinglePanel__StyledRow-sc-3fe6ip-0.kvAyjV.bkNZkl > div:nth-child(4) > div > div.abilityPanel__AbilityBody-sz1ae3-6.eKizlG > div.abilityPanel__Body-sz1ae3-2.iiZEoY > div"
        private const val selectorStory = "li:nth-child(1) > div.accordion__Wrapper-sc-1ajidpw-0.dQPrZH > div.accordion__Content-sc-1ajidpw-1.hmmRtS > div > div:nth-child(1) > div > div"

        private const val selectorDetailsButton = "li:nth-child(1) > div.accordion__Wrapper-sc-1ajidpw-0.dQPrZH > div.accordion__Bar-sc-1ajidpw-2.cGFOBr"
    }

    fun getAstroURLs(): List<String?> {
        // Retorna uma lista contendo as urls para a página de cada astromano.
        val listAstros: List<String?>

        try {
            webDriver.get(baseUrl)
            val astros = webDriver.findElements(By.cssSelector(selectorListAstro))
            listAstros = astros.map { it.getAttribute("href") }
            listAstros.forEach { println(it) }
        } catch (except: Exception) {
            except.printStackTrace()
            throw Exception("Erro ao procurar a lista de astromanos")
        }

        return listAstros
    }

    fun getAstroInfo(astroUrl: String) {

        val evo1Name: String
        val evo2Name: String
        val evo3Name: String

        val leaderSkillName: String
        val leaderSkillDesc: String
        val leaderSkillType: String

        val primarySkillName: String
        val primarySkillDesc: String
        val primarySkillType: String

        val secondarySkillName: String
        val secondarySkillDesc: String
        val secondarySkillType: String

        val hp: String
        val attack: String
        val defense: String
        val recovery: String
        val critDmg: String
        val critRate: String
        val resist: String
        val critRes: String

        val primarySkillPassiveName: String
        val primarySkillPassiveDesc: String

        val secondarySkillPassiveName: String
        val secondarySkillPassiveDesc: String

        val story: String


        try {
            webDriver.get(astroUrl)
            val astroEvoButtons = webDriver.findElement(By.cssSelector(selectorListEvo)).findElements(By.tagName("li"))

            evo1Name = astroEvoButtons[0].text.substring(0, astroEvoButtons[0].text.indexOf(" ("))
            evo2Name = astroEvoButtons[1].text.substring(0, astroEvoButtons[1].text.indexOf(" ("))
            evo3Name = astroEvoButtons[2].text.substring(0, astroEvoButtons[2].text.indexOf(" ("))

            leaderSkillName = webDriver.findElement(By.cssSelector(selectorLeaderSkillName)).text
            leaderSkillDesc = webDriver.findElement(By.cssSelector(selectorLeaderSkillDesc)).text
            leaderSkillType = webDriver.findElement(By.cssSelector(selectorLeaderSkillType)).text

            primarySkillName = webDriver.findElement(By.cssSelector(selectorPrimarySkillName)).text
            primarySkillDesc = webDriver.findElement(By.cssSelector(selectorPrimarySkillDesc)).text
            primarySkillType = webDriver.findElement(By.cssSelector(selectorPrimarySkillType)).text

            secondarySkillName = webDriver.findElement(By.cssSelector(selectorSecondarySkillName)).text
            secondarySkillDesc = webDriver.findElement(By.cssSelector(selectorSecondarySkillDesc)).text
            secondarySkillType = webDriver.findElement(By.cssSelector(selectorSecondarySkillType)).text

            hp = webDriver.findElement(By.cssSelector(selectorHp)).text
            attack = webDriver.findElement(By.cssSelector(selectorAttack)).text
            defense = webDriver.findElement(By.cssSelector(selectorDef)).text
            recovery = webDriver.findElement(By.cssSelector(selectorRec)).text
            critDmg = webDriver.findElement(By.cssSelector(selectorCritDmg)).text
            critRate = webDriver.findElement(By.cssSelector(selectorCritRate)).text
            resist = webDriver.findElement(By.cssSelector(selectorRes)).text
            critRes = webDriver.findElement(By.cssSelector(selectorCritRes)).text

            primarySkillPassiveName = webDriver.findElement(By.cssSelector(selectorPrimarySkillPassiveName)).text
            primarySkillPassiveDesc = webDriver.findElement(By.cssSelector(selectorPrimarySkillPassiveDesc)).text
            secondarySkillPassiveName = webDriver.findElement(By.cssSelector(selectorSecondarySkillPassiveName)).text
            secondarySkillPassiveDesc = webDriver.findElement(By.cssSelector(selectorSecondarySkillPassiveDesc)).text

            webDriver.findElements(By.cssSelector(selectorDetailsButton))

            story = webDriver.findElement(By.cssSelector(selectorStory)).text


            println("Evo: ")
            println("\t$evo1Name\t$evo2Name\t$evo3Name")
            println("Leader Skill: ")
            println("\t$leaderSkillName\n\t$leaderSkillDesc\n\t$leaderSkillType")
            println("Prim Skill: ")
            println("\t$primarySkillName\n\t$primarySkillDesc\n\t$primarySkillType")
            println("Second Skill: ")
            println("\t$secondarySkillName\n\t$secondarySkillDesc\n\t$secondarySkillType")
            println("Status: ")
            println("\tHP: $hp\n\tCrit Dmg: $critDmg\n\tAttack: $attack\n\tCrit Rate: $critRate\n\tDefense: $defense\n\tResist: $resist\n\tRecovery: $recovery\n\tCrit Res: $critRes")
            println("Prim Passive Skill: ")
            println("\t$primarySkillPassiveName\n\t$primarySkillPassiveDesc")
            println("Second Passive Skill: ")
            println("\t$secondarySkillPassiveName\n\t$secondarySkillPassiveDesc")
            println("Story: ")
            println("\t$story")


        } catch (except: Exception) {
            except.printStackTrace()
            throw Exception("Erro ao procurar informações do astromano")
        } finally {
            webDriver.close()
        }
    }
}