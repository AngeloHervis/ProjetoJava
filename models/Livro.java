package models;

public class Livro {
    // Propriedades
    private int codigo;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numExemplaresDisponiveis;

    // Construtor
    public Livro(int codigo, String titulo, String autor, int anoPublicacao, int numExemplaresDisponiveis) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numExemplaresDisponiveis = numExemplaresDisponiveis;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumExemplaresDisponiveis() {
        return numExemplaresDisponiveis;
    }

    public void setNumExemplaresDisponiveis(int numExemplaresDisponiveis) {
        this.numExemplaresDisponiveis = numExemplaresDisponiveis;
    }

    // Método para exibir informações do livro
    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", numExemplaresDisponiveis=" + numExemplaresDisponiveis +
                '}';
    }
}
