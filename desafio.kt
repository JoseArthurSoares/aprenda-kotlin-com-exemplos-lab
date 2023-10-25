import java.text.Normalizer.Form

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Aluno(val nome: String) {
    init {
        if (nome.isBlank()) {
            throw IllegalArgumentException("O nome não pode ser vazio.")
        }
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int){
    init {
        if (nome.isBlank()){
            throw IllegalArgumentException("O nome não pode ser vazio.")
        }
        if (duracao <= 0) {
            throw IllegalArgumentException("A duração deve ser maior que zero.")
        }
    }
}

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Aluno>()
    
    fun matricular(vararg alunos: Aluno) {
        for (aluno in alunos) {
            inscritos.add(aluno)
        }
    }

    fun getInscritos(): MutableList<Aluno> {
        return this.inscritos
    }
}

fun main() {
    val conteudosEducacionais = listOf(ConteudoEducacional("Programanção 1", 60), ConteudoEducacional("Programação 2", 60))
    val formacao = Formacao("Java", Nivel.AVANCADO, conteudosEducacionais)
    formacao.matricular(Aluno("José"))
}
