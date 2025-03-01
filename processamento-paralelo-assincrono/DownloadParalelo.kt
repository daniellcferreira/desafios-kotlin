import java.util.concurrent.ConcurrentHashMap

data class DownloadResult(val index: Int, val size: Int)

fun main() {
  val urls = mutableListOf<String>()

  println("Digite as URLs (pressione Enter em uma linha vazia para finalizar):")
  
  // Recebe URLs de entrada até uma linha em branco
  while (true) {
    val input = readLine() ?: break
    if (input.isBlank()) break
    urls.add(input)
  }

  if (urls.isEmpty()) {
    println("Nenhuma URL foi fornecida. Encerrando o programa.")
    return
  }

  println("\nIniciando downloads...\n")

  val results = ConcurrentHashMap<Int, Int>()
  val startTime = System.currentTimeMillis()

  // Criando e iniciando as Threads
  val threads = urls.mapIndexed { index, url ->
    Thread {
      println("Baixando conteúdo de: $url ...")
      val length = openLink(url)
      results[index] = length
      println("Download concluído para: $url (Tamanho: $length caracteres)\n")
    }.apply { start() }
  }

  // Aguarda todas as threads finalizarem
  threads.forEach { it.join() }

  val totalTime = System.currentTimeMillis() - startTime

  println("### Resultados Finais ###")
  results.toSortedMap().forEach { (idx, size) ->
    println("Arquivo ${idx + 1}: ${size} caracteres")
  }

  println("\nTodos os downloads foram concluídos em ${totalTime}ms.")
}

// Simula a abertura de uma URL, retornando seu tamanho.
fun openLink(url: String): Int {
  Thread.sleep(500) // Simula um tempo de resposta da "requisição"
  return url.length // Simula o "download" baseado no tamanho da URL
}
