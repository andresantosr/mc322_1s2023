import java.util.ArrayList;
//DUVIDA: tem problema fazer essa classe abstrata ??????
public abstract class Cliente {
    private String nome ;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    private double valorSeguro;

    // Construtor
    public Cliente (String nome, String endereco, double valorSeguro) {
        this.nome              = nome ;
        this.endereco          = endereco ;
        this.listaVeiculos     = new ArrayList<Veiculo>();
        this.valorSeguro       = 0;
    }

    // Getters e setters
    public String getNome () {
        return nome ;
    }

    public void setNome ( String nome ) {
        this.nome = nome ;
    }

 
    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this.endereco = endereco ;
    }

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        for (Veiculo veiculoCadastrado: listaVeiculos) {
            if (veiculoCadastrado == veiculo) {
                //veiculo já esta cadastrado
                System.out.println("Veiculo " + veiculo.getPlaca() + " já possui cadastro.");
                return false;
            }           
        }
        listaVeiculos.add(veiculo);
        System.out.println("Veiculo cadastrado: " + veiculo.getPlaca());
        
        this.valorSeguro = this.calcularScore();
        return true;
    }

    public boolean removerVeiculo(Veiculo veiculo) {
        //verificar se o veiculo esta cadastrado
        for (Veiculo veiculoCadastrado: listaVeiculos) {
            if (veiculoCadastrado == veiculo) {
                //veiculo cadastrado, é possível removê-lo
                listaVeiculos.remove(veiculoCadastrado);
                this.valorSeguro = this.calcularScore();
                return true;
            }           
        }
        //veiculo não existe, não é possível removê-lo
        return false;
    }

    public ArrayList<Veiculo> listarVeiculos() {
        return listaVeiculos;
    }

    public abstract double calcularScore();    

    public String toString() {
        return 
            "nome: " + nome +
            "\nendereco: " + endereco +
            "\nlistaVeiculos" + listaVeiculos;
    }


    
    
}