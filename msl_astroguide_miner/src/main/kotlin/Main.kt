import miner.AstroguideMiner

fun main() {
    val testUrl = "https://astroguide.xyz/astromons/sura"
    val astroMiner = AstroguideMiner(false)

    astroMiner.getAstroInfo(testUrl)
}