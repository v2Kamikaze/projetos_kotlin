package models

data class Astromon(val name: String, val evolutions: List<Evolution>)

data class Evolution(
    val name: String,
    val leaderSkill: Skill,
    val primarySkill: Skill,
    val secondarySkill: Skill,
    val primarySkillPassive: PassiveSkill,
    val secondarySkillPassive: PassiveSkill,
    val status: Status,
    val element: String,
)

data class Skill(
    val skillName: String,
    val type: String,
    val description: String,
)

data class PassiveSkill(
    val name: String,
    val description: String,
)

data class Status(
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val recovery: Int,
    val critDmg: Int,
    val critRate: Int,
    val resist: Int,
    val critResist: Int,
)