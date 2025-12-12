package Grafipel;

public class Livro implements Publicacao {

    //ATRIBUTOS
    private String titulo;
    private String autor;
    private int totPag;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    //MÉTODO CONSTRUTOR
    public Livro(String titulo, String autor, int totPag, Pessoa leitor) {
        this.titulo = titulo;
        this.autor = autor;
        this.totPag = totPag;
        this.pagAtual = 0;
        this.aberto = false;
        this.leitor = leitor;
    }

    //MÉTODOS ESPECIAIS
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

    public int getTotPag() {
        return totPag;
    }
    public void setTotPag(int totPag) {
        this.totPag = totPag;
    }

    public int getPagAtual() {
        return pagAtual;
    }
    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public boolean isAberto() {
        return aberto;
    }
    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }
    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

    //MÉTODO PERSONALIZADO
    public String detalhes() { //detalhes do livro (feito com toString)
        return "\nLivro:" +
                "\nTítulo = " + titulo +
                "\nAutor = " + autor +
                "\nTotal de Páginas = " + totPag +
                "\nPágina Atual = " + pagAtual +
                "\nEstá Aberto? " + aberto +
                "\nLeitor = " + leitor.getNome() + ". Idade = " + leitor.getIdade() +
                ". Sexo = " + leitor.getSexo();
    }

    @Override
    public void abrir() {
        if (this.isAberto()) {
            System.out.println("\nO livro já está aberto!");
        } else {
            this.setAberto(true);
            System.out.println("\nO livro está aberto!");
        }
    }

    @Override
    public void fechar() {
        if (!isAberto()) {
            System.out.println("\nO livro já está fechado!");
        } else {
            this.setAberto(false);
            System.out.println("\nO livro está fechado!");
        }
    }

    @Override
    public void folhear(int p) {
        if (!isAberto()) {
            System.out.println("Abra o livro antes de folhear!");
        } else if (p > this.getTotPag() || p <= 0) {
            System.out.println("Número de páginas inexistente!");
        } else {
            this.pagAtual = p;
        }
    }

    @Override
    public void avancarPag() {
        if (!isAberto()) {
            System.out.println("Abra o livro antes de avançar uma página!");
        } else if (this.getPagAtual() == totPag) {
            System.out.println("Não é possível avançar, já está na última página!");
        } else {
            this.pagAtual++;
        }
    }

    @Override
    public void voltarPag() {
        if (!isAberto()) {
            System.out.println("Abra o livro antes de voltar uma página!");
        } else if (this.getPagAtual() == 1) {
            System.out.println("Não é possível voltar, já está na primeira página!");
        } else {
            this.pagAtual--;
        }
    }
}