import java.util.ArrayList

public class Seguradora {
    private String nome ;
    private String telefone ;
    private String email ;
    private String endereco ;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;
    


    // Construtor
    public Seguradora ( String nome , String telefone , String email , String endereco ) {
        this .nome      = nome ;
        this .telefone  = telefone ;
        this .email     = email ;
        this .endereco  = endereco ;
        this .listaSinistros = new ArrayList<Sinistro>();
        this .listaClientes = new ArrayList<Cliente>();
    }

    // Getters e setters
    public String getNome () {
        return nome ;
    }

    public void setNome ( String nome ) {
        this .nome = nome ;
    }

    public String getTelefone () {
        return telefone ;
    }

    public void setTelefone ( String telefone ) {
        this . telefone = telefone ;
    }

    public String getEmail () {
        return email ;
    }

    public void setEmail ( String email ) {
        this . email = email ;
    }

    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this . endereco = endereco ;
    }

    public boolean cadastrarCliente(Cliente cliente) {
        //verificar se o cliente ja esta cadastrado
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado.getNome() == cliente.getNome()) {
                //cliente ja cadastrado
                return false;
            }           
        }
        //cliente novo
        listaClientes.add(cliente);
        return true;
    }

    public boolean removerCliente(String cliente) {
        //verificar se o cliente esta cadastrado
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado.getNome() == cliente) {
                //cliente cadastrado, é possível removê-lo
                listaClientes.remove(clienteCadastrado);
                return true;
            }           
        }
        //cliente não existe, não é possível removê-lo
        return false;
    }

    public ArrayList<Cliente> listarClientes(String tipoCliente) {
        if (tipoCliente == "PF"){
            ArrayList<Cliente> listaClientesPF = new ArrayList<Cliente>();
            for (Cliente clienteCadastrado: listaClientes) {
                if (clienteCadastrado instanceof ClientePF) {
                    listaClientesPF.add(clienteCadastrado);                    
                }
            }
            return listaClientesPF;
        }
        //tipoCliente == "PJ"
        ArrayList<Cliente> listaClientesPJ = new ArrayList<Cliente>();
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado instanceof ClientePJ) {
                listaClientesPJ.add(clienteCadastrado);                    
            }
        }
        return listaClientesPJ;
    }

    public boolean gerarSinistro(Cliente cliente, Veiculo veiculo) {
        /*  Aqui se gera um sinistro de um cliente e um veículo já existentes,
            O endereco será o do cliente e a data será uma string vazia, a ser preenchida
            à medida que obtivermos mais informações.
         */
        //verificar se cliente existe
        boolean existeCliente = false;
        boolean existeVeiculo = false;
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado.getCPF() == cliente.getCPF()) {
                existeCliente = true;
            }           
        }
        //verificar se veiculo exite
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado.getCPF() == cliente.getCPF()) {
                existeCliente = true;
            }           
        }

        if (existeCliente && existeVeiculo) {
            //gerar sinistro
            Sinistro sinistro = new Sinistro("01/01/2023","Rua dos Girassois", this, veiculo, cliente);
            listaSinistros.add(sinistro);
            return true;
        }
        return false;
        
    }
    
    public boolean visualizarSinistro (String cliente) {
        //encontrar os sinistros com o nome do cliente
        int numSinistros = 0;
        
        for (Sinistro sinistroCadastrado: listaSinistros) {
            if (sinistroCadastrado.getCliente().getNome() == cliente) {
                numSinistros++;
            }           
        }
        //informar quantos sinistros tem
        if (numSinistros >= 1){
            System.out.println("O cliente" + cliente + "possui" + numSinistros + "sinistros.");
            return true;    
        }
        else {
            System.out.println("O cliente" + cliente + " não possui sinistros cadastrados");
            return false;
        }
 
    }

    public ArrayList<Sinistro> listarSinistros() {
        return listaSinistros;  
    }
}