import br.com.alura.pickupcep.models.Conexao;
import br.com.alura.pickupcep.models.EnderecosViaCEP;
import br.com.alura.pickupcep.models.GeradorDeEndereco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        var busca = "";
        var conexao = new Conexao();
        var gerador = new GeradorDeEndereco();
        List<EnderecosViaCEP> listaEnderecos = new ArrayList<>();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite o CEP que você deseja consultar ou sair para terminar a aplicação:");
            busca = leitor.nextLine();

            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            try{
                EnderecosViaCEP novoEndereco = conexao.buscaCEP(busca);
                gerador.geradorDeEnderecoJSON(novoEndereco);
                listaEnderecos.add(novoEndereco);
            } catch (Exception e) {
                System.out.println("Programa encerrado!");
                throw new RuntimeException(e.getMessage());
            }
        }
        System.out.println(listaEnderecos);
    }
}