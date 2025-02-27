// Interface para conversores de moeda
interface CurrencyConverter {
  fun convert(amount: Double): Double
}

// Conversor antigo que apenas converte USD para GBP
class OldCurrencyConverter : CurrencyConverter {
  override fun convert(amount: Double): Double {
    return amount * 0.80 // 1 USD = 0.80 GBP
  }
}

// Adaptador que converte USD para EUR usando a conversão antiga
class CurrencyAdapter(private val oldConverter: CurrencyConverter) : CurrencyConverter {
  private val gbpToEurRate = 1.0625

  override fun convert(amount: Double): Double {
    val amountInGBP = oldConverter.convert(amount)
    return amountInGBP * gbpToEurRate
  }
}

// Função principal
fun main() {
  val oldConverter = OldCurrencyConverter()
  val adapter = CurrencyAdapter(oldConverter)

  while (true) {
    print("Digite o valor em USD: ")
    val input = readLine()?.toDoubleOrNull()
    
    if (input != null && input >= 0) {
      val amountInEUR = adapter.convert(input)
      println("USD: %.2f".format(input))
      println("EUR: %.2f".format(amountInEUR))
      break
    } else {
      println("Entrada inválida. Digite um número válido.")
    }
  }
}
