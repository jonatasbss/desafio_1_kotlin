fun main() {
    val fatorEmissaoEletricidade = 0.475  // kg CO₂/kWh
    val fatorEmissaoGas = 2.0  // kg CO₂/m³

    println("Digite o tipo de energia (eletricidade ou gás natural):")
    val tipoEnergia = readlnOrNull()?.toLowerCase()

    println("Digite o consumo de energia em kWh (para eletricidade) ou m³ (para gás natural):")
    val consumoEnergia = readlnOrNull()?.toDoubleOrNull() ?: 0.0

    var pegadaCarbonoEletricidade = 0.0
    var pegadaCarbonoGas = 0.0

    when (tipoEnergia) {
        "eletricidade" -> {
            pegadaCarbonoEletricidade = consumoEnergia * fatorEmissaoEletricidade
            println("Eletricidade: %.2f kg CO₂".format(pegadaCarbonoEletricidade))
        }

        "gás natural", "gas natural" -> {
            pegadaCarbonoGas = consumoEnergia * fatorEmissaoGas
            println("Gás: %.2f kg CO₂".format(pegadaCarbonoGas))
        }

        else -> {
            println("Tipo de energia inválido. Por favor, insira 'eletricidade' ou 'gás natural'.")
            return
        }
    }

    val pegadaCarbonoTotal = pegadaCarbonoEletricidade + pegadaCarbonoGas
    println("Total: %.2f kg CO₂".format(pegadaCarbonoTotal))
}