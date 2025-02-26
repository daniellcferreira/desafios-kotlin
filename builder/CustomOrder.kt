// Classe que representa um produto com nome, preço e quantidade
class Product(val name: String, val price: Double, val quantity: Int)

// Classe que representa um pedido personalizado
class CustomOrder private constructor(
  val customerName: String,  // Nome do cliente
  val products: List<Product>,  // Lista de produtos no pedido
  val total: Double,  // Valor total do pedido
  val deliveryAddress: String  // Endereço de entrega
) {
  // Classe interna Builder para facilitar a criação do pedido
  class Builder {
    private var customerName: String = ""
    private val products = mutableListOf<Product>()
    private var deliveryAddress: String = ""

    // Define o nome do cliente (remove espaços extras)
    fun setCustomerName(name: String) = apply { customerName = name.trim() }

    // Adiciona um produto à lista
    fun addProduct(product: Product) = apply { products.add(product) }

    // Define o endereço de entrega (remove espaços extras)
    fun setDeliveryAddress(address: String) = apply { deliveryAddress = address.trim() }

    // Método que finaliza a construção do pedido e retorna um objeto CustomOrder
    fun build(): CustomOrder {
      val total = products.sumOf { it.price * it.quantity }  // Calcula o total do pedido
      return CustomOrder(customerName, products.toList(), total, deliveryAddress)
    }
  }

  // Método para imprimir o recibo do pedido
  fun printReceipt() {
    println("Cliente: $customerName")
    println("Produtos:")
    products.forEachIndexed { index, product ->
      println("${index + 1}. ${product.name} | R$%.2f | ${product.quantity}".format(product.price))
    }
    println("Total: R$%.2f".format(total))
    println("Endereço de Entrega: $deliveryAddress")
  }
}

fun main() {
  // Solicita o nome do cliente
  print("Nome do cliente: ")
  val customerName = readlnOrNull()?.trim().orEmpty()

  val orderBuilder = CustomOrder.Builder().setCustomerName(customerName)

  // Solicita o número de produtos a serem adicionados ao pedido
  print("Número de produtos: ")
  val numProducts = readlnOrNull()?.toIntOrNull() ?: 0

  // Loop para capturar detalhes de cada produto
  repeat(numProducts) { i ->
    print("Nome do produto ${i + 1}: ")
    val productName = readlnOrNull()?.trim().orEmpty()

    // Solicita um valor válido para o preço do produto
    val productPrice = generateSequence {
      print("Preço do produto $productName: ")
      readlnOrNull()?.toDoubleOrNull()
    }.firstOrNull() ?: 0.0

    // Solicita um valor válido para a quantidade do produto
    val productQuantity = generateSequence {
      print("Quantidade de $productName: ")
      readlnOrNull()?.toIntOrNull()
    }.firstOrNull() ?: 1

    // Adiciona o produto ao pedido
    orderBuilder.addProduct(Product(productName, productPrice, productQuantity))
  }

  // Solicita o endereço de entrega
  print("Endereço de entrega: ")
  val deliveryAddress = readlnOrNull()?.trim().orEmpty()

  // Finaliza a construção do pedido
  val customOrder = orderBuilder.setDeliveryAddress(deliveryAddress).build()

  // Exibe o recibo do pedido
  println("\n==== Recibo ====")
  customOrder.printReceipt()
}
