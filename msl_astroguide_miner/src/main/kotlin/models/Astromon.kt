package models

class Astromon (val evo1: AstromonEvo, val evo2: AstromonEvo, val evo3: AstromonEvo? = null) {

    fun toJson(): String {
        return ""
    }
}


data class AstromonEvo (
    val superEvo: Boolean,
    val name: String,
    val status: Status,
    val primSkill: Skill,
    val secSkill: Skill,
    val leaderSkill: PassiveSkill,
    val story: String,
)

data class Status(
    val hp: String,
    val atk: String,
    val def: String,
    val rec: String,
    val critDmg: String,
    val critRate: String,
    val res: String,
    val critRes: String,
)

data class Skill(
    val name: String,
    val desc: String,
    val target: String,
    val passive: PassiveSkill,
)

data class PassiveSkill(
    val name: String,
    val desc: String,
)
