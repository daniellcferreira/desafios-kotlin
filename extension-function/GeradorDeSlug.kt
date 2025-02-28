import java.text.Normalizer

fun main() {
  print("Digite o título do livro: ")
  val titulo = readLine()?.trim().orEmpty()
  
  print("Digite o nome do autor: ")
  val autor = readLine()?.trim().orEmpty()
  
  val slugTitulo = titulo.toSlug()
  val slugAutor = autor.toSlug()
  
  println("\nSlug gerado para o livro:")
  println("${slugTitulo}_${slugAutor}")
}

// Função de extensão para gerar o slug
fun String.toSlug(): String {
  return Normalizer.normalize(this, Normalizer.Form.NFD)
    .replace("[^\\p{ASCII}]".toRegex(), "") // Remove acentos
    .lowercase() // Converte para minúsculas
    .replace("[^a-z0-9\\s-]".toRegex(), "") // Remove caracteres especiais
    .replace("\\s+".toRegex(), "-") // Substitui espaços por hífens
    .replace("-+".toRegex(), "-") // Remove múltiplos hífens seguidos
    .trim('-') // Remove hífens extras no começo e fim
}
