// Classe que representa um usuário com ID único e nome
class User private constructor(val id: Int, val name: String) {
  companion object {
    private var currentId = 1 // Variável estática para gerar IDs únicos

    // Método para criar um novo usuário garantindo um ID único
    fun create(name: String): User {
      return User(currentId++, name)
    }
  }
}

// Objeto Singleton responsável pelo gerenciamento de usuários
object UserManager {
  private val users = mutableListOf<User>() // Lista para armazenar os usuários cadastrados

  // Adiciona um novo usuário à lista
  fun addUser(name: String) {
    users.add(User.create(name))
  }

  // Exibe a lista de usuários cadastrados
  fun listUsers() {
    if (users.isEmpty()) {
      println("Nenhum usuário cadastrado.") // Mensagem caso a lista esteja vazia
    } else {
      users.forEach { println("${it.id} - ${it.name}") } // Formatação da saída
    }
  }
}

fun main() {
  // Solicita ao usuário a quantidade de cadastros desejada
  print("Quantos usuários deseja adicionar? ")
  val quantity = readLine()?.toIntOrNull()?.takeIf { it > 0 } ?: run {
    println("Entrada inválida. Tente novamente.") // Validação da entrada
    return
  }

  // Loop para adicionar múltiplos usuários com base na quantidade informada
  repeat(quantity) {
    print("Digite o nome do usuário: ")
    val name = readLine()?.takeIf { it.isNotBlank() } ?: "Desconhecido" // Evita nomes vazios
    UserManager.addUser(name)
  }

  // Exibe a lista de usuários cadastrados
  println("\nLista de Usuários:")
  UserManager.listUsers()
}
