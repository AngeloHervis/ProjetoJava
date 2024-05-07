package models;

public class Livro {
    private int codigo;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numExemplaresDisponiveis;
    private int quantidadeDisponivel;
    private String categoria;

    public Livro(int codigo, String titulo, String autor, int anoPublicacao, int numExemplaresDisponiveis) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numExemplaresDisponiveis = numExemplaresDisponiveis;
        this.quantidadeDisponivel = numExemplaresDisponiveis;
    }

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

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "codigo = " + codigo +
                "\n titulo = '" + titulo + '\'' +
                "\n autor = '" + autor + '\'' +
                "\n anoPublicacao = " + anoPublicacao +
                "\n numExemplaresDisponiveis = " + numExemplaresDisponiveis;
    }
}