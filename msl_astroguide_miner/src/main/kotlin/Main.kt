import miner.AstroguideMiner

fun main() {
    val testUrl = "https://astroguide.xyz/astromons/sura"
    val astroMiner = AstroguideMiner()

    astroMiner.getAstroInfo(testUrl)
}